package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	// Public driver instance
	public WebDriver driver;
	
	// Public instance of Excel file
	public String excelFile;

	// Public instance of Excel sheet name
	public String sheetName;
	
	// Public instances of extent test required for a test case
	public String testName;
	public String testAuthor;
	public String testCategory;
	
	// Public instance used for capturing the failed test case screenshot file path
	public String filePath;
	
	// Public instance of user name used for update user name scenario
	public String updatedUserName;
	
	// Public method to launch browser and load url
	public void launchBrowser(String browser, String url) {
		
		//Setting headless browser on Chrome driver 
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("headless");
//		
//		//Setting headless browser on Firefox driver 
//		FirefoxOptions firefoxOptions = new FirefoxOptions ();
//		firefoxOptions.addArguments("--headless");
		
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			//driver = new FirefoxDriver(firefoxOptions);
		} else if (browser.equals("Safari")) {
			driver = new SafariDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	// Public method to close browser
	public void closeBrowser() {
		driver.close();
	}
	
	// Public method to take screenshot with time stamp
	public String takeScreenshot(String testCaseName) throws IOException {
		Date d = new Date();
		String date = d.toString();
	
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/FailedScreenshots/" + testCaseName + "-" + date
				+ ".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
	//Public method to generate random test name for test creation
	public static String randomTestName() {
		String testName = "Test" + "-" + randomTestDuration();
		return testName;
	}
	
	//Public method to get random two digit number for Objective duration
	public static String randomTestDuration() {
		int min = 10, max = 120;
		Random random = new Random();
		int num = random.nextInt((max-min) + 1) + min;
		String strNum = Integer.toString(num);
		return strNum;
	}
	
	//Public method to get the value of global properites from property file
	public static String getPropertyValue(String propKey) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/testResources/GlobalData.properties");
		prop.load(fis);
		return prop.getProperty(propKey);
	}
	
	//Public method to generate random user name
	public static String randomUserName() {
		// Creating string of all characters
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// Creating random string builder
		StringBuilder sb = new StringBuilder();

		// creating an object of random class
		Random random = new Random();
		// Specifying the length of random string
		int length = 7;

		for (int i = 0; i < length; i++) {
			// Generating random index number
			int index = random.nextInt(alphabet.length());

			// Getting the character based on the specified index
			char randomChar = alphabet.charAt(index);

			// Appending the character to string builder
			sb.append(randomChar);

		}
		String name = sb.toString();
		System.out.println("The random string is " + name);
		return name;
	}
	
	//Public method to clear text field inside a web element
	public static void clearTextfield(WebElement ele) {
		String input = ele.getAttribute("value");
			for(int i=0; i<input.length(); i++) {
				ele.sendKeys(Keys.BACK_SPACE);
			}
	
	}
	
	// Public method to read data from Excel file
	public String[][] readExcel(String excelfile, String sheetname) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook(System.getProperty("user.dir")+"/src/test/java/testResources/" + excelfile + ".xlsx");
		XSSFSheet sheet = book.getSheet(sheetname);

		// Getting the row count and column count
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();

		// Two dimensional array to store row and column values of cells
		String[][] data = new String[rowCount][columnCount];

		// Get into row
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);

			// Get into cell
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				if(cell == null) {
				data[i-1][j] = "";	
				}else {
				data[i - 1][j] = cell.getStringCellValue();	
				}
				
			}
		}
		// Closing the book
		book.close();
		return data;
	}
	
	// Public method to find an element by ID and enter text
	public void findElementAndSendKeysByID(String attributevalue, String value) {
		driver.findElement(By.id(attributevalue)).sendKeys(value);
	}
	
	// Public method to find an element by xpath and enter text
	public void findElementAndSendKeysByXpath(WebElement attributevalue, String value) {
		attributevalue.sendKeys(value);
	}
	
	// Public method to check whether the element is visible
	public void isElementDisplayed(WebElement ele) {
		boolean eleDisplayed= ele.isDisplayed();
	}
	
	// Public method to check whether the element is enabled
	public void isElementEnabled(WebElement ele) {
		boolean eleEnabled = ele.isEnabled();
	}
	
	// Public method to perform click operation
	public void click(WebElement ele) {
		ele.click();
	}
	
	// Public method to find an element by xpath and enter text
	public void waitforWebElementToBeVisible(WebElement attributevalue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(attributevalue));
	}

}
