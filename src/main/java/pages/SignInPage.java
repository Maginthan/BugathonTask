package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.Input;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class SignInPage extends ProjectSpecificationMethod{

	// Page factory to inspect element inside constructor
	@FindBy(id = "email")
	WebElement emailInput;
	
	@FindBy(id = "password")
	WebElement passwordInput;
	
	@FindBy(xpath = "//div[contains(text(),'Sign-in')]/parent::button[@id='submit']")
	WebElement signInButton;
	
	@FindBy(xpath="//a[@href='/sign-up']")
	WebElement signUpButton;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Public method to enter the email ID
	public SignInPage emailID(String emailID) {
		isElementEnabled(emailInput);
		findElementAndSendKeysByXpath(emailInput,emailID);
		return this;
	}
	
	//Public method to enter the password
	public SignInPage password(String password) {
		isElementEnabled(passwordInput);
		findElementAndSendKeysByXpath(passwordInput,password);
		return this;
	}
	
	//Public method to click Sign-in button
	public DashboardPage signInButton() {
		isElementEnabled(signInButton);
		click(signInButton);
		return new DashboardPage(driver);
	}
	
	//Public method to click Sign-Up button
	public SignUpPage clickSignUp() {
		isElementEnabled(signInButton);
		click(signUpButton);
		return new SignUpPage(driver);
	}
	
//	//Public method to get the sign in page title
//	public SignInPage signInTitle() {
//		driver.getTitle
//		return this;
//	}
	
}
