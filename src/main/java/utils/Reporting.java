package utils;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

@Listeners
public class Reporting {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public static ExtentTest test;
	String fileName = this.getClass().getSimpleName();

	public static String dir = System.getProperty("user.dir");

	@BeforeClass
	public void startReport() throws Exception {
		String currentDateTime = new SimpleDateFormat("dd-MMMM-yyyy_HH.mm.ss").format(Calendar.getInstance().getTime());
		// htmlReporter = new
		// ExtentHtmlReporter("./Extend_Reports/"+fileName+"/"+fileName+"-"+currentDateTime+".html");
		htmlReporter = new ExtentHtmlReporter(
				dir + "//Extent_Reports//" + fileName + "//" + fileName + "-" + currentDateTime + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setReportName("Report");
		return;
	}

	@AfterClass
	public void endReport() {
		extent.flush();
	}


}
