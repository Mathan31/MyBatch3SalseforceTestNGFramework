package wrapper;

import java.io.File;
import java.text.SimpleDateFormat; 
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class HTMLReport {
	
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public ExtentTest test,node;
	public String authors,category;
	private static String pattern = "dd-MMM-yyyy HH-mm-ss";
	public static String folderName = "";
	
	public static String createFolder(String folderName) {
		String date = new SimpleDateFormat(pattern).format(new Date());
		folderName = folderName+"/" + date;

		File folder = new File("./" + folderName);
		if (!folder.exists()) {
			folder.mkdir();
		}
		return folderName;
	}
	
	public void startReport() {
		folderName = createFolder("report");
		spark = new ExtentSparkReporter("./"+folderName+"/SalesForceReport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	
	public void endReport() {
		extent.flush();
	}
	
	public ExtentTest startTestCase(String testCaseName, String testDescription) {
		test = extent.createTest(testCaseName, testDescription);
		test.assignAuthor(authors);
		test.assignCategory(category);
		return test;
	}

	public ExtentTest startTestCase(String nodes) {
		node = test.createNode(nodes);
		return node;
	}
	 
	public void reportStep(String desc,String status) {
		if(status.equalsIgnoreCase("pass")){
			node.pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
			} else if(status.equalsIgnoreCase("fail")) {
				node.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());	
			} else {
				node.info(desc);	
			}
	}
	
	public abstract String takeScreenshot();

}
