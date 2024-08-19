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

public class DriveCreationTest extends ProjectSpecificationMethod{

	@BeforeTest
	public void fileSetup() {
		testName = "TC_012_TestCreation";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}
	
	@Test
	public void TC_012_TemplateCreation() throws IOException{
		// TODO Auto-generated method stub
		extentTest.info("Verifying the Test creation scneario with test case " + "-" + testName);
		
		try {
			SignInPage obj = new SignInPage(driver);
			obj.emailID(getPropertyValue("emailID")).password(getPropertyValue("password")).signInButton()
			.testModule()
			.createTest()
			.selectFirstTemplate()
			.saveNContinue()
			.testName()
			.testPeriod()
			.testDescription()
			.saveNsubmit();
			
			String expectedMessage = "Successfully created Drive.";
					
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success')]/descendant::p[contains(text(),'Successfully created Drive.')]")));
			String actualMessage = ele.getText();	
			
			if(expectedMessage.equals(actualMessage)) {
				extentTest.pass("The test creation test case " + testName + " passed");
			}else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("The test creation test case " + testName + " failed");
			}
			
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("The test creation test case " + testName + " failed due to exception"+ e.getMessage());
			e.printStackTrace();
		}
		

	}

}
