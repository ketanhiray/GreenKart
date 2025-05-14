package GreenKart.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import GreenKart.Base.BaseComponent;
import GreenKart.PageObjects.CartPage;
import GreenKart.PageObjects.GreenKartDashboardPage;

public class CartTest extends BaseComponent {

	@Test(priority = 2)
    public void testCartProducts() throws InterruptedException {

        // Create an instance of GreenKartDashboardPage
        CartPage cartPage = new CartPage(driver);

        cartPage.clickToCartButton();
        cartPage.clickToCheckOutButton();
        cartPage.calculateTotalPrice();

        Thread.sleep(2000);
		Assert.assertEquals(cartPage.calculateTotalPrice(),Integer.parseInt(cartPage.textActualTotal()),"Total price and Actual price is missmatched...!");
//		dashboardAdminPage.navigateToOrders();
		System.out.println("Cart Test...!");
		System.out.println("*******************");

       
    }
}
