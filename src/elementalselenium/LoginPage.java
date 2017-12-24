package elementalselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	By usernameLocator =  By.id("username");
	By passwordLocator =  By.id("password");
	By submitLocator =  By.cssSelector("#login button");
	 
	private final WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public LoginPage typeUsername(String username) {
	driver.findElement(usernameLocator).sendKeys(username);
	return this;
	} 
	public LoginPage typePassword(String password) {
	driver.findElement(passwordLocator).sendKeys(password);
	return this;
	} 
	public LoginTest submitLogin() {
	driver.findElement(submitLocator).submit();
	return new LoginTest();
	} 
	public LoginPage submitLoginExpectingFailure() {
	driver.findElement(submitLocator).submit();
	return new LoginPage(driver);
	} 
	public LoginTest loginAs(String username, String password) {
	typeUsername(username);
	typePassword(password);
	return submitLogin();
	}
	}
