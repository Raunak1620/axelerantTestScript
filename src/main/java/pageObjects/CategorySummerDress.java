package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class CategorySummerDress extends base{
    public CategorySummerDress(WebDriver driver) {
    	this.driver = driver;
	}

	WebDriver driver;
    
    public By prodsortdropdown = By.id("selectProductSort");
    public By hoverprod = By.xpath("(//div[@class='right-block'])[1]");
    public By proddiscount = By.cssSelector("li[class*='last-mobile-line'] div[class='right-block'] div[class='content_price'] span[class='price-percent-reduction']");
    public By defaultproducts = By.xpath("//div[@class='right-block']//span[@class='price product-price']");
    public By loading = By.xpath("//div[@id='center_column']//p[1]//img");
}