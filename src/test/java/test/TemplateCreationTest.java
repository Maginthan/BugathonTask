package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.SignInPage;

public class TemplateCreationTest extends ProjectSpecificationMethod{
	@BeforeTest
	public void fileSetup() {
		testName = "TC_011_TemplateCreation";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}

	@Test
	public void TC_011_TemplateCreation() {
		// TODO Auto-generated method stub
		SignInPage obj = new SignInPage(driver);
		obj.emailID("hyrenet+bugathon@guvi.in").password("hyrenettest@123").signInButton()
		.templateModule()
		.createtemplate()
		.enterRole();
	}

}
