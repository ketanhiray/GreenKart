package GreenKart.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import GreenKart.Base.BaseComponent;
import GreenKart.PageObjects.GreenKartDashboardPage;

public class GreenKartDashboardTest extends BaseComponent {

	@Test(priority = 1)
    public void testAddToCart() throws InterruptedException {

        // Create an instance of GreenKartDashboardPage
        GreenKartDashboardPage dashboard = new GreenKartDashboardPage(driver);

        // Define the products to be added to the cart
        String[] productsToAdd = { "Brocolli", "Tomato", "Beans" };

        // Add the products to the cart
        dashboard.addProductsToCart(productsToAdd);

       
    }
}
