package SeleniumPackage1.Seleniumproject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement cont;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement passWord;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement signIN;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement verifyLogin;
	
	
	
	@FindBy(xpath="//a[@id='createAccountSubmit']")
	WebElement createNew;
	
	
	public void inputMobile(String MobileNum) {
		userName.sendKeys(MobileNum);
	}
	
	public void clickCont() {
		cont.click();
	}
	
	public void inputPassword(String Pass) {
		passWord.sendKeys(Pass);
	}
	
	public void clickSignin() {
		signIN.click();
	}
	
	public void clickCreate() {
		createNew.click();
	}
	
	public Amz_LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
