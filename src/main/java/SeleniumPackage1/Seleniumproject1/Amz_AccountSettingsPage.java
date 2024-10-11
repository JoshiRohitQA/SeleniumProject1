package SeleniumPackage1.Seleniumproject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_AccountSettingsPage {
	WebDriver driver;
	
	@FindBy(xpath="(//div[@class='a-box ya-card--rich'])[2]")
	WebElement Login_Security;
	
	@FindBy(xpath="(//input[@class='a-button-input'])[2]")
	WebElement submitCode;
	
	
	public void clickLogin_Security() {
		Login_Security.click();
	}
	
	public void clickSubmitCode()  {
		
		submitCode.click();
	}
	
	public Amz_AccountSettingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
