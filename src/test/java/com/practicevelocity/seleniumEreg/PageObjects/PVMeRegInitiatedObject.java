package com.practicevelocity.seleniumEreg.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * @author tcammon
 *
 */
public class PVMeRegInitiatedObject {
	
	private static WebElement element = null;

	public static WebElement pvm_GeneratePin(WebDriver driver){
		//element = driver.findElement(By.xpath("//div[@id='kioskPrintAbort']//i[@ng-click='displayKioskPin(row.KioskPin)'][@title]"));
		element = driver.findElement(By.xpath("//div[@id='kioskPrintAbort']//i[@ng-click='displayKioskPin(row.KioskPin)']"));
		return element;
	}
	//AddNew_privateVisit
	public static WebElement AddNew_privateVisit(WebDriver driver){

		element = driver.findElement(By.id("Button-Add-New-Priv"));
		return element;
	}
	//VisitLastName
	public static WebElement VisitLastName(WebDriver driver){

		element = driver.findElement(By.id("txtLastName"));
		return element;
	}
	//VisitFirstName
	public static WebElement VisitFirstName(WebDriver driver){

		element = driver.findElement(By.id("txtFirstName"));
		return element;
	}
	//visitVerify
	public static WebElement visitVerify(WebDriver driver){

		element = driver.findElement(By.id("btnVerify"));
		return element;
	}
	//visitSendToKiosk
	public static WebElement visitSendToKiosk(WebDriver driver){

		element = driver.findElement(By.id("btnSendToKiosk"));
		return element;
	}
}
