package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavigation extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initilizeeDriver() throws IOException {
		driver = intializeDriver();
		driver.get(prop.getProperty("url"));
	}

	//@SuppressWarnings("deprecation")
	@Test
	public void ValidateNavigation() throws IOException {
		; 
		LandingPage lp = new LandingPage(driver);
		org.testng.Assert.assertTrue(lp.getNavigation().isDisplayed());
		log.info("Naviation is displayed");
		
		//lp.getNavigation().getText();
			}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
