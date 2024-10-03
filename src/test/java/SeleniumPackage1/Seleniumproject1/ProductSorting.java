package SeleniumPackage1.Seleniumproject1;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductSorting extends Launch_Quit{
	@Test(retryAnalyzer = SeleniumPackage1.Seleniumproject1.RetryClass.class,dataProvider = "inputs")
	public void sortProd(String prod) {
			Amz_HomePage hp = new Amz_HomePage(driver);
			hp.inputSearchitem(prod +Keys.ENTER);
			
			Amz_SearchResult sr = new Amz_SearchResult(driver);
			sr.sortProdonPrice();
			
			Assert.assertTrue(sr.sortedList.isDisplayed());
			
			sr.sortProdonRating();
			
			Assert.assertTrue(sr.sortedList.isDisplayed());
			
			sr.sortProdonNewArrivals();
			
			Assert.assertTrue(sr.sortedList.isDisplayed());
			
	}
	
	
	@DataProvider(name="inputs")
	public Object[][] data1(){
		return new Object[][] {{"iphone"}};
	}

}
