package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

	public ShoppingCartPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//div[@id='cart']")
	private WebElement linkcart;
	
	@FindBy(xpath="//strong[text()=' View Cart']")
	private WebElement viewCart;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div/table//strong[text()='Total:']//following::td")
	WebElement lblTotalPrice;
	
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement btnCheckout;
	
	public void clickItemsToNavigateCart()
	{
		linkcart.click();
	}
	public void clickViewCart()
	{
		viewCart.click();
	}
	
	public String getTotalPrice()
	{
		return lblTotalPrice.getText();
	}
	public void clickCheckout()
	{
		btnCheckout.click();
	}
}
