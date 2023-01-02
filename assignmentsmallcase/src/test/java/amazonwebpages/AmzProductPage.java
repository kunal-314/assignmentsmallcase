package amazonwebpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmzProductPage {
	WebDriver driver;
	public AmzProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By price = By.xpath("//div[@class='a-section a-spacing-none aok-align-center']/span[2]/span[2]/span[2]");
	By addtocart = By.xpath("//input[@id='add-to-cart-button']");
	
	public WebElement Price() {
		return driver.findElement(price);
		}
	public WebElement AddToCart() {
		return driver.findElement(addtocart);
		}

}
