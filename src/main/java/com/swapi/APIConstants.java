package com.swapi;

/**
 * Created by Manish on 11/30/2016
 * API constants
 */
public class APIConstants {
    public static  String BASE_URL = "http://swapi.co/api/";
    public static  String APPLICATION_NAME = "SWAPI-JAVA";
    public static  String PEOPLE = "people/";
    public static  String SEARCH = "&search=";
	
    public static String getBASE_URL() {
		return BASE_URL;
	}
	public static void setBASE_URL(String bASE_URL) {
		BASE_URL = bASE_URL;
	}
}
