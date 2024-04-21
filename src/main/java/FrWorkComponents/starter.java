package FrWorkComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.support.ui.WebDriverWait;

public class starter {

	public static Properties prop = null;
	public static FileInputStream fso = null;
	public static boolean getproperties = false;
	public static String path = System.getProperty("user.dir");
	public static Map<String, String> testdatamap = null;
	public static String url = null;
	public static WebDriverWait wait = null;


	public static void getProperties() throws IOException {

		if (!getproperties) {
			fso = new FileInputStream(path + "\\src\\test\\resources\\appication.properties");
			prop = new Properties();

			prop.load(fso);
			getproperties = true;
		}

	}
	
	public void staticWait(int milliseconds)
	{
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setglobalWait(int timeinSeconds) {

		try {

			testParams.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeinSeconds)); 

		} catch (Exception E) {
			E.getMessage();
		}

	}
	public void setexplicitWait(int timeinSeconds) {

		try {

			wait = new WebDriverWait(testParams.getDriver(), Duration.ofSeconds(timeinSeconds));

		} catch (Exception E) {
			E.getMessage();
		}

	}

	public void openUrl(String URL) {
		System.out.println(URL);
		testParams.getDriver().manage().window().maximize();
		testParams.getDriver().get(URL);

	}

}
