package GreenKart.Base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseComponent {

	protected static WebDriver driver;
	protected static WebDriverWait wait;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeSuite
	public void setup() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		}
	}

	@AfterSuite
	public void tearDown() {
//		if (driver != null) {
//			//driver.quit(); // 
//			//driver = null;
//		}
	}
}
