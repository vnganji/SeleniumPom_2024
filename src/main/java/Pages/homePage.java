package Pages;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import FrWorkComponents.basePageClass;
import FrWorkComponents.custFunctions;
import FrWorkComponents.testParams;
import FrWorkComponents.webdriverGenerator;
import Utilities.TestReporter;

public class homePage extends basePageClass {
	
	public custFunctions actions = new custFunctions();

	

	@FindBy(xpath = "//a[text()='Input Forms']//following::ul[1]/li")
	public List<WebElement> menuItems_inputForms;
	
	@FindBy(xpath = "//a[text()='No, thanks!']")
	public WebElement home_Popup;

	public homePage() {
		super();
		PageFactory.initElements(testParams.getDriver(), this);
	}
	
	public  void Checkpopup(){
		
		setglobalWait(0);
		setexplicitWait(10);
	
		try{
		wait.until(ExpectedConditions.visibilityOf(home_Popup));
		home_Popup.click();
		}catch(TimeoutException e){}
		finally
		{
			setglobalWait(10);
		}
		}
	

	public void validateInputForms() throws IOException  {

		String[] InputFormItems = new String[] { "Simple Form Demo", "Checkbox Demo", "Radio Buttons Demo",
				"Select Dropdown List", "Input Form Submit", "Ajax Form Submit", "JQuery Select dropdown" };
		int i = 0;
		String str = "";
		List<String> list =Arrays.asList(InputFormItems);
		
	
	
	actions.Click(lnk_inputForms, "clicking listitem_inputforms");

		
		for (WebElement menuitem : menuItems_inputForms) {
			if (!menuitem.getText().equals(InputFormItems[i])) {
				str = str + InputFormItems[i];
			}

			i++;
		}

		if (str.equals("")) {
			
			System.out.println(testParams.getTcdesc());
			System.out.println(testParams.getAlmid());
			TestReporter.log(testParams.getTcdesc(), testParams.getAlmid(),
					"All Input Form Menu Items" + list + " displayed", "Pass", 0);
		} else {
			TestReporter.log(testParams.getTcdesc(), testParams.getAlmid(),
					"All Input Form Menu Items" + list + " not displayed", "Fail", 1);
		}
	}

	@Override
	public void pageCondition() {

	}
}
