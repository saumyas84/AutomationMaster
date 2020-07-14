package resources;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	WebDriver driver;
	static ExtentReports extent;

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		// ExtentSparkreporter expecs path to where the reports are created. responsible
		// to create reposts
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		// reporter is responsible for config
		reporter.config().setReportName("Web Automation result001");
		reporter.config().setDocumentTitle("Test Result 001");

		// ExtentReport is responsible to drive all report executions
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Saumya Sharma");

		return extent;
	}
}
