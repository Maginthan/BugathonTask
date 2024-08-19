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

public class UpadateEndPageTest extends ProjectSpecificationMethod {
	
	@BeforeTest
	public void fileSetup() {
		testName = "TC_014_UpadateEndPageDetails";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}

	@Test
	public void TC_014_UpadateEndPageDetails() throws IOException {
		// TODO Auto-generated method stub
		
		extentTest.info("Verifying the Updating End page details in Test End page with test case " + "-" + testName);
		try {
			SignInPage obj = new SignInPage(driver);
			obj.emailID(getPropertyValue("emailID")).password(getPropertyValue("password")).signInButton()
			.pagesModule()
			.editButton()
			.updateDetails()
			.updateButton();
			
			String expectedMessage = "Submit page details updated successfully";
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='snackbar__text'][contains(text(),'Submit page details updated successfully')]")));
			String actualMessage = ele.getText();
			
			if(expectedMessage.equals(actualMessage)) {
				extentTest.pass("Updating End page details in Test End page with test case " + testName + " passed");
			}else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Updating End page details in Test End page with test case " + testName + " failed");
			}
			
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Updating End page details in Test End page with test case " + testName + " failed due to exception"+ e.getMessage());
			e.printStackTrace();
		}
		
	}

}
