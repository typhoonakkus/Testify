package Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import Utility.Util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
			
	@BeforeTest
	public static void CreateDriver() throws MalformedURLException {
		System.out.println("Driver Yaratiliyor************");
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//driver.get(Util.properties("config", "Applink"));

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String baseURL=System.getProperty("baseURL");
		driver.get(baseURL);
		//driver.navigate().to("https://");
		//driver.navigate().to("http://");		
		driver.manage().window().maximize();		
		webDriver.set(driver);
		webDriver.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
			//.implicitlyWait(Integer.parseInt((Util.properties("config", "ImplicitWait"))), TimeUnit.SECONDS);
		
	}

	@AfterTest
	public synchronized void afterSuite() {
		System.out.println("Driver kapaniyor************");
		WebDriver driver = webDriver.get();
		if (driver != null) {
			driver.close();
			driver.quit();
			webDriver.remove(); // thread'den temizle
		}
	}

}
