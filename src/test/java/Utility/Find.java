package Utility;


import io.qameta.allure.Allure;
import io.qameta.allure.AllureResultsWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.DriverManager;

import java.io.ByteArrayInputStream;

public class Find extends DriverManager {
	
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
			WebDriverWait wait = new WebDriverWait(webDriver.get(), timeOut.value);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			Allure.addAttachment("Element Found [" + type + "]", new ByteArrayInputStream(Util.takeScreenShot()));
			return element;
		} catch (Exception e) {
			Allure.addAttachment("Error", e.toString());
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

	
	
	/*public static WebElement Element (WebDriver driver , By locator ) {
		
		
	       try {
					            
	            WebDriverWait wait = new WebDriverWait((WebDriver) webDriver.get(),10);
	            List<WebElement> visibleElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));	 
	            if(visibleElements.size() != 0){
	                element = visibleElements.get(0);
	                
	                System.out.println("OBJECT IS LOCATED: ");
	            }
	            
			} catch (Exception e) {
		        System.out.println("LOCATE OBJECT EXCEPTION: " + e + locator);
		       
			}
	      
		
		return element;
		
	}*/
	
	
	

  /*  public static WebElement FindWebElement(WebDriver driver, By locator)
    {
    	
    	System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " function started..." );
        try {
        	
        	
		
		        // Return it if you find.
		        if(locateTheObject(driver, locator)) {
		        	System.out.println("OBJECT FOUNDDDD" + foundObject);
		        }       
		
	        	
	        // Throw an exception if you still can't find it.
	        if (foundObject == null) {
		        System.out.println("fail: " + locator + " is not found: " + foundObject);
			}
	        return foundObject;
		} catch (Exception e) {
            System.out.println("An error occured while finding webelement : " + e.getMessage());
            return null;
		}
    }

    private static Boolean locateTheObject (WebDriver driver, By locator){
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " function started..." );
        try {
			foundObject = null;
            Boolean result = false;
            WebDriverWait wait = new WebDriverWait(driver, 10);
            List<WebElement> visibleElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            System.out.println("visibleElements SIZE: " + visibleElements.size());
            if(visibleElements.size() != 0){
                foundObject = visibleElements.get(0);
                result = true;
                System.out.println("OBJECT IS LOCATED: " + result);
            }
            return result;
		} catch (Exception e) {
	        System.out.println("LOCATE OBJECT EXCEPTION: " + e);
	        return false;
		}
    }*/
	
	
	
	
	/*
	public static WebElement FindElement(String locator, String locatorValue)
    {
        WebElement element = null;
        switch (locator)
        {
            case "Id":
                By idSelector = By.id(locatorValue);
                element = Element(idSelector);
                break;

            case "Name":
            	By nameSelector = By.name(locatorValue);
                element = utils.FindHelpers.FindWebElement(driver, nameSelector, waitTimeout);
                break;

            case "XPath":
                By xpathSelector = By.xpath(locatorValue);
                element = utils.FindHelpers.FindWebElement(driver, xpathSelector, waitTimeout);
                break;

            case "Css":
                By cssSelector = By.cssSelector(locatorValue);
                element = utils.FindHelpers.FindWebElement(driver, cssSelector, waitTimeout);
                break;

            case "ClassName":
                By classNameselector = By.className(locatorValue);
                element = utils.FindHelpers.FindWebElement(driver, classNameselector, waitTimeout);
                break;

            case "LinkText":
                By linkTextSelector = By.linkText(locatorValue);
                element = utils.FindHelpers.FindWebElement(driver, linkTextSelector, waitTimeout);
                break;

            default:
                break;
        }
        return element;
    }*/

}
