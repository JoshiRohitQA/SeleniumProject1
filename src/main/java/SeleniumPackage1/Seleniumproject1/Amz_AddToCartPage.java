package SeleniumPackage1.Seleniumproject1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_AddToCartPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='a-cardui-body a-scroller-none']/form/div")
	List<WebElement> addTocartItems;
	
	public Amz_AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

}
