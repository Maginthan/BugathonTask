package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class CreateTemplatePage extends ProjectSpecificationMethod{
	
	
	@FindBy(xpath="//input[@id='custom-test-name']")
	WebElement tempName;
	
	@FindBy(xpath="//input[@id='custom-select-role-selectized'][@placeholder='Choose / Add a Role']")
	WebElement enterRole;
	
	@FindBy(xpath="//input[@placeholder='Choose a Template Plan']")
	WebElement tempPlan;
	
	@FindBy(xpath="//input[@id='custom-pgm-duration']")
	WebElement duration;
	
	@FindBy(xpath = "//input[@placeholder='Choose Language']")
	WebElement language;
	
	@FindBy(xpath = "//button[contains(@class,'custom-btn custom-btn--primary')][@id='step1-submit']")
	WebElement saveAndContinue;

	public CreateTemplatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Public method to click and enter role
	public CreateTemplatePage enterRole() {
		enterRole.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='option'][@data-value='Full stack developer']")));
		ele.click();
		return this;
	}
	
	//Public method to click and enter template name
	public CreateTemplatePage enterTemplateName() {
		tempName.click();
		tempName.sendKeys("Maginthan");
		return this;
	}
	
	//Public method to click and enter template plan
	public CreateTemplatePage enterTemplatePlan() {
		tempPlan.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='option'][@data-value='programming']")));
		ele.click();
		return this;
	}
	
	//Public method to click and enter duration
	public CreateTemplatePage enterDuration() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(""));
		duration.click();
		duration.sendKeys("10");
		return this;
	}
	
	//Public method to click and enter language
	public CreateTemplatePage enterLanguage() {
		language.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='option'][@data-value='java8']")));
		ele.click();
		return this;
	} 
	
	//Public method to click save and continue
	public AddQuestionsPage saveAndContinue() {
		saveAndContinue.click();
		return new AddQuestionsPage(driver);
	} 

}
