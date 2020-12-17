package com.steerelan.utils;

public class utility {
	public static String jsonFormat(String jsonResponse) {
		StringBuilder json = new StringBuilder();
	    String indentString = "";

	    for (int i = 0; i < jsonResponse.length(); i++) {
	        char letter = jsonResponse.charAt(i);
	        switch (letter) {
	            case '{':
	            case '[':
	                json.append("\n" + indentString + letter + "\n");
	                indentString = indentString + "\t";
	                json.append(indentString);
	                break;
	            case '}':
	            case ']':
	                indentString = indentString.replaceFirst("\t", "");
	                json.append("\n" + indentString + letter);
	                break;
	            case ',':
	                json.append(letter + "\n" + indentString);
	                break;

	            default:
	                json.append(letter);
	                break;
	        }
	    }
		return json.toString();
	}
}
