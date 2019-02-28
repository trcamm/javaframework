package com.practicevelocity.seleniumEreg.Tests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.practicevelocity.seleniumEreg.PageObjects.*;

/**
 * @author tcammon
 *
 */
public class Login {

	//SauceLabs Config
	//public static final String USERNAME = "tellycammon1";
	//public static final String AUTOMATE_KEY = "Cnd8s8r5abqkZC1L5smy";
	//public static final String URL="https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	WebDriver driver = null;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	String projectPath;
	
    @BeforeTest
    public void setup(){

    	//SauceLabs config
    	//DesiredCapabilities caps = new DesiredCapabilities();
    	//caps.setCapability("os", "Windows");
    	//caps.setCapability("os_version", "10");
    	//caps.setCapability("browser", "Chrome");
    	//caps.setCapability("browser_version", "70.0");
    	//caps.setCapability("name", "PVMLoginTest");
    	//caps.setCapability("browserstack.local", "false");
    	//caps.setCapability("browserstack.selenium_version", "3.5.2");


    	//WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

    	projectPath = System.getProperty("user.dir");
    	System.setProperty("webdriver.chrome.driver", projectPath+"/seleniumdrivers/chrome/chromedriver.exe");
    	driver = new ChromeDriver();
    	//System.setProperty("webdriver.gecko.driver", projectPath+"/seleniumdrivers/Firefox/geckodriver.exe");	
    	//driver = new FirefoxDriver();

    	//added implicit wait to find elements
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
    	//enter PVM URL
    	driver.manage().window().maximize();
    	driver.get("https://stpvpm.practicevelocity.com/18_4");
    }	
	    
    @Test
    public void PVloginDataDriven() throws IOException{
    	// Import excel sheet.
    	File src=new File("C:/EregFramework/master/com.practicevelocity.seleniumEreg/data/TestData.xlsx"); 

    	// Load the file.
    	FileInputStream fis = new FileInputStream(src);
    	// Load he workbook.
    	workbook = new XSSFWorkbook(fis);
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
    }
    @AfterTest
    public void teardown(){
    	//close browser
    	driver.quit();
    	System.out.println("test complete successfully");
    }
}


