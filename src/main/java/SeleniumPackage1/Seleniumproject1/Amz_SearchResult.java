package SeleniumPackage1.Seleniumproject1;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amz_SearchResult {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='a-declarative']/div/div")
	WebElement listProd;
	
	@FindBy(xpath="//li[@id='p_90/20912642031']")
	WebElement deliveryFilter;
	
	@FindBy(xpath="//span[@class='a-size-base a-color-base'][.='Puma']")
	WebElement brand;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-none s-messaging-widget-results-header']")
	WebElement verifyResult;
	
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal'][.='Vintage A158WA-1DF Black Digital Dial Silver Stainless Steel Band D011']")
	WebElement searchRes;
	
	
	@FindBy(xpath="//select[@id='s-result-sort-select']")
	WebElement sortDropdown;
	
	@FindBy(xpath="//div[@class='s-main-slot s-result-list s-search-results sg-row']/div/div")
	WebElement sortedList;
	
	
	@FindBy(xpath="(//div[@data-csa-c-action-name='addToCart'])[2]")
	WebElement addToCart;
	
	@FindBy(xpath="//span[@class='a-button a-button-span11 a-button-base a-button-small']")
	WebElement directToCart;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']/h2/a")
	List<WebElement> desiredProd;
	
	
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
	
	
	public void clickDesiredSearchRes()  {
		
		searchRes.click();
	}
	
	public void sortProdonPrice() {
		Select select = new Select(sortDropdown);
		select.selectByVisibleText("Price: High to Low");
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(sortedList));
		
	}
	
	public void sortProdonRating() {
		Select select = new Select(sortDropdown);
		select.selectByVisibleText("Avg. Customer Review");
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(sortedList));
		
	}
	
	public void sortProdonNewArrivals() {
		Select select = new Select(sortDropdown);
		select.selectByVisibleText("Newest Arrivals");
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(sortedList));
		
	}
	
	public void clickAddToCart() {
		addToCart.click();
	}
	
	public void clickDirecttoCart()  {
		directToCart.click();
	
	}
	
	public void clickDesireditem() {
		desiredProd.get(1).click();;
		
	}
	
	
	
	
	public Amz_SearchResult(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

}
