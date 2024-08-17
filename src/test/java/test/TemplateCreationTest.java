package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.AddQuestionsPage;
import pages.SignInPage;

public class TemplateCreationTest extends ProjectSpecificationMethod{
	@BeforeTest
	public void fileSetup() {
		testName = "TC_011_TemplateCreation";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}

	@Test
	public void TC_011_TemplateCreation() {
		// TODO Auto-generated method stub
		SignInPage obj = new SignInPage(driver);
		obj.emailID("hyrenet+bugathon@guvi.in").password("hyrenettest@123").signInButton()
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
		WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']/child::p[contains(text(), 'Successfully created Template')]")));
		String actualMessage = ele1.getText();
		//div[@class='alert alert-success']/child::p[contains(text(), 'Successfully created Template')]
		
		if(expectedMessage.equals(actualMessage)) {
			System.out.println("template created successfully");
		}else {
			System.out.println("template creation failed");
		}
	}

}
