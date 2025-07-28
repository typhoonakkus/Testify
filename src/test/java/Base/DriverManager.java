package Base;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	@BeforeMethod(alwaysRun = true)
	public static void CreateDriver() throws MalformedURLException {
		System.out.println("Driver Yaratiliyor************");
		//driver.get(Util.properties("config", "Applink"));
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String baseURL=System.getProperty("baseURL");
		driver.get(baseURL);
		//driver.navigate().to("https://");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
			//.implicitlyWait(Integer.parseInt((Util.properties("config", "ImplicitWait"))), TimeUnit.SECONDS);
		webDriver.set(driver);
	}

	public static WebDriver getDriver() {
		return webDriver.get();
	}

	@AfterMethod(alwaysRun = true)
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
