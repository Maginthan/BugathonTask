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

public class UserNameUpdateTest extends ProjectSpecificationMethod{

	@BeforeTest
	public void fileSetup() {
		testName = "TC_015_UpdateUserName";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}
	
	@Test
	public void TC_015_UpadateUserName() throws IOException {
		// TODO Auto-generated method stub
		extentTest.info("Verifying the Updating User name in settings page with test case " + "-" + testName);
		try {
			SignInPage obj = new SignInPage(driver);
			obj.emailID(getPropertyValue("emailID")).password(getPropertyValue("password")).signInButton()
			.settingsModule()
			.updateUserName()
			.saveNupdate();
			
			String expectedMessage = "Profile updated successfully";
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'snackbar--success')]/descendant::p[contains(text(),'Profile updated successfully')]")));
			String actualMessage = ele.getText();
			
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ele2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='user-bio__info']/child::span[@class='user-bio__name']")));
			String userName = ele2.getText();
			
			if(expectedMessage.equals(actualMessage) && userName.equals(updatedUserName)) {
				extentTest.pass("Updating User name in settings page with test case " + testName + " passed");
				System.out.println("User name is "+userName);
				System.out.println("Update usr name is "+updatedUserName);
			}else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Updating User name in settings page with test case " + testName + " failed");
			}
			
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Updating User name in settings page with test case " + testName + " failed due to exception"+ e.getMessage());
			e.printStackTrace();
	}

}
}
