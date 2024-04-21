package FrWorkComponents;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FlruentWait {
	
	static boolean isElementVisibleusingFleuent(WebElement elem,int wtime,int ptime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(testParams.getDriver())
				
				.withTimeout(Duration.ofSeconds(wtime)) 			
				.pollingEvery(Duration.ofSeconds(ptime)) 			
				.ignoring(NoSuchElementException.class);
		boolean isPresent = wait.until(new Function<WebDriver, Boolean>(){
		
			public Boolean apply(WebDriver driver ) {
				return elem.isDisplayed();
			}
		});
		return isPresent;
	}

}
