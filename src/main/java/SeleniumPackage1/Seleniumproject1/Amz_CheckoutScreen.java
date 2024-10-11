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

public class Amz_CheckoutScreen {
	WebDriver driver;
	
	@FindBy(xpath="(//div[@class='a-box-inner']/fieldset/div)[1]")
	WebElement address;
	
	@FindBy(xpath="(//input[@class='a-button-input'])[6]")
	WebElement useAddress;
	
	@FindBy(xpath="//div[@aria-label='Delivery address']")
	WebElement selectedAddress;
	
	
	@FindBy(xpath="//input[@aria-labelledby='orderSummaryPrimaryActionBtn-announce']")
	WebElement usePaymentMethod;
	
	
	@FindBy(xpath="//input[@name='ppw-instrumentRowSelection'][@value='instrumentId=0h_PE_CUS_18b1c868-2e63-40e2-8b24-414fe05d88c8%2FCash&isExpired=false&paymentMethod=COD&tfxEligible=false']")
	WebElement codPay;
	
	@FindBy(xpath="//input[@name='ppw-instrumentRowSelection'][@value='SelectableAddCreditCard']")
	WebElement creditCardPay;
	
	
	@FindBy(xpath="//a[@class='a-link-emphasis pmts-add-cc-default-trigger-link']")
	WebElement AddcardDetails;
	
	@FindBy(xpath="//input[@name='addCreditCardNumber']")
	WebElement addCardnumber;
	
	@FindBy(xpath="//iframe[@name='ApxSecureIframe']")
	WebElement ifram;
	
	
	@FindBy(xpath="//div[@class='a-row checkout spc desktop locale-in spc-desktop']")
	WebElement reviewOrder;
	
	
	@FindBy(xpath="//select[@name='ppw-expirationDate_month']")
	WebElement cardMonth;
	
	@FindBy(xpath="//select[@name='ppw-expirationDate_year']")
	WebElement cardYear;
	
	
	@FindBy(xpath="//input[@name='ppw-widgetEvent:AddCreditCardEvent']")
	WebElement enterDetails;
	
	@FindBy(xpath="//div[@class='a-box a-alert a-alert-error']")
	WebElement errorCard;
	
	@FindBy(xpath="//button[@name='ppw-widgetEvent:CancelAddCreditCardEvent']")
	WebElement cancelCardwindow;
	
	
	@FindBy(xpath="//input[@value='instrumentId=NetBanking&isExpired=false&paymentMethod=NB&tfxEligible=false']")
	WebElement netBankingradio;
	
	
	@FindBy(xpath = "//span[@class='a-dropdown-prompt'][.='Choose an Option']")
	WebElement netBankingDropdown;
	
	@FindBy(xpath="//div[@class='a-popover-inner a-lgtbox-vertical-scroll']/ul/li")
	List<WebElement> cardList;
	
	@FindBy(xpath="//span[@class='a-dropdown-prompt'][.='HDFC Bank']")
	WebElement verifyNetBank;
	
	@FindBy(xpath="//input[@value='instrumentId=amzn1.pm.poa.YW16bjEucG9hOmFtem4xLnBvYS5wb2RhLlVuaWZpZWRQYXltZW50c0ludGVyZmFjZTox.QTEyUE5OVDcyM1FZNUI&isExpired=false&paymentMethod=UnifiedPaymentsInterface&tfxEligible=false']")
	WebElement clickUPI;
	
	@FindBy(xpath = "//input[@class='a-input-text a-form-normal no-prefetch-on-change']")
	WebElement inputUPI;
	
	@FindBy(xpath="//input[@name='ppw-widgetEvent:ValidateUpiIdEvent']")
	WebElement verifyUPI;
	
	@FindBy(xpath ="//div[@class='a-alert-content'][.='Verified!']")
	WebElement verifiedUpiPayment;
	
	
	@FindBy(xpath = "//input[@value='instrumentId=0h_PE_CUS_18b1c868-2e63-40e2-8b24-414fe05d88c8%2FCash&isExpired=false&paymentMethod=COD&tfxEligible=false']")
	WebElement CODPay;
	
	
	@FindBy(xpath="//input[@class='a-input-text a-form-normal a-width-large a-span9 pmts-claim-code']")
	WebElement couponCode;
	
	@FindBy(xpath = "//input[@name='ppw-claimCodeApplyPressed']")
	WebElement applyCoupon;
	
	
	@FindBy(xpath="//div[@class='a-alert-content'][.='The promotional code you entered is not valid.']")
	WebElement verifyCoup;
	
	public void clickAddress() {
	
		address.click();
	}
	
	public void clickUseAddress() {
		useAddress.click();
	}
	
	public void verifyAddress() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(selectedAddress));
	}
	
	
	public void clickUsepaymentmethod() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(codPay));
		usePaymentMethod.click();
	}
	
	
	public void clickCreditcardPay() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(creditCardPay));
		creditCardPay.click();
		AddcardDetails.click();
		
		
		
	}
	
	public void inputCardDetails(String cardNum) {
		addCardnumber.sendKeys(cardNum);
		Select select = new Select(cardMonth);
		select.selectByValue("10");
		Select select1 = new Select(cardYear);
		select1.selectByValue("2025");
		enterDetails.click();
		
		
		
	}
	
	public void clickCancelCardwindow() {
		cancelCardwindow.click();
	}
	
	public void clickNetBanking() {
		netBankingradio.click();
	}
	
	public void clickNetbankDrop() {
		netBankingDropdown.click();
		cardList.get(2).click();
		
	}
	
	public void verifyNet() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(verifyNetBank));
	}
	
	public void clickOTherUPI(String UPI) {
		clickUPI.click();
		inputUPI.sendKeys(UPI);
		verifyUPI.click();
		
	}
	
	public void clickCODPay() {
		codPay.click();
	}
	
	public void inputCouponCode(String coupon) {
		couponCode.sendKeys(coupon);
	}
	
	public void clickApplycoupon() {
		applyCoupon.click();
	}
	
	public void verifyCouponcode() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(verifyCoup));
	}
	
	public void verifyReviewOrder() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(reviewOrder));
	}
	

	
	public Amz_CheckoutScreen(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
