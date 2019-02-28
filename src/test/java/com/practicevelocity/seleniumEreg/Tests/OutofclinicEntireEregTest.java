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
import com.practicevelocity.seleniumEreg.PageObjects.EregNavigationObjects;
import com.practicevelocity.seleniumEreg.PageObjects.EregPatientInfoVerificationObjects;
import com.practicevelocity.seleniumEreg.PageObjects.EregPatientSymptomsObjects;
import com.practicevelocity.seleniumEreg.PageObjects.EregPinAPICheckObjects;
import com.practicevelocity.seleniumEreg.PageObjects.PVMLoginObjects;
import com.practicevelocity.seleniumEreg.PageObjects.PVMeRegInitiatedObject;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import com.jayway.restassured.authentication.PreemptiveBasicAuthScheme;
import com.jayway.restassured.builder.RequestSpecBuilder;


/**
 * @author tcammon
 *
 */

public class OutofclinicEntireEregTest {

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

		System.setProperty("webdriver.chrome.driver", projectPath+"/seleniumdrivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
//		System.setProperty("webdriver.gecko.driver", projectPath+"/seleniumdrivers/Firefox/geckodriver.exe");	
//		driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

	@Test
	public void OutofClinicNewPat() throws JSONException,InterruptedException,IOException {
		
		driver.get("https://st2pvpm.practicevelocity.com/18_5/LogBook.aspx");
		
		driver.findElement(By.name("txtLogin")).sendKeys("tcammon@admin");;
		driver.findElement(By.name("txtPassword")).sendKeys("Tester9$");;
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		driver.findElement(By.name("btnSubmit")).sendKeys(Keys.RETURN);
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		
	    driver.findElement(By.id("ddlPractice")).click();
	    new Select(driver.findElement(By.id("ddlPractice"))).selectByVisibleText("TEST");
	    driver.findElement(By.id("ddlPractice")).click();
	    driver.findElement(By.id("ddlClinic")).click();
	    new Select(driver.findElement(By.id("ddlClinic"))).selectByVisibleText("ZIPPASS");
	    driver.findElement(By.id("ddlClinic")).click();
	    driver.findElement(By.id("hlClinicScheduling")).click();
//	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	    
	    //WebElement element = EregNavigationObjects.resourcePractice_Clinic(driver);
		
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
//	    driver.findElement(By.id("lstClinic")).click();
//	    new Select(driver.findElement(By.id("lstClinic"))).selectByVisibleText("ZIPPASS::8777 Velocity Drive");
//	    driver.findElement(By.id("lstClinic")).click();
	    
	    Select dropdown = new Select (driver.findElement(By.xpath("//select//option[@value='99969']")));
	    dropdown.selectByVisibleText("ZIPPASS::8777 Velocity Drive");
	    //((JavascriptExecutor)driver).executeScript("arguments[7].click();", element);
	    //.isSelected();
	    
	    
	    driver.findElement(By.id("lstWeekDay")).click();
	    new Select(driver.findElement(By.id("lstWeekDay"))).selectByVisibleText("TUE");
	    driver.findElement(By.id("lstWeekDay")).click();
	    driver.findElement(By.id("btnSave")).click();
	    driver.findElement(By.id("lnkDefault")).click();
	    driver.findElement(By.id("lstClinic")).click();
	    new Select(driver.findElement(By.id("lstClinic"))).selectByVisibleText("ZIPPASS CLINIC :: On the corner of East State and Main St.");
	    driver.findElement(By.id("lstClinic")).click();
	    driver.findElement(By.id("txtFirstName")).click();
	    driver.findElement(By.id("txtFirstName")).clear();
	    driver.findElement(By.id("txtFirstName")).sendKeys("test");
	    driver.findElement(By.id("txtLastName")).click();
	    driver.findElement(By.id("txtLastName")).clear();
	    driver.findElement(By.id("txtLastName")).sendKeys("automate");
	    driver.findElement(By.id("txtDOB")).click();
	    driver.findElement(By.id("txtDOB")).clear();
	    driver.findElement(By.id("txtDOB")).sendKeys("01/07/1980");
	    driver.findElement(By.id("txtCN1")).click();
	    driver.findElement(By.id("txtCN1")).clear();
	    driver.findElement(By.id("txtCN1")).sendKeys("773");
	    driver.findElement(By.id("txtCN2")).clear();
	    driver.findElement(By.id("txtCN2")).sendKeys("588");
	    driver.findElement(By.id("txtCN3")).clear();
	    driver.findElement(By.id("txtCN3")).sendKeys("2300");
	    driver.findElement(By.id("txtEmail")).click();
	    driver.findElement(By.id("txtEmail")).clear();
	    driver.findElement(By.id("txtEmail")).sendKeys("test@nomail.com");
//	    acceptNextAlert = true;
	    driver.findElement(By.id("btnSubmit")).click();
	    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to confirm this check-in at 2/26/2019 2:15:00 PM\\. [\\s\\S]$"));
	    driver.findElement(By.id("eRegistration")).click();

//		// Import excel sheet.
//		File src=new File(projectPath+"/data/TestData.xlsx"); 
//
//		// Load the file.
//		FileInputStream rc = new FileInputStream(src);
//
//		// Load the workbook.
//		workbook = new XSSFWorkbook(rc);
//		firefox.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//		firefox.get("https://st2pvpm.practicevelocity.com/");
//		sheet= workbook.getSheetAt(0);
//
//		for(int i=1; i<=sheet.getLastRowNum(); i++){
//			cell = sheet.getRow(i).getCell(0);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			PVMLoginObjects.login_username(firefox).clear();
//			PVMLoginObjects.login_username(firefox).sendKeys(cell.getStringCellValue());
//			cell = sheet.getRow(i).getCell(1);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			PVMLoginObjects.login_pwd(firefox).clear();
//			PVMLoginObjects.login_pwd(firefox).sendKeys(cell.getStringCellValue()); 	
//			PVMLoginObjects.login_btn(firefox).sendKeys(Keys.RETURN);
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//
//		}
//
//		//Grab eReg pin from pvm
//		WebElement pin = PVMeRegInitiatedObject.pvm_GeneratePin(firefox);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		String result = pin.getAttribute("title");
//		System.out.println(pin.getAttribute("title"));
//
//		firefox.close();
//		// Navigate to eRegistration Page, verify correct page, enter pin
//		driver.get("https://st2ereg.practicevelocity.com/qatc");
//		EregPatientInfoVerificationObjects.get_pin(driver).sendKeys(result);
//		EregPatientInfoVerificationObjects.insert_pin(driver).sendKeys(Keys.RETURN);
//
//		// Load the sheet in which data is stored.
//		sheet2= workbook.getSheetAt(1);		 
//
//		for(int i=1; i<=sheet2.getLastRowNum(); i++){
//
//			Select dropdown4 = new Select(EregPatientInfoVerificationObjects.gender(driver));
//			dropdown4.selectByIndex(1);
//
//			cell = sheet2.getRow(i).getCell(0);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			EregPatientInfoVerificationObjects.patient_ssn(driver).clear();
//			EregPatientInfoVerificationObjects.patient_ssn(driver).sendKeys(cell.getStringCellValue());
//
//			cell = sheet2.getRow(i).getCell(1);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			EregPatientInfoVerificationObjects.patient_birthdate(driver).clear();
//			EregPatientInfoVerificationObjects.patient_birthdate(driver).sendKeys(cell.getStringCellValue());
//
//			cell = sheet2.getRow(i).getCell(2);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			EregPatientInfoVerificationObjects.patient_address(driver).clear();
//			EregPatientInfoVerificationObjects.patient_address(driver).sendKeys(cell.getStringCellValue());
//
//			cell = sheet2.getRow(i).getCell(3);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			EregPatientInfoVerificationObjects.patient_zip(driver).clear();
//			EregPatientInfoVerificationObjects.patient_zip(driver).sendKeys(cell.getStringCellValue());
//
//			try {
//				Thread.sleep(4000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			Select dropdown = new Select(EregPatientInfoVerificationObjects.county(driver));
//			dropdown.selectByIndex(1);
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Select selectbox= new Select(EregPatientInfoVerificationObjects.patient_race(driver)); 
//			selectbox.selectByIndex(3);   
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Select dropdown2 = new Select(EregPatientInfoVerificationObjects.patient_ethnicity(driver));
//			dropdown2.selectByIndex(1);
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Select dropdown3 = new Select(EregPatientInfoVerificationObjects.hear_from(driver));
//			dropdown3.selectByIndex(2);
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Select dropdown5 = new Select(EregPatientInfoVerificationObjects.alt_location(driver));
//			dropdown5.selectByIndex(1);
//
//			EregPatientInfoVerificationObjects.next_btn(driver).click();
//			cell = sheet2.getRow(i).getCell(4);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			EregPatientInfoVerificationObjects.kiosk_cellphone(driver).clear();
//			EregPatientInfoVerificationObjects.kiosk_cellphone(driver).sendKeys(cell.getStringCellValue());
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			cell = sheet2.getRow(i).getCell(5);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			EregPatientInfoVerificationObjects.kiosk_homephone(driver).clear();
//			EregPatientInfoVerificationObjects.kiosk_homephone(driver).sendKeys(cell.getStringCellValue());
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			cell = sheet2.getRow(i).getCell(6);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			EregPatientInfoVerificationObjects.kiosk_email(driver).clear();
//			EregPatientInfoVerificationObjects.kiosk_email(driver).sendKeys(cell.getStringCellValue());
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			cell = sheet2.getRow(i).getCell(7);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			EregPatientInfoVerificationObjects.KioskNextOfKin_FirstName(driver).clear();
//			EregPatientInfoVerificationObjects.KioskNextOfKin_FirstName(driver).sendKeys(cell.getStringCellValue());
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			cell = sheet2.getRow(i).getCell(8);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			EregPatientInfoVerificationObjects.KioskNextOfKin_LastName(driver).clear();
//			EregPatientInfoVerificationObjects.KioskNextOfKin_LastName(driver).sendKeys(cell.getStringCellValue());
//			EregPatientInfoVerificationObjects.KioskNextOfKin_RelationshipCode(driver).click();
//			new Select(EregPatientInfoVerificationObjects.KioskNextOfKin_RelationshipCode(driver)).selectByVisibleText("Spouse");
//			EregPatientInfoVerificationObjects.KioskNextOfKin_RelationshipCode(driver).click();
//			cell = sheet2.getRow(i).getCell(9);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			EregPatientInfoVerificationObjects.KioskNextOfKin_Phone(driver).clear();
//			EregPatientInfoVerificationObjects.KioskNextOfKin_Phone(driver).sendKeys(cell.getStringCellValue());
//			cell = sheet2.getRow(i).getCell(10);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			EregPatientInfoVerificationObjects.KioskNextOfKin_CellPhone(driver).clear();
//			EregPatientInfoVerificationObjects.KioskNextOfKin_CellPhone(driver).sendKeys(cell.getStringCellValue());
//			cell = sheet2.getRow(i).getCell(11);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			EregPatientInfoVerificationObjects.KioskNextOfKin_StreetAddress(driver).clear();
//			EregPatientInfoVerificationObjects.KioskNextOfKin_StreetAddress(driver).sendKeys(cell.getStringCellValue());
//			cell = sheet2.getRow(i).getCell(12);
//			cell.setCellType(Cell.CELL_TYPE_STRING);
//			EregPatientInfoVerificationObjects.KioskNextOfKin_ZipCode(driver).clear();
//			EregPatientInfoVerificationObjects.KioskNextOfKin_ZipCode(driver).sendKeys(cell.getStringCellValue());
//			EregPatientInfoVerificationObjects.next_btn(driver).click();
//		}
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		EregPatientInfoVerificationObjects.PatientGuarantor(driver).click();
//		EregPatientInfoVerificationObjects.next_btn(driver).click();
//
//		//Patient Symptoms
//		EregPatientSymptomsObjects.Abdominalpain(driver).click();
//		EregPatientSymptomsObjects.Abnormalbloodsugar(driver).click();
//		EregPatientSymptomsObjects.AnxietyNerves(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Backpain(driver).click();
//		EregPatientSymptomsObjects.Bloodinstool(driver).click();
//		EregPatientSymptomsObjects.Bloodinurine(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Blurredvision(driver).click();
//		EregPatientSymptomsObjects.Bruising(driver).click();
//		EregPatientSymptomsObjects.Changeinappetite(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Chestpainpressure(driver).click();
//		EregPatientSymptomsObjects.Chills(driver).click();
//		EregPatientSymptomsObjects.Coldintolerance(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Congestion(driver).click();
//		EregPatientSymptomsObjects.Constipation(driver).click();
//		EregPatientSymptomsObjects.Cough(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Depression(driver).click();
//		EregPatientSymptomsObjects.Diarrhea(driver).click();
//		EregPatientSymptomsObjects.Difficultyswallowing(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Dischargeurethral(driver).click();
//		EregPatientSymptomsObjects.Dischargevaginal(driver).click();
//		EregPatientSymptomsObjects.Dizziness(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Earpain(driver).click();
//		EregPatientSymptomsObjects.Easybleeding(driver).click();
//		EregPatientSymptomsObjects.ExcessiveCrying(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.ExcessivehungerThirst(driver).click();
//		EregPatientSymptomsObjects.Eyedischarge(driver).click();
//		EregPatientSymptomsObjects.Eyepain(driver).click();
//		EregPatientSymptomsObjects.Eyeredness(driver).click();
//
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientInfoVerificationObjects.goToSymptomPage2(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//
//		EregPatientInfoVerificationObjects.goToSymptomPage3(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//
//		EregPatientSymptomsObjects.Painfulurination(driver).click();
//		EregPatientSymptomsObjects.Poorbalance(driver).click();
//		EregPatientSymptomsObjects.Postnasaldrip(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Rash(driver).click();
//		EregPatientSymptomsObjects.Shortnessofbreath(driver).click();
//		EregPatientSymptomsObjects.Skinsores(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Sleepdifficulties(driver).click();
//		EregPatientSymptomsObjects.Sneezing(driver).click();
//		EregPatientSymptomsObjects.Snoring(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Sorethroat(driver).click();
//		EregPatientSymptomsObjects.Swelling(driver).click();
//		EregPatientSymptomsObjects.Vomiting(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Weakness(driver).click();
//		EregPatientSymptomsObjects.Wheeze(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//
//		EregPatientInfoVerificationObjects.next_btn(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//
//		EregPatientSymptomsObjects.Eyeswelling(driver).click();
//		EregPatientSymptomsObjects.Fainting(driver).click();
//		EregPatientSymptomsObjects.Fatigue(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Fever(driver).click();
//		EregPatientSymptomsObjects.FlutteringPalpitations(driver).click();
//		EregPatientSymptomsObjects.Frequentinfections(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Frequenturination(driver).click();
//		EregPatientSymptomsObjects.Hairloss(driver).click();
//		EregPatientSymptomsObjects.Heatintolerance(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Hoarseness(driver).click();
//		EregPatientSymptomsObjects.Hotflashes(driver).click();
//		EregPatientSymptomsObjects.Itching(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.ItchyEyes(driver).click();
//		EregPatientSymptomsObjects.Jointpain(driver).click();
//		EregPatientSymptomsObjects.Laceration(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Legswelling(driver).click();
//		EregPatientSymptomsObjects.Lightheadedness(driver).click();
//		EregPatientSymptomsObjects.LipTongueThroatSwelling(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Lossofconsciousness(driver).click();
//		EregPatientSymptomsObjects.Menstrualcomplaints(driver).click();
//		EregPatientSymptomsObjects.Mouthpain(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Musclepain(driver).click();
//		EregPatientSymptomsObjects.Nasalcongestion(driver).click();
//		EregPatientSymptomsObjects.Nausea(driver).click();
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientSymptomsObjects.Nighttimeurination(driver).click();
//		EregPatientSymptomsObjects.Nosedischarge(driver).click();
//		EregPatientSymptomsObjects.NumbnessTingling(driver).click();
//		//end patient symptoms
//
//		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientInfoVerificationObjects.goToSymptomPage3(driver).click();
//
//		EregPatientInfoVerificationObjects.next_btn(driver).click();
//		EregPatientInfoVerificationObjects.NotoAllSymptoms(driver).click();
//		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientInfoVerificationObjects.next_btn(driver).click();
//		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientInfoVerificationObjects.FatherMedicalHistory(driver).click();
//		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientInfoVerificationObjects.MotherMedicalHistory(driver).click();
//		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
//		EregPatientInfoVerificationObjects.finishBtn(driver).click();


	}

	private String closeAlertAndGetItsText() {
		// TODO Auto-generated method stub
		return null;
	}

	@AfterTest
	public void teardownTest(){
		//close browser
		driver.quit();
		System.out.println("session completed successfully check report for test results");

	}

}
