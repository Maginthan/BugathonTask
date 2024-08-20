package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class SettingsPage extends ProjectSpecificationMethod{

	//div[contains(@class,'user-bio')]/descendant::a[@id='logout']
	@FindBy(xpath="//div[contains(@class,'user-bio')]/descendant::a[@id='logout']")
	WebElement logOutButton;
	
	@FindBy(xpath="	//div[@class='form-group']/descendant::input[@id='userName']")
	WebElement userName;
	
	//div[@class='tab__content profile']/descendant::button[@id='updateUserDetails']
	@FindBy(xpath="//div[@class='tab__content profile']/descendant::button[@id='updateUserDetails']")
	WebElement saveNupdate;

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Public method to enter updated user name
	public SettingsPage updateUserName() throws IOException, InterruptedException {
		
		updatedUserName = randomUserName();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		userName.click();
		Thread.sleep(1000);
		//Keys class to perform to inputs in text box
//		userName.sendKeys(Keys.CONTROL + "a");
//		userName.sendKeys(Keys.DELETE);
		clearTextfield(userName);
		Thread.sleep(1000);
		userName.sendKeys(updatedUserName);
		return this;
	}
	
	//Public method to click save and update button
	public SettingsPage saveNupdate() {
		isElementEnabled(saveNupdate);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(saveNupdate));
		click(saveNupdate);
		return this;
	}
	
	
}
