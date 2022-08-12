package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class ShoppingCartSummary extends base{
    public ShoppingCartSummary(WebDriver driver) {
    	this.driver = driver;
	}

	WebDriver driver;
    
    public By scsptocheckout = By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']/span");
    
    
}