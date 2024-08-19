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

public class TestEndPage extends ProjectSpecificationMethod {

	@FindBy(xpath = "//div[@class='page__card']/descendant::button[@id='editPage']")
	WebElement edit;
	
	@FindBy(xpath = "//input[@id='heading'][@placeholder='Heading |']")
	WebElement heading;
	
	@FindBy(xpath = "//textarea[@id='content'][@placeholder='content |']")
	WebElement content;
	
	@FindBy(xpath = "//div[contains(text(),'Update')]/parent::button[@id='updateSubmitPageDetails']")
	WebElement update;

	public TestEndPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Public method to click edit button
	public TestEndPage editButton() {
		isElementEnabled(edit);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(edit));
		click(edit);
		return this;
	}
	
	// Public method to enter heading and content details
	public TestEndPage updateDetails() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(heading));
		heading.clear();
		heading.sendKeys(getPropertyValue("heading")+" - "+randomTestDuration());
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(content));
		content.clear();
		content.sendKeys(getPropertyValue("content"));
		return this;
	}
	
	// Public method to click update button
	public TestEndPage updateButton() {
		isElementEnabled(update);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(update));
		click(update);
		return this;
	}
}
