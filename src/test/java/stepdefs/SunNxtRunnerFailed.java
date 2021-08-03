package stepdefs;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;
//import jirautil.JiraUtil;
//import mantisutil.ConnectMantis;
import utilities.ConfigReader;
import utilities.DriverUtil;
import utilities.ExcelDataUtil;
import utilities.ExtReport;
import utilities.GlobalUtil;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/rerun.txt", glue = "classpath:stepdefs", plugin = { "pretty",
		"html:target/cucumber-html-report" }, monochrome = true)
public class SunNxtRunnerFailed extends AbstractTestNGCucumberTests {
	private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();
	// private LogUtil logUtil = new GlobalUtil().logUtil;
	public static ConfigReader config = new ConfigReader();

	public static TestNGCucumberRunner getRunner() {
		return testNGCucumberRunner.get();
	}

	protected static void setRunner(TestNGCucumberRunner testNGCucumberRunner1) {
		testNGCucumberRunner.set(testNGCucumberRunner1);
	}

	@BeforeSuite
	public void beforeSuite() {
		ExtReport.setReport(this.getClass().getSimpleName());
	}

	@Parameters({ "browserName" })
	@BeforeClass
	public void onStart(String browserName) {
		try {
			// Get all the common setting from excel file that are required for
			new GlobalUtil().setCommonSettings(new ExcelDataUtil().getCommonSettings());
			String browser = "";
			// Overriding the browserName retrieved from Excel
			new GlobalUtil().getCommonSettings().setBrowser(browserName);
			browser = new GlobalUtil().getCommonSettings().getBrowser();

			String executionEnv = "";
			executionEnv = new GlobalUtil().getCommonSettings().getExecutionEnv();

			String url = "";
			url = new GlobalUtil().getCommonSettings().getUrl();

			if (url == null) {
				url = config.getValue("BASE_URL");
				new GlobalUtil().getCommonSettings().setUrl(url);
			}
			// logUtil.infoLog(getClass(),
			// "\n\n+===========================================================================================================+");
			// logUtil.infoLog(getClass(), " Suite started" + " at " + new Date());
			// logUtil.infoLog(getClass(), "Suite Execution For Web application on
			// environment : " + executionEnv);
			// logUtil.infoLog(getClass(),
			// "\n\n+===========================================================================================================+");
			setRunner(new TestNGCucumberRunner(this.getClass()));
			new GlobalUtil()
					.setDriver(new DriverUtil().getBrowser(new GlobalUtil().getCommonSettings().getExecutionEnv(),
							new GlobalUtil().getCommonSettings().getBrowser()));
		} catch (Exception e) {
			e.printStackTrace();
			// logUtil.errorLog(getClass(), "Common Settings not properly set may not run
			// the scripts properly");
		}
	}

	@AfterClass
	public void onFinish() {
		// logUtil.infoLog(getClass(), " suite finished" + " at " + new Date());
		// logUtil.infoLog(getClass(),
		// "\n\n+===========================================================================================================+");
		ExtReport.getReport().flush();
		new DriverUtil().getDriver().quit();
	}

	@AfterSuite
	public void afterSuite() {
		ExtReport.getReport().close();
	}
}
