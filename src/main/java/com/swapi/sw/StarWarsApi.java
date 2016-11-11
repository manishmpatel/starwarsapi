package com.swapi.sw;

import com.swapi.APIConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.*;
import com.swapi.models.*;



/**
 * Created by Manish on 11/10/2016.
 * The Star Wars Api class
 */
public class StarWarsApi {

	
    private StarWars mSwApi;
    private static StarWarsApi sInstance;
    private ObjectMapper mapper;

    public static void main(String[] args)
    {
        StarWarsApi api = new StarWarsApi();
            
        api.getPeople();
        	
 
    }
    public StarWarsApi() {
     mapper = new ObjectMapper();
    }

    public static void init() {
        sInstance = new StarWarsApi();
    }

    public static StarWars getApi() {
        return sInstance.mSwApi;
    }

    public void setApi(StarWars starWarsApi) {
        sInstance.mSwApi = starWarsApi;
    }
    public People getPeople() {
    	People p = new People();
    	
    	try {
    		URLConnection connection = new URL("https://swapi.co/api/people/1/?format=json").openConnection();
    		connection.setRequestProperty("User-Agent", "swapi-Java-" + APIConstants.APPLICATION_NAME);;
    		connection.setReadTimeout(1000);
    		BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));

    		StringBuilder sb = new StringBuilder();
    		String line;
    		while ((line = r.readLine()) != null) {
    		    sb.append(line);
    		}
    		System.out.println(sb.toString());
    		
    	    p = mapper.readValue(sb.toString(), People.class);
		    System.out.println(p.hairColor);
    	
    	} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return p;
    }
}
