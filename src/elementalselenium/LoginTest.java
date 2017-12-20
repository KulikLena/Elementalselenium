package elementalselenium;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

//import static org.testng.Assert.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginTest {
	private static WebDriver driverMozilla;
 
 
  @BeforeClass
  public void setUp() {
	  System.setProperty("webdriver.gecko.driver", "d:\\geckodriver.exe");
      driverMozilla = new FirefoxDriver();
  }
  public Boolean isDisplayed(By locator) {
	    try {
	      return driverMozilla.findElement(locator).isDisplayed();
	    } catch (org.openqa.selenium.NoSuchElementException exception) {
	      return false;
	    }
	  }
  @Test
  public void withValidCredentials() {
      driverMozilla.get("http://the-internet.herokuapp.com/login");
      driverMozilla.findElement(By.id("username")).sendKeys("tomsmith");
      driverMozilla.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
      driverMozilla.findElement(By.cssSelector("#login button")).click();
      WebDriverWait wait = new WebDriverWait(driverMozilla, 2);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#flash.success")));
      Assert.assertEquals(isDisplayed(By.cssSelector("#flash.success")), true); 
     
      
  }
  @AfterClass 
  public void tearDown() {
	  driverMozilla.quit();
  }



}