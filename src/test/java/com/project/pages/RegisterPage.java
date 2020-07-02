package com.project.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.baseTest.Base;

public class RegisterPage extends Base{
	
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='/images/masts/mast_register.gif']");
	
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPassworLocator = By.cssSelector("input[name='confirmPassword']");

	By registerBtnLocator = By.name("register");
	
	By registerMessage = By.tagName("font");
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void registerUser(String user, String pass) throws InterruptedException {
		click(registerLinkLocator);
		Thread.sleep(2000);
		if(isDisplayed(registerPageLocator)) {
			type(user, usernameLocator);
			type(pass, passwordLocator);
			type(pass, confirmPassworLocator);
			
			click(registerBtnLocator);
		}else {
			System.out.println("Register pages was not found");
		}	
		
	}
	
	public String registeredMessage() {
		List<WebElement> fonts = findElements(registerMessage);
		return getText(fonts.get(5));
	}
	

}
