package elementalselenium;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class UploadFile {
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
  public void uploadFile() throws Exception {
      String filename = "LOGIN.txt";
      File file = new File(filename);
      String path = file.getAbsolutePath();
      driverMozilla.get("http://the-internet.herokuapp.com/upload");
      driverMozilla.findElement(By.id("file-upload")).sendKeys(path);
      driverMozilla.findElement(By.id("file-submit")).click();
      driverMozilla.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      String text = driverMozilla.findElement(By.id("uploaded-files")).getText();
      assertThat(text, is(equalTo(filename)));
  }

  @AfterClass 
  public void tearDown() {
	  driverMozilla.quit();
  }



}
