package easySeleniumTests;

import java.io.IOException;

import org.testng.annotations.Test;

import FrWorkComponents.baseTestClass;
import Pages.javaScriptAlertsPage;

public class JavaScriptAlerts extends baseTestClass {

	@aboutTest(desc = "Validation of JavaScriptAlert", almid = "12232",module="JavaScriptAlert")
	@Test(enabled = true)
	public void validate_JavaScriptPage() throws IOException{
	
	openUrl(prop.getProperty("baseurl"));
	javaScriptAlertsPage jsa = new javaScriptAlertsPage();
	jsa.gottoJavaScriptAlertPage();
	
	
	}
		
	}
