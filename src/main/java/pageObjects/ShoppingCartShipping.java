package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class ShoppingCartShipping extends base{
    public ShoppingCartShipping(WebDriver driver) {
    	this.driver = driver;
	}

	WebDriver driver;
    
    public By agreebtn = By.xpath("//input[@id='cgv']");
    public By sproceedtc = By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]");
    
}