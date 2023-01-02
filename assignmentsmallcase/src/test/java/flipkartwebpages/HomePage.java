package flipkartwebpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By cancelbutton = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	By searchbox = By.xpath("//input[@title='Search for products, brands and more']");
	By firstproduct = By.xpath("//*[contains(text(), 'Mi 5A 80 cm')]"); 
	
	
	public WebElement CancelButton() {
		 return driver.findElement(cancelbutton);
	}

	public WebElement SearchBox() {
		return driver.findElement(searchbox);
	}

	public WebElement FirstProduct() {
		return driver.findElement(firstproduct);
	}

}