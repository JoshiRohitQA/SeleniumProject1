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


public class Amz_AddToCartPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='a-cardui-body a-scroller-none']/form/div")
	List<WebElement> addTocartItems;
	
	@FindBy(xpath="//select[@name='quantity']")
	WebElement quantityDrop;
	
	@FindBy(xpath="//span[@id='sc-subtotal-label-activecart']")
	WebElement verifyitemCount;
	
	public void increaseQunatity() {
		Select select = new Select(quantityDrop);
		select.selectByValue("3");
	}
	
	public void verifyCount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(verifyitemCount, "Subtotal (3 items):"));
		String count=verifyitemCount.getText();
		System.out.println(count);
	}
	
	public void decreaseQunatity() {
		Select select = new Select(quantityDrop);
		select.selectByValue("2");
	}
	public void verifydecreaseCount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(verifyitemCount, "Subtotal (2 items):"));
		String count1=verifyitemCount.getText();
		System.out.println(count1);
	}
	
	public Amz_AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
