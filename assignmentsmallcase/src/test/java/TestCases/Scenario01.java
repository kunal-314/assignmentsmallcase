package TestCases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import flipkartwebpages.HomePage;
import flipkartwebpages.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario01 {
	@SuppressWarnings("deprecation")
	@Test
	public void TestScenario01() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		HomePage hp = new HomePage(driver);
		hp.CancelButton().click();
		hp.SearchBox().sendKeys("mi 5A 32 inch tv", Keys.ENTER);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", hp.FirstProduct());
		ProductPage product = new ProductPage(driver);
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOf(product.Price()));
		String price = product.Price().getText();
		String price2 = price.replaceAll("[₹]", "");
		System.out.println("The price of the product is: " +price2);
		product.AddtoCart().click();
		executor.executeScript("arguments[0].scrollIntoView();", product.IncQty());
		product.IncQty().click();
		Thread.sleep(1000);
		String finalprice = product.FinalPrice().getText();
		String finalprice2= finalprice.replaceAll("[₹]", "");
		System.out.println("The final price of the product is: " +finalprice2);
		driver.quit();

	}

}
