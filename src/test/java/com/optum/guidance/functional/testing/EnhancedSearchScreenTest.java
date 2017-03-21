package com.optum.guidance.functional.testing;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import com.optum.guidance.unit.testing.EnhancedSearchTest;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class EnhancedSearchScreenTest {
 

 
  @Given("^I am an Administor in the Search Sysem$")
  public void loginAsAdmin() throws Exception {
    EnhancedSearchTest est = new EnhancedSearchTest();
    boolean b = est.verifyAdministrativeUser("Mehul", "abc123");
    
  }

  @DataProvider(name = "CharacterNames")
  public Object[][] createData() {
	  return new Object[][] {
		  new Object[] { new String("Luke")},
		  { new String ("Han")},
	  };
	  
  }
  @Test(groups = "functional", dataProvider="CharacterNames")

  @When("hgghhgI type '(.+)' and submit")

    public void testSearchForLuke2( String searchContext) throws Exception {
    
    verifySearchResults();
    
  }

  @Then("^the results should come back with all of Luke Skywalker infomation$")
  public void verifySearchResults() {
	
}

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
   
  }


 
}
