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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.practicevelocity.seleniumEreg.PageObjects.PVMLoginObjects;
 
/**
 * @author tcammon
 *
 */
public class PVMLoginTest {
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	String projectPath;
 
    @BeforeTest
    public void initialization(){

    	projectPath = System.getProperty("user.dir");

    	//System.setProperty("webdriver.chrome.driver", projectPath+"/seleniumdrivers/chrome/chromedriver.exe");
    	//driver = new ChromeDriver();
    	System.setProperty("webdriver.gecko.driver", projectPath+"/seleniumdrivers/Firefox/geckodriver.exe");	
    	driver = new FirefoxDriver();
    	driver.get("https://st2pvpm.practicevelocity.com/");
    	// To maximize the browser
    	//driver.manage().window().maximize();
    	// implicit wait
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }
   
    @Test
    public void fbLoginLogout() throws IOException{
    	// Import excel sheet.
    	File src=new File(projectPath+"/data/TestData.xlsx"); 

    	// Load the file.
    	FileInputStream tc = new FileInputStream(src);
    	// Load he workbook.
    	workbook = new XSSFWorkbook(tc);
    	// Load the sheet in which data is stored.
    	sheet= workbook.getSheetAt(0);
    	for(int i=1; i<=sheet.getLastRowNum(); i++){

    		// Import data for Email.
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
    	
    }
    @AfterTest
    public void teardownTest(){
    	//close browser
    	driver.quit();
    	System.out.println("test complete successfully");

    }

}

