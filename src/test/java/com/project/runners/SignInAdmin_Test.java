package com.project.runners;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.project.pages.SignInAdminPage;

public class SignInAdmin_Test {
	private WebDriver driver;
	public SignInAdminPage signAdminInPage;


	@Before
	public void setUp() throws Exception {
		signAdminInPage = new SignInAdminPage(driver);
		driver = signAdminInPage.chromeDriverConnection();
		
//		signInPage.visit("http://newtours.demoaut.com/mercurywelcome.php");	
		signAdminInPage.visit("https://www.phptravels.net/admin");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
//	User:admin@phptravels.com
//	Pass:demoadmin

	@Test
	public void UserSingIn() throws InterruptedException, IOException {
		
		String user = "admin@phptravels.com";
		String pass = "demoadmin";
		
		signAdminInPage.signIn(user, pass);		
		Thread.sleep(6000);
		assertTrue(signAdminInPage.isAdminPageDisplayed());	
	}

}
