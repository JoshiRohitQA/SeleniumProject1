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
	
	@FindBy(xpath="(//span[@class='a-price-whole'])[5]")
	WebElement proPrice;
	
	@FindBy(xpath="//div[@class='a-section review aok-relative']/div/div")
	List<WebElement> reviewList;
	
	@FindBy(xpath="//div[@id='feature-bullets']")
	WebElement proDescription;
	
	
	public void verifyReviewList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(reviewList));
	}
	
	
	
	public Amz_ProductDetailScreen(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

}
