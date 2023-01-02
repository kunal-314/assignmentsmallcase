package amazonwebpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmzHomePage {
	WebDriver driver;

	public AmzHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchbox = By.xpath("//input[@id='twotabsearchtextbox']");
	By firstproduct = By.xpath("//*[contains(text(), 'MI 80 cm')]"); 
	
	public WebElement SearchBox() {
		return driver.findElement(searchbox);
		}
	public WebElement FirstProduct() {
		return driver.findElement(firstproduct);
	}

}

