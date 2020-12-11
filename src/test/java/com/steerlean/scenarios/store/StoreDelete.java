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
import methods.PostMethod;
import utils.*;

public class StoreDelete extends Reporting {

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
	success(testCaseID,"9");
}

@Test
public void TC_02() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	Error(testCaseID,"6565");
}

@Test
public void TC_03() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	Error(testCaseID,"%^&");
}

@Test
public void TC_04() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	Error(testCaseID," ");
}

@Test
public void TC_05() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	Error(testCaseID,null);
}

@Test
public void TC_06() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	Error(testCaseID,"");
}

@Test
public void TC_07() throws IOException
{
	String testCaseID = new Object() {
	}.getClass().getEnclosingMethod().getName();
	Error(testCaseID,"dbn");
}

	
	public static void success(String testcaseID,String ID) throws IOException
	{
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
		prop.load(fileInput);
		String storeGET_endpoint=prop.getProperty("StoreGET");
		String storeGet_endpointURL=storeGET_endpoint+ID;
		test.log(Status.INFO,MarkupHelper.createLabel("End Point", ExtentColor.PURPLE));
		test.info(storeGet_endpointURL);
	
		Response res = GetResponse.sendRequestDelete("api_key", "special-key", storeGet_endpointURL);
		String responsestr = res.asString();
		responsestr = utility.jsonFormat(responsestr);
		JsonPath js = new JsonPath(responsestr);
		System.out.println("JS->"+responsestr);
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
	
	public static void Error(String testcaseID,String ID) throws IOException
	{

		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
		prop.load(fileInput);
		String storeGET_endpoint=prop.getProperty("StoreGET");
		String storeGet_endpointURL=storeGET_endpoint+ID;
		test.log(Status.INFO,MarkupHelper.createLabel("End Point", ExtentColor.PURPLE));
		test.info(storeGet_endpointURL);
	
		Response res = GetResponse.sendRequestDelete("api_key", "special-key", storeGet_endpointURL);
		String responsestr = res.asString();
		responsestr = utility.jsonFormat(responsestr);
		JsonPath js = new JsonPath(responsestr);
		System.out.println("JS->"+responsestr);
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
