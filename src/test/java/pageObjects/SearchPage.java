package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//*[@id='content']/div[3]//img")
	List<WebElement> searchproducts;
	
	@FindBy(xpath="//input[@name='quantity']")
	private WebElement txtQuantity;
	
	@FindBy(xpath="//button[text()='Add to Cart']")
	private WebElement btnAddtoCart;
	
	@FindBy(xpath="//div[contains(text(),'Success: You have added ')]")
	private WebElement cnfrmmsg;
	
	public boolean isProductExist(String productName)
	{
		boolean flag=false;
		for(WebElement product:searchproducts)
		{
			System.out.println(product.getAttribute("title"));
			if(product.getAttribute("title").equalsIgnoreCase(productName))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	public void selectProduct(String productName)
	{
		for(WebElement product:searchproducts)
		{
			if(product.getAttribute("title").equals(productName))
			{
				product.click();
			}
		}
	}
	
	public void setQuantity(String quantity)
	{
		txtQuantity.clear();
		txtQuantity.sendKeys(quantity);
	}
	
	public void addToCart()
	{
		btnAddtoCart.click();
	}
	public boolean checkConfMsg()
	{
		try {
			return cnfrmmsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
