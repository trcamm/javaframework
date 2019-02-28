package com.practicevelocity.seleniumEreg.NavConfig;

import java.util.regex.Pattern;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import com.practicevelocity.seleniumEreg.PageObjects.EregNavigationObjects;
import com.practicevelocity.seleniumEreg.PageObjects.PVMLoginObjects;

import static org.testng.Assert.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author tcammon
 *
 */


public class InClinicEndAfterOnsetNewPatientConfig {

	private WebDriver driver;
	String projectPath;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFSheet sheet2;
	XSSFCell cell;
	
	@BeforeTest
	public void setUp() throws Exception {

		projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/seleniumdrivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", projectPath+"/seleniumdrivers/Firefox/geckodriver.exe");	
		//driver = new FirefoxDriver();
	}

	@Test
	public void endAfterOnsetNewPatSelect() throws Exception {

		File src=new File(projectPath+"/data/TestData.xlsx"); 

		// Load the file.
		FileInputStream rc = new FileInputStream(src);

		// Load the workbook.
		workbook = new XSSFWorkbook(rc);
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://st2pvpm.practicevelocity.com/");
		sheet= workbook.getSheetAt(0);
		sheet2= workbook.getSheetAt(2);
		
		for(int i=1; i<=sheet.getLastRowNum(); i++){

			cell = sheet.getRow(i).getCell(0);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			PVMLoginObjects.login_username(driver).clear();
			PVMLoginObjects.login_username(driver).sendKeys(cell.getStringCellValue());
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			PVMLoginObjects.login_pwd(driver).clear();
			PVMLoginObjects.login_pwd(driver).sendKeys(cell.getStringCellValue()); 	
			PVMLoginObjects.login_btn(driver).sendKeys(Keys.RETURN);
			
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Used javascriptExecutor to embed javascript  in order to interact with element on menu 
		WebElement element = EregNavigationObjects.resourcePractice_Clinic(driver);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=1; i<=sheet2.getLastRowNum(); i++){
			cell = sheet2.getRow(i).getCell(0);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregNavigationObjects.PracticeSearch(driver).clear();
			EregNavigationObjects.PracticeSearch(driver).sendKeys(cell.getStringCellValue());
			EregNavigationObjects.practiceLink(driver).click();
			EregNavigationObjects.clinicLink(driver).click();
			new Select(EregNavigationObjects.KioskEndpoint(driver)).selectByVisibleText("End After Onset - New Patient");
			EregNavigationObjects.NavConfig_SaveExit(driver).click();
			EregNavigationObjects.NavConfig_SaveExit(driver).click();
			EregNavigationObjects.Config_logout(driver).click();
		}
	}

	@AfterTest
	public void teardown(){
		//close browser
		driver.quit();
		System.out.println("session completed successfully check report for test results");

	}
	
}
