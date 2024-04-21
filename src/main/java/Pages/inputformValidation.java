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
import Utilities.dataProvider;

public class inputformValidation extends basePageClass{
	
	public custFunctions actions = new custFunctions();

	@FindBy(xpath = "(//a[text()='Input Form Submit'])[2]")
	public WebElement lnk_inputFormSubmit;
	
	@FindBy(xpath = "//*[text()='Input form with validations']")
	public WebElement txt_pageCondition;
	
	@FindBy(xpath = "//input[@name='first_name']")
	public WebElement inp_formsubmission_firstname;
	
	@FindBy(xpath = "//input[@name='last_name']")
	public WebElement inp_formsubmission_secondname;
	
	public inputformValidation() {
		super();
		
		PageFactory.initElements(testParams.getDriver(), this);
	}
	
	public void enterFormDetails() throws IOException{
		
		
		testdatamap=dataProvider.getExceltestdata("inputformvalidation","23456");
		actions.Click(lnk_inputForms, "clicking listitem_inputforms");
		actions.Click(lnk_inputFormSubmit, "clicking option input form submission option");
		pageCondition();
		
		actions.setText(inp_formsubmission_firstname, "entering first name",testdatamap.get("firstName") );
		actions.setText(inp_formsubmission_secondname, "entering first name",testdatamap.get("secondName") );
		staticWait(5000);
	}

	@Override
	public void pageCondition() throws IOException {
		try{
			wait.until(ExpectedConditions.visibilityOf(txt_pageCondition));
		}catch(TimeoutException e)
		{
			TestReporter.log(testParams.getTcdesc(), testParams.getAlmid(), "Test Cases Skipped as it is not on the desired page", "Skip", 0);
			throw new SkipException("Skipping this test");
		}
		
		
	}
	
	

}
