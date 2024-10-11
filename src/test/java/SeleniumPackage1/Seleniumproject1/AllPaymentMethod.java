package SeleniumPackage1.Seleniumproject1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AllPaymentMethod extends Launch_Quit {
	
	@Test(retryAnalyzer=SeleniumPackage1.Seleniumproject1.RetryClass.class,dataProvider = "inputs")
	public void selectPay(String num, String password,String prod,String cardNum, String UPInum)  {
		
		Amz_HomePage hp = new Amz_HomePage(driver);
		hp.accountlist(driver);
		hp.signin_click();
		
		Amz_LoginPage lp = new Amz_LoginPage(driver);
		lp.inputMobile(num);
		
		lp.clickCont();
		
		lp.inputPassword(password);
		
		lp.clickSignin();
		
		
		hp.inputSearchitem(prod + Keys.ENTER);
		
		Amz_SearchResult sr = new Amz_SearchResult(driver);
		sr.clickDesireditem();
		
		Set<String>s1=driver.getWindowHandles();
		Iterator<String>i1=s1.iterator();
		String parentWindow=i1.next();
		String childWindow=i1.next();
		driver.switchTo().window(childWindow);
		
		Amz_ProductDetailScreen ps = new Amz_ProductDetailScreen(driver);
		ps.clickbuyNow();
		
		Amz_CheckoutScreen cs = new Amz_CheckoutScreen(driver);

		cs.clickAddress();
		cs.clickUseAddress();
		cs.verifyAddress();
		
		cs.clickCreditcardPay();
		
		driver.switchTo().frame(cs.ifram);
		
		cs.inputCardDetails(cardNum);
		
		
		Assert.assertTrue(cs.errorCard.isDisplayed());
		
		cs.clickCancelCardwindow();
		
		driver.switchTo().defaultContent();
		
		cs.clickNetBanking();
		cs.clickNetbankDrop();
		cs.verifyNet();
		
		Assert.assertTrue(cs.verifyNetBank.isDisplayed());
		
		cs.clickOTherUPI(UPInum);
		
		Assert.assertTrue(cs.verifiedUpiPayment.isDisplayed());
		
		cs.clickCODPay();
		
		Assert.assertTrue(cs.codPay.isSelected());
	
		
	}
	
	@DataProvider(name="inputs")
	public Object[][] data1() throws EncryptedDocumentException, IOException{
		FileInputStream fs = new FileInputStream("C:\\Users\\rohit.joshi\\eclipse-workspace\\Seleniumproject1\\DataFetch\\LoginSheet.xlsx");
		Workbook w1=WorkbookFactory.create(fs);
		String mobNumber=NumberToTextConverter.toText(w1.getSheet("Login").getRow(0).getCell(0).getNumericCellValue());
		String passworD=w1.getSheet("Login").getRow(0).getCell(1).getStringCellValue();
		Object[][] d1 = new Object[1][5];
		d1[0][0]=mobNumber;
		d1[0][1]=passworD;
		d1[0][2]="mouse";
		d1[0][3]="122345554";
		d1[0][4]="9873733935@paytm";
		return d1;
	}

}
