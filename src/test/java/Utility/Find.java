package Utility;


import Base.DriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureResultsWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.ByteArrayInputStream;

public class Find {
	
	public enum Locator {

	    id,

	    className,

	    name,

	    xPath,

	    cssSelector,

	    linkText
	}
	

	public enum FTimeOut {

		LOW(5),

		MIDDLE(10),

		HIGH(15),

		CUSTOM_MAX(60);

    	private final int value;

  		public int getValue() {

        	return value;

    	}
    	// enum constructor - cannot be public or protected

    	private FTimeOut(int value) {

        	this.value = value;

    	}
	}


	public static WebElement Element(Locator type, String locator, FTimeOut timeOut) {
		try {
			By by = getBy(type, locator);
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOut.value);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			Allure.addAttachment("Element Found [" + type + "]", new ByteArrayInputStream(Util.takeScreenShot()));
			return element;
		} catch (Exception e) {
			Allure.addAttachment("Error", e.toString());
			System.out.println("Element Not Found "+ locator +"*******!!!!" +e);
			Allure.addAttachment("Screenshot", new ByteArrayInputStream(Util.takeScreenShot()));
			return null;
		}
	}

	private static By getBy(Locator type, String locator) {
		switch (type) {
			case id: return By.id(locator);
			case name: return By.name(locator);
			case xPath: return By.xpath(locator);
			case className: return By.className(locator);
			case cssSelector: return By.cssSelector(locator);
			case linkText: return By.linkText(locator);
			default: throw new NotFoundException("Unknown locator type: " + type);
		}
	}
}
