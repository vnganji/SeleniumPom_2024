package FrWorkComponents;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utilities.TestResultUpdator;

public class baseTestClass extends starter {

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface aboutTest {

		String desc() default "seleniumtest";

		String almid() default "";

		String module() default "";

	}

	@BeforeSuite

	public void setup() throws IOException {

		getProperties();

		setglobalWait(10);
		TestResultUpdator.updateBeforeSuit();
		System.out.println("start");

	}

	/*
	 * @BeforeTest
	 * 
	 * @Parameters("browser")
	 * 
	 * public void callDriver(@Optional("optional") String browser) throws
	 * IOException{ System.out.println(browser);
	 * 
	 * if (browser.equals("optional")) browser="chrome";
	 * testParams.setbrowser(browser); initDriver();
	 * 
	 * System.out.println("start");
	 * 
	 * }
	 */

	@AfterSuite
	public void tearDown() {
		TestResultUpdator.updateAfterSuit();
	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(Method M, @Optional("optional") String browser) {

		Annotation ano = M.getAnnotation(aboutTest.class);
		testParams.setTcdesc(((aboutTest) ano).desc());
		testParams.setAlmid(((aboutTest) ano).almid());
		testParams.setModule(((aboutTest) ano).module());
		testParams.setFailstatus(0);

		if (browser.equals("optional"))
			browser = "chrome";

		if (browser.equalsIgnoreCase("chrome")) {
			webdriverGenerator.setDriver(browser);
			
		}

	}

	@AfterMethod
	public void verifyTestStatus() {

		webdriverGenerator.getDriver().quit();

	}
}
