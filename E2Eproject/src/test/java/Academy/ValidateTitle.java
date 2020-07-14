package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateTitle extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initilizeeDriver() throws IOException {
		driver = intializeDriver();
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
		log.info("Loading home page.....");
	}
	//@SuppressWarnings("deprecation")
	@Test
	public void ValidateTitle() throws IOException {
		log.info("Validating title is started....");
		LandingPage lp = new LandingPage(driver);
		log.info("Received title from the portal is : "+lp.getTitle().getText());
	//	Assert.assertTrue(false);
		Assert.assertEquals("FEATURED1111 COURSES",lp.getTitle().getText());
		log.info("Successfully validated text message...");
			}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Closing the browser...");
	}
}
