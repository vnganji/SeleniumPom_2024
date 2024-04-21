package Pages;

import java.io.IOException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;

import FrWorkComponents.basePageClass;
import FrWorkComponents.custFunctions;
import FrWorkComponents.testParams;
import Utilities.TestReporter;

public class javaScriptAlertsPage extends basePageClass{
	
public custFunctions actions = new custFunctions();

	

	@FindBy(xpath="(//div[text()='Java Script Alert Box'])[1]")
	public WebElement pageConditon;
	
	@FindBy(xpath="(//a[text()='Javascript Alerts'])[2]")
	public WebElement lnk_JavaScriptAlert;
	
	public javaScriptAlertsPage(){
		super();
		PageFactory.initElements(testParams.getDriver(), this);
	}
	
	public void gottoJavaScriptAlertPage() throws IOException{
		
		actions.Click(lnk_AlertsandModals, "Clcking Alert&Modals link");
		actions.Click(lnk_JavaScriptAlert, "Clickinv JavaScriptAlert link");
		pageCondition();
	}

	@Override
	public void pageCondition() throws IOException {
		
		setexplicitWait(10);
		try{
			wait.until(ExpectedConditions.visibilityOf(pageConditon));
		}catch(TimeoutException e){
			TestReporter.log(testParams.getTcdesc(), testParams.getAlmid(), "Test Cases Skipped as it is not on the desired page", "Skip", 0);
			throw new SkipException("Skipping this test");
		}
	
		
	}


}
