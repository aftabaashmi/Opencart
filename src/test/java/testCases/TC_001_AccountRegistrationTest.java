package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{

	
	@Test(groups={"regression","master"})
	public void test_account_Registration()
	{
		logger.info("***Starting TC_001_AccountRegistrationTest***");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickonMyaccountPage();
		logger.info("Click on My Account link");
		
		hp.clickonRegisterPage();
		logger.info("Clicked on register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer data");
		regpage.setFirstNameRegisterPage(randomString());
		regpage.setlastnameRegisterPage(randomString());
		regpage.setEmailRegisterPage(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String pasword=randomAlphaNumeric();
		regpage.setPasswordRegisterPage(pasword);
		regpage.setConfirmPasword(pasword);
		System.out.println("Password-"+pasword);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		regpage.clickonNewsLetter();
		regpage.clickonAgreeCheckbox();
		regpage.clickonContinue();
		logger.info("Clicked on Continue");
		
		String confmmsg=regpage.getConfirmationMsg();
		
		
		logger.info("Validating expected message");
		Assert.assertEquals(confmmsg, "Your Account Has Been Created!");
		
		}
		catch(Exception e) {
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("***Finished TC_001_AccountRegistrationTest***");
	}
	
	
}
