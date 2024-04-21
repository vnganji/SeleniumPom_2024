package easySeleniumTests;

import java.io.IOException;

import org.testng.annotations.Test;

import FrWorkComponents.baseTestClass;
import Pages.homePage;
import Pages.inputformValidation;

public class inputformValidationTest extends baseTestClass {
	
	@aboutTest(desc = "Validation of HomePageMenuItems", almid = "23456",module="inputformvalidation")
	@Test(enabled = true)
	public void validatehomepage_menuitems() throws IOException, InterruptedException{
		System.out.println(Thread.currentThread().getName());
		
		openUrl(prop.getProperty("baseurl"));
		homePage hp = new homePage();
	
		inputformValidation ip = new inputformValidation();
		ip.enterFormDetails();

		
	}


}
