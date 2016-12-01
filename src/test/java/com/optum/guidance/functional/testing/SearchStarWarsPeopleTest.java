package com.optum.guidance.functional.testing;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchStarWarsPeopleTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @DataProvider(name = "CharacterNames")
  public Object[][] createData() {
	  return new Object[][] {
		  new Object[] { new String("Luke")},
		  { new String ("Han")},
	  };
	  
  }
  @Test(groups = "functional", dataProvider="CharacterNames")
  public void testSearchForLuke( String searchContext) throws Exception {
    driver.get(baseUrl + "/starwarsui/search.html");
    driver.findElement(By.name("searchContext")).clear();
    driver.findElement(By.name("searchContext")).sendKeys(searchContext);
    driver.findElement(By.cssSelector("input.flexsearch--submit")).click();
    By byXpath = By.xpath("//*[contains(., 'Skywalker')]");
    
    if (this.isElementPresent(byXpath))
    	assert true;
    else
    	assert false;
    
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
