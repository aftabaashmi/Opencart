package testCases;

import org.testng.annotations.Test;

import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_006_ShoppingCartTest extends BaseClass{
	
	@Test(groups= {"master"})
	public void ViewCartForCheckout()
	{
		ShoppingCartPage scp=new ShoppingCartPage(driver);
		scp.clickItemsToNavigateCart();
		scp.clickViewCart();
		String totalprice=scp.getTotalPrice();
		System.out.println("The total price of iphone -"+totalprice);
		scp.clickCheckout();
	}

}
