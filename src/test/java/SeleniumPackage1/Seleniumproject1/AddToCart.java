package SeleniumPackage1.Seleniumproject1;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddToCart extends Launch_Quit {
	@Test(retryAnalyzer = SeleniumPackage1.Seleniumproject1.RetryClass.class,dataProvider = "inputs")
	public void addItems(String prod) {
		Amz_HomePage hp= new Amz_HomePage(driver);
		hp.inputSearchitem(prod + Keys.ENTER);
		
		Amz_SearchResult sr = new Amz_SearchResult(driver);
		sr.clickAddToCart();
		
		sr.clickDirecttoCart();
		
		Amz_AddToCartPage cp = new Amz_AddToCartPage(driver);
		
		Assert.assertFalse(cp.addTocartItems.isEmpty());
		
	}
	
	@DataProvider(name="inputs")
	public Object[][] data1(){
		return new Object[][] {{"Daikin 1.5 ton ac"}};
	}

}
