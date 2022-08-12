package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class shortProdInfo extends base{
    public shortProdInfo(WebDriver driver) {
    	this.driver = driver;
	}

	WebDriver driver;
    
    public By fproceedtocart = By.xpath("//span[normalize-space()='Proceed to checkout']");
   // public By proceedtocheckout = By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']/span");
    
    
}