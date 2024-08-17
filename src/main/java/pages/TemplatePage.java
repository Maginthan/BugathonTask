package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class TemplatePage extends ProjectSpecificationMethod{
	
	@FindBy(xpath="//a[@href='/templates/create/step1']")
	WebElement createTemplate;
	
	public TemplatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Public method to click create template
	public CreateTemplatePage createTemplate() {
		isElementEnabled(createTemplate);
		click(createTemplate);
		return new CreateTemplatePage(driver);
	}	
	
}
