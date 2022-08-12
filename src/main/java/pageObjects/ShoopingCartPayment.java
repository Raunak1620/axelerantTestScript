package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class ShoopingCartPayment extends base{
    public ShoopingCartPayment(WebDriver driver) {
    	this.driver = driver;
	}

	WebDriver driver;
    
    public By paybywire = By.xpath("//a[@title='Pay by bank wire']");
    public By confirmorder = By.xpath("//span[normalize-space()='I confirm my order']");
    public By orderconfirmtext = By.xpath("//strong[normalize-space()='Your order on My Store is complete.']");
}