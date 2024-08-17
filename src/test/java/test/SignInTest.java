package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.SignInPage;

public class SignInTest extends ProjectSpecificationMethod {

	// Public method to set the name of the Excel file
	@BeforeTest
	public void fileSetup() {
		excelFile = "TestDataSheet";
		sheetName = "SignInTest";
		testName = "TS_002_LoginTest";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}
	
	@Test(dataProvider = "ReadfromExcel")
	public void TS_002_SignInTest(String emailID, String password, String testCaseID) throws IOException {
		// TODO Auto-generated method stub
//		System.out.println("The email ID is: "+ emailID);
//		System.out.println("The email password is: "+ password);
		
		SignInPage obj = new SignInPage(driver);
		obj.emailID(emailID).password(password).signInButton();

		// Validating test cases for Sigin functionality
		if (testCaseID.equals("TC_002_SignInTest")) {
			String expectedTitle = "Dashboard";
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignIn scneario with test case " + "-" + testCaseID);
			
			try {
				// Explicit wait for the dashboard page to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(), 'dashboard')]")));
				String actualTitle = ele.getText();

				if (expectedTitle.equals(actualTitle)) {
					extentTest.pass("The user SignIn test case " + testCaseID + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testCaseID);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testCaseID);
					extentTest.fail("The user SignIn test case " + testCaseID + " failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testCaseID);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testCaseID);
				extentTest.fail("The user SignIn test case " + testCaseID + " failed");
				e.printStackTrace();
			}
		} else if (testCaseID.equals("TC_003_SignInTest")) {
			String expectedError = "Email or Password is Incorrect";
			extentTest.info("Verifying the SignIn scneario with test case " + "-" + testCaseID);

			try {
				// Explicit wait for the error message to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Email or Password is Incorrect')]")));
				String actualError = ele.getText();

				if (expectedError.equals(actualError)) {
					extentTest.pass("The user SignIn test case " + testCaseID + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testCaseID);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testCaseID);
					extentTest.fail("The user SignIn test case " + testCaseID + " failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testCaseID);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testCaseID);
				extentTest.fail("The user SignIn test case " + testCaseID + " failed");
				e.printStackTrace();
			}
		} else if (testCaseID.equals("TC_004_SignInTest")) {
			String expectedError = "Email or Password is Incorrect";
			extentTest.info("Verifying the SignIn scneario with test case " + "-" + testCaseID);

			try {
				// Explicit wait for the error message to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Email or Password is Incorrect')]")));
				String actualError = ele.getText();

				if (expectedError.equals(actualError)) {
					extentTest.pass("The user SignIn test case " + testCaseID + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testCaseID);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testCaseID);
					extentTest.fail("The user SignIn test case " + testCaseID + " failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testCaseID);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testCaseID);
				extentTest.fail("The user SignIn test case " + testCaseID + " failed");
				e.printStackTrace();
			}
		}else if (testCaseID.equals("TC_005_SignInTest")) {
			String expectedError = "Email or Password is Incorrect";
			extentTest.info("Verifying the SignIn scneario with test case " + "-" + testCaseID);
			
			try {
				// Explicit wait for the error message to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Email or Password is Incorrect')]")));
				String actualError = ele.getText();

				if (expectedError.equals(actualError)) {
					extentTest.pass("The user SignIn test case " + testCaseID + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testCaseID);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testCaseID);
					extentTest.fail("The user SignIn test case " + testCaseID + " failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testCaseID);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testCaseID);
				extentTest.fail("The user SignIn test case " + testCaseID + " failed");
				e.printStackTrace();
			}
	}else {
		extentTest.info("Verifying the SignIn scneario with test case " + "-" + testCaseID);
		
		String expectedEmailError = "E-mail is required.";
		String expectedPassError = "Password is required."; 
		
		try {
			// Explicit wait for the error message to appear
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[contains(text(),'E-mail is required.')]")));
			String actualEmailError = emailError.getText();
			
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement passError = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[contains(text(),'Password is required.')]")));
			String actualPassError = passError.getText();
			
//			System.out.println("------"+actualPassError+"------");
//			System.out.println("------"+actualEmailError+"------");
			
			if (expectedEmailError.equals(actualEmailError) && expectedPassError.equals(actualPassError)) {
				extentTest.pass("The user SignIn test case " + testCaseID + " passed");
			} else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testCaseID);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testCaseID);
				extentTest.fail("The user SignIn test case " + testCaseID + " failed");
			}
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testCaseID);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testCaseID);
			extentTest.fail("The user SignIn test case " + testCaseID + " failed");
			e.printStackTrace();
		}
	}

}
}
