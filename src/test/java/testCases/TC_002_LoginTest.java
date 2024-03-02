	package testCases;


import java.time.Duration;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"sanity","master"})
	public void verifyLoginTest()
	{
		
		
		try
		{
			logger.info("***Starting TC_002_LoginTest***");
		//Homepage
		HomePage hp=new HomePage(driver);
		hp.clickonMyaccountPage();
		logger.info("clicked on my account link");
		hp.clickonLoginDropDownmenu();  	// loginlink from Homepage
		logger.info("CLicked on login menu of Dropdown");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		//LoginPage
		logger.info("This is loginpage");
		LoginPage lp=new LoginPage(driver);
		lp.setEmailLoginPage(p.getProperty("email"));
		logger.info("Entered email");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		lp.setPasswordLoginPage(p.getProperty("password"));
		logger.info("Entered password");
		lp.clickonLoginButton();	//login Button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		logger.info("Clicked on Login Button");
		
		//MyAccountpage
		MyAccountPage maccp=new MyAccountPage(driver);
		boolean targetPage=maccp.isMyAccountPageExists();
		
		SoftAssert sf=new SoftAssert();
		sf.assertEquals(targetPage, true);
		sf.assertAll();
		}
		catch(Exception e)
		{
			System.out.println("Issue in login test");
		}
		//logger.info("***Finished TC_002_LoginTest***");
	}
}
