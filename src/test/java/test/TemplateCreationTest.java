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

public class TemplateCreationTest extends ProjectSpecificationMethod{
	@BeforeTest
	public void fileSetup() {
		testName = "TC_011_TemplateCreation";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}

	@Test
	public void TC_011_TemplateCreation() throws IOException {
		// TODO Auto-generated method stub
		extentTest.info("Verifying the Template creation sceanrio with test case " + "-" + testName);
		
		try {
			SignInPage obj = new SignInPage(driver);
			obj.emailID(getPropertyValue("emailID")).password(getPropertyValue("password")).signInButton()
			.templateModule()
			.createTemplate()
			.enterRole()
			.enterTemplateName()
			.enterTemplatePlan()
			.enterDuration()
			.enterLanguage()
			.saveAndContinue()
			.addQuestions()
			.questions()
			.closeQuestionsView()
			.saveNsubmit();
			
			String expectedMessage = "Successfully created Template";
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']/child::p[contains(text(), 'Successfully created Template')]")));
			String actualMessage = ele.getText();
			//div[@class='alert alert-success']/child::p[contains(text(), 'Successfully created Template')]
			
			if(expectedMessage.equals(actualMessage)) {
				extentTest.pass("The template creation test case " + testName + " passed");
			}else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("The template creation test case " + testName + " failed");
			}
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("The template creation test case " + testName + " failed due to exception"+ e.getMessage());
			e.printStackTrace();
		}

	}

}
