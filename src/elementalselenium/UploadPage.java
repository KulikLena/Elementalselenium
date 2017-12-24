package elementalselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadPage {
	//public WebDriver drive;
	By uploadLocator = By.id("file-upload");
	By submitLocator = By.id("file-submit");
	
	public void uploadFile(WebDriver driver, String s) {
		driver.findElement(uploadLocator).sendKeys(s);
		driver.findElement(submitLocator).submit();
	}

}
