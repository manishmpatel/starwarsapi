package com.optum.guidance.testng.roundtabledemo;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import static org.mockserver.integration.ClientAndProxy.startClientAndProxy;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import io.netty.handler.codec.http.HttpHeaders;
import org.mockserver.model.Header;
import org.mockserver.model.Parameter;
import org.mockserver.socket.PortFactory;
import static org.mockserver.verify.VerificationTimes.exactly;
import org.mockserver.integration.ClientAndProxy;
import org.mockserver.integration.ClientAndServer;

public class SearchPeopleUnitTest {

	private ClientAndProxy proxy;
	private ClientAndServer mockServer;

	public static void main(String args[]) {
		SearchPeopleUnitTest sp = new SearchPeopleUnitTest();
		sp.beforeTest();
		sp.startMockServer();

	}

	@Test
  public void startMockServer() {
	  
	  String mockJson = "{\"count\":1,\"next\":null,\"previous\":null,\"results\":[{\"name\":\"Luke Skywalker\",\"height\":\"172\",\"mass\":\"77\",\"hair_color\":\"blond\",\"skin_color\":\"fair\",\"eye_color\":\"blue\",\"birth_year\":\"19BBY\",\"gender\":\"male\",\"homeworld\":\"http://swapi.co/api/planets/1/\",\"films\":[\"http://swapi.co/api/films/6/\",\"http://swapi.co/api/films/3/\",\"http://swapi.co/api/films/2/\",\"http://swapi.co/api/films/1/\",\"http://swapi.co/api/films/7/\"],\"species\":[\"http://swapi.co/api/species/1/\"],\"vehicles\":[\"http://swapi.co/api/vehicles/14/\",\"http://swapi.co/api/vehicles/30/\"],\"starships\":[\"http://swapi.co/api/starships/12/\",\"http://swapi.co/api/starships/22/\"],\"created\":\"2014-12-09T13:50:51.644000Z\",\"edited\":\"2014-12-20T21:17:56.891000Z\",\"url\":\"http://swapi.co/api/people/1/\"}]}";
		  
		  
	  mockServer
      .when(
              request()
                      .withPath("/api/people/")
      )
      .respond(
              response()
                      .withHeaders(
                              new Header(HttpHeaders.Names.CONTENT_TYPE, "JSON")
                      )
                      .withBody(mockJson)
      );
  }

	@BeforeTest
	public void beforeTest() {
		mockServer = startClientAndServer(1080);
		proxy = startClientAndProxy(1090);
	}

	@AfterTest
	public void afterTest() {
		proxy.stop();
		mockServer.stop();
	}

}
