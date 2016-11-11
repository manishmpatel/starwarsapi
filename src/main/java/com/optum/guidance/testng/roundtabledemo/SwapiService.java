package com.optum.guidance.testng.roundtabledemo;

import com.swapi.models.Film;
import com.swapi.models.SWModelList;
import com.swapi.sw.StarWars;
import com.swapi.sw.StarWarsApi;

public class SwapiService {

	public SWModelList<Film> getFilms() {
	
		
    return new SWModelList<Film>(); 

}
}
