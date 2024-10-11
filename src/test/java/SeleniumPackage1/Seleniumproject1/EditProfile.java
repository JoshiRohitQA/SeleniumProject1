package SeleniumPackage1.Seleniumproject1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditProfile extends Launch_Quit{
	@Test(retryAnalyzer = SeleniumPackage1.Seleniumproject1.RetryClass.class,dataProvider = "inputs")
	public void editProf(String mobNum , String PassW,String name) throws InterruptedException {
		Amz_HomePage hp = new Amz_HomePage(driver);
		hp.accountlist(driver);
		hp.signin_click();
		
		Amz_LoginPage lp = new Amz_LoginPage(driver);
		lp.inputMobile(mobNum);
		lp.clickCont();
		lp.inputPassword(PassW);
		lp.clickSignin();
		
		hp.clickAccounts();
		
		Amz_AccountSettingsPage as=  new Amz_AccountSettingsPage(driver);
		as.clickLogin_Security();
		
		Thread.sleep(15000);
		as.clickSubmitCode();
		
		
		Amz_LoginSecurityPage lsp = new Amz_LoginSecurityPage(driver);
		lsp.clickEdit();
		
		Amz_ChangeNamePage cp = new Amz_ChangeNamePage(driver);
		cp.inpuEditName(name + Keys.BACK_SPACE);
		
		cp.clickSubmit();
		
		Assert.assertTrue(lsp.verifyEdit.isDisplayed());
	}
	
	@DataProvider(name="inputs")
	public Object[][] data1() throws EncryptedDocumentException, IOException{
		FileInputStream fs = new FileInputStream("C:\\Users\\rohit.joshi\\eclipse-workspace\\Seleniumproject1\\DataFetch\\LoginSheet.xlsx");
		Workbook w1=WorkbookFactory.create(fs);
		String mobilData=NumberToTextConverter.toText(w1.getSheet("Login").getRow(0).getCell(0).getNumericCellValue());
		String passwordData=w1.getSheet("Login").getRow(0).getCell(1).getStringCellValue();
		Object[][] d1 = new Object[1][3];
		d1[0][0]=mobilData;
		d1[0][1]=passwordData;
		d1[0][2]="s";
		return d1;
		
	}

}
