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

public class PetDELETE {

static File file = new File(".//src//main//resources//endpoints//endpoints.properties");
	
	
	@Test
	public static void success() throws IOException
	{
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
		prop.load(fileInput);
		String petDelete_endpoint=prop.getProperty("PetDelete");
		String petDelete_endpointURL=petDelete_endpoint+"101";
		
		String payload=PostMethod.petPost("101", "1001", "cats", "Doremon", "abc.png", "1001", "cats", "available");
		String requestFormatted=utility.jsonFormat(payload);
		Response res = GetResponse.sendRequestDelete("api_key", "special-key", petDelete_endpointURL);
		String responsestr = res.asString();
		responsestr = utility.jsonFormat(responsestr);
		JsonPath js = new JsonPath(responsestr);
		System.out.println("JS->"+responsestr);
		String statusCode = String.valueOf(res.statusCode());
		System.out.println("WSSTatus"+statusCode);
		
		System.out.println("petPost_endpoint"+petDelete_endpointURL);
	}
}
