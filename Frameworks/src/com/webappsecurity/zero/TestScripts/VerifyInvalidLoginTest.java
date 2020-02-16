package com.webappsecurity.zero.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webappsecurity.zero.Pages.Login;
import com.webappsecurity.zero.Pages.LoginError;

import utils.GenericMethods;

public class VerifyInvalidLoginTest {

	WebDriver driver;
	@BeforeTest
	public void openApplication() {
		System.setProperty("webdrive.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void verifyInValidLogin() throws IOException {
		Login lp = new Login(driver);
		LoginError le = new LoginError(driver);

		String[][] data = GenericMethods.getData("D:\\SelJan18\\TestData.xlsx", "Sheet1");

		for(int i=1;i<data.length;i++) {
			lp.applicationLogin(data[i][0],data[i][1]);
			String actualMessage = le.getErrorMsg();
			String expectedMessage= "Login and/or password are wrong.";
			Assert.assertEquals(actualMessage, expectedMessage);
			driver.navigate().back();
		}
	}

	@AfterTest
	public void closeApplication() {
		driver.close();
	}

}
