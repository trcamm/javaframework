package com.practicevelocity.seleniumEreg.PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author tcammon
 *
 */

public class EregNavigationObjects {

	private static WebElement element = null;

	//resourcePractice_Clinic
	public static WebElement resourcePractice_Clinic(WebDriver driver){

		element = driver.findElement(By.xpath("//a[text()='Practice/Clinic']"));
		return element;
	}
	//PracticeSearch
	public static WebElement PracticeSearch(WebDriver driver){

		element = driver.findElement(By.id("txtPracticeSearch"));
		return element;
	}
	//practiceLink	
	public static WebElement practiceLink(WebDriver driver){

		element = driver.findElement(By.linkText("QATC"));
		return element;
	}
	//clinicLink	
	public static WebElement clinicLink(WebDriver driver){

		element = driver.findElement(By.linkText("PIPCLINIC"));
		return element;
	}
	//NavConfig_SaveExit
	public static WebElement NavConfig_SaveExit(WebDriver driver){

		element = driver.findElement(By.id("btnSaveExit"));
		return element;
	}
	//Config_logout
	public static WebElement Config_logout(WebDriver driver){

		element = driver.findElement(By.linkText("logout"));
		return element;
	}
	//KioskEndpoint
	public static WebElement KioskEndpoint(WebDriver driver){

		element = driver.findElement(By.id("KioskEndpoint"));
		return element;
	}
}
