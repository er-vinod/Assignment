package stepDefinition;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import utility.WebUtil;

public class Hook {
	static WebUtil util = WebUtil.getWebUtilObj();
	
	@BeforeAll
	public static void intitReport() {
		//String featureName = sc.getId().split(":")[0];
		util.initExentReport("assignmentReport");
	}
	@Before()
	public void setup(Scenario sc) {
		
		util.getExtentLogger(sc.getName());
	}
	@After
	public void tearDown(Scenario sc) {
		if(sc.getStatus().FAILED==Status.FAILED) {
			util.getExtentLogger().addScreenCaptureFromPath(util.getScreenShot(sc.getName()));
		}
		util.flushReport();
	}
	
	@AfterAll
	public static void closeBrowser() {
		util.closeAllWindow();
	}
}
