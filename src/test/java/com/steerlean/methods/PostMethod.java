package com.steerlean.methods;

public class PostMethod {
	
	public static String petPost(String id,String categoryID,String categoryName,String name,String photoURL,String tagID,String tagName,String status)
	{
		String payload="{\"id\":"+id+",\""
				+ "category\":{\"id\":"+categoryID+",\"name\":\""+categoryName+"\"},"
				+ "\"name\":\""+name+"\",\"photoUrls\":[\""+photoURL+"\"],"
				+ "\"tags\":[{\"id\":"+tagID+",\"name\":\""+tagName+"\"}],"
				+ "\"status\":\""+status+"\"}";
		
		return payload;
	}
	
	public static String storePost(String id,String petID,String quantity,String shipDate,String status,String complete)
	{
		String payload="{\"id\":"+id+","
				+ "\"petId\":"+petID+","
				+ "\"quantity\":"+quantity+","
				+ "\"shipDate\":\""+shipDate+"\","
				+ "\"status\":\""+status+"\","
				+ "\"complete\":"+complete+"}";
		
		return payload;
		
	}

}
