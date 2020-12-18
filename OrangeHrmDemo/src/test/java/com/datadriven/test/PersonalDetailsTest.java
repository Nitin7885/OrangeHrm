package com.datadriven.test;
import Pages.PersonalDetailsPageFactory;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;


public class PersonalDetailsTest{
	WebDriver driver;
	private PersonalDetailsPageFactory objelppf;
	public int testCount;
	public String cdriverAd;
	public String url;
	public String un;
	public String pwd;
	public int waitTime;

	
	@BeforeTest
	public void setUp() throws Throwable {
		/*
		File src = new File("./Attributes.property");
		FileInputStream fis = new FileInputStream(src);
		Properties p = new Properties();
		p.load(fis);
		cdriverAd = p.getProperty("chromeDriverAddress");
		url = p.getProperty("url");
		un = p.getProperty("uname");
		pwd = p.getProperty("pass");
		waitTime = Integer.parseInt(p.getProperty("low"));
		System.out.println(url);
		*/
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abc\\Downloads\\Programs\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		objelppf = new PersonalDetailsPageFactory(driver);
		objelppf.setUname("Admin");
		objelppf.setPwd("admin123");
		objelppf.setLogin();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		objelppf.setPimLink();
		
		Thread.sleep(1000);
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider = "getTestData")
	public void personalDetailsPageTest(String en, String eID, String sn) throws Throwable {
		testCount++;
		Thread.sleep(1000);
		objelppf.getPfename().clear();
		objelppf.setEmpName(en);
		objelppf.getPfeid().clear();
		objelppf.setEmpID(eID);
		objelppf.getPfsname().clear();
		objelppf.setSupName(sn);
		//Thread.sleep(1000);
		System.out.println("TEST CASE: " + testCount);
		System.out.println("Employee name: " + en);
		System.out.println("Employee ID: " + eID);
		System.out.println("Supervisor name: " + sn);
		
	    String data = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td")).getText();
	    String expectedResult = "No Records Found";
	    Assert.assertEquals(data, expectedResult);
	    
	    if(data.contentEquals("No Records Found")) {
	    	System.out.println("Status: **********PASSED");
	    }
	    else {
	    	System.out.println("Status: **********FAILED");
	    }
	    driver.close();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
