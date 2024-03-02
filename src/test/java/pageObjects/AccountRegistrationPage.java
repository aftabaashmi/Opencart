package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
		//PageFactory.initElements(driver, this);
	}

	//Elements
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmpasword;
	
	@FindBy(xpath="//input[@value='0']")
	private WebElement subscribenewsletter;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreecheckbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continuebutton;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement confirmmessage;
	
	public void setFirstNameRegisterPage(String fname)
	{
		firstname.sendKeys(fname);
	}
	public void setlastnameRegisterPage(String lname)
	{
		lastname.sendKeys(lname);
	}
	public void setEmailRegisterPage(String textemail)
	{
		email.sendKeys(textemail);
	}
	public void setTelephone(String tel)
	{
		telephone.sendKeys(tel);
	}
	public void setPasswordRegisterPage(String psd)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		password.sendKeys(psd);
		
	}
	public void setConfirmPasword(String confpswd)
	{
		confirmpasword.sendKeys(confpswd);
	}
	public void clickonNewsLetter()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		subscribenewsletter.click();
	}
	public void clickonAgreeCheckbox()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		agreecheckbox.click();
	}
	public void clickonContinue()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		continuebutton.click();
	}
	public String getConfirmationMsg()
	{
		try {
			return(confirmmessage.getText());
		} catch (Exception e) {
			return(e.getMessage());
		}
		
		
	}
	
}
