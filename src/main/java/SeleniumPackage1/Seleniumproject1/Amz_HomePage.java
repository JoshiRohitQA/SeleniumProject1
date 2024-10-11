package SeleniumPackage1.Seleniumproject1;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Amz_HomePage 
{
	WebDriver driver;
	
	
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	WebElement Account_andList;
	@FindBy(xpath="(//span[.='Sign in'])[1]")
	WebElement signin;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	WebElement accountsButton;
	
	@FindBy(xpath="//a[@class='nav-a nav-a-2   nav-progressive-attribute']")
	WebElement orders;
	
	
	public void accountlist(WebDriver driver)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(Account_andList).perform();
		
	}
	public void signin_click()
	{
		signin.click();
		
	}
	
	public void inputSearchitem(String item) {
		searchBox.sendKeys(item);
	}
	

	
	public void clickAccounts() {
		accountsButton.click();
	}
	
	public void clickOrders() {
		orders.click();
	}
	
	
	
	public Amz_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
}
