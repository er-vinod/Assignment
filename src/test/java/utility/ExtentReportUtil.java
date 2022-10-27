package utility;




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {
	private ExtentReports extRepoObj;
	private static ExtentTest extLogger;
	
	public ExtentTest getExtentLogger() {
		return extLogger;
	}
	
	public void initExentReport(String fileName) {
		
		ExtentSparkReporter	extHtmlRepoObj=new ExtentSparkReporter("reports\\"+fileName+".html");
		
		extRepoObj = new ExtentReports();
		extRepoObj.attachReporter(extHtmlRepoObj);
		extRepoObj.setSystemInfo("OS Name", System.getProperty("os.name"));
		extRepoObj.setSystemInfo("Browser Name", "Chrome");
		extRepoObj.setSystemInfo("Author Name", System.getProperty("user.name"));	
	}
	
	public void getExtentLogger(String testId_Name) {
		 extLogger = extRepoObj.createTest(testId_Name);
		 
	}
	
	public void flushReport() {
		extRepoObj.flush();
	}
	public void info(String message) {
		extLogger.log(Status.INFO, message);
	}
	public void warning(String message) {
		extLogger.log(Status.WARNING ,message);
	}
	public void pass(String message) {
		extLogger.log(Status.PASS, message);
	}
	public void fail(String message) {
		extLogger.log(Status.FAIL, message);
	}
	
}
