package SeleniumPackage1.Seleniumproject1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductDetails extends Launch_Quit {
	@Test(retryAnalyzer = SeleniumPackage1.Seleniumproject1.RetryClass.class, dataProvider = "inputs")
	public void verifyProdDetails(String pro)  {
		Amz_HomePage hp = new Amz_HomePage(driver);
		hp.inputSearchitem(pro +Keys.ENTER);
		
		Amz_SearchResult sr = new Amz_SearchResult(driver);
		sr.clickDesiredSearchRes();
		
		Set<String>s1=driver.getWindowHandles();
		
		Iterator<String> i1=s1.iterator();
		
		String parentWindow=i1.next();
		String childWindow=i1.next();
		
		driver.switchTo().window(childWindow);
		
		Amz_ProductDetailScreen ps = new Amz_ProductDetailScreen(driver);
		
		Assert.assertTrue(ps.proPrice.isDisplayed());
		
		ps.verifyReviewList();
		
		Assert.assertFalse(ps.reviewList.isEmpty());
		
		Assert.assertTrue(ps.proDescription.isDisplayed());
		
	}
	
	@DataProvider(name="inputs")
	public Object[][] data(){
		return new Object[][] {{"iphone 15 pro"}};
	}

}
