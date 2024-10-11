package SeleniumPackage1.Seleniumproject1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TillCartWithoutLogin extends Launch_Quit{
	@Test(retryAnalyzer = SeleniumPackage1.Seleniumproject1.RetryClass.class,dataProvider = "inputs")
	public void withoutLoginTillCart(String prod) {
		Amz_HomePage hp = new Amz_HomePage(driver);
		hp.inputSearchitem(prod +Keys.ENTER);
		
		Amz_SearchResult sr = new Amz_SearchResult(driver);
		sr.clickDesireditem();
		
		Set<String>s1=driver.getWindowHandles();
		Iterator<String>i1=s1.iterator();
		String parentWindow=i1.next();
		String childWindow=i1.next();
		
		driver.switchTo().window(childWindow);
		
		Amz_ProductDetailScreen ps = new Amz_ProductDetailScreen(driver);
		ps.clickAddToCart();
		
		ps.clickProceedtoBuy();
		
		Amz_LoginPage lp = new Amz_LoginPage(driver);
		Assert.assertTrue(lp.userName.isDisplayed());
	}
	
	
	@DataProvider(name="inputs")
	public Object[][] data1(){
		return new Object[][] {{"mouse"}};
	}
	

}
