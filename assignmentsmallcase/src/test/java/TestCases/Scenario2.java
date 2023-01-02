package TestCases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import amazonwebpages.AmzHomePage;
import amazonwebpages.AmzProductPage;
import flipkartwebpages.HomePage;
import flipkartwebpages.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2 {
	@SuppressWarnings("deprecation")
	@Test
	public void TestScenario02() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		HomePage hp = new HomePage(driver);
		hp.CancelButton().click();
		//search for product on flipkart
		hp.SearchBox().sendKeys("mi 5A 32 inch tv", Keys.ENTER);
		//click on the first product
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", hp.FirstProduct());
		ProductPage product = new ProductPage(driver);
		//switch to new tab
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		product.AddtoCart().click();
		//fetch price
		String price = product.FinalPrice().getText();
		String price2 = price.replaceAll("[,₹]", "");
		System.out.println("The price of the flipkart product is: " +price2);
		driver.get("https://www.amazon.in/");
		AmzHomePage AHP = new AmzHomePage(driver);
		//search for product on amazon
		AHP.SearchBox().sendKeys("mi 5A 32 inch tv", Keys.ENTER);
		//click on the first product
		AHP.FirstProduct().click();
		AmzProductPage amproduct = new AmzProductPage(driver);
		//switch to new tab
		ArrayList<String> newTb2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb2.get(2));
		//fetch price
		String amprice = amproduct.Price().getText();
		String amprice2 = amprice.replaceAll("[,]", "");
		System.out.println("The price of amazon product is: "+amprice2);
		amproduct.AddToCart().click();
		driver.quit();
		//compare prices
		int f = Integer.parseInt(price2);
		int a = Integer.parseInt(amprice2);
		if(f>a) {
			System.out.println("Product is cheaper on Amazon");
		}
		else if(f<a) {
			System.out.println("Product is cheaper on Flipkart");
		}
		else {
			System.out.println("Product is priced equally on Flipkart and Amazon");
		}
		}
	
	
}
