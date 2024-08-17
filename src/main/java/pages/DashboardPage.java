package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class DashboardPage extends ProjectSpecificationMethod{

	@FindBy(xpath = "//a[@href='/settings']")
	WebElement settingsModule;
	
	@FindBy(xpath= "//a[@href='/tests']")
	WebElement testsModule;
	
	@FindBy(xpath= "//a[@href='/templates']")
	WebElement templateModule;
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Public method to select Settings module
	public SettingsPage settingsModule() {
		isElementEnabled(settingsModule);
		click(settingsModule);
		return new SettingsPage();
	}
	
	//Public method to select template module
	public TemplatePage templateModule() {
		isElementEnabled(templateModule);
		click(templateModule);
		return new TemplatePage(driver);
	}
}
