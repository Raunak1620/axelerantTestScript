package assignment.EcomProject;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class MWindowNewsLetterAddToCart extends base {
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
	public void verifyHeaderFooter() {
		LandingPage lp = new LandingPage(driver);

		WebElement pathToLinks = driver.findElement(lp.footerLinks);
		List<WebElement> st = pathToLinks.findElements(lp.footerlinka);

		// open child window
		for (int i = 0; i < 1; i++) {
			String text = Keys.chord(Keys.CONTROL, Keys.ENTER);
			st.get(i).sendKeys(text);
		}

		// MainWindow
		String MainWindow = driver.getWindowHandle();

		// To handle child window
		Set<String> s1 = driver.getWindowHandles();
		System.out.println("Child window handle is" + s1);
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);

				// check header footer on child pages
				Assert.assertTrue(lp.getHeader());
				Assert.assertTrue(lp.getFooter());

				driver.close();
				// child window close
			}
		}
		driver.switchTo().window(MainWindow);

	}

	@Test
	public void verifyNewsletter() {
		driver.findElement(lp.newsletterinput).sendKeys("rlkrkr037@gmail.com");
		driver.findElement(lp.newsletterbutton).click();

		waitDriver().until(ExpectedConditions.visibilityOf(driver.findElement(lp.confirmnewsletter)));
		// Assert.assertEquals(driver.findElement(lp.confirmNewsletter()).getText(),
		// "Newsletter : You have successfully subscribed to this newsletter.");
		Assert.assertTrue(driver.findElement(lp.confirmnewsletter).getText().contains("Newsletter"));
	}

	@Test
	public void verifyxddToCart() {
		waitDriver().until(ExpectedConditions.visibilityOf(driver.findElement(lp.itemtocart)));
		driver.findElement(lp.itemtocart).click();
		driver.findElement(sp.fproceedtocart).click();
		driver.findElement(sm.scsptocheckout).click();
		driver.findElement(sa.emailsc).sendKeys("raunakr037@gmail.com");
		driver.findElement(sa.passsc).sendKeys("RomanReign!@12");
		driver.findElement(sa.signinbtn).click();
		driver.findElement(sc.ptc).click();
		driver.findElement(scs.agreebtn).click();
		driver.findElement(scs.sproceedtc).click();
		driver.findElement(scp.paybywire).click();
		driver.findElement(scp.confirmorder).click();
		Assert.assertEquals("Your order on My Store is complete.", driver.findElement(scp.orderconfirmtext).getText());
		driver.findElement(lp.logohome).click();
	}

}
