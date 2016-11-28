package com.swapi.sw;

import com.swapi.APIConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.*;
import com.swapi.models.*;



/**
 * Created by Manish on 11/10/2016.
 * The Star Wars Api class
 */
public class StarWarsApi {

    private ObjectMapper mapper;

    public static void main(String[] args)
    {
        StarWarsApi api = new StarWarsApi();
         
        SWModelList<?> swl =  api.getSearchResultsForPeople("Luke");
        System.out.println(swl.results.isEmpty());	
 
    }
    public StarWarsApi() {
     mapper = new ObjectMapper();
    }

    
    @SuppressWarnings("unchecked")
	public SWModelList<?> getSearchResultsForPeople (String searchContext) {
    	
		SWModelList<People> swl = new SWModelList<People>();
    	String searchURL = APIConstants.BASE_URL + APIConstants.PEOPLE +  "?format=json" + APIConstants.SEARCH + searchContext;
    	String sResults = null;
    	
    	
		try {
			sResults = callJSONService(searchURL);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			swl = mapper.readValue(sResults, SWModelList.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return swl;
    }
    
    public People getPeople(String number) {
    	People p = new People();
    	
    	try {
    		
    		String searchURL = APIConstants.BASE_URL + APIConstants.PEOPLE + number + "?format=json";
    		String sResults = callJSONService(searchURL);
    		
    	    p = mapper.readValue(sResults, People.class);
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
    
	private String callJSONService(String searchURL) throws IOException, MalformedURLException {
		URLConnection connection = new URL(searchURL).openConnection();
		connection.setRequestProperty("User-Agent", "swapi-Java-" + APIConstants.APPLICATION_NAME);;
		connection.setReadTimeout(1000);
		BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = r.readLine()) != null) {
		    sb.append(line);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
