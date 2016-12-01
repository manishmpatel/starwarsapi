package com.optum.guidance.integration.testing;

import org.testng.annotations.Test;

import com.swapi.models.SWModelList;
import com.swapi.sw.StarWarsApi;

public class SwapiAPITest {
  
  @Test (groups="integration_tests", threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
  public void test_swapi_api_call() {
	  StarWarsApi api = new StarWarsApi();
	  SWModelList<?> swl =  api.getSearchResultsForPeople("Luke");
      System.out.println(swl.results.isEmpty());	
  }
}
