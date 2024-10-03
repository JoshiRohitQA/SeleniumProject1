package SeleniumPackage1.Seleniumproject1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchWithFilters extends Launch_Quit {
	
	@Test(retryAnalyzer = SeleniumPackage1.Seleniumproject1.RetryClass.class , dataProvider = "inputs")
	public void searchFilters(String prod) {
		Amz_HomePage hp = new Amz_HomePage(driver);
		hp.inputSearchitem(prod);
		hp.waitforvisibleList();
		
		Amz_SearchResult sr=new Amz_SearchResult(driver);
		sr.click_deliveryFilter();
		sr.click_brandfilter();
		
		Assert.assertTrue(sr.verifyResult.isDisplayed());
		
	}
	
	@DataProvider(name="inputs")
	public Object[][]data1(){
		
		return new Object[][] {{"shoes"}};
		
	}
}
