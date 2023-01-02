package flipkartwebpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By price = By.xpath("//div[@class='CEmiEU']/div[1]/div[1]");
	By addtocart = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	By increaseqty = By.xpath("//div[@class='_3dY_ZR']/button[2]");
	By finalprice = By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[5]/div/span/div/div/span");
	
	public WebElement Price() {
		return driver.findElement(price);
	}
	public WebElement AddtoCart() {
		return driver.findElement(addtocart);
	}
	public WebElement IncQty() {
		return driver.findElement(increaseqty);
	}
	public WebElement FinalPrice() {
		return driver.findElement(finalprice);
	}
	

}