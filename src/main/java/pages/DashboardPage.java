package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class DashboardPage extends ProjectSpecificationMethod {

	@FindBy(xpath = "//a[@href='/settings']")
	WebElement settingsModule;

	@FindBy(xpath = "//a[@href='/tests']")
	WebElement testsModule;

	@FindBy(xpath = "//a[@href='/templates']")
	WebElement templateModule;

	@FindBy(xpath = "//a[@href='/tests']")
	WebElement testModule;

	@FindBy(xpath = "//a[@href='/library']")
	WebElement qlibraryModule;
	
	@FindBy(xpath = "//a[@href='/pages']")
	WebElement pagesModule;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Public method to select Settings module
	public SettingsPage settingsModule() {
		isElementEnabled(settingsModule);
		click(settingsModule);
		return new SettingsPage(driver);
	}

	// Public method to select template module
	public TemplatePage templateModule() {
		isElementEnabled(templateModule);
		click(templateModule);
		return new TemplatePage(driver);
	}

	// Public method to select test module
	public CreateTestPage testModule() {
		isElementEnabled(testModule);
		click(testModule);
		return new CreateTestPage(driver);
	}
	
	// Public method to select My QLibrary module
	public QlibraryPage qLibraryModule() {
		isElementEnabled(qlibraryModule);
		click(qlibraryModule);
		return new QlibraryPage(driver);
	}
	
	// Public method to select My QLibrary module
	public TestEndPage pagesModule() {
		isElementEnabled(pagesModule);
		click(pagesModule);
		return new TestEndPage(driver);
	}
	
}
