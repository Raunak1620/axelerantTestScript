package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class ShoopingCartAuth extends base{
    public ShoopingCartAuth(WebDriver driver) {
    	this.driver = driver;
	}

	WebDriver driver;
    
    public By emailsc = By.xpath("//input[@id='email']");
    public By passsc = By.xpath("//input[@id='passwd']");
    public By signinbtn = By.xpath("//span[normalize-space()='Sign in']");
}