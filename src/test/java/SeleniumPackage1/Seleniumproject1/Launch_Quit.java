package SeleniumPackage1.Seleniumproject1;

import java.time.Duration;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ListenerPRo.class)

public class Launch_Quit  extends ListenerPRo {

	
	
	@BeforeMethod
	public void launchAmazon() 
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}


}
