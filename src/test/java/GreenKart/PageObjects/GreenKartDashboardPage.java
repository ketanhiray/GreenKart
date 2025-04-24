package GreenKart.PageObjects;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKartDashboardPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Constructor
	public GreenKartDashboardPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	// All product containers
	private By products = By.cssSelector("div.product");

	// Method to add products to cart by names
	public void addProductsToCart(String[] productNames) throws InterruptedException {
		Thread.sleep(2000); 

		List<WebElement> allProducts = driver.findElements(products);

		for (WebElement product : allProducts) {
			Thread.sleep(2000); 
			List<WebElement> productNameElements = wait.until(
				ExpectedConditions.visibilityOfNestedElementsLocatedBy(product, By.cssSelector("h4.product-name"))
			);

			if (productNameElements.isEmpty()) continue;

			String name = productNameElements.get(0).getText().split("-")[0].trim();
			//System.out.println(name);
			
			for (String item : productNames) {
				if (name.equalsIgnoreCase(item)) {
					WebElement addButton = product.findElement(By.xpath(".//button[text()='ADD TO CART']"));
					wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
					break;
				}
			}
		}
	}

	
}
