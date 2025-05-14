package GreenKart.PageObjects;

import java.time.Duration;
import java.util.List;
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

	// Method to add products to the cart
	public void addProductsToCart(String[] productNames) {
		List<WebElement> productCards = driver.findElements(By.xpath("//div[@class='product']"));

		for (WebElement productCard : productCards) {
			String fullText = productCard.findElement(By.cssSelector("h4.product-name")).getText();
			String productName = fullText.split("-")[0].trim();

			for (String item : productNames) {
				if (productName.equalsIgnoreCase(item)) {
					WebElement btnAddToCart = productCard.findElement(By.xpath(".//button[.='ADD TO CART']"));
					wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
					System.out.println(productName + " added to cart.");
					break;
				}
			}
		}
	}
	
}
