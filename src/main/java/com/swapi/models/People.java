package com.swapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Manish on 11/16/2016
 * People model represents an individual person or character within the Star Wars universe.
 */
@JsonIgnoreProperties({"count","next","previous","results"})
public class People implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	/*public String count;
	public String next;
	public String previous;
	public String results;
	*/
	public String name;

	
    @JsonProperty("birth_year")
    public String birthYear;

    @JsonProperty("films")
    public ArrayList<String> filmsUrls;

    public String gender;

    @JsonProperty("hair_color")
    public String hairColor;

    public String height;

    @JsonProperty("homeworld")
    public String homeWorldUrl;

    public String mass;

    @JsonProperty("skin_color")
    public String skinColor;
    
    @JsonProperty("eye_color")
    public String eyeColor;

    public String created;
    public String edited;
    public String url;
    @JsonProperty("species")
    public ArrayList<String> speciesUrls;

    @JsonProperty("starships")
    public ArrayList<String> starshipsUrls;

    @JsonProperty("vehicles")
    public ArrayList<String> vehiclesUrls;
}
