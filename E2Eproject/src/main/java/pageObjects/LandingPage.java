package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class LandingPage {

	public WebDriver driver;

	By signin = By.cssSelector("a[href*='sign_in']");
	By Title = By.cssSelector(".text-center>h2");
	By Navigation = By.xpath("//*[@id=\'homepage\']/header/div[2]/div/nav/ul");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		return driver.findElement(Title);
	}

	public WebElement getNavigation() {
		return driver.findElement(Navigation);
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
