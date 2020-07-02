package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.project.baseTest.Base;

public class SignInPage extends Base{

	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("login");
	
	By homePageLocator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");
	
	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void signIn(String user, String pass) {
		if(isDisplayed(userLocator)) {
			type(user, userLocator);
			type(pass, passLocator);
			click(signInBtnLocator);
		}else {
			System.out.println("Username textbox was not present");
		}
		
	}
	
	public boolean isHomePageDisplayed() {
		return isDisplayed(homePageLocator);
	}

}
