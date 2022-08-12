package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class LandingPage extends base {
	WebDriver driver;

	public By header = By.cssSelector(".header-container");
	public By footer = By.cssSelector("#footer");
	public By footerLinks = By.xpath("//section[@id='block_various_links_footer'][1]/ul");
	public By footerlinka = By.xpath("//section[@id='block_various_links_footer']/ul/li/a");
	public By newsletterinput = By.xpath("(//input[@id='newsletter-input'])[1]");
	public By newsletterbutton = By.cssSelector("button[name='submitNewsletter']");
	public By confirmnewsletter = By.xpath("(//div[@id='columns'])/p");
	public By itemtocart = By.xpath("(//span[contains(text(),'Add to cart')])[3]");
	public By topmenu = By.xpath("//div[@id='block_top_menu']/child::ul/li");
	public By topmenuchildsd = By.xpath("//div[@id='block_top_menu']/child::ul/li/ul/li/ul/li/a[@title='Summer Dresses']");
    public By logohome = By.cssSelector("img[alt='My Store']");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public By confirmNewsletter() {
		return confirmnewsletter;
	}

	public boolean getHeader() {
		return driver.findElement(header).isDisplayed();
	}

	public boolean getFooter() {
		return driver.findElement(footer).isDisplayed();
	}

}
