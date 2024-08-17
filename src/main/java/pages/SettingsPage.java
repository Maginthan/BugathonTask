package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class SettingsPage extends ProjectSpecificationMethod{

	@FindBy(xpath="(//a[@href='javascript:signOut();'])[2]")
	WebElement logOutButton;
	
	public void Settings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
