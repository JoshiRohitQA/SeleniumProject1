package SeleniumPackage1.Seleniumproject1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amz_ProductDetailScreen  {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='a-price-whole'][1]")
	WebElement proPrice;
	
	@FindBy(xpath="//div[@class='a-section review aok-relative']/div/div")
	List<WebElement> reviewList;
	
	@FindBy(xpath="//div[@class='a-expander-content a-expander-partial-collapse-content']")
	WebElement proDescription;
	
	@FindBy(xpath="//input[@id='buy-now-button']")
	WebElement buyNow;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addTocart;
	
	@FindBy(xpath="//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']")
	WebElement proceedToBuy;
	
	
	public void verifyReviewList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(reviewList));
	}
	
	public void clickbuyNow() {
		buyNow.click();
	}
	
	public void clickAddToCart() {
		addTocart.click();
	}
	
	public void clickProceedtoBuy() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(proceedToBuy));
		proceedToBuy.click();
	}
	
	
	
	public Amz_ProductDetailScreen(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

}
