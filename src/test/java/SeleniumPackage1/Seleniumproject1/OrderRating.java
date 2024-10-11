package SeleniumPackage1.Seleniumproject1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrderRating extends Launch_Quit{
	@Test(retryAnalyzer = SeleniumPackage1.Seleniumproject1.RetryClass.class,dataProvider = "inputs")
	public void fiveStarRate(String mobNum ,String passW) {
		
		Amz_HomePage hp = new Amz_HomePage(driver);
		hp.accountlist(driver);
		hp.signin_click();
		
		Amz_LoginPage lp = new Amz_LoginPage(driver);
		lp.inputMobile(mobNum);
		lp.clickCont();
		lp.inputPassword(passW);
		lp.clickSignin();
		
		hp.clickOrders();
		
		Amz_OrdersPage op = new Amz_OrdersPage(driver);
		op.clickPastOrders();
		op.clickProdReview();
		
		Amz_ReviewPurchasePage rp = new Amz_ReviewPurchasePage(driver);
		rp.click5star();
		
		Assert.assertTrue(rp.ratingverify.isDisplayed());
	}
	
	@DataProvider(name="inputs")
	public Object[][] data1() throws EncryptedDocumentException, IOException{
		FileInputStream fs = new FileInputStream("C:\\Users\\rohit.joshi\\eclipse-workspace\\Seleniumproject1\\DataFetch\\LoginSheet.xlsx");
		Workbook w1=WorkbookFactory.create(fs);
		String mobile=NumberToTextConverter.toText(w1.getSheet("Login").getRow(0).getCell(0).getNumericCellValue());
		String password=w1.getSheet("Login").getRow(0).getCell(1).getStringCellValue();
		Object[][] d1 = new Object[1][2];
		d1[0][0]=mobile;
		d1[0][1]=password;
		return d1;
		
		
	}


}
