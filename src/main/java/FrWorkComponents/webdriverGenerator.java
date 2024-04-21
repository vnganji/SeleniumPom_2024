package FrWorkComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webdriverGenerator  {
	
	public static ChromeOptions doChromeSettings(){
		
		
		System.setProperty("webdriver.chrome.driver",
	starter.path + "\\src\\test\\resources\\Executables\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments ("--remote-allow-origins=*");
		
		return options;
		//System.setProperty("webdriver.chrome.driver",
				//starter.path + "\\src\\test\\resources\\Executables\\chromedriver.exe");
	}
	
	public static void setDriver(String drivername){
		
		if (drivername.equalsIgnoreCase("chrome")){
		
		testParams.setDriver(new ChromeDriver(doChromeSettings()));}
	}
	
	public static WebDriver getDriver(){
		return testParams.getDriver();
	}

}
