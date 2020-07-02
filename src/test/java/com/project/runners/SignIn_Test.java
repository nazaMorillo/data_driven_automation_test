package com.project.runners;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.project.helpers.ReadExcelFile;
import com.project.helpers.WriteExcelFile;
import com.project.pages.SignInPage;

public class SignIn_Test {
	private WebDriver driver;
	public SignInPage signInPage;
	
	public WriteExcelFile writeFile;
	public ReadExcelFile readFile;
	public String filepath;

	@Before
	public void setUp() throws Exception {
		signInPage = new SignInPage(driver);
		driver = signInPage.chromeDriverConnection();
		
		readFile = new ReadExcelFile();
		writeFile = new WriteExcelFile();
		filepath = "src/test/resources/data/Test.xlsx";
		
		signInPage.visit("http://newtours.demoaut.com/mercurywelcome.php");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void UserSingIn() throws InterruptedException, IOException {
		
		String user = readFile.getCellValue(filepath, "Credenciales", 0, 0);
		String pass = readFile.getCellValue(filepath, "Credenciales", 0, 1);
		
		signInPage.signIn(user, pass);
		
		Thread.sleep(4000);
		assertTrue(signInPage.isHomePageDisplayed());
		writeFile.writeCellValue(filepath, "Credenciales", 0, 3, "activo");
	}

}
