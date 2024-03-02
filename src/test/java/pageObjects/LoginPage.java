package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-email']")
	private WebElement textemaillogin;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement textpassowrdlogin;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginbutton;
	
	public void setEmailLoginPage(String email)
	{
		textemaillogin.sendKeys(email);
	}
	public void setPasswordLoginPage(String pwd)
	{
		textpassowrdlogin.sendKeys(pwd);
	}
	public void clickonLoginButton()
	{
		loginbutton.click();
	}
}
