package com.steerlean.methods;

public class PutMethod {
	
	public static String petPut(String id,String categoryID,String categoryName,String name,String photoURL,String tagID,String tagName,String status)
	{
		String payload="{\"id\":"+id+",\""
				+ "category\":{\"id\":"+categoryID+",\"name\":\""+categoryName+"\"},"
				+ "\"name\":\""+name+"\",\"photoUrls\":[\""+photoURL+"\"],"
				+ "\"tags\":[{\"id\":"+tagID+",\"name\":\""+tagName+"\"}],"
				+ "\"status\":\""+status+"\"}";
		
		return payload;
	}

}
