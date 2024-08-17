package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.SignInPage;

public class LogoutTest extends ProjectSpecificationMethod{

	// Public method to set the name of the Excel file
	@BeforeTest
	public void fileSetup() {
		testName = "TC_007_LogOutTest";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}
	
	@Test
	public void TC_008_SignUnTest() throws IOException {
		// TODO Auto-generated method stub
		extentTest.info("Verifying the user log out test case " + "-" + testName);
		try {
			SignInPage obj = new SignInPage(driver);
			obj.emailID("hyrenet+bugathon@guvi.in").password("hyrenettest@123").signInButton()
			.settingsModule();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='javascript:signOut();'])[2]")));
			ele.click();
			
			String expectedTitle = "Hyre";
			String actualTitle = driver.getTitle();
			
			if(expectedTitle.equals(actualTitle)) {
				extentTest.pass("The user log out test case " + testName + " passed");
			}else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("The user log out test case " + testName + " failed");
			}
			
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("The user log out test case " + testName + " failed");
			e.printStackTrace();
		}

	}

}
