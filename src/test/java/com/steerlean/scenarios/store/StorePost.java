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
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.steerelan.utils.*;
import com.steerlean.methods.*;
public class StorePost extends Reporting {

public static String dir = System.getProperty("user.dir");
	
static File file = new File(".//src//test//java//com/steerlean//resources//endpoints.properties");
	
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
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the Store details successfully added when valid values are passed for all attributes in JSON Request.", ExtentColor.PURPLE));
		success(testCaseID);
	}
	
	@Test
	public void TC_02() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when alphabetical value for ID attribute is passed in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.storePost("'"+"abcd"+"'", "1134", "5", "2020-12-11T05:37:18.653Z", "placed", "true");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_03() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response"
				+ " when speical characters for ID attribute is passed in JSON Request.", ExtentColor.PURPLE));
		String payload=PostMethod.storePost("'"+"$%^&"+"'", "1134", "5", "2020-12-11T05:37:18.653Z", "placed", "true");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_04() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when null is  passed for id attributes in JSON Request.", ExtentColor.PURPLE));
		String payload=PostMethod.storePost("'"+null+"'", "1134", "5", "2020-12-11T05:37:18.653Z", "placed", "true");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_05() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when empty is  passed for id attributes in JSON Request.", ExtentColor.PURPLE));
		String payload=PostMethod.storePost("'"+""+"'", "1134", "5", "2020-12-11T05:37:18.653Z", "placed", "true");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_06() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when space is  passed for id attributes in JSON Request.", ExtentColor.PURPLE));
		String payload=PostMethod.storePost("'"+" "+"'", "1134", "5", "2020-12-11T05:37:18.653Z", "placed", "true");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_07() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when alphabetical value for PET ID attribute is passed in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.storePost("101", "'"+"abcd"+"'", "5", "2020-12-11T05:37:18.653Z", "placed", "true");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_08() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when speical characters for PET ID attribute is passed in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.storePost("101", "'"+"$%^&*"+"'", "5", "2020-12-11T05:37:18.653Z", "placed","true");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_09() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when space is  passed for pet id attributes in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.storePost("101", "'"+" "+"'", "5", "2020-12-11T05:37:18.653Z", "placed", "true");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_10() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when null is  passed for pet id attributes in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.storePost("101", "'"+""+"'", "5", "2020-12-11T05:37:18.653Z", "placed", "true");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_11() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as responsewhen empty is  passed for pet id attributes in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.storePost("101", null, "5", "2020-12-11T05:37:18.653Z", "placed", "true");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_12() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when invalid date format is passed in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.storePost("101", "1124", "5", "2020/12/11T05:37:18.653Z", "placed", "true");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_13() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when alphabetical value is passed for complete attribute in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.storePost("101", "1124", "5", "2020-12-11T05:37:18.653Z", "placed", "DFG");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_14() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when special character value is passed for complete attribute in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.storePost("101", "1124", "5", "2020-12-11T05:37:18.653Z", "placed", "%^&*");
		Error(testCaseID,payload);
	}
	
	
	@Test
	public void TC_15() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when space is  passed for complete attribute in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.storePost("101", "1124", "5", "2020-12-11T05:37:18.653Z", "placed", " ");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_16() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when null is  passed for complete attribute in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.storePost("101", "1124", "5", "2020-12-11T05:37:18.653Z", "placed", null);
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_17() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when empty is  passed for complete attribute in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.storePost("101", "1124", "5", "2020-12-11T05:37:18.653Z", "placed", "");
		Error(testCaseID,payload);
	}
	
	
	public static void success(String testcaseID) throws IOException
	{
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
		prop.load(fileInput);
		String storePost_endpoint=prop.getProperty("StorePost");
		
		test.log(Status.INFO,MarkupHelper.createLabel("End Point", ExtentColor.PURPLE));
		test.info(storePost_endpoint);
		
		String payload=PostMethod.storePost("501", "1134", "5", "2020-12-11T05:37:18.653Z", "placed", "true");
		String requestFormatted=utility.jsonFormat(payload);
		Response res = GetResponse.sendRequestPost(payload, "api_key", "special-key", storePost_endpoint,testcaseID);
		String responsestr = res.asString();
		
				
		responsestr = utility.jsonFormat(responsestr);
		test.log(Status.INFO,MarkupHelper.createLabel("Request Body", ExtentColor.PURPLE));
		test.info(requestFormatted);
		JsonPath js = new JsonPath(responsestr);
		
		test.log(Status.INFO,MarkupHelper.createLabel("Response Body", ExtentColor.PURPLE));
		test.info(responsestr);
		int statusCode = res.statusCode();
		test.log(Status.INFO,MarkupHelper.createLabel("Status Code", ExtentColor.PURPLE));
		test.info(statusCode+"");
		if(statusCode==200)
		{
			test.pass("Post service executed successfully");
			test.log(Status.PASS,MarkupHelper.createLabel("PASS:Post service executed successfully", ExtentColor.GREEN));
		}
		else
		{
			test.fail("Unable to complete Post service");
			test.log(Status.FAIL,MarkupHelper.createLabel("FAIL:Unable to complete Post service", ExtentColor.RED));
			Assert.fail();
		}
	}
	
	public static void Error(String testcaseID,String payload) throws IOException
	{
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
		prop.load(fileInput);
		String storePost_endpoint=prop.getProperty("StorePost");
		
		test.log(Status.INFO,MarkupHelper.createLabel("End Point", ExtentColor.PURPLE));
		test.info(storePost_endpoint);
		
		
		String requestFormatted=utility.jsonFormat(payload);
		test.log(Status.INFO,MarkupHelper.createLabel("Request Body", ExtentColor.PURPLE));
		test.info(requestFormatted);
		Response res = GetResponse.sendRequestPost(payload, "api_key", "special-key", storePost_endpoint,testcaseID);
		String responsestr = res.asString();
		
				
		responsestr = utility.jsonFormat(responsestr);
		test.log(Status.INFO,MarkupHelper.createLabel("Response Body", ExtentColor.PURPLE));
		test.info(responsestr);
		JsonPath js = new JsonPath(responsestr);
		
		int statusCode = res.statusCode();
		test.log(Status.INFO,MarkupHelper.createLabel("Status Code", ExtentColor.PURPLE));
		test.info(statusCode+"");
		String message=js.get("message");
		if(statusCode!=200)
		{
			test.log(Status.INFO,MarkupHelper.createLabel("Error Message", ExtentColor.PURPLE));
			test.info(message);
			
			test.log(Status.PASS,MarkupHelper.createLabel("PASS", ExtentColor.GREEN));
		}
		else
		{

			test.log(Status.FAIL,MarkupHelper.createLabel("FAIL", ExtentColor.RED));
			Assert.fail(message);
		}
	}
}
