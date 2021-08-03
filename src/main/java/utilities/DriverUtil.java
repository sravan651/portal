package utilities;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This DriverUtil class refer to browsers, os details, browser versions and
 * will close all browsers
 *
 */

public class DriverUtil extends GlobalUtil {

	public final String IE = "IE";
	public final String REMOTE = "Remote";
	public final String EDGE = "edge";
	public final String SAFARI = "safari";
	public final String CHROME = "Chrome";
	public final String FIREFOX = "firefox";
	private Map<String, WebDriver> drivers = new HashMap<>();
	public final WebDriver driver = null;
	public DesiredCapabilities capabilities = new DesiredCapabilities();

	/**
	 * @param browserName
	 * @return
	 */
	public WebDriver getBrowser(String exeEnv, String browserName) {
		WebDriver browser = null;
		try {
			DesiredCapabilities caps;
			String URL = null;

			if (exeEnv.equalsIgnoreCase(REMOTE)) {

				if (browserName.equalsIgnoreCase(CHROME)) {
					caps = DesiredCapabilities.chrome();
					caps.setCapability("os", "WINDOWS");
					if (getCommonSettings().getRemoteOS().toUpperCase().contains("WINDOWS")) {
						caps.setCapability("os_version", getCommonSettings().getRemoteOS().split("_")[1]);
					}
					if (getCommonSettings().getRemoteOS().toUpperCase().contains("MAC")) {
						caps.setCapability("os", "OS X");
						caps.setCapability("os_version", getCommonSettings().getRemoteOS().split("_")[1]);
					}
				} else if (browserName.equalsIgnoreCase(FIREFOX)) {
					caps = DesiredCapabilities.firefox();
					caps.setCapability("os", "WINDOWS");
					if (getCommonSettings().getRemoteOS().toUpperCase().contains("WINDOWS")) {
						caps.setCapability("os_version", getCommonSettings().getRemoteOS().split("_")[1]);
					}
				} else if (browserName.equalsIgnoreCase(EDGE)) {
					caps = DesiredCapabilities.edge();
					caps.setCapability("os", "WINDOWS");
					caps.setCapability("version", "14.0");
					caps.setCapability("os_version", "10");
				}

				else if (browserName.equalsIgnoreCase("Safari")) {
					caps = DesiredCapabilities.safari();
					if (getCommonSettings().getRemoteOS().toUpperCase().contains("WINDOWS")) {
						caps.setCapability("os", "OS X");
						caps.setCapability("os_version", "SIERRA");
					}

					else {
						caps.setCapability("os", "OS X");
						caps.setCapability("os_version", getCommonSettings().getRemoteOS().split("_")[1]);
					}
				} else {
					caps = DesiredCapabilities.internetExplorer();
					caps.setCapability("os", "WINDOWS");
					if (getCommonSettings().getRemoteOS().toUpperCase().contains("WINDOWS")) {
						caps.setCapability("os_version", getCommonSettings().getRemoteOS().split("_")[1]);
					}
					if (getCommonSettings().getRemoteOS().toUpperCase().contains("MAC")) {
						caps.setCapability("os", "OS X");
						caps.setCapability("os_version", getCommonSettings().getRemoteOS().split("_")[1]);
					}
				}

				if (getCommonSettings().getCloudProvider().equalsIgnoreCase("BrowserStack")) {
					caps.setCapability("browserstack.debug", "true");
					caps.setCapability("build", getCommonSettings().getBuildNumber());
					URL = "https://" + getCommonSettings().getHostName() + ":" + getCommonSettings().getKey()
							+ "@hub-cloud.browserstack.com/wd/hub";
				}
				try {
					browser = new RemoteWebDriver(new URL(URL), caps);
				} catch (Exception e) {
					e.printStackTrace();
				}
				drivers.put(browserName, browser);
			} else {
				if (browserName.equalsIgnoreCase(CHROME)) {
					browser = drivers.get(browserName);
					WebDriverManager.chromedriver().setup();
					browser = new ChromeDriver();
				} else if (browserName.equalsIgnoreCase(FIREFOX)) {
					browser = drivers.get(browserName);
					WebDriverManager.firefoxdriver().setup();
					browser = new FirefoxDriver();
				} else if (browserName.equalsIgnoreCase(IE)) {
					browser = drivers.get(browserName);
					WebDriverManager.iedriver().setup();
					browser = new InternetExplorerDriver();
				} else if (browserName.equalsIgnoreCase(EDGE)) {
					browser = drivers.get(browserName);
					WebDriverManager.edgedriver().setup();
					browser = new EdgeDriver();
				} else if (browserName.equalsIgnoreCase(SAFARI)) {
					browser = drivers.get(browserName);
					browser = new SafariDriver();
				}
			}
			browser.manage().window().maximize();
			// logUtil.infoLog("TestStarted",
			// getCommonSettings().getBrowser() + " : Browser Launched and Maximized.");
		} catch (Exception e) {
			// logUtil.errorLog(DriverUtil.class, "Browser not launched. Please check the
			// configuration ", e);
			e.printStackTrace();
		}
		return browser;
	}

	/**
	 * will get browser type and version
	 * 
	 * @param browser
	 * @param cap
	 * @return
	 */
	public String getBrowserAndVersion(WebDriver browser, DesiredCapabilities cap) {
		String browserversion;
		String windows = "Windows";
		String browsername = cap.getBrowserName();
		if ("IE".equalsIgnoreCase(browsername)) {
			String uAgent = (String) ((JavascriptExecutor) browser).executeScript("return navigator.userAgent;");
			// logUtil.infoLog(DriverUtil.class, uAgent);
			if (uAgent.contains("MSIE") && uAgent.contains(windows)) {
				browserversion = uAgent.substring(uAgent.indexOf("MSIE") + 5, uAgent.indexOf(windows) - 2);
			} else if (uAgent.contains("Trident/7.0")) {
				browserversion = "11.0";
			} else {
				browserversion = "0.0";
			}
		} else {
			browserversion = cap.getVersion();
		}
		String browserversion1 = browserversion.substring(0, browserversion.indexOf('.'));
		return browsername + " " + browserversion1;
	}
}