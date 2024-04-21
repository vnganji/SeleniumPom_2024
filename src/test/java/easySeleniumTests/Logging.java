package easySeleniumTests;



import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import FrWorkComponents.starter;

public class Logging {
	
	public static void main(String[] args) {
		
		String s = "venkat";
		String s1 = "venkat";
		
		System.out.println(s==s1);
		System.out.println(s.equals(s1));
		
		String s3 = new String("ganji");
		String s4 = new String("ganji");
		String s5= "ganji";
		String s6= "ganji";
		
		
		System.out.println(s5==s6);
		System.out.println(s3.equals(s6));
		
		
		/*WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				starter.path + "\\src\\test\\resources\\Executables\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable( LogType.PERFORMANCE, Level.ALL );
		options.setCapability( "goog:loggingPrefs", logPrefs );
		
		 driver = new ChromeDriver(options);
		driver.get("http://www.google.com");
		    
		List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		System.out.println(entries.size() + " " + LogType.PERFORMANCE + " log entries found");
		 for (LogEntry entry : entries) {
		   System.out.println(entry.getMessage());
		 }*/
	}

}
