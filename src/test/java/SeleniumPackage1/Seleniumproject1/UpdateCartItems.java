package SeleniumPackage1.Seleniumproject1;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UpdateCartItems extends Launch_Quit{
	@Test(retryAnalyzer = SeleniumPackage1.Seleniumproject1.RetryClass.class,dataProvider = "inputs")
	public void updateItem(String prod) {
		Amz_HomePage hp = new Amz_HomePage(driver);
		hp.inputSearchitem(prod+Keys.ENTER);
		
		Amz_SearchResult sr = new Amz_SearchResult(driver);
		sr.clickAddToCart();
		sr.clickDirecttoCart();
		
		Amz_AddToCartPage cp = new Amz_AddToCartPage(driver);
		cp.increaseQunatity();
		
		cp.verifyCount();
		
		Assert.assertEquals(cp.verifyitemCount.getText(),"Subtotal (3 items):");
		
		cp.decreaseQunatity();
		
		cp.verifydecreaseCount();
		
		Assert.assertEquals(cp.verifyitemCount.getText(),"Subtotal (2 items):");
		
	}
	
	@DataProvider(name="inputs")
	public Object[][] data1(){
		return new Object[][] {{"usb type c cable"}};
		
	}

}
