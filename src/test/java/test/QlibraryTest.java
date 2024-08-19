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

public class QlibraryTest extends ProjectSpecificationMethod{

	@BeforeTest
	public void fileSetup() {
		testName = "TC_013_AddNewQuestion";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}
	
	@Test
	public void TC_013_AddNewQuestion() throws IOException {
		// TODO Auto-generated method stub
		extentTest.info("Verifying the adding new question in Qlibrary with test case " + "-" + testName);
		
		try {
			SignInPage obj = new SignInPage(driver);
			obj.emailID(getPropertyValue("emailID")).password(getPropertyValue("password")).signInButton()
			.qLibraryModule()
			.addNewQuestion()
			.enterNewQuestion()
			.enterOptions()
			.enterScore()
			.selectDifficulty()
			.selectCategory()
			.selectTag()
			.selectAnswer()
			.addToLibrary();
			
			String expectedMessage = "Successfully added the question to the Library";
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']/child::p[contains(text(), 'Successfully added the question to the Library')]")));
			String actualMessage = ele.getText();

			
			if(expectedMessage.equals(actualMessage)) {
				extentTest.pass("Adding new question in Qlibrary test case " + testName + " passed");
			}else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Adding new question in Qlibrary test case " + testName + " failed");
			}
			
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Adding new question in Qlibrary test case " + testName + " failed due to exception"+ e.getMessage());
			e.printStackTrace();
		}
	}

}
