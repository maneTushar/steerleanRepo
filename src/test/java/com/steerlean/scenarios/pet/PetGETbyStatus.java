package com.steerlean.scenarios.pet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import methods.PostMethod;
import utils.GetResponse;
import utils.utility;

public class PetGETbyStatus {
	
public static String dir = System.getProperty("user.dir");
	
	static File file = new File(".//src//main//resources//endpoints//endpoints.properties");
	
	
	@Test
	public static void success() throws IOException
	{
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
		prop.load(fileInput);
		String petGET_endpoint=prop.getProperty("PetFindByStatus");
		String petGet_endpointURL=petGET_endpoint+"available";
		
		String payload=PostMethod.petPost("101", "1001", "cats", "Doremon", "abc.png", "1001", "cats", "available");
		String requestFormatted=utility.jsonFormat(payload);
		Response res = GetResponse.sendRequestGet("api_key", "special-key", petGet_endpointURL, "", "");
		String responsestr = res.asString();
		responsestr = utility.jsonFormat(responsestr);
		JsonPath js = new JsonPath(responsestr);
		System.out.println("JS->"+responsestr);
		String statusCode = String.valueOf(res.statusCode());
		System.out.println("WSSTatus"+statusCode);
		
		System.out.println("petPost_endpoint"+petGet_endpointURL);
	}

}
