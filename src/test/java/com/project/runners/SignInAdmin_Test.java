package com.project.runners;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.project.helpers.ReadExcelFile;
import com.project.helpers.WriteExcelFile;
import com.project.pages.SignInAdminPage;

public class SignInAdmin_Test {
	private WebDriver driver;
	public SignInAdminPage signAdminInPage;
	
	public WriteExcelFile writeFile;
	public ReadExcelFile readFile;
	public String filepath;

	@Before
	public void setUp() throws Exception {
		signAdminInPage = new SignInAdminPage(driver);
		driver = signAdminInPage.chromeDriverConnection();
		
		readFile = new ReadExcelFile();
		writeFile = new WriteExcelFile();
		filepath = "src/test/resources/data/Test.xlsx";		

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
		
		String user = readFile.getCellValue(filepath, "Credenciales", 1, 0);
		String pass = readFile.getCellValue(filepath, "Credenciales", 1, 1);
		
		signAdminInPage.signIn(user, pass);		
		Thread.sleep(6000);
		assertTrue(signAdminInPage.isAdminPageDisplayed());
	
		writeFile.writeCellValue(filepath, "Credenciales", 1, 2, "administrador");		
	}

}
