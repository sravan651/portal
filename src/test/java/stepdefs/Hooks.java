package stepdefs;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.ExtReport;
import utilities.ExtTest;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

public class Hooks extends KeywordUtil {

	String imagePath;
	String pathForLogger;
	String testCaseDescription;

	@Before("@web")
	public void beforeMethod(Scenario scenario) {
		if (scenario.getName().contains("_"))
			testCaseDescription = scenario.getName().split("_")[1];
		else
			testCaseDescription = scenario.getName();
		String testName = getCommonSettings().getBrowser() + "_" + testCaseDescription;
		ExtTest.setTest(ExtReport.getReport().startTest(testName));
		// logUtil.infoLog(getClass(),
		// "\n+----------------------------------------------------------------------------------------------------------------------------+");
		// logUtil.infoLog(getClass(), "Test Started: " + scenario.getName());
		// logUtil.infoLog("Test Environment",
		// "Test is executed in Environment: " + getCommonSettings().getExecutionEnv());

		// logUtil.infoLog("TestStarted", "Test is started with browser: " +
		// getCommonSettings().getBrowser());
	}

	@After("@web")
	public void afterMethod(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				String scFileName = "ScreenShot_" + System.currentTimeMillis();
				String screenshotFilePath = config.getValue("screenshotPath") + "/" + scFileName + ".png";

				imagePath = new HTMLReportUtil().testFailTakeScreenshot(screenshotFilePath);
				pathForLogger = ExtTest.getTest().addScreenCapture(imagePath);
				ExtTest.getTest().log(LogStatus.FAIL,
						new HTMLReportUtil().failStringRedColor("Failed at point: " + pathForLogger));
				scenario.write("Current Page URL is " + getDriver().getCurrentUrl());
				byte[] screenshot = takeScreenshot(screenshotFilePath);
				scenario.embed(screenshot, "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// logUtil.infoLog("TestEnded", "Test has ended closing browser: " +
			// getCommonSettings().getBrowser());
		}
		ExtReport.getReport().endTest(ExtTest.getTest());
	}
}