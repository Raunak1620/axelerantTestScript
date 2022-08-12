package assignment.EcomProject;

import java.io.IOException;
import java.time.Duration;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.CategorySummerDress;
import pageObjects.LandingPage;
import pageObjects.ShoopingCartAuth;
import pageObjects.ShoopingCartPayment;
import pageObjects.ShoppingCartAddress;
import pageObjects.shortProdInfo;
import pageObjects.ShoppingCartSummary;
import pageObjects.ShoppingCartShipping;
import resources.base;

public class SortingFilter extends base {
	LandingPage lp = new LandingPage(driver);
	shortProdInfo sp = new shortProdInfo(driver);
	ShoppingCartSummary sm = new ShoppingCartSummary(driver);
	ShoopingCartAuth sa = new ShoopingCartAuth(driver);
	ShoppingCartAddress sc = new ShoppingCartAddress(driver);
	ShoppingCartShipping scs = new ShoppingCartShipping(driver);
	ShoopingCartPayment scp = new ShoopingCartPayment(driver);
	CategorySummerDress csd = new CategorySummerDress(driver);
	
	public WebDriverWait waitDriver() {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wt;
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		driver = initializeDriver();
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void verifySorting(){
		Actions action = new Actions(driver);
		WebElement el = driver.findElement(lp.topmenu);
		action.moveToElement(el).perform();
		driver.findElement(lp.topmenuchildsd).click();
		
		WebElement e0 = driver.findElement(csd.prodsortdropdown);
		Select sortDropdown = new Select(e0);
		sortDropdown.selectByIndex(7);
	
     	waitDriver().until(ExpectedConditions.invisibilityOf(driver.findElement(csd.loading)));
     	
		WebElement e2 = driver.findElement(csd.hoverprod);
		action.moveToElement(e2).perform();
		Assert.assertEquals("-20%", driver.findElement(csd.proddiscount).getText());
       
	}

	@Test
	public void verifyfilter(){
		
		WebElement slider = driver.findElement(By.xpath("//div[@class='layered_price']//a[1]"));
		for (int i = 1; i <= 30; i++) {
			slider.sendKeys(Keys.ARROW_RIGHT);
		}
		
		waitDriver().until(ExpectedConditions.invisibilityOf(driver.findElement(csd.loading)));

		Assert.assertFalse(priceList().contains(16.40));
	}

	//method for getting price list and sorting the list 
	public List<Double> priceList() {
		List<WebElement> pricefilter = driver.findElements(csd.defaultproducts);
		List<Double> filtersortedlist = pricefilter.stream().map(s -> Double.parseDouble(s.getText().replace("$", "")))
				.collect(Collectors.toList());
		Collections.sort(filtersortedlist, Collections.reverseOrder());
		return filtersortedlist;
	}
}
