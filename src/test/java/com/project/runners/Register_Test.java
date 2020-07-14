package com.project.runners;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.project.helpers.ReadExcelFile;
import com.project.helpers.WriteExcelFile;
import com.project.pages.RegisterPage;

public class Register_Test {

	private WebDriver driver;
	public RegisterPage registerPage;
	
	public WriteExcelFile writeFile;
	public ReadExcelFile readFile;
	public String filepath;
	
	
	@Before
	public void setUp() throws Exception {
		
		registerPage = new RegisterPage(driver);
		driver = registerPage.chromeDriverConnection();
		
		readFile = new ReadExcelFile();
		writeFile = new WriteExcelFile();
		filepath = "src/test/resources/data/Test.xlsx";
		
//		registerPage.visit("http://newtours.demoaut.com/mercurywelcome.php");
		registerPage.visit("https://phptravels.com/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void UserRegister() throws InterruptedException, IOException {		

		String user = readFile.getCellValue(filepath, "Credenciales", 0, 0);
		String pass = readFile.getCellValue(filepath, "Credenciales", 0, 1);
		
		registerPage.registerUser(user, pass);
		
		assertEquals("Note: Your user name is "+user+".", registerPage.registeredMessage());
		
		writeFile.writeCellValue(filepath, "Credenciales", 0, 2, "registrado");
	}

}
