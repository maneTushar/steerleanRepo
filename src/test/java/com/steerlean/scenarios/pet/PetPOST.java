package com.steerlean.scenarios.pet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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


public class PetPOST extends Reporting {
	public static String dir = System.getProperty("user.dir");
	
	public static File file = new File(".//src//main//resources//endpoints//endpoints.properties");
	
	
	
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
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the Pet service is successfully added new Pet when valid values are passed for all attributes in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("101", "1001", "cats", "Doremon", "abc.png", "1001", "cats", "available");
		success(testCaseID,payload);
	}
	

	@Test
	public void TC_02() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when character value for ID attribute is passed in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("'"+"Test"+"'", "1001", "cats", "Doremon", "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_03() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when alphanumeric value for ID attribute is passed in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("'"+"Test123"+"'", "1001", "cats", "Doremon", "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_04() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the Pet service is successfully added new Pet when valid values are passed for all attributes in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("$%^&", "1001", "cats", "Doremon", "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_05() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when null  value for ID attribute is passed in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost(null, "1001", "cats", "Doremon", "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_06() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when String value is passed for Category ID attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "'"+"Test"+"'", "cats", "Doremon", "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_07() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when Special Character value is passed for Category ID attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001","'"+"$%^&"+"'", "cats", "Doremon", "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_08() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when null value is passed for Category ID attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", null, "cats", "Doremon", "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	
	
	
	@Test
	public void TC_09() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when Special Character value is passed for Category name attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "%^&", "Doremon", "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_10() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when empty "
				+ "value is passed for Category name attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "", "Doremon", "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_11() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when space value is passed for Category name attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", " ", "Doremon", "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_12() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when space value is passed for Pet name attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "cats", " ", "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_13() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when special "
				+ "charater value is passed for Pet name attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "cats", "$%^&", "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_14() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when empty charater value is passed for Pet name attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "cats", "", "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_15() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when null value is passed for Pet name attribute  in JSON Request.", ExtentColor.PURPLE));
		String payload=PostMethod.petPost("1001", "1001", "cats", null, "abc.png", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_16() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when special character value is passed for PhotoURLs attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "cats", "Doremon", "$%^&", "1001", "cats", "available");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_17() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when special character value is passed for Tag ID attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "cats", "Doremon", "abc.png", "%^&*", "cats", "available");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_18() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when string value is passed for Tag ID attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "cats", "Doremon", "abc.png", "'"+"HGH"+"'", "cats", "available");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_19() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when space is passed for Tag ID attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "cats", "Doremon", "abc.png", "'"+" "+"'", "cats", "available");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_20() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when empty value is passed for Tag ID attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "cats", "Doremon", "abc.png", "'"+""+"'", "cats", "available");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_21() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when empty value is passed for Tag name attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "cats", "Doremon", "abc.png", "1001", "", "available");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_22() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when space value is passed for Tag name attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "cats", "Doremon", "abc.png", "1001", " ", "available");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_23() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the Pet service is successfully added new Pet when valid values are passed for all attributes in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "cats", "Doremon", "abc.png", "1001", " ", "available");
		Error(testCaseID,payload);
	}
	
	
	@Test
	public void TC_24() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when speical character value is passed for status attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "cats", "Doremon", "abc.png", "1001", "cats", "$%^&");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_25() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when"
				+ " space value is passed for status attribute  in JSON Request.", ExtentColor.PURPLE));
		String payload=PostMethod.petPost("1001", "1001", "cats", "Doremon", "abc.png", "1001", "cats", " ");
		Error(testCaseID,payload);
	}
	
	@Test
	public void TC_26() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when empty value is passed for status attribute  in JSON Request.", ExtentColor.PURPLE));
		
		String payload=PostMethod.petPost("1001", "1001", "cats", "Doremon", "abc.png", "1001", "cats", "");
		Error(testCaseID,payload);
	}
	@Test
	public void TC_27() throws IOException
	{
		String testCaseID = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		test.log(Status.INFO,MarkupHelper.createLabel("Validate that the ERROR message is retrieved as response when  value other than available,pending,sold is passed for status attribute  in JSON Request.", ExtentColor.PURPLE));
		String payload=PostMethod.petPost("1001", "1001", "cats", "Doremon", "abc.png", "1001", "cats", "Not available");
		Error(testCaseID,payload);
	}
	
	public static void success(String testcaseID,String payload) throws IOException
	{
		
		
		
		
		
		
		
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
		prop.load(fileInput);
		String storePost_endpoint=prop.getProperty("StorePost");
		
		
		
		test.log(Status.INFO,MarkupHelper.createLabel("End Point", ExtentColor.PURPLE));
		test.info(storePost_endpoint);
		
		
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
