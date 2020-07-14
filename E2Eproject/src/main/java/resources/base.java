package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	
	public WebDriver intializeDriver() throws IOException {
		// if chorme then invoke chrome only
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\qxy0037\\Desktop\\AUTOMATION_PRACTICE\\E2Eproject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\qxy0037\\Desktop\\AUTOMATION_PRACTICE\\OnlineStore\\src\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\qxy0037\\Desktop\\AUTOMATION_PRACTICE\\OnlineStore\\src\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String desitinatiofile= System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		FileUtils.copyFile(Source, new File(desitinatiofile));
		return desitinatiofile;
		
	}
}
