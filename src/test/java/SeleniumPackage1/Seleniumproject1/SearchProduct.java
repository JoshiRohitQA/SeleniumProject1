package SeleniumPackage1.Seleniumproject1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchProduct extends Launch_Quit {
	@Test(retryAnalyzer = SeleniumPackage1.Seleniumproject1.RetryClass.class,dataProvider = "inputs")
	public void searchPRo(String product) {
		
		Amz_HomePage hp = new Amz_HomePage(driver);
		hp.inputSearchitem(product);
		hp.waitforvisibleList();
		
		Amz_SearchResult sr = new Amz_SearchResult(driver);
		
		Assert.assertTrue(sr.listProd.isDisplayed());
		
	}
	
	@DataProvider(name="inputs")
	public Object[][] data1(){
		return new Object[][] {{"shoes"}};
	}

}
