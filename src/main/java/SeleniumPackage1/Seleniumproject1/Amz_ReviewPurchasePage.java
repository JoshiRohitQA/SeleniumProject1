package SeleniumPackage1.Seleniumproject1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_ReviewPurchasePage {
	WebDriver driver;
	
	@FindBy(xpath="//div/div/button")
	List<WebElement>stars;
	
	
	@FindBy(xpath = "//span[@class='a-color-link']")
	WebElement ratingverify;
	
	
	public void click5star() {
		stars.get(5).click();
	}
	
	
	
	public Amz_ReviewPurchasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
