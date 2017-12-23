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



public class FrameJS2 {
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
	  driverMozilla.get("http://the-internet.herokuapp.com/nested_frames");
	  driverMozilla.switchTo().frame("frame-top");
	  driverMozilla.switchTo().frame("frame-left");
	  String s = driverMozilla.findElement(By.xpath("//body")).getText();
	  System.out.println(s);
	  
	  driverMozilla.switchTo().defaultContent();
	  driverMozilla.switchTo().frame("frame-top");
	  driverMozilla.switchTo().frame("frame-middle");
	  String k = driverMozilla.findElement(By.xpath("//body")).getText();
	  System.out.println(k);
	  
	  driverMozilla.switchTo().defaultContent();
	  driverMozilla.switchTo().frame("frame-top");
	  driverMozilla.switchTo().frame("frame-right");
	  String l = driverMozilla.findElement(By.xpath("//body")).getText();
	  System.out.println(l);
	  
	  driverMozilla.switchTo().defaultContent();
	  driverMozilla.switchTo().frame("frame-bottom");
	  String m = driverMozilla.findElement(By.xpath("//body")).getText();
	  System.out.println(m);
	  
                     
  }
  @AfterClass 
  public void tearDown() {
	  driverMozilla.quit();
  }



}
