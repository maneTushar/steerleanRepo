package com.steerlean.scenarios.store;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.steerelan.utils.GetResponse;
import com.steerelan.utils.Reporting;
import com.steerelan.utils.Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestReport extends Reporting {
	
	static File file = new File(".//src//test//java//com/steerlean//resources//endpoints.properties");
	
	@BeforeMethod
	protected void startRepo(Method m) throws IOException {

		String testCaseName = m.getName();
			test = extent.createTest(testCaseName);

	}

	
	public  void success(String testcaseID,String ID,String payload,String scenario) throws IOException
	{
		Response res=null;
		String responsestr=null;
		
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
		prop.load(fileInput);
		String storeGET_endpoint=prop.getProperty("StoreGET");
		String storePost_endpoint=prop.getProperty("StorePost");
		String storeGet_endpointURL=storeGET_endpoint+ID;
		test.log(Status.INFO,MarkupHelper.createLabel("End Point", ExtentColor.PURPLE));
		test.info(storeGet_endpointURL);
	
		if(scenario.equalsIgnoreCase("POST"))
		{
			//String requestFormatted=utility.jsonFormat(payload);
			 res = GetResponse.sendRequestPost(payload, "api_key", "special-key", storePost_endpoint,testcaseID);
			 responsestr = res.asString();
			
					
			responsestr = Utility.jsonFormat(responsestr);
		}else if(scenario.equalsIgnoreCase("DELETE"))
		{
			 res = GetResponse.sendRequestDelete("api_key", "special-key", storeGet_endpointURL);
			 responsestr = res.asString();
			responsestr = Utility.jsonFormat(responsestr);
				
		}else if(scenario.equalsIgnoreCase("GET"))
		{
			 res = GetResponse.sendRequestGet("api_key", "special-key", storeGet_endpointURL);
			 responsestr = res.asString();
			responsestr = Utility.jsonFormat(responsestr);
		}
		
		
		JsonPath js = new JsonPath(responsestr);
		test.log(Status.INFO,MarkupHelper.createLabel("Response Body", ExtentColor.PURPLE));
		test.info(responsestr);
		int statusCode = res.statusCode();
		test.log(Status.INFO,MarkupHelper.createLabel("Status Code", ExtentColor.PURPLE));
		test.info(statusCode+"");
		String message=js.get("message");
		if(statusCode==200)
		{
			test.pass("Delete service executed successfully");
			test.log(Status.PASS,MarkupHelper.createLabel("PASS"+message, ExtentColor.GREEN));
		}
		else
		{
			
			test.log(Status.FAIL,MarkupHelper.createLabel("FAIL"+message, ExtentColor.RED));
			Assert.fail();
		}
	}
	
	public  void Error(String testcaseID,String ID,String payload,String scenario) throws IOException
	{

		Response res=null;
		String responsestr=null;
		
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
		prop.load(fileInput);
		String storeGET_endpoint=prop.getProperty("StoreGET");
		String storePost_endpoint=prop.getProperty("StorePost");
		String storeGet_endpointURL=storeGET_endpoint+ID;
		
		if(scenario.equalsIgnoreCase("GET"))
		{
			test.log(Status.INFO,MarkupHelper.createLabel("End Point", ExtentColor.PURPLE));
			test.info(storeGet_endpointURL);
			 res = GetResponse.sendRequestGet("api_key", "special-key", storeGet_endpointURL);
			 responsestr = res.asString();
			responsestr = Utility.jsonFormat(responsestr);	
		}else if(scenario.equalsIgnoreCase("DELETE"))
		{
			test.log(Status.INFO,MarkupHelper.createLabel("End Point", ExtentColor.PURPLE));
			test.info(storeGet_endpointURL);
			 res = GetResponse.sendRequestDelete("api_key", "special-key", storeGet_endpointURL);
			 responsestr = res.asString();
			responsestr = Utility.jsonFormat(responsestr);
		}
		
		else if(scenario.equalsIgnoreCase("POST"))
		{
			test.log(Status.INFO,MarkupHelper.createLabel("End Point", ExtentColor.PURPLE));
			test.info(storeGet_endpointURL);
			 res = GetResponse.sendRequestPost(payload, "api_key", "special-key", storePost_endpoint,testcaseID);
			 responsestr = res.asString();
				
			responsestr = Utility.jsonFormat(responsestr);
		}
		
		
		JsonPath js = new JsonPath(responsestr);
		
		test.log(Status.INFO,MarkupHelper.createLabel("Response Body", ExtentColor.PURPLE));
		test.info(responsestr);
		int statusCode = res.statusCode();
		test.log(Status.INFO,MarkupHelper.createLabel("Status Code", ExtentColor.PURPLE));
		test.info(statusCode+"");
		//String message=js.get("message");
		if(statusCode!=200)
		{
			
			test.log(Status.PASS,MarkupHelper.createLabel("PASS", ExtentColor.GREEN));
		}
		else
		{
			
			test.log(Status.FAIL,MarkupHelper.createLabel("FAIL", ExtentColor.RED));
			Assert.fail();
		}
	
	}

}
