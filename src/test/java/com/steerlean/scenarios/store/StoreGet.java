package com.steerlean.scenarios.store;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.steerelan.utils.*;


public class StoreGet extends Reporting {
	
	static File file = new File(".//src//test//java//com/steerlean//resources//endpoints.properties");
	
	TestReport testReport=new TestReport();

@BeforeMethod
protected void startRepo(Method m) throws IOException {

	String testCaseName = m.getName();
		test = extent.createTest(testCaseName);

}


@Test
public void TC_01() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	
	test.log(Status.INFO,MarkupHelper.createLabel("Validate that the Store details are successfully "
			+ "fetched  Pet details when valid ID passed in URL", ExtentColor.PURPLE));
	
	testReport.success(testCaseID,"501","","GET");
}

@Test
public void TC_02() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	test.log(Status.INFO,MarkupHelper.createLabel("Validate that the error is displayed when  invalid ID passed in URL", ExtentColor.PURPLE));
	testReport.Error(testCaseID,"6565","","GET");
}

@Test
public void TC_03() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	
	test.log(Status.INFO,MarkupHelper.createLabel("Validate that the error is displayed when  special characters are passed for ID  in URL", ExtentColor.PURPLE));
	testReport.Error(testCaseID,"%^&","","GET");
}

@Test
public void TC_04() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	
	test.log(Status.INFO,MarkupHelper.createLabel("Validate that the error is displayed when  space passed for ID  in URL", ExtentColor.PURPLE));
	testReport.Error(testCaseID," ","","GET");
}

@Test
public void TC_05() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	test.log(Status.INFO,MarkupHelper.createLabel("Validate that the error is displayed when  null is passed for ID  in URL", ExtentColor.PURPLE));
	testReport.Error(testCaseID,null,"","GET");
}

@Test
public void TC_06() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	test.log(Status.INFO,MarkupHelper.createLabel("Validate that the error is displayed when  empty is passed for ID  in URL", ExtentColor.PURPLE));
	testReport.Error(testCaseID,"","","GET");
}

@Test
public void TC_07() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	test.log(Status.INFO,MarkupHelper.createLabel("Validate that the error is displayed when  invalid ID passed in URL", ExtentColor.PURPLE));
	testReport.Error(testCaseID,"dbn","","GET");
}

	/*
	public static void success(String testcaseID,String ID) throws IOException
	{
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
		prop.load(fileInput);
		String storeGET_endpoint=prop.getProperty("StoreGET");
		String storeGet_endpointURL=storeGET_endpoint+ID;
		test.log(Status.INFO,MarkupHelper.createLabel("End Point", ExtentColor.PURPLE));
		test.info(storeGet_endpointURL);
	
		Response res = GetResponse.sendRequestGet("api_key", "special-key", storeGet_endpointURL);
		String responsestr = res.asString();
		responsestr = utility.jsonFormat(responsestr);
		JsonPath js = new JsonPath(responsestr);
		
		test.log(Status.INFO,MarkupHelper.createLabel("Response Body", ExtentColor.PURPLE));
		test.info(responsestr);
		int statusCode = res.statusCode();
		test.log(Status.INFO,MarkupHelper.createLabel("Status Code", ExtentColor.PURPLE));
		test.info(statusCode+"");
		if(statusCode==200)
		{
			
			test.log(Status.PASS,MarkupHelper.createLabel("PASS", ExtentColor.GREEN));
		}
		else
		{
			
			test.log(Status.FAIL,MarkupHelper.createLabel("FAIL", ExtentColor.RED));
			Assert.fail();
		}
	}
	
	public static void Error(String testcaseID,String ID) throws IOException
	{

		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
		prop.load(fileInput);
		String storeGET_endpoint=prop.getProperty("StoreGET");
		String storeGet_endpointURL=storeGET_endpoint+ID;
		test.log(Status.INFO,MarkupHelper.createLabel("End Point", ExtentColor.PURPLE));
		test.info(storeGet_endpointURL);
	
		Response res = GetResponse.sendRequestGet("api_key", "special-key", storeGet_endpointURL);
		String responsestr = res.asString();
		responsestr = utility.jsonFormat(responsestr);
		JsonPath js = new JsonPath(responsestr);
		
		test.log(Status.INFO,MarkupHelper.createLabel("Response Body", ExtentColor.PURPLE));
		test.info(responsestr);
		int statusCode = res.statusCode();
		test.log(Status.INFO,MarkupHelper.createLabel("Status Code", ExtentColor.PURPLE));
		test.info(statusCode+"");
		if(statusCode!=200)
		{
			
			test.log(Status.PASS,MarkupHelper.createLabel("PASS", ExtentColor.GREEN));
		}
		else
		{
			
			test.log(Status.FAIL,MarkupHelper.createLabel("FAIL", ExtentColor.RED));
			Assert.fail();
		}
	
	}*/
}
