package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_005_AddToCartTest extends BaseClass{

	@Test(groups= {"master"})
	public void Verify_addToCart()
	{
		logger.info("Started TC_005_AddToCartTest");
		try {
			HomePage hp=new HomePage(driver);
			hp.enterProductname("iPhone");
			hp.clickSearch();
			
			SearchPage sp=new SearchPage(driver);
			
			if(sp.isProductExist("iPhone"))
			{
				sp.selectProduct("iPhone");
				sp.setQuantity("2");
				sp.addToCart();
				
			}
			Assert.assertEquals(sp.checkConfMsg(), true);
		} catch (Exception e) {
			Assert.fail();
		}
		
		
		logger.info("Finished TC_005_AddToCartTest");
	}
}
