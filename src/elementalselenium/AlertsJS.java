package elementalselenium;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

//import static org.testng.Assert.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AlertsJS {
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
	  driverMozilla.get("http://the-internet.herokuapp.com/javascript_alerts");
      driverMozilla.findElement(By.cssSelector("button[onclick=\"jsAlert()\"]")).click();
      Alert al1 = driverMozilla.switchTo().alert();
      al1.accept();
      Assert.assertEquals(driverMozilla.findElement(By.id("result")).getText(), "You successfuly clicked an alert"); 
      
      driverMozilla.findElement(By.cssSelector("button[onclick=\"jsConfirm()\"]")).click();
      Alert al2= driverMozilla.switchTo().alert();
      al2.dismiss();
      Assert.assertEquals(driverMozilla.findElement(By.id("result")).getText(), "You clicked: Cancel"); 
    
      driverMozilla.findElement(By.cssSelector("button[onclick=\"jsPrompt()\"]")).click();
      Alert al3= driverMozilla.switchTo().alert();
      String s = new String ("Hello!!");
      al3.sendKeys(s);
      al3.accept();
      Assert.assertEquals(driverMozilla.findElement(By.id("result")).getText(), "You entered: "+s); 

                 
  }
  @AfterClass 
  public void tearDown() {
	  driverMozilla.quit();
  }



}
