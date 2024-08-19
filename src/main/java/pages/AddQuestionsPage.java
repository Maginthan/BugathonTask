package pages;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.ProjectSpecificationMethod;



public class AddQuestionsPage extends ProjectSpecificationMethod{

	@FindBy(xpath = "//button[@type='button'][@data-target='#modal-question-library']")
	WebElement addQuestions;
	
	@FindBy(xpath = "//button[@type='button']/child::div[contains(text(),'Update Questions')]")
	WebElement updateQuestions;
	
	@FindBy(xpath = "//div[contains(text(),'Close')]/parent::button[@aria-label='Close']")
	WebElement close;
	
	@FindBy(xpath = "//div[contains(text(),'Save & Submit')]/parent::a[contains(@class,'save-and-submit')]")
	WebElement saveNsubmit;
	
	public AddQuestionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Public method to click add questions button
	public AddQuestionsPage addQuestions() {
		click(addQuestions);
		return this;
	}
	
	//public method to add questions
	public AddQuestionsPage questions() {
		List<WebElement> questions = driver.findElements(By.xpath("//button[@title='Add this question']"));
		questions.stream().forEach(ele -> ele.click());
		return this;
	}
	
	//public method to update questions
	public AddQuestionsPage updateQuestion() {
		click(updateQuestions);
		return this;
	}
	
	//public method to close question view
	public AddQuestionsPage closeQuestionsView() {
		click(close);
		return this;
	}
	
	//public method to click save and submit button
	public TemplateCompletionPage saveNsubmit() {
		click(saveNsubmit);
		return new TemplateCompletionPage(driver);
	}
	
	
	
	
}
