package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.project.baseTest.Base;

public class SignInPage extends Base{

	By userLocator = By.name("username");
	By passLocator = By.name("password");
//	By signInBtnLocator = By.name("login");
	By dropDownSignInBtnLocator = By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/div/ul/li[3]/div/a");
	By signInBtnLocator = By.xpath("//*[@id=\'//header-waypoint-sticky\']/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[1]");
	By loginBtnLocator = By.xpath("//*[@id=\'loginfrm\']/button");
	By homePageLocator = By.xpath("//*[@id=\'search\']/div");
	
	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void signIn(String user, String pass) throws InterruptedException {
		click(dropDownSignInBtnLocator);
		click(signInBtnLocator);
		
		Thread.sleep(6000);
	
		System.out.println("User:"+user);
		System.out.println("Pass:"+pass);
		
		if(isDisplayed(passLocator)) {
			type(user, userLocator);
			type(pass, passLocator);
			click(loginBtnLocator);
			Thread.sleep(4000);
			back();
		}else {
			System.out.println("Username textbox was not present");
		}
		
	}
	
	public boolean isHomePageDisplayed() {
		return isDisplayed(homePageLocator);
	}

}
