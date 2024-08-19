package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;

public class BrokenURLValidationTest extends ProjectSpecificationMethod{
	@BeforeTest
	public void fileSetup() {
		testName = "TC_001_URLValidation";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}

	@Parameters({ "url" })
	@Test
	public void TC_001_URLValidation(String url) throws IOException {
		
		// Passing info the extent report for test case
		extentTest.info("Verifying the Broken URL Screnario");
		try {
			
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			// Setting connection timeout for 3 seconds
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.connect();

			String actualResult = String.valueOf(httpURLConnection.getResponseCode());
			
			extentTest.info("Actual response is "+ actualResult);
			
			if (httpURLConnection.getResponseCode() == 200) {
				extentTest.pass("The URL is not broken and test case " + testName +" passed");
			} else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("The URL is broken and test case "+ testName +" failed");
			}

		} catch (Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("The URL Broken testcase "+testName+ " failed due to exception " + e.getMessage());
			e.printStackTrace();
		}
	}
	}


