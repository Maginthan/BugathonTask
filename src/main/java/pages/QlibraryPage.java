package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class QlibraryPage extends ProjectSpecificationMethod{
	
	@FindBy(xpath = "//div[contains(text(),'Add New Objective Question')]/parent::button[contains(@id,'add-mcq')]")
	WebElement addNewQuestion;
	
	//div[contains(@class,'ck-editor__main')]
	@FindBy(xpath = "//div[contains(@class,'ck-editor__main')]/child::div")
	WebElement enterNewQuestion;
	
	@FindBy(xpath = "//input[@id='mcq-option-a']")
	WebElement optionA;
	
	@FindBy(xpath = "//input[@id='mcq-option-b']")
	WebElement optionB;
	
	@FindBy(xpath = "//input[@id='mcq-question-score']")
	WebElement enterScore;
	
	@FindBy(xpath = "//input[@placeholder='Choose Level'][contains(@id,'mcq-question')]")
	WebElement selectDifficulty;
	
	@FindBy(xpath = "//select[@id='mcq-question-difficulty']/following-sibling::div/descendant::div[@data-value='easy']")
	WebElement selectEasy;
	
	@FindBy(xpath = "//select[@id='mcq-question-category']/following-sibling::div/descendant::input")
	WebElement selectCategory;
	
	@FindBy(xpath = "//select[@id='mcq-question-category']/following-sibling::div/descendant::div[@data-value='Java']")
	WebElement selectJava;
	
	@FindBy(xpath = "//select[@id='mcq-question-tags']/following-sibling::div/descendant::input")
	WebElement selectTag;
	
	@FindBy(xpath = "//select[@id='mcq-question-tags']/following-sibling::div/descendant::div[@data-value='Java']")
	WebElement selectJavaTag;
	
	@FindBy(xpath = "//select[@id='mcq-answer']/following-sibling::div/descendant::input")
	WebElement selectAnswer;
	
	@FindBy(xpath = "//select[@id='mcq-answer']/following-sibling::div/descendant::div[@data-value='1']")
	WebElement selectOptionA;
	
	@FindBy(xpath = "//div[contains(text(),'Add to Library')]/parent::button/parent::div[@class='modal-footer']/child::button[contains(@class,'add-to-library')]")
	WebElement AddToLibrary;

	public QlibraryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Public method to click add new question
	public QlibraryPage addNewQuestion() {
		isElementEnabled(addNewQuestion);
		click(addNewQuestion);
		return this;
	}
	
	//Public method to click add new question
	public QlibraryPage enterNewQuestion() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(enterNewQuestion));
		enterNewQuestion.click();
		enterNewQuestion.sendKeys(getPropertyValue("newMCQQuestion"));
		return this;
	}
	
	//Public method to enter options for A and B
	public QlibraryPage enterOptions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(optionA));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(optionB));
		optionA.sendKeys(randomTestDuration());
		optionB.sendKeys(randomTestDuration());
		return this;
	}
	
	//Public method to enter score
	public QlibraryPage enterScore() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(enterScore));
		enterScore.click();
		enterScore.sendKeys("100");
		return this;
	}
	
	//Public method to select Difficulty
	public QlibraryPage selectDifficulty() {
		selectDifficulty.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(selectEasy));
		selectEasy.click();
		return this;
	}
	
	//Public method to select Category
	public QlibraryPage selectCategory() {
		selectCategory.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(selectJava));
		selectJava.click();
		return this;
	}
	
	//Public method to select Tag
	public QlibraryPage selectTag() {
		selectTag.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(selectJavaTag));
		selectJavaTag.click();
		return this;
	}
	
	//Public method to select Option A
	public QlibraryPage selectAnswer() {
		selectAnswer.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(selectOptionA));
		selectOptionA.click();
		return this;
	}
	
	
	//public method to click add to library button
	public void addToLibrary() {
		isElementEnabled(AddToLibrary);
		click(AddToLibrary);
	}
	
	
}
