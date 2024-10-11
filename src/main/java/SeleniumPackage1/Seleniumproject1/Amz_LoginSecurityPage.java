package SeleniumPackage1.Seleniumproject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_LoginSecurityPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[@aria-label='Edit name']")
	WebElement edit;
	
	
	@FindBy(xpath="//div[@class='a-alert-content'][.='Name updated. ']")
	WebElement verifyEdit;
	public void clickEdit() {
		edit.click();
	}
	
	
	
	public Amz_LoginSecurityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
