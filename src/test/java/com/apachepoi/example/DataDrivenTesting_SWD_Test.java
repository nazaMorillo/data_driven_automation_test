package com.apachepoi.example;

//import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DataDrivenTesting_SWD_Test {

	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	private By searchBoxLocator = By.id("search_query_top");
	private By searchBtnLocator = By.name("submit_search");
	private By resultTextLocator = By.xpath("//*[@id=\'center_column\']/h1/span[2]");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized", "--whitelisted-ips");// ejecuta sin abrir el navegador, "--headless"
		driver = new ChromeDriver(options);	
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();

		driver.get("http://automationpractice.com");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws IOException {
		
		//Aquí poner la dirección del archivo excel de su computadora 
		//o también pueden incluirlo como parte del proyecto, la ruta sería como la que usamos para el chromedriver.exe (ver en el método setUp arriba)
		String filepath = "src/test/resources/data/Test.xlsx";

		String searchText = readFile.getCellValue(filepath, "Hoja1", 0, 0);

		driver.findElement(searchBoxLocator).clear();

		driver.findElement(searchBoxLocator).sendKeys(searchText);
		driver.findElement(searchBtnLocator).click();
		String resultText = driver.findElement(resultTextLocator).getText();

		System.out.println("Page result text:" + resultText);

		readFile.readExcel(filepath, "Hoja1");

		writeFile.writeCellValue(filepath, "Hoja1", 0, 1, resultText);

		readFile.readExcel(filepath, "Hoja1");

	}

}
