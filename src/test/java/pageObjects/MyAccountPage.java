package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	
	}

	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement headingmsgmyaccount;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	private WebElement logoutmyaccountpage;
	
	public boolean isMyAccountPageExists()
	{
		try {
			return(headingmsgmyaccount.isDisplayed());
		} catch (Exception e) {
			return(false);
		}
		
	}
	
	public void clickLogout()
	{
		logoutmyaccountpage.click();
	}
}

