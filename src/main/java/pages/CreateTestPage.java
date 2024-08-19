package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class CreateTestPage extends ProjectSpecificationMethod{
	
	@FindBy(xpath="//a[@href='/tests/create/step1']")
	WebElement createTest;

	public CreateTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Public method to click the create Test button
	public SelectTemplatePage createTest(){
		isElementEnabled(createTest);
		click(createTest);
		return new SelectTemplatePage(driver);
	}
}
