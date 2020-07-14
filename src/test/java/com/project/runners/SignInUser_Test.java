package com.project.runners;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.project.pages.SignInPage;

public class SignInUser_Test {
	private WebDriver driver;
	public SignInPage signInPage;


	@Before
	public void setUp() throws Exception {
		signInPage = new SignInPage(driver);
		driver = signInPage.chromeDriverConnection();
	
//		signInPage.visit("http://newtours.demoaut.com/mercurywelcome.php");
		
		signInPage.visit("https://www.phptravels.net/home");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
//	User:user@phptravels.com
//	Pass:demouser

	@Test
	public void UserSingIn() throws InterruptedException, IOException {
		
		String user = "user@phptravels.com";
		String pass = "demouser";
		
		signInPage.signIn(user, pass);		
		Thread.sleep(6000);
		assertTrue(signInPage.isHomePageDisplayed());
	}

}
