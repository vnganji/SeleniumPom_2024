package Exceptions;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import FrWorkComponents.testParams;
import Utilities.MessageTypes;
import Utilities.TestReporter;

public class usrexceptions extends RuntimeException {

	public usrexceptions() {

	}

	public static void traceException(Exception E, String elemDesc) throws IOException {

		System.out.println("expections");
		System.out.println(E.getStackTrace());
		System.out.println(E.getMessage());
		if (E instanceof NoSuchElementException) {
			System.out.println("No Such Element  Exception found" + elemDesc);
			TestReporter.log(testParams.getTcdesc(), testParams.getAlmid(),
					"No Such Element  Exception found and object is - " + elemDesc, MessageTypes.Fail, 1);

		} else if (E instanceof TimeoutException) {
			System.out.println("TimeOut Exception" + elemDesc);
			TestReporter.log(testParams.getTcdesc(), testParams.getAlmid(), "Timeout Exception and object is - " + elemDesc,
					MessageTypes.Fail, 1);

		} else {

			System.out.println("Exception" + elemDesc);
			TestReporter.log(testParams.getTcdesc(), testParams.getAlmid(), " Exception and object is - " + elemDesc,
					MessageTypes.Fail, 1);
		}

	}

}
