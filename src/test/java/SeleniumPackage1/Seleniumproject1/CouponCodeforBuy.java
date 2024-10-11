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

public class CouponCodeforBuy extends Launch_Quit {
	
	@Test(retryAnalyzer = SeleniumPackage1.Seleniumproject1.RetryClass.class,dataProvider = "inputs")
	public void couponBuy(String mobNum,String passW,String prod,String couponCode) {
		
		Amz_HomePage hp = new Amz_HomePage(driver);
		hp.accountlist(driver);
		hp.signin_click();
		
		Amz_LoginPage lp = new Amz_LoginPage(driver);
		lp.inputMobile(mobNum);
		lp.clickCont();
		lp.inputPassword(passW);
		lp.clickSignin();
		
		hp.inputSearchitem(prod + Keys.ENTER);
		
		Amz_SearchResult sr = new Amz_SearchResult(driver);
		sr.clickDesireditem();
		
		Set<String>s1=driver.getWindowHandles();
		Iterator<String>i1=s1.iterator();
		String parentWindow=i1.next();
		String childWindow=i1.next();
		
		driver.switchTo().window(childWindow);
		
		Amz_ProductDetailScreen pr = new Amz_ProductDetailScreen(driver);
		pr.clickbuyNow();
		
		Amz_CheckoutScreen cs = new Amz_CheckoutScreen(driver);
		cs.clickUseAddress();
		
		cs.inputCouponCode(couponCode);
		cs.clickApplycoupon();
		
		cs.verifyCouponcode();
		
		Assert.assertTrue(cs.verifyCoup.isDisplayed());
		
		
		
	}
	
	@DataProvider(name="inputs")
	public Object[][] data1() throws EncryptedDocumentException, IOException{
		FileInputStream fs = new FileInputStream("C:\\Users\\rohit.joshi\\eclipse-workspace\\Seleniumproject1\\DataFetch\\LoginSheet.xlsx");
		Workbook w1=WorkbookFactory.create(fs);
		String mobile=NumberToTextConverter.toText(w1.getSheet("Login").getRow(0).getCell(0).getNumericCellValue());
		String password=w1.getSheet("Login").getRow(0).getCell(1).getStringCellValue();
		Object[][] d1 = new Object[1][4];
		d1[0][0]=mobile;
		d1[0][1]=password;
		d1[0][2]="keyboard";
		d1[0][3]="Test213";
		return d1;
		
		
	}

}
