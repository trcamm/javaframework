package com.practicevelocity.seleniumEreg.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author tcammon
 *
 */
public class EregPatientInfoVerificationObjects {
	
private static WebElement element = null;
	
	public static WebElement get_pin(WebDriver driver){

		element = driver.findElement(By.xpath("//input[@name='Pin']"));
		return element;
	}
	
	public static WebElement insert_pin(WebDriver driver){

		element = driver.findElement(By.xpath("//input[@name='Pin']"));
		return element;
	}
	
	public static WebElement noEmergency_btn(WebDriver driver){
		
		element = driver.findElement(By.xpath("//input[@name='NavigationSequence_Button2SequenceID']"));
		return element;
	}
	
	public static WebElement no_photoID(WebDriver driver){

		element = driver.findElement(By.cssSelector("button.btn.btn-default"));
		return element;
	}
	
	public static WebElement no_InsuranceCard(WebDriver driver){

		element = driver.findElement(By.cssSelector("button.btn.btn-default"));
		return element;
	}
	
	public static WebElement nxt_btn(WebDriver driver){

		element = driver.findElement(By.id("NavigationSequence_Button1SequenceID"));
		return element;
	}
	
	public static WebElement back_btn(WebDriver driver){

		element = driver.findElement(By.id("NavigationSequence_Button1SequenceID"));
		return element;
	}
	
	public static WebElement first_name(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_FirstName"));
		return element;
	}
	
	public static WebElement last_name(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_LastName"));
		return element;
	}
	
	public static WebElement gender(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_Gender"));
		return element;
	}
	
	public static WebElement patient_ssn(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_Ssn"));
		return element;
	}
	
	public static WebElement patient_birthdate(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_BirthDate"));
		return element;
	}
	
	public static WebElement patient_address(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_Address1"));
		return element;
	}
	
	public static WebElement patient_zip(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_Zip"));
		return element;
	}
	
	public static WebElement county(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_CountyParish"));
		return element;
	}
	
	public static WebElement patient_race(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_RaceAsList"));
		return element;
	}
	
	public static WebElement patient_ethnicity(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_Ethnicities"));
		return element;
	}
	
	public static WebElement hear_from(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_HearFrom"));
		return element;
	}
	
	public static WebElement alt_location(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_AlternateLocation"));
		return element;
	}
	
	public static WebElement abort_btn(WebDriver driver){

		element = driver.findElement(By.xpath("//input[@name='abortButton']"));
		return element;
	}
	
	public static WebElement abort_yes(WebDriver driver){

		element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Are you sure that you want to abort this eRegistration session?'])[1]/following::button[1]"));
		return element;
	}
	
	public static WebElement next_btn(WebDriver driver){

		element = driver.findElement(By.id("NavigationSequence_Button2SequenceID"));
		return element;
	}
	//KioskPatient_CellPhone
	public static WebElement kiosk_cellphone(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_CellPhone"));
		return element;
	}
	//KioskPatient_HomePhone
	public static WebElement kiosk_homephone(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_HomePhone"));
		return element;
	}
	//KioskPatient_Email
	public static WebElement kiosk_email(WebDriver driver){

		element = driver.findElement(By.id("KioskPatient_Email"));
		return element;
	}
	//KioskNextOfKin_FirstName
	public static WebElement KioskNextOfKin_FirstName(WebDriver driver){

		element = driver.findElement(By.id("KioskNextOfKin_FirstName"));
		return element;
	}
	//KioskNextOfKin_LastName
	public static WebElement KioskNextOfKin_LastName(WebDriver driver){

		element = driver.findElement(By.id("KioskNextOfKin_LastName"));
		return element;
	}
	//KioskNextOfKin_RelationshipCode
	public static WebElement KioskNextOfKin_RelationshipCode(WebDriver driver){

		element = driver.findElement(By.id("KioskNextOfKin_RelationshipCode"));
		return element;
	}
	//KioskNextOfKin_Phone
	public static WebElement KioskNextOfKin_Phone(WebDriver driver){

		element = driver.findElement(By.id("KioskNextOfKin_Phone"));
		return element;
	}
	//KioskNextOfKin_CellPhone
	public static WebElement KioskNextOfKin_CellPhone(WebDriver driver){

		element = driver.findElement(By.id("KioskNextOfKin_CellPhone"));
		return element;
	}
	//KioskNextOfKin_StreetAddress
	public static WebElement KioskNextOfKin_StreetAddress(WebDriver driver){

		element = driver.findElement(By.id("KioskNextOfKin_CellPhone"));
		return element;
	}
	//KioskNextOfKin_ZipCode
	public static WebElement KioskNextOfKin_ZipCode(WebDriver driver){

		element = driver.findElement(By.id("KioskNextOfKin_ZipCode"));
		return element;
	}
	//EmployerCountry
	public static WebElement EmployerCountry(WebDriver driver){

		element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Employer Country'])[1]/following::button[2]"));
		return element;
	}
	//NoPrimaryCarePhysician
	public static WebElement NoPrimaryCarePhysician(WebDriver driver){

		element = driver.findElement(By.id("NoPrimaryCarePhysician"));
		return element;
	}
	//sayYes
	public static WebElement sayYes(WebDriver driver){

		element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yes'])[1]/following::input[1]"));
		return element;
	}
	//NotFound_Pharmacy
	public static WebElement NotFound_Pharmacy(WebDriver driver){

		element = driver.findElement(By.id("NotFound_Pharmacy"));
		return element;
	}
	//PatientGuarantor
	public static WebElement PatientGuarantor(WebDriver driver){

		element = driver.findElement(By.id("PatientGuarantor"));
		return element;
	}
	//NoAddressOnCard
	public static WebElement btnNoAddressOnCard(WebDriver driver){

		element = driver.findElement(By.id("btnNoAddressOnCard"));
		return element;
	}
	//showInsCardFrontDesk
	public static WebElement showInsCardFrontDesk(WebDriver driver){

		element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Please present your insurance card at the front desk.'])[1]/following::button[1]"));
		return element;
	}
	//wholeBody_Generalized
	public static WebElement wholeBody_Generalized(WebDriver driver){

		element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Whole Body/Generalized'])[1]/following::area[1]"));
		return element;
	}
	//sympton_Fever
	public static WebElement sympton_Fever(WebDriver driver){

		element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fever'])[1]/following::label[1]"));
		return element;
	}
	//howOftenSymptons
	public static WebElement howOftenSymptons(WebDriver driver){

		element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Constantly, worse at times'])[1]/following::label[1]"));
		return element;
	}
	//pain_Scale
	public static WebElement pain_Scale(WebDriver driver){

		element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('(', '\"', '0', '\"', ' = No Problem, ', '\"', '10', '\"', ' = Worst problem Imaginable)')])[1]/following::label[6]"));
		return element;
	}
	//isThisInjury
	public static WebElement isThisInjury(WebDriver driver){

		element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yes'])[1]/following::label[1]"));
		return element;
	}
	//isThisOften
	public static WebElement isThisOften(WebDriver driver){

		element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yes'])[2]/following::label[1]"));
		return element;
	}
	//whenDid_symptons_Occur
	public static WebElement whenDid_symptons_Occur(WebDriver driver){

		element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Suddenly'])[1]/following::label[1]"));
		return element;
	}
	//ApproximateOnsetValue
	public static WebElement ApproximateOnsetValue(WebDriver driver){

		element = driver.findElement(By.id("ApproximateOnsetValue"));
		return element;
	}
	//ApproximateOnsetUnit
	public static WebElement ApproximateOnsetUnit(WebDriver driver){

		element = driver.findElement(By.id("ApproximateOnsetUnit"));
		return element;
	}
	//OnMeds
	public static WebElement OnMeds(WebDriver driver){

		element = driver.findElement(By.id("btnNo"));
		return element;
	}
	//goToSymptomPage2
	public static WebElement goToSymptomPage2(WebDriver driver){

		element = driver.findElement(By.xpath("//a[@class='goToPage btn'][@href='2']"));
		return element;
	}
	//goToSymptomPage3
	public static WebElement goToSymptomPage3(WebDriver driver){

		element = driver.findElement(By.xpath("//a[@class='goToPage btn'][@href='3']"));
		return element;
	}
	//goToSymptomPage4
	public static WebElement goToSymptomPage4(WebDriver driver){

		element = driver.findElement(By.xpath("//a[@class='goToPage btn'][@href='4']"));
		return element;
	}
	//goToSymptomPage5
	public static WebElement goToSymptomPage5(WebDriver driver){

		element = driver.findElement(By.xpath("//a[@class='goToPage btn'][@href='5']"));
		return element;
	}
	//goToSymptomPage6
	public static WebElement goToSymptomPage6(WebDriver driver){

		element = driver.findElement(By.xpath("//a[@class='goToPage btn'][@href='6']"));
		return element;
	}
	//goToSymptomPage7
	public static WebElement goToSymptomPage7(WebDriver driver){

		element = driver.findElement(By.xpath("//a[@class='goToPage btn'][@href='7']"));
		return element;
	}
	//NotoAllSymptoms
	public static WebElement NotoAllSymptoms(WebDriver driver){

		element = driver.findElement(By.id("noToAll"));
		return element;
	}
	//FatherMedicalHistory
	public static WebElement FatherMedicalHistory(WebDriver driver){

		element = driver.findElement(By.xpath("//div[@class='well well-sm Father']//label[contains(text(), 'No Medical Problems')]"));
		return element;
	}
	//MotherMedicalHistory
	public static WebElement MotherMedicalHistory(WebDriver driver){

		element = driver.findElement(By.xpath("//div[@class='well well-sm Mother']//label[contains(text(), 'No Medical Problems')]"));
		return element;
	}
	//finishBtn
	public static WebElement finishBtn(WebDriver driver){

		element = driver.findElement(By.id("NavigationSequence_Button3SequenceID"));
		return element;
	}
}