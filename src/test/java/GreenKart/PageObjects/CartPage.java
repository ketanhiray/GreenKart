package GreenKart.PageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='cart-icon']")
	private WebElement btnCart;

	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
	private WebElement btnCheckOut;

	//.totAmt
	@FindBy(css = ".totAmt")
	private WebElement txtActualTotal;
	
	@FindBy(xpath = "//input[@placeholder='Enter promo code']")
	private WebElement txtPromoCode;

	public void clickToCartButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(btnCart)).click();
		// Thread.sleep(3000);
	}

	public void clickToCheckOutButton() {

		wait.until(ExpectedConditions.elementToBeClickable(btnCheckOut)).click();

	}

	public int calculateTotalPrice() {
		int totalPrice = 0;

		List<WebElement> priceElements = driver.findElements(By.xpath("//table//tr/td[4]/p[@class='amount']"));

		for (WebElement priceElement : priceElements) {
			String priceText = priceElement.getText().trim();

			// If price contains any non-numeric characters, remove them
			priceText = priceText.replaceAll("[^0-9]", "");

			int price = Integer.parseInt(priceText);
			totalPrice += price;
		}
		System.out.println("Total Price of all products in cart: " + totalPrice);
		return totalPrice;

	}
	
	public String textActualTotal() {

		System.out.println(wait.until(ExpectedConditions.visibilityOf(txtActualTotal)).getText());
		return wait.until(ExpectedConditions.visibilityOf(txtActualTotal)).getText();
	}
	
}
