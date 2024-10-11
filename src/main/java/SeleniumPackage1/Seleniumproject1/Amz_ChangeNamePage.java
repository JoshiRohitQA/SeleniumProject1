package SeleniumPackage1.Seleniumproject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_ChangeNamePage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='ap_customer_name']")
	WebElement inputName;
	
	@FindBy(xpath="//input[@id='cnep_1C_submit_button']")
	WebElement submit;
	
	
	public void inpuEditName(String name) {
		inputName.sendKeys(name);
	}
	
	
	public void inputEditName(String name) {
		inputName.sendKeys(name);
	
	}
	
	public void clickSubmit() {
		submit.click();
	}
	
	public Amz_ChangeNamePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
