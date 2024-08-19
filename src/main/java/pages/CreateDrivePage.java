package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class CreateDrivePage extends ProjectSpecificationMethod {

	@FindBy(xpath = "//div[contains(text(),'Save & Continue')]/parent::a[contains(@class,'to-drive-2')]")
	WebElement saveNContinue;

	public CreateDrivePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Public method to click save and continue button
	public TestConfigurationPage saveNContinue() {
		isElementEnabled(saveNContinue);
		click(saveNContinue);
		return new TestConfigurationPage(driver);
	}
}
