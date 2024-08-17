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

public class SignUpTest extends ProjectSpecificationMethod{

	// Public method to set the name of the Excel file
	@BeforeTest
	public void fileSetup() {
		excelFile = "TestDataSheet";
		sheetName = "SignUpTest";
		testName = "TS_004_SignUpTest";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}
	
	@Test(dataProvider = "ReadfromExcel")
	public void TS_004_SignUpTest(String workEmailID, String testCase_ID) throws IOException {
		// TODO Auto-generated method stub
		SignInPage obj = new SignInPage(driver);
		obj.clickSignUp().workEmail(workEmailID).continueButton();
		
		if(workEmailID.equals("TC_008_SignUpTest")) {
			String expectedError = "Enter valid E-mail.";
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignUp scneario with test case " + "-" + testCase_ID);
			try {
				// Explicit wait for the dashboard page to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Enter valid E-mail.')]")));
				String actualError = ele.getText();

				if (expectedError.equals(actualError)) {
					extentTest.pass("The user SignUp test case " + testCase_ID + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testCase_ID);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testCase_ID);
					extentTest.fail("The user SignUp test case " + testCase_ID + " failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testCase_ID);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testCase_ID);
				extentTest.fail("The user SignUp test case " + testCase_ID + " failed");
				e.printStackTrace();
			}
		}else if(testCase_ID.equals("TC_009_SignUpTest")) {
			String expectedError = "Enter valid work email";
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignUp scneario with test case " + "-" + testCase_ID);
			try {
				// Explicit wait for the dashboard page to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Enter valid work email')]")));
				String actualError = ele.getText();

				if (expectedError.equals(actualError)) {
					extentTest.pass("The user SignUp test case " + testCase_ID + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testCase_ID);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testCase_ID);
					extentTest.fail("The user SignUp test case " + testCase_ID + " failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testCase_ID);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testCase_ID);
				extentTest.fail("The user SignUp test case " + testCase_ID + " failed");
				e.printStackTrace();
			}
		}else {
			String expectedError = "E-mail is required.";
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignUp scneario with test case " + "-" + testCase_ID);
			try {
				// Explicit wait for the dashboard page to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'E-mail is required.')]")));
				String actualError = ele.getText();

				if (expectedError.equals(actualError)) {
					extentTest.pass("The user SignUp test case " + testCase_ID + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testCase_ID);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testCase_ID);
					extentTest.fail("The user SignUp test case " + testCase_ID + " failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testCase_ID);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testCase_ID);
				extentTest.fail("The user SignUp test case " + testCase_ID + " failed");
				e.printStackTrace();
			}
		}
	}

}
