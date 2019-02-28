package com.practicevelocity.seleniumEreg.Tests;

import java.util.regex.Pattern;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import com.practicevelocity.seleniumEreg.PageObjects.EregPinAPICheckObjects;
import com.practicevelocity.seleniumEreg.PageObjects.PVMLoginObjects;
import com.practicevelocity.seleniumEreg.PageObjects.PVMeRegInitiatedObject;
import com.steadystate.css.parser.selectors.PseudoElementSelectorImpl;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author tcammon
 *
 */
public class PVMEregInitiateTest {
	
	WebDriver driver;
	String projectPath;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	@BeforeTest
	public void setUp() throws Exception {
		
		projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/seleniumdrivers/chrome/chromedriver.exe");
    	driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", projectPath+"/seleniumdrivers/Firefox/geckodriver.exe");	
    	//driver = new FirefoxDriver();
    	
    	//driver.manage().window().maximize();
    	
	}

	@Test
	public void eRegInit() throws Exception {
		// Import excel sheet.
		File src=new File(projectPath+"/data/TestData.xlsx"); 

		// Load the file.
		FileInputStream rc = new FileInputStream(src);

		// Load the workbook.
		workbook = new XSSFWorkbook(rc);
		
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.get("https://st2pvpm.practicevelocity.com/");
		sheet= workbook.getSheetAt(0);
		
		for(int i=1; i<=sheet.getLastRowNum(); i++){
			
			cell = sheet.getRow(i).getCell(0);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			PVMLoginObjects.login_username(driver).clear();
			PVMLoginObjects.login_username(driver).sendKeys(cell.getStringCellValue());
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			PVMLoginObjects.login_pwd(driver).clear();
			PVMLoginObjects.login_pwd(driver).sendKeys(cell.getStringCellValue()); 	
			PVMLoginObjects.login_pwd(driver).sendKeys(Keys.RETURN);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PVMeRegInitiatedObject.AddNew_privateVisit(driver).click();
			cell = sheet.getRow(i).getCell(2);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			PVMeRegInitiatedObject.VisitLastName(driver).clear();
			PVMeRegInitiatedObject.VisitLastName(driver).sendKeys(cell.getStringCellValue());
			cell = sheet.getRow(i).getCell(3);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			PVMeRegInitiatedObject.VisitFirstName(driver).clear();
			PVMeRegInitiatedObject.VisitFirstName(driver).sendKeys(cell.getStringCellValue());
			PVMeRegInitiatedObject.visitVerify(driver).click();
			PVMeRegInitiatedObject.visitSendToKiosk(driver).click();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@AfterTest
	public void teardownTest(){
		//close browser
		driver.quit();
		System.out.println("session completed successfully check report for test results");
	
	}

}

