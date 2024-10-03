package SeleniumPackage1.Seleniumproject1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Amz_RegistartionPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='ap_customer_name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='ap_phone_number']")
	WebElement mobil;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement passW;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement verifyButton;
	
	@FindBy(xpath="//button[.='Start Puzzle']")
	WebElement existingUSer;
	
	public void inputName(String User) {
		name.sendKeys(User);
	}
	
	public void inputMobil(String Number) {
		mobil.sendKeys(Number);
	}
	
	public void inputPass(String Password) {
		passW.sendKeys(Password);
	}
	
	public void clickVerify() {
		verifyButton.click();
	}
	
	
	
	
	public Amz_RegistartionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	

}
