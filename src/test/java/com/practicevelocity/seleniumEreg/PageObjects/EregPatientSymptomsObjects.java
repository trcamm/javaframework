package com.practicevelocity.seleniumEreg.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * @author tcammon
 *
 */

/*To switch patient symptoms to Yes or No trigger, update xpath element
example: update NoAbdominalpain to YesAbdominalpain
*/
public class EregPatientSymptomsObjects {

	private static WebElement element = null;
	
	//Abdominalpain
	public static WebElement Abdominalpain(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='YesAbdominalpain']"));
		return element;
	}
	//Abnormalbloodsugar
	public static WebElement Abnormalbloodsugar(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='YesAbnormalbloodsugar']"));
		return element;
	}
	//AnxietyNerves
	public static WebElement AnxietyNerves(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='YesAnxietyNerves']"));
		return element;
	}
	//Backpain
	public static WebElement Backpain(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoBackpain']"));
		return element;
	}
	//Bloodinstool
	public static WebElement Bloodinstool(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoBloodinstool']"));
		return element;
	}
	//Bloodinurine
	public static WebElement Bloodinurine(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoBloodinurine']"));
		return element;
	}
	//Blurredvision
	public static WebElement Blurredvision(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoBlurredvision']"));
		return element;
	}
	//Bruising
	public static WebElement Bruising(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoBruising']"));
		return element;
	}
	//Changeinappetite
	public static WebElement Changeinappetite(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoChangeinappetite']"));
		return element;
	}
	//Chestpainpressure
	public static WebElement Chestpainpressure(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoChestpainpressure']"));
		return element;
	}
	//Chills
	public static WebElement Chills(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoChills']"));
		return element;
	}
	//Coldintolerance
	public static WebElement Coldintolerance(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoColdintolerance']"));
		return element;
	}
	//Congestion
	public static WebElement Congestion(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoCongestion']"));
		return element;
	}
	//Constipation
	public static WebElement Constipation(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoConstipation']"));
		return element;
	}
	//Cough
	public static WebElement Cough(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoCough']"));
		return element;
	}
	//Depression
	public static WebElement Depression(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoDepression']"));
		return element;
	}
	//Diarrhea
	public static WebElement Diarrhea(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoDiarrhea']"));
		return element;
	}
	//Difficultyswallowing
	public static WebElement Difficultyswallowing(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoDifficultyswallowing']"));
		return element;
	}
	//Dischargeurethral
	public static WebElement Dischargeurethral(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoDischargeurethral']"));
		return element;
	}
	//Dischargevaginal
	public static WebElement Dischargevaginal(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoDischargevaginal']"));
		return element;
	}
	//Dizziness
	public static WebElement Dizziness(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoDizziness']"));
		return element;
	}
	//Earpain
	public static WebElement Earpain(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoEarpain']"));
		return element;
	}
	//Easybleeding
	public static WebElement Easybleeding(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoEasybleeding']"));
		return element;
	}
	//ExcessiveCrying
	public static WebElement ExcessiveCrying(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoExcessiveCrying']"));
		return element;
	}
	//ExcessivehungerThirst
	public static WebElement ExcessivehungerThirst(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoExcessivehungerThirst']"));
		return element;
	}
	//Eyedischarge
	public static WebElement Eyedischarge(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoEyedischarge']"));
		return element;
	}
	//Eyepain
	public static WebElement Eyepain(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoEyepain']"));
		return element;
	}
	//Eyeredness
	public static WebElement Eyeredness(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoEyeredness']"));
		return element;
	}
	//Eyeswelling
	public static WebElement Eyeswelling(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoEyeswelling']"));
		return element;
	}
	//Fainting
	public static WebElement Fainting(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoFainting']"));
		return element;
	}
	//Fatigue
	public static WebElement Fatigue(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoFatigue']"));
		return element;
	}
	//Fever
	public static WebElement Fever(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoFever']"));
		return element;
	}
	//FlutteringPalpitations
	public static WebElement FlutteringPalpitations(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoFlutteringPalpitations']"));
		return element;
	}
	//Frequentinfections
	public static WebElement Frequentinfections(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoFrequentinfections']"));
		return element;
	}
	//Frequenturination
	public static WebElement Frequenturination(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoFrequenturination']"));
		return element;
	}
	//Hairloss
	public static WebElement Hairloss(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoHairloss']"));
		return element;
	}
	//Heatintolerance
	public static WebElement Heatintolerance(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoHeatintolerance']"));
		return element;
	}
	//Hoarseness
	public static WebElement Hoarseness(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoHoarseness']"));
		return element;
	}
	//Hotflashes
	public static WebElement Hotflashes(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoHotflashes']"));
		return element;
	}
	//Itching
	public static WebElement Itching(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoItching']"));
		return element;
	}
	//ItchyEyes
	public static WebElement ItchyEyes(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoItchyEyes']"));
		return element;
	}
	//Jointpain
	public static WebElement Jointpain(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoJointpain']"));
		return element;
	}
	//Laceration
	public static WebElement Laceration(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoLaceration']"));
		return element;
	}
	//Legswelling
	public static WebElement Legswelling(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoLegswelling']"));
		return element;
	}
	//Lightheadedness
	public static WebElement Lightheadedness(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoLightheadedness']"));
		return element;
	}
	//LipTongueThroatSwelling
	public static WebElement LipTongueThroatSwelling(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoLipTongueThroatSwelling']"));
		return element;
	}
	//Lossofconsciousness
	public static WebElement Lossofconsciousness(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoLossofconsciousness']"));
		return element;
	}
	//Menstrualcomplaints
	public static WebElement Menstrualcomplaints(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoMenstrualcomplaints']"));
		return element;
	}
	//Mouthpain
	public static WebElement Mouthpain(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoMouthpain']"));
		return element;
	}
	//Musclepain
	public static WebElement Musclepain(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoMusclepain']"));
		return element;
	}
	//Nasalcongestion
	public static WebElement Nasalcongestion(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoNasalcongestion']"));
		return element;
	}
	//Nausea
	public static WebElement Nausea(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoNausea']"));
		return element;
	}
	//Nighttimeurination
	public static WebElement Nighttimeurination(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoNighttimeurination']"));
		return element;
	}
	//Nosedischarge
	public static WebElement Nosedischarge(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoNosedischarge']"));
		return element;
	}
	//NumbnessTingling
	public static WebElement NumbnessTingling(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoNumbnessTingling']"));
		return element;
	}
	//Painfulurination
	public static WebElement Painfulurination(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoPainfulurination']"));
		return element;
	}
	//Poorbalance
	public static WebElement Poorbalance(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoPoorbalance']"));
		return element;
	}
	//Postnasaldrip
	public static WebElement Postnasaldrip(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoPostnasaldrip']"));
		return element;
	}
	//Rash
	public static WebElement Rash(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoRash']"));
		return element;
	}
	//Shortnessofbreath
	public static WebElement Shortnessofbreath(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoShortnessofbreath']"));
		return element;
	}
	//Skinsores
	public static WebElement Skinsores(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoSkinsores']"));
		return element;
	}
	//Sleepdifficulties
	public static WebElement Sleepdifficulties(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoSleepdifficulties']"));
		return element;
	}
	//Sneezing
	public static WebElement Sneezing(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoSneezing']"));
		return element;
	}
	//Snoring
	public static WebElement Snoring(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoSnoring']"));
		return element;
	}
	//Sorethroat
	public static WebElement Sorethroat(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoSorethroat']"));
		return element;
	}
	//Swelling
	public static WebElement Swelling(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoSwelling']"));
		return element;
	}
	//Vomiting
	public static WebElement Vomiting(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoVomiting']"));
		return element;
	}
	//Weakness
	public static WebElement Weakness(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoWeakness']"));
		return element;
	}
	//Wheeze
	public static WebElement Wheeze(WebDriver driver){

		element = driver.findElement(By.xpath("//div//label[@for='NoWheeze']"));
		return element;
	}
}
