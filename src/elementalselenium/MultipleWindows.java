package elementalselenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Set;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class MultipleWindows {
	private static WebDriver driverMozilla;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "d:\\geckodriver.exe");
		driverMozilla = new FirefoxDriver();
	}

	@Test
	public void multipleWindowsRedux() {
		driverMozilla.get("http://the-internet.herokuapp.com/windows");
		String firstWindow = driverMozilla.getWindowHandle();
		String newWindow = "";
		driverMozilla.findElement(By.cssSelector(".example a")).click();
		Set<String> allWindows = driverMozilla.getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(firstWindow)) {
				newWindow = window;
			}
		}

		driverMozilla.switchTo().window(firstWindow);
		assertThat(driverMozilla.getTitle(), is(not(equalTo("New Window"))));

		driverMozilla.switchTo().window(newWindow);
		assertThat(driverMozilla.getTitle(), is(equalTo("The Internet")));
	}

	@After
	public void tearDown() throws Exception {
		driverMozilla.quit();
	}
}
