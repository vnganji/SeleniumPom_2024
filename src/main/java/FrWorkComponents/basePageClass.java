package FrWorkComponents;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrWorkComponents.annotattions.FndBy;

public abstract class basePageClass extends starter {

	// Global Object that would be
	public custFunctions actions = new custFunctions();

	public static By name = By.xpath("//input[@id=@text]");
	
	@FindBy(xpath = "//a[text()='Input Forms']")
	public WebElement lnk_inputForms;
	
	
	@FindBy(xpath = "//a[text()='Alerts & Modals']")
	public WebElement lnk_AlertsandModals;
	@FindBy(xpath="(//a[text()='Input Form Submit'])[2]")
	public WebElement lnk_InputForm_Submit;

	@FindBy(xpath = "//a[text()='Selenium Easy']")
	public static WebElement lnk_SeleniumEasy;

	@FindBy(xpath = "//div[text()='Complete Automation Testing Tutorials']")
	public static WebElement txt_homepage;

	@FindBy(xpath = "(//li/a)[1]")
	public static WebElement lnk_mi_inputForm;


	public abstract void pageCondition() throws IOException;

	public basePageClass() {
		PageFactory.initElements(testParams.getDriver(), this);

	}

}
