package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class ShoppingCartAddress extends base{
    public ShoppingCartAddress(WebDriver driver) {
    	this.driver = driver;
	}

	WebDriver driver;
    
    public By ptc = By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]");
    
}