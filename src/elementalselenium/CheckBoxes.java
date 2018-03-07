package elementalselenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckBoxes {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
    	System.setProperty("webdriver.gecko.driver", "d:\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void checkboxDiscoveryTest() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        System.out.println("With .attribute('checked')");
        for (WebElement checkbox : checkboxes) {
            System.out.println(String.valueOf(checkbox.getAttribute("checked")));
        }

        System.out.println("\nWith .selected?");
        for (WebElement checkbox : checkboxes) {
            System.out.println(checkbox.isSelected());
        }
        
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
        assertThat(checkbox.getAttribute("checked"), is(not("null")));
        assertThat(checkbox.getAttribute("checked"), is("true"));
    
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
        assertThat(checkbox1.isSelected(), is(true));
    }
    
    
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
