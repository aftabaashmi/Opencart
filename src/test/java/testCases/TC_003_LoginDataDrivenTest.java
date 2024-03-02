package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void VerifyLoginDataDrivenTest(String email,String passw, String exp)
	{
		logger.info("***Starting TC_003_LoginDataDrivenTest***");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickonMyaccountPage();
		hp.clickonLoginDropDownmenu();  	// loginlink from Homepage
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		//LoginPage
		logger.info("This is loginpage");
		LoginPage lp=new LoginPage(driver);
		lp.setEmailLoginPage(email);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		lp.setPasswordLoginPage(passw);
		lp.clickonLoginButton();	//login Button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		logger.info("Clicked on Login Button");
		
		//MyAccountpage
		MyAccountPage maccp=new MyAccountPage(driver);
		boolean targetPage=maccp.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				maccp.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		} 
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				maccp.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Finished Login Data driven test***");
	}
}
