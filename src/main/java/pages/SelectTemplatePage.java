package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class SelectTemplatePage extends ProjectSpecificationMethod{
		
	public SelectTemplatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Public method to click first template from list of templates
	public CreateDrivePage selectFirstTemplate() {
			List<WebElement> templateList = driver.findElements(By.xpath("//div[contains(text(),'Select This')]/parent::button[contains(@class,'test-selector')]"));
			//Using streams to click first template
			
			//Optional<WebElement> template = templates.stream().findFirst().get().click();
			//templates.stream().findFirst().get().click();
			//ele.get().click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(templateList));
			templateList.get(0).click();
			return new CreateDrivePage(driver);
	}
	
	
}
