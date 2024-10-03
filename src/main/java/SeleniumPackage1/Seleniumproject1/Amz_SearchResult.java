package SeleniumPackage1.Seleniumproject1;



import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amz_SearchResult {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='a-declarative']/div/div")
	WebElement listProd;
	
	@FindBy(xpath="//li[@id='p_90/20912642031']")
	WebElement deliveryFilter;
	
	@FindBy(xpath="(//a[@class='a-link-normal s-navigation-item'])[15]")
	WebElement brand;
	
	@FindBy(xpath="//input[@id='p_36/range-slider_slider-item_upper-bound-slider']")
	WebElement rangeFilter;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	WebElement goButton;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-none s-messaging-widget-results-header']")
	WebElement verifyResult;
	
	@FindBy(xpath="(//div[@class='a-section a-spacing-small a-spacing-top-small'])[2]/div/h2")
	WebElement searchRes;
	
	
	public void click_deliveryFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(deliveryFilter));
		
		deliveryFilter.click();
	}
	
	public void click_brandfilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(brand));
		brand.click();
	}
	
	public void inputRange(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(rangeFilter));
		rangeFilter.sendKeys(value);
	}
	
	public void clickGo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(goButton));
		goButton.click();
	}
	
	public void clickDesiredSearchRes()  {
		
		searchRes.click();
	}
	
	public Amz_SearchResult(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

}
