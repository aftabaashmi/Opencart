package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement lnkmyaccount;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement lnkRegister;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
	private WebElement loginhomepage;
	
	//For Search Product test
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement txtsearchBox;
	
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-search']")
	private WebElement searchButton;
	
	//Actions Methods
	public void clickonMyaccountPage()
	{
		lnkmyaccount.click();
	}
	
	public void clickonRegisterPage()
	{
		lnkRegister.click();
	}
	public void clickonLoginDropDownmenu()
	{
		loginhomepage.click();
	}

	//Methods for Searching the product
	public void enterProductname(String Pname)
	{
		txtsearchBox.sendKeys(Pname);
	}
	public void clickSearch()
	{
		searchButton.click();
	}
}
