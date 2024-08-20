package pages;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class TestConfigurationPage extends ProjectSpecificationMethod{
	
	@FindBy(id="drive-name")
	WebElement testName;
	
	@FindBy(xpath="//input[@id='drive-dates'][@placeholder='-Test period-']")
	WebElement testPeriodInput;
	
	@FindBy(xpath="//div[contains(text(),'Save & Submit')]/parent::button[contains(@class,'save-drive')]")
	WebElement saveNContinueTest;
	
	@FindBy(xpath="//p[@data-placeholder='Job Description |']/parent::div")
	WebElement jobDescription;
	
	@FindBy(xpath = "//button[contains(text(),'Apply')][contains(@class,'applyBtn')]")
	WebElement apply;
	
	public TestConfigurationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Public method to enter test configuration details of test name
	public TestConfigurationPage testName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(testName));
		testName.sendKeys(randomTestName());
		return this;
	}
	
	//Public method to enter test configuration details of test period
	public TestConfigurationPage testPeriod() {
		testPeriodInput.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(apply));
		click(apply);
		return this;
	}
	
	//Public method to enter test description
	public TestConfigurationPage testDescription() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(jobDescription));
		click(jobDescription);
		jobDescription.sendKeys(getPropertyValue("jobDescription"));
		return this;
	}
	
	//Public method to click save and submit to move to create test page
	public TestCompletionPage saveNsubmit() {
		isElementEnabled(saveNContinueTest);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(saveNContinueTest));
		click(saveNContinueTest);
		return new TestCompletionPage(driver);
	}
	
}
