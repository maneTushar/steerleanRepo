package com.steerlean.scenarios.pet;

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
import methods.PostMethod;
import utils.GetResponse;
import utils.Reporting;
import utils.utility;

public class PetGETbyStatus extends Reporting {
	
public static String dir = System.getProperty("user.dir");
	


static File file = new File(".//src//main//resources//endpoints//endpoints.properties");
	
	

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
	test.log(Status.INFO,MarkupHelper.createLabel("Validate that the Pet service details are successfully fetched  Pet details when valid status passed in URL", ExtentColor.PURPLE));
	success(testCaseID,"available");
}

@Test
public void TC_02() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	
	test.log(Status.INFO,MarkupHelper.createLabel("Validate that the error is displayed when invalid status passed in URL", ExtentColor.PURPLE));
	Error(testCaseID,"NA");
}

@Test
public void TC_03() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	test.log(Status.INFO,MarkupHelper.createLabel("Validate that the error is displayed when special characters passed for status in URL", ExtentColor.PURPLE));
	Error(testCaseID,"%^&");
}

@Test
public void TC_04() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	
	test.log(Status.INFO,MarkupHelper.createLabel("Validate that the error is displayed when  space  passed for status in URL", ExtentColor.PURPLE));
	Error(testCaseID," ");
}

@Test
public void TC_05() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	
	test.log(Status.INFO,MarkupHelper.createLabel("Validate that the error is displayed when  null is  passed for status in URL", ExtentColor.PURPLE));
	Error(testCaseID,null);
}

@Test
public void TC_06() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	
	test.log(Status.INFO,MarkupHelper.createLabel("Validate that the error is displayed when  empty  passed for status in URL", ExtentColor.PURPLE));
	Error(testCaseID,"");
}



	
	public static void success(String testcaseID,String status) throws IOException
	{
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
		prop.load(fileInput);
		String storeGET_endpoint=prop.getProperty("PetFindByStatus");
		String petGet_endpointURL=storeGET_endpoint+status;
		test.log(Status.INFO,MarkupHelper.createLabel("End Point", ExtentColor.PURPLE));
		test.info(petGet_endpointURL);
	
		Response res = GetResponse.sendRequestGet("api_key", "special-key", petGet_endpointURL);
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
	
	public static void Error(String testcaseID,String status) throws IOException
	{
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
		prop.load(fileInput);
		String storeGET_endpoint=prop.getProperty("PetFindByStatus");
		String petGet_endpointURL=storeGET_endpoint+status;
		test.log(Status.INFO,MarkupHelper.createLabel("End Point", ExtentColor.PURPLE));
		test.info(petGet_endpointURL);
	
		Response res = GetResponse.sendRequestGet("api_key", "special-key", petGet_endpointURL);
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
	
	}

	
	
	

}
