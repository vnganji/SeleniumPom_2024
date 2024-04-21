package FrWorkComponents;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Exceptions.usrexceptions;
import Utilities.TestReporter;
import Utilities.dataProvider;

public class custFunctions extends starter {
	
	public JavascriptExecutor js = (JavascriptExecutor)testParams.getDriver();

	
	public void filltestdata(String Module, String Key){
		
				testdatamap=dataProvider.getExceltestdata(Module,Key);
		
	}
	
	public void setText(WebElement elem, String Desc, String value) throws IOException{
		
	
		try{
			elem.sendKeys(value);
			TestReporter.log(testParams.getTcdesc(), testParams.getAlmid(), Desc, "Pass", 0);
		}catch(Exception e){
			
			usrexceptions.traceException(e,Desc);
			TestReporter.log(testParams.getTcdesc(), testParams.getAlmid(), Desc, "Fail", 0);
		}
	}
		
		public void jsClick(WebElement elem, String Desc) throws IOException{
			
			
			try{
				
				js.executeScript("arguments[0].click()",elem);
				TestReporter.log(testParams.getTcdesc(), testParams.getAlmid(), Desc, "Pass", 0);
				
			}catch(Exception e){
				
				usrexceptions.traceException(e,Desc);
				TestReporter.log(testParams.getTcdesc(), testParams.getAlmid(), Desc, "Fail", 0);
			}
		
					
			}
		
	public void Click(WebElement elem, String Desc) throws IOException{
			
			
			try{
				
				setglobalWait(0);
				setexplicitWait(10);
				wait.until(ExpectedConditions.visibilityOf(elem));
			elem.click();
				
				
				TestReporter.log(testParams.getTcdesc(), testParams.getAlmid(), Desc, "Pass", 0);
				
			}catch(Exception e){
				
				usrexceptions.traceException(e,Desc);
				TestReporter.log(testParams.getTcdesc(), testParams.getAlmid(), Desc, "Fail", 0);
			}
			
			finally{
				setglobalWait(10);
			}
		
					
			}
		
	}


