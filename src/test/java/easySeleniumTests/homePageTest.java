package easySeleniumTests;

import java.io.IOException;

import org.testng.annotations.Test;

import FrWorkComponents.baseTestClass;
import Pages.homePage;

public class homePageTest extends baseTestClass {
	
	@aboutTest(desc = "Validation of HomePageMenuItems", almid = "12345",module="homePage")
	@Test(enabled = true)
	public void validatehomepage_menuitems() throws IOException, InterruptedException{
		
		System.out.println(Thread.currentThread().getName());
		System.out.println(prop.getProperty("baseurl"));
		openUrl(prop.getProperty("baseurl"));
		homePage hp = new homePage();
		
		hp.validateInputForms();
	
		
	}

}
