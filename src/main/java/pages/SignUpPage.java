package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class SignUpPage extends ProjectSpecificationMethod{
	
	// Page factory to inspect element inside constructor
	@FindBy(id = "workEmail")
	WebElement workEmailInput;
	
	@FindBy(id = "signupContinueBtn")
	WebElement signUpButton;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Public method to enter work email
	public SignUpPage workEmail(String emailID) {
		isElementEnabled(workEmailInput);
		findElementAndSendKeysByXpath(workEmailInput,emailID);
		return this;
	}
	
	//Public method to click Sign up button
	public SignUpPage continueButton() {
		isElementEnabled(signUpButton);
		click(signUpButton);
		return this;
	}
	
}
