package Academy;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initilizeeDriver() throws IOException {
		driver = intializeDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		//driver.navigate().refresh();
		LoginPage login = new LoginPage(driver);
		login.getEmail().sendKeys(Username);
		login.getPassword().sendKeys(Password);
		login.getLogin().click();
		log.info("Login is made successfully...");
		//driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "nonrestriceduser@user.com";
	    data[0][1]= "12345678";
		data[1][0]="restricteduser@user.com";
	data[1][1]="1234567890";
	
		return data;
	}
	
}
