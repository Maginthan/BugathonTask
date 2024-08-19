package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class TestCompletionPage extends ProjectSpecificationMethod{
	
	@FindBy(xpath= "//div[contains(@class,'alert-success')]/descendant::p[contains(text(),'Successfully created Drive.')]")
	WebElement testCreatedMessage;
	
	public TestCompletionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
