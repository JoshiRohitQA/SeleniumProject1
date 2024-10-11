package SeleniumPackage1.Seleniumproject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_OrdersPage {
	WebDriver driver;
	
	
	@FindBy(xpath="//a[@class='a-link-normal'][.='View orders in 2024']")
	WebElement clickpastOrders;
	
	@FindBy(xpath = "//a[@href='/review/review-your-purchases?asins=B0B1XPC885&channel=YAcc-wr&ref=ppx_yo2ov_dt_b_rev_prod']")
	WebElement productReviewButton;
	
	
	public void clickPastOrders() {
		clickpastOrders.click();
	}
	
	public void clickProdReview() {
		productReviewButton.click();
	}
	
	
	
	
	public Amz_OrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
