package GreenKart.TestCases;

import org.testng.annotations.Test;

import GreenKart.Base.BaseComponent;
import GreenKart.PageObjects.GreenKartDashboardPage;

public class GreenKartDashboardTest extends BaseComponent {

	@Test
	public void testAddToCart() throws InterruptedException {

		GreenKartDashboardPage dashboard = new GreenKartDashboardPage(driver);
		String[] productsToAdd = { "Brocolli", "Tomato", "Beans" };

		dashboard.addProductsToCart(productsToAdd);
	}

}
