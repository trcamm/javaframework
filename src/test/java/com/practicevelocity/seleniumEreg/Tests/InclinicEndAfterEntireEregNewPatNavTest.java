package com.practicevelocity.seleniumEreg.Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.restassured.specification.RequestSpecification;
import com.practicevelocity.seleniumEreg.PageObjects.EregPatientInfoVerificationObjects;
import com.practicevelocity.seleniumEreg.PageObjects.EregPatientSymptomsObjects;

import static com.jayway.restassured.RestAssured.given;


import com.jayway.restassured.builder.RequestSpecBuilder;

/**
 * @author tcammon
 *
 */
public class InclinicEndAfterEntireEregNewPatNavTest {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	WebDriver driver;
	private String Pin;
	String projectPath;
	private long unixTime = System.currentTimeMillis() / 1000L;
	private String unixtimeFormatted = String.valueOf(unixTime);
	private String FinalDate = unixtimeFormatted +"000"+"-"+"0000";
	private String firstName = RandomStringUtils.randomAlphabetic(8).toUpperCase();
	String restAPIUrl= null;
	String apiBody = null;

	@BeforeTest
	public void setupTest() throws Exception{


		projectPath = System.getProperty("user.dir");


		System.setProperty("webdriver.chrome.driver", projectPath+"/seleniumdrivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		Dimension expectedWindowSize = new Dimension(890, 1012);
		driver.manage().window().setSize(expectedWindowSize);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@Test
	public void EndAfterEntireEregNewPat() throws JSONException,InterruptedException,IOException {
		//Rest API's URL
		restAPIUrl = "https://st2eregapi.practicevelocity.com/18_5/KioskAPI/NewPatientSession/qatc/44c0ddba-bfe5-e711-80ca-0050568cab3b/P";

		//API Body
		apiBody = "{\"firstName\":\""+ firstName + "\",\"lastName\":\"Automaton\",\"ssn\":\"\",\"sessionSettings\":[{\"settingKey\":\"UsesESign\",\"settingValue\":\"true\"},{\"settingKey\":\"UsesMarketingAltlocation\",\"settingValue\":\"true\"},{\"settingKey\":\"RequireInHouseDispensing\",\"settingValue\":\"N/A\"},{\"settingKey\":\"RequirePreferredPharmacy\",\"settingValue\":\"true\"},{\"settingKey\":\"RequiresVisitCategories\",\"settingValue\":\"true\"},{\"settingKey\":\"ClinicLocalTime\",\"settingValue\":\"2018-05-26T20:49:55.2445873\"},{\"settingKey\":\"eRegSignatureSetting\",\"settingValue\":\"1\"},{\"settingKey\":\"UsesVoicemailAuth\",\"settingValue\":\"true\"},{\"settingKey\":\"PatientPortalRequired\",\"settingValue\":\"true\"},{\"settingKey\":\"EthnicityRequired\",\"settingValue\":\"true\"},{\"settingKey\":\"RaceRequired\",\"settingValue\":\"true\"},{\"settingKey\":\"LanguageRequired\",\"settingValue\":\"true\"},{\"settingKey\":\"RequiredPrimaryPhysician\",\"settingValue\":\"true\"},{\"settingKey\":\"OverrideEregEmergencyContactInfo\",\"settingValue\":\"false\"},{\"settingKey\":\"OverrideVisitCategory\",\"settingValue\":\"false\"}],\"eSignDocuments\":[{\"createdOn\":\"\\/Date("+FinalDate+")\\/\",\"documentTemplatePk\":\"b275094e26f24802ab3eb3dbc596c89b\",\"documentTemplateRootStorageId\":26,\"documentTypeName\":\"HIPAAPolicy\",\"isPracticeDocument\":false},{\"createdOn\":\"\\/Date("+FinalDate+")\\/\",\"documentTemplatePk\":\"8c2c4060ca3648efba5ffb44eb552189\",\"documentTemplateRootStorageId\":26,\"documentTypeName\":\"PatientAuth\",\"isPracticeDocument\":false}],\"sessionDocuments\":[]}";

		// Building request by using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();

		//Set API's Body
		builder.setBody(apiBody);

		//Setting content type as application/json
		builder.setContentType("application/json; charset=UTF-8");

		RequestSpecification requestSpec = builder.build();

		//Making post request with authentication or leave blank if you don't have credentials like: basic("","")
		com.jayway.restassured.response.Response response = given().authentication().preemptive().basic("PvApiUser", "Bh4LeWLnCByeMUq6")
				.spec(requestSpec).when().post(restAPIUrl);

		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		// Import excel sheet.
		File src=new File(projectPath+"/data/TestData.xlsx"); 

		// Load the file.
		FileInputStream rc = new FileInputStream(src);

		// Load the workbook.
		workbook = new XSSFWorkbook(rc);
				String result = JSONResponseBody.getString("pin");

				//Print the Result
				Pin = result;
				System.out.println(result);
		
		// Navigate to eRegistration Page, verify correct page, enter pin
		driver.get("https://st2ereg.practicevelocity.com/qatc");
		EregPatientInfoVerificationObjects.get_pin(driver).sendKeys(result);
		EregPatientInfoVerificationObjects.insert_pin(driver).sendKeys(Keys.RETURN);

		// Load the sheet in which data is stored.
		sheet= workbook.getSheetAt(1);		 

		for(int i=1; i<=sheet.getLastRowNum(); i++){

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

			cell = sheet.getRow(i).getCell(0);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.patient_ssn(driver).clear();
			EregPatientInfoVerificationObjects.patient_ssn(driver).sendKeys(cell.getStringCellValue());

			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.patient_birthdate(driver).clear();
			EregPatientInfoVerificationObjects.patient_birthdate(driver).sendKeys(cell.getStringCellValue());

			cell = sheet.getRow(i).getCell(2);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.patient_address(driver).clear();
			EregPatientInfoVerificationObjects.patient_address(driver).sendKeys(cell.getStringCellValue());

			cell = sheet.getRow(i).getCell(3);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.patient_zip(driver).clear();
			EregPatientInfoVerificationObjects.patient_zip(driver).sendKeys(cell.getStringCellValue());

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Select dropdown = new Select(EregPatientInfoVerificationObjects.county(driver));
			dropdown.selectByIndex(1);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select selectbox= new Select(EregPatientInfoVerificationObjects.patient_race(driver)); 
			selectbox.selectByIndex(3);   
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown2 = new Select(EregPatientInfoVerificationObjects.patient_ethnicity(driver));
			dropdown2.selectByIndex(1);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown3 = new Select(EregPatientInfoVerificationObjects.hear_from(driver));
			dropdown3.selectByIndex(2);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown5 = new Select(EregPatientInfoVerificationObjects.alt_location(driver));
			dropdown5.selectByIndex(1);

			EregPatientInfoVerificationObjects.next_btn(driver).click();
			cell = sheet.getRow(i).getCell(4);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.kiosk_cellphone(driver).clear();
			EregPatientInfoVerificationObjects.kiosk_cellphone(driver).sendKeys(cell.getStringCellValue());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cell = sheet.getRow(i).getCell(5);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.kiosk_homephone(driver).clear();
			EregPatientInfoVerificationObjects.kiosk_homephone(driver).sendKeys(cell.getStringCellValue());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cell = sheet.getRow(i).getCell(6);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.kiosk_email(driver).clear();
			EregPatientInfoVerificationObjects.kiosk_email(driver).sendKeys(cell.getStringCellValue());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cell = sheet.getRow(i).getCell(7);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.KioskNextOfKin_FirstName(driver).clear();
			EregPatientInfoVerificationObjects.KioskNextOfKin_FirstName(driver).sendKeys(cell.getStringCellValue());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cell = sheet.getRow(i).getCell(8);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.KioskNextOfKin_LastName(driver).clear();
			EregPatientInfoVerificationObjects.KioskNextOfKin_LastName(driver).sendKeys(cell.getStringCellValue());
			EregPatientInfoVerificationObjects.KioskNextOfKin_RelationshipCode(driver).click();
			new Select(EregPatientInfoVerificationObjects.KioskNextOfKin_RelationshipCode(driver)).selectByVisibleText("Spouse");
			EregPatientInfoVerificationObjects.KioskNextOfKin_RelationshipCode(driver).click();
			cell = sheet.getRow(i).getCell(9);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.KioskNextOfKin_Phone(driver).clear();
			EregPatientInfoVerificationObjects.KioskNextOfKin_Phone(driver).sendKeys(cell.getStringCellValue());
			cell = sheet.getRow(i).getCell(10);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.KioskNextOfKin_CellPhone(driver).clear();
			EregPatientInfoVerificationObjects.KioskNextOfKin_CellPhone(driver).sendKeys(cell.getStringCellValue());
			cell = sheet.getRow(i).getCell(11);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			EregPatientInfoVerificationObjects.KioskNextOfKin_StreetAddress(driver).clear();
			EregPatientInfoVerificationObjects.KioskNextOfKin_StreetAddress(driver).sendKeys(cell.getStringCellValue());
			cell = sheet.getRow(i).getCell(12);
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
		
		EregPatientInfoVerificationObjects.NotFound_Pharmacy(driver).click();
		EregPatientInfoVerificationObjects.next_btn(driver).click();
		
		EregPatientInfoVerificationObjects.PatientGuarantor(driver).click();

		driver.findElement(By.id("SameAsGuarantor")).click();
		WebElement element = driver.findElement(By.id("mainCanvas"));
	    Actions actionbuilder = new Actions(driver);
		   Action drawAction = actionbuilder.moveToElement(element, 135, 15)  
		             .clickAndHold()
		             .moveByOffset(200, 60)
		             .moveByOffset(100, 70)
		             .release()
		             .build();
		          drawAction.perform();
		
	    driver.findElement(By.id("NavigationSequence_Button2SequenceID")).click();
	    try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
	    driver.findElement(By.id("NavigationSequence_Button2SequenceID")).click();
	    try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Who is the main person giving this history?'])[1]/following::label[1]")).click();
	    driver.findElement(By.id("NavigationSequence_Button2SequenceID")).click();

		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();} 
		EregPatientInfoVerificationObjects.wholeBody_Generalized(driver).click();
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();} 

		EregPatientInfoVerificationObjects.sympton_Fever(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();} 

		EregPatientInfoVerificationObjects.next_btn(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();} 

		EregPatientInfoVerificationObjects.howOftenSymptons(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();} 

		EregPatientInfoVerificationObjects.pain_Scale(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();} 

		EregPatientInfoVerificationObjects.isThisInjury(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();} 

		EregPatientInfoVerificationObjects.isThisOften(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();} 

		EregPatientInfoVerificationObjects.whenDid_symptons_Occur(driver).click();
		EregPatientInfoVerificationObjects.next_btn(driver).click();
		EregPatientInfoVerificationObjects.ApproximateOnsetValue(driver).click();
		new Select(EregPatientInfoVerificationObjects.ApproximateOnsetValue(driver)).selectByVisibleText("1");
		EregPatientInfoVerificationObjects.ApproximateOnsetValue(driver).click();
		EregPatientInfoVerificationObjects.ApproximateOnsetUnit(driver).click();
		new Select(EregPatientInfoVerificationObjects.ApproximateOnsetUnit(driver)).selectByVisibleText("Days");
		EregPatientInfoVerificationObjects.ApproximateOnsetUnit(driver).click();
		EregPatientInfoVerificationObjects.next_btn(driver).click();
		EregPatientInfoVerificationObjects.OnMeds(driver).click();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();} 

		//Patient Symptoms
		EregPatientSymptomsObjects.Abdominalpain(driver).click();
		EregPatientSymptomsObjects.Abnormalbloodsugar(driver).click();
		EregPatientSymptomsObjects.AnxietyNerves(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientSymptomsObjects.Backpain(driver).click();
		EregPatientSymptomsObjects.Bloodinstool(driver).click();
		EregPatientSymptomsObjects.Bloodinurine(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientSymptomsObjects.Blurredvision(driver).click();
		EregPatientSymptomsObjects.Bruising(driver).click();
		EregPatientSymptomsObjects.Changeinappetite(driver).click();

		EregPatientSymptomsObjects.Chestpainpressure(driver).click();
		
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientInfoVerificationObjects.goToSymptomPage2(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}

		EregPatientSymptomsObjects.Chills(driver).click();
		EregPatientSymptomsObjects.Coldintolerance(driver).click();
		
		EregPatientSymptomsObjects.Congestion(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientSymptomsObjects.Constipation(driver).click();
		EregPatientSymptomsObjects.Cough(driver).click();
		
		EregPatientSymptomsObjects.Depression(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientSymptomsObjects.Diarrhea(driver).click();
		EregPatientSymptomsObjects.Difficultyswallowing(driver).click();
		
		EregPatientSymptomsObjects.Dischargeurethral(driver).click();
		
		
		EregPatientSymptomsObjects.Dischargevaginal(driver).click();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientInfoVerificationObjects.goToSymptomPage3(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		EregPatientSymptomsObjects.Dizziness(driver).click();
		
		EregPatientSymptomsObjects.Earpain(driver).click();
		EregPatientSymptomsObjects.Easybleeding(driver).click();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		EregPatientSymptomsObjects.ExcessiveCrying(driver).click();
		
		EregPatientSymptomsObjects.ExcessivehungerThirst(driver).click();
		EregPatientSymptomsObjects.Eyedischarge(driver).click();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientSymptomsObjects.Eyepain(driver).click();
		EregPatientSymptomsObjects.Eyeredness(driver).click();
		EregPatientSymptomsObjects.Eyeswelling(driver).click();
		EregPatientSymptomsObjects.Fainting(driver).click();
		

		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientInfoVerificationObjects.goToSymptomPage4(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}

		driver.findElement(By.xpath("(//input[@id='noToAll'])[4]")).click();
		
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientInfoVerificationObjects.goToSymptomPage5(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		driver.findElement(By.xpath("(//input[@id='noToAll'])[5]")).click();
		
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientInfoVerificationObjects.goToSymptomPage6(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		driver.findElement(By.xpath("(//input[@id='noToAll'])[6]")).click();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientInfoVerificationObjects.goToSymptomPage7(driver).click();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		driver.findElement(By.xpath("(//input[@id='noToAll'])[7]")).click();
		
		//end patient symptoms
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}

		EregPatientInfoVerificationObjects.next_btn(driver).click();
		EregPatientInfoVerificationObjects.OnMeds(driver).click();
		EregPatientInfoVerificationObjects.NotoAllSymptoms(driver).click();
		EregPatientInfoVerificationObjects.next_btn(driver).click();
		EregPatientInfoVerificationObjects.NotoAllSymptoms(driver).click();
		EregPatientInfoVerificationObjects.goToSymptomPage2(driver).click();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		driver.findElement(By.xpath("(//input[@id='noToAll'])[2]")).click();
		EregPatientInfoVerificationObjects.next_btn(driver).click();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientInfoVerificationObjects.FatherMedicalHistory(driver).click();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientInfoVerificationObjects.MotherMedicalHistory(driver).click();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		EregPatientInfoVerificationObjects.finishBtn(driver).click();


	}

	@AfterTest
	public void teardownTest(){
		//close browser
		driver.quit();
		System.out.println("session completed successfully check report for test results");

	}

}