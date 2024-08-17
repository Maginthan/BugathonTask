package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class TemplatePage extends ProjectSpecificationMethod{
	
	@FindBy(xpath="//a[@href='/templates/create/step1']")
	WebElement createTemplate;
	
	@FindBy(xpath="")
	WebElement clickRole;
	
	@FindBy(xpath="//input[@id='custom-select-role-selectized']")
	WebElement enterRole;
	
	public TemplatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Public method to click create template
	public TemplatePage createtemplate() {
		isElementEnabled(createTemplate);
		click(createTemplate);
		return this;
	}
	
	//Public method to click and enter role
	public TemplatePage enterRole() {
		enterRole.click();
		enterRole.sendKeys("Testengineer");
		return this;
	}
	
	
}
