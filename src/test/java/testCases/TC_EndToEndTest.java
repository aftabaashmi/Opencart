package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_EndToEndTest extends BaseClass{
	
	@Test(groups= {"master"})
	public void EndtoEndTestOpenCart()
	{
		logger.info("Staring Account Registration");
		HomePage hp=new HomePage(driver);
		
		hp.clickonMyaccountPage();
		hp.clickonLoginDropDownmenu();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmailLoginPage("UBamS@gmail.com");
		lp.setPasswordLoginPage("YWfS@032");
		lp.clickonLoginButton();
		
		String pName="iPhone";
		hp.enterProductname(pName);
		hp.clickSearch();
		
		SearchPage sp=new SearchPage(driver);
		
		if(sp.isProductExist(pName))
		{
			sp.selectProduct(pName);
			sp.setQuantity("2");
			sp.addToCart();
		}
		
		ShoppingCartPage scart=new ShoppingCartPage(driver);
		
		scart.clickItemsToNavigateCart();
		scart.clickViewCart();
		scart.clickCheckout();
	}

}
