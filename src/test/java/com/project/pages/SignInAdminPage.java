package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.project.baseTest.Base;

public class SignInAdminPage extends Base{

	By userLocator = By.name("email");
	By passLocator = By.name("password");
	By loginBtnLocator = By.xpath("/html/body/div[2]/form[1]/button");
	By adminDashboarLocator = By.xpath("//*[@id=\'content\']/div[2]");
	By adminPageLocator = By.xpath("//*[@id=\'mainHeader\']/strong");
	
	public SignInAdminPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void signIn(String user, String pass) {
	
		System.out.println("User:"+user);
		System.out.println("Pass:"+pass);
		
		if(isDisplayed(userLocator)) {
			type(user, userLocator);
			type(pass, passLocator);
			click(loginBtnLocator);
		}else {
			System.out.println("Username textbox was not present");
		}
		
	}
	
	public boolean isAdminPageDisplayed() {
		return isDisplayed(adminDashboarLocator);
	}
	
	public boolean isAdminDisplayed() {
		return isDisplayed(adminPageLocator);
	}

}
