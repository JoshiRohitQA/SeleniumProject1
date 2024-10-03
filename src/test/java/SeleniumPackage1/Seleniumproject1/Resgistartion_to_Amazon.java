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


public class Resgistartion_to_Amazon extends Launch_Quit
{
	@Test(retryAnalyzer = SeleniumPackage1.Seleniumproject1.RetryClass.class,dataProvider = "inputs")
	public void creating_new_account(String Name ,String Mobil , String Pass) 
	{
		Amz_HomePage a1=new Amz_HomePage(driver);
		a1.accountlist(driver);
		a1.signin_click();
	
		Amz_LoginPage lp = new Amz_LoginPage(driver);
		lp.clickCreate();
		
		
		Amz_RegistartionPage rp = new Amz_RegistartionPage(driver);
		rp.inputName(Name);
		rp.inputMobil(Mobil);
		rp.inputPass(Pass);
		rp.clickVerify();
		
		Assert.assertEquals(driver.getTitle(), "Authentication required");
		
		
	}
	
	
	@DataProvider(name="inputs")
	public Object[][] data1() throws EncryptedDocumentException, IOException{
		FileInputStream fs = new FileInputStream("C:\\Users\\rohit.joshi\\eclipse-workspace\\Seleniumproject1\\DataFetch\\RegisterSheet.xlsx");
		Workbook w1=WorkbookFactory.create(fs);
		String nameData=w1.getSheet("Register").getRow(0).getCell(0).getStringCellValue();
		String mobilData=NumberToTextConverter.toText(w1.getSheet("Register").getRow(0).getCell(1).getNumericCellValue());
		String passData=w1.getSheet("Register").getRow(0).getCell(2).getStringCellValue();
		Object[][] d1 = new Object[1][3];
		d1[0][0]=nameData;
		d1[0][1]=mobilData;
		d1[0][2]=passData;
		return d1;
		
	}
	
}

