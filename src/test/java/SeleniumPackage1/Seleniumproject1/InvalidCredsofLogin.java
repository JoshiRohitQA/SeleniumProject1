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


public class InvalidCredsofLogin extends Launch_Quit{
	
	@Test(retryAnalyzer = SeleniumPackage1.Seleniumproject1.RetryClass.class,dataProvider = "inputs")
	
	public void unsuccesfulLogin(String mobil,String pass) {
		
		Amz_HomePage hp = new Amz_HomePage(driver);
		hp.accountlist(driver);
		hp.signin_click();
		
		Amz_LoginPage lp = new Amz_LoginPage(driver);
		
		lp.inputMobile(mobil);
		lp.clickCont();
		lp.inputPassword(pass);
		lp.clickSignin();
		
		Assert.assertTrue(lp.passWord.isDisplayed());
		
		
		
	}
	
	@DataProvider(name="inputs")
	public Object[][] data1() throws EncryptedDocumentException, IOException{
		
		FileInputStream fs = new FileInputStream("C:\\Users\\rohit.joshi\\eclipse-workspace\\Seleniumproject1\\DataFetch\\InvalidSheet.xlsx");
		Workbook w1=WorkbookFactory.create(fs);
		String userName=NumberToTextConverter.toText(w1.getSheet("Invalid").getRow(0).getCell(0).getNumericCellValue());
		String password=w1.getSheet("Invalid").getRow(0).getCell(1).getStringCellValue();
		Object[][] d1 = new Object[1][2];
		d1[0][0]=userName;
		d1[0][1]=password;	
		return d1;
	}
		
	}



