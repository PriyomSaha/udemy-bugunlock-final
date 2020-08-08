package resources;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentRepoterNG {
	static ExtentReports extent;
	public static ExtentReports getReport() {
		
		String path =System.getProperty("user.dir")+"\\Output\\Reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Automation Results");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Test Results");

		extent =new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Testbots", "Team 4");
		
		return extent;
	}
}