package SeleniumPackage1.Seleniumproject1;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amz_HomePage 
{
	WebDriver driver;
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	WebElement Account_andList;
	@FindBy(xpath="(//span[.='Sign in'])[1]")
	WebElement signin;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	@FindBy(xpath="//div[@class='left-pane-results-container']/div/div")
	List<WebElement> searchResult;
	
	
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
	

	public void waitforvisibleList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(searchResult));
		searchResult.get(2).click();
	}
	
	
	
	public Amz_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
}
