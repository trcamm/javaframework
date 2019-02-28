package com.practicevelocity.seleniumEreg.Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.specification.RequestSpecification;
import com.practicevelocity.seleniumEreg.PageObjects.EregAbortSessionObjects;
import com.practicevelocity.seleniumEreg.PageObjects.EregPatientInfoVerificationObjects;
import com.practicevelocity.seleniumEreg.PageObjects.EregPinAPICheckObjects;
import com.practicevelocity.seleniumEreg.PageObjects.PVMLoginObjects;
import com.practicevelocity.seleniumEreg.PageObjects.PVMeRegInitiatedObject;

import static com.jayway.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import com.jayway.restassured.authentication.PreemptiveBasicAuthScheme;
import com.jayway.restassured.builder.RequestSpecBuilder;

/**
 * @author tcammon
 *
 */

public class InclinicEndAfterInsuranceInfoNewPatNavTest {

	XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFSheet sheet2;
    XSSFCell cell;
	WebDriver driver;
	WebDriver firefox;
	private String Pin;
	String projectPath;

	@BeforeTest
	public void setupTest() throws Exception{
		

		projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.gecko.driver", projectPath+"/seleniumdrivers/Firefox/geckodriver.exe");	
		firefox = new FirefoxDriver();
		firefox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/seleniumdrivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void EndAfterInsInfoNewPat() throws JSONException,InterruptedException,IOException {

		// Import excel sheet.
		File src=new File(projectPath+"/data/TestData.xlsx"); 

		// Load the file.
		FileInputStream rc = new FileInputStream(src);

		// Load the workbook.
		workbook = new XSSFWorkbook(rc);

		firefox.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		firefox.get("https://st2pvpm.practicevelocity.com/");
		sheet= workbook.getSheetAt(0);
		for(int i=1; i<=sheet.getLastRowNum(); i++){
			cell = sheet.getRow(i).getCell(0);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			PVMLoginObjects.login_username(firefox).clear();
			PVMLoginObjects.login_username(firefox).sendKeys(cell.getStringCellValue());
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			PVMLoginObjects.login_pwd(firefox).clear();
			PVMLoginObjects.login_pwd(firefox).sendKeys(cell.getStringCellValue()); 	
			PVMLoginObjects.login_btn(firefox).sendKeys(Keys.RETURN);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		//Grab eReg pin from pvm
		WebElement pin = PVMeRegInitiatedObject.pvm_GeneratePin(firefox);
		String result = pin.getAttribute("title");
		System.out.println(pin.getAttribute("title"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		firefox.close();
		// Navigate to eRegistration Page, verify correct page, enter pin
		driver.get("https://st2ereg.practicevelocity.com/qatc");
		EregPatientInfoVerificationObjects.get_pin(driver).sendKeys(result);
		EregPatientInfoVerificationObjects.insert_pin(driver).sendKeys(Keys.RETURN);

		// Load the sheet in which data is stored.
		sheet2= workbook.getSheetAt(1);		 

		for(int i=1; i<=sheet2.getLastRowNum(); i++){

			//Navigate pass Is Emergency page to PatientID Photo page then abort
			EregPatientInfoVerificationObjects.noEmergency_btn(driver).click();
			EregPatientInfoVerificationObjects.no_photoID(driver).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			EregPatientInfoVerificationObjects.no_InsuranceCard(driver).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			EregPatientInfoVerificationObjects.nxt_btn(driver).click();

			Select dropdown4 = new Select(EregPatientInfoVerificationObjects.gender(driver));
			dropdown4.selectByIndex(1);

			cell = sheet2.getRow(i).getCell(0);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.patient_ssn(driver).clear();
			EregPatientInfoVerificationObjects.patient_ssn(driver).sendKeys(cell.getStringCellValue());

			cell = sheet2.getRow(i).getCell(1);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.patient_birthdate(driver).clear();
			EregPatientInfoVerificationObjects.patient_birthdate(driver).sendKeys(cell.getStringCellValue());

			cell = sheet2.getRow(i).getCell(2);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.patient_address(driver).clear();
			EregPatientInfoVerificationObjects.patient_address(driver).sendKeys(cell.getStringCellValue());

			cell = sheet2.getRow(i).getCell(3);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.patient_zip(driver).clear();
			EregPatientInfoVerificationObjects.patient_zip(driver).sendKeys(cell.getStringCellValue());

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Select dropdown = new Select(EregPatientInfoVerificationObjects.county(driver));
			dropdown.selectByIndex(1);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select selectbox= new Select(EregPatientInfoVerificationObjects.patient_race(driver)); 
			selectbox.selectByIndex(3);   
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown2 = new Select(EregPatientInfoVerificationObjects.patient_ethnicity(driver));
			dropdown2.selectByIndex(1);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown3 = new Select(EregPatientInfoVerificationObjects.hear_from(driver));
			dropdown3.selectByIndex(2);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown5 = new Select(EregPatientInfoVerificationObjects.alt_location(driver));
			dropdown5.selectByIndex(1);

			EregPatientInfoVerificationObjects.next_btn(driver).click();
			cell = sheet2.getRow(i).getCell(4);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.kiosk_cellphone(driver).clear();
			EregPatientInfoVerificationObjects.kiosk_cellphone(driver).sendKeys(cell.getStringCellValue());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cell = sheet2.getRow(i).getCell(5);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.kiosk_homephone(driver).clear();
			EregPatientInfoVerificationObjects.kiosk_homephone(driver).sendKeys(cell.getStringCellValue());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cell = sheet2.getRow(i).getCell(6);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.kiosk_email(driver).clear();
			EregPatientInfoVerificationObjects.kiosk_email(driver).sendKeys(cell.getStringCellValue());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cell = sheet2.getRow(i).getCell(7);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.KioskNextOfKin_FirstName(driver).clear();
			EregPatientInfoVerificationObjects.KioskNextOfKin_FirstName(driver).sendKeys(cell.getStringCellValue());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cell = sheet2.getRow(i).getCell(8);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.KioskNextOfKin_LastName(driver).clear();
			EregPatientInfoVerificationObjects.KioskNextOfKin_LastName(driver).sendKeys(cell.getStringCellValue());
			EregPatientInfoVerificationObjects.KioskNextOfKin_RelationshipCode(driver).click();
			new Select(EregPatientInfoVerificationObjects.KioskNextOfKin_RelationshipCode(driver)).selectByVisibleText("Spouse");
			EregPatientInfoVerificationObjects.KioskNextOfKin_RelationshipCode(driver).click();
			cell = sheet2.getRow(i).getCell(9);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.KioskNextOfKin_Phone(driver).clear();
			EregPatientInfoVerificationObjects.KioskNextOfKin_Phone(driver).sendKeys(cell.getStringCellValue());
			cell = sheet2.getRow(i).getCell(10);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.KioskNextOfKin_CellPhone(driver).clear();
			EregPatientInfoVerificationObjects.KioskNextOfKin_CellPhone(driver).sendKeys(cell.getStringCellValue());
			cell = sheet2.getRow(i).getCell(11);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.KioskNextOfKin_StreetAddress(driver).clear();
			EregPatientInfoVerificationObjects.KioskNextOfKin_StreetAddress(driver).sendKeys(cell.getStringCellValue());
			cell = sheet2.getRow(i).getCell(12);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.KioskNextOfKin_ZipCode(driver).clear();
			EregPatientInfoVerificationObjects.KioskNextOfKin_ZipCode(driver).sendKeys(cell.getStringCellValue());
			EregPatientInfoVerificationObjects.next_btn(driver).click();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EregPatientInfoVerificationObjects.EmployerCountry(driver).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EregPatientInfoVerificationObjects.NoPrimaryCarePhysician(driver).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EregPatientInfoVerificationObjects.sayYes(driver).click();
		EregPatientInfoVerificationObjects.NotFound_Pharmacy(driver).click();
		EregPatientInfoVerificationObjects.next_btn(driver).click();
		EregPatientInfoVerificationObjects.PatientGuarantor(driver).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//start insurance info
		EregPatientInfoVerificationObjects.btnNoAddressOnCard(driver).click();
		EregPatientInfoVerificationObjects.showInsCardFrontDesk(driver).click();

	}

	@AfterTest
	public void teardownTest(){
		//close browser
		driver.quit();
		System.out.println("session completed successfully check report for test results");

	}

}
