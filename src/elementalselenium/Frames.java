package elementalselenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class Frames {
	private static WebDriver driverMozilla;
	
	 @Before
	    public void setUp() throws Exception {
		 System.setProperty("webdriver.gecko.driver", "d:\\geckodriver.exe");
	      driverMozilla = new FirefoxDriver();
	    }
	  @Test
	    public void nestedFrames() throws Exception {
		  driverMozilla.get("http://the-internet.herokuapp.com/nested_frames");
		  driverMozilla.switchTo().frame("frame-top");
		  driverMozilla.switchTo().frame("frame-middle");
	        assertThat(driverMozilla.findElement(By.id("content")).getText(), is(equalTo("MIDDLE")));
	        
	        driverMozilla.get("http://the-internet.herokuapp.com/tinymce");
	        driverMozilla.switchTo().frame("mce_0_ifr");
	        WebElement editor =  driverMozilla.findElement(By.id("tinymce"));
	        String beforeText = editor.getText();
	        editor.clear();
	        editor.sendKeys("Hello World!");
	        String afterText = editor.getText();
	        assertThat(afterText, not(equalTo((beforeText))));
	    }
	    @After
	    public void tearDown() throws Exception {
	    	driverMozilla.quit();
	    }

}
