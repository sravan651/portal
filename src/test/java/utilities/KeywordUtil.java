package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;

public class KeywordUtil extends DriverUtil {
	public String cucumberTagName;
	private final int DEFAULT_WAIT_SECONDS = 20;
	protected final int FAIL = 0;
	static WebElement webElement;
	protected String url = "";
	private String userDir = "user.dir";
	public final String VALUE = "value";
	public String lastAction = "";
	public HTMLReportUtil report = new HTMLReportUtil();

	public void onExecutionFinish() {
		String htmlReportFile = System.getProperty("user.dir") + "/" + config.getValue("HtmlReportFullPath");
		System.out.println("cucumber path is " + htmlReportFile);
		File f = new File(htmlReportFile);
		if (f.exists()) {

			try {
				Runtime.getRuntime().exec(
						"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe \" " + htmlReportFile + "\"");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (cucumberTagName.equals("Mobile") || cucumberTagName.equals("Web")) {
			String htmlExtentReportFile = System.getProperty("user.dir") + "/" + config.getValue("extentReportPath");
			File extentReport = new File(htmlExtentReportFile);
			if (extentReport.exists()) {
				try {
					Runtime.getRuntime().exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe \""
							+ htmlExtentReportFile + "\"");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public WebElement clickOnElementUsingJS(By locator, String logStep) {
		WebElement element = waitForVisible(locator);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return webElement;
	}

	public byte[] takeScreenshot(String screenshotFilePath) {
		try {
			byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
			FileOutputStream fileOuputStream = new FileOutputStream(screenshotFilePath);
			fileOuputStream.write(screenshot);
			fileOuputStream.close();
			return screenshot;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void refresh() {
		getDriver().navigate().refresh();
	}

	public void quit() {
		getDriver().quit();
	}

	public void close() {
		getDriver().close();
	}

	public void back() {
		getDriver().navigate().back();
	}

	public void pause(long a) {
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void visibilityofElementLocated(By locator, String logstep) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logstep));
		lastAction = "Find Element: " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
	}

	public void moveToElement(By locator) {
		WebElement ele = waitForClickable(locator);
		Actions a = new Actions(getDriver());
		a.moveToElement(ele).build().perform();

	}

	public boolean visibilityOfElementLocated(By locator, String logstep) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		Boolean flag = false;
		if (wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null) {
			ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logstep));
			flag = true;
		}
		return flag;
	}

	@SuppressWarnings("deprecation")
	public WebElement visibilityOfElementLocated1(By locator, String logstep) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logstep));
		return webElement;
	}

	public void elementToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void window(int value) {
		ArrayList<String> a = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(a.get(value));
	}

	public boolean scrollingToElementofAPage(By locator, String logStep) {
		pause(5000);
		WebElement element = getDriver().findElement(locator);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return true;
	}

	public void scrollDown(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public String getCurrentDateTime() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMddHHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	/**
	 * @param locator
	 * @return
	 */
	public void scrollWindowforElementclickable(By locator, int howManySwipes, String logStep) {
		for (int i = 1; i <= howManySwipes; i++) {
			try {
				getDriver().findElement(locator).click();
				ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
				System.out.println("swipe");
				break;
			} catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			}
		}
	}

	public void navigateToUrl(String url) {
		try {
			lastAction = "Navigate to: " + url;
			// logUtil.infoLog(KeywordUtil.class, lastAction);
			getDriver().manage().deleteAllCookies();
			getDriver().navigate().refresh();
			getDriver().navigate().to(url);
		} catch (Exception e) {

		}
	}

	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}

	public WebElement waitForClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(WebDriverException.class);

		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * @param locator
	 * @return
	 */
	public WebElement waitForPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
		wait.ignoring(ElementNotVisibleException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * @param locator
	 * @return
	 */
	public WebElement waitForVisible(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			return null;
		}
	}

	public boolean waitForInVisibile(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public WebElement waitForVisibleIgnoreStaleElement(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(ElementNotVisibleException.class);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	@SuppressWarnings("deprecation")
	public WebElement findWithFluentWait(By locator, int seconds, int poolingMil) {
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		WebElement element = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(seconds, TimeUnit.SECONDS)
					.pollingEvery(poolingMil, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class).ignoring(ElementNotVisibleException.class)
					.ignoring(WebDriverException.class);
			element = wait.until(new Function<WebDriver, WebElement>() {
				@Override
				public WebElement apply(WebDriver driver) {
					return driver.findElement(locator);
				}
			});
		} catch (Exception t) {
			System.err.println("Timeout reached when searching for element! Time: " + seconds + " seconds " + "\n"
					+ t.getMessage());
		}
		return element;
	}

	/**
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public WebElement findWithFluentWait(By locator) {
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		lastAction = "Find Element: " + locator.toString();
		WebElement element = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
					.withTimeout(DEFAULT_WAIT_SECONDS, TimeUnit.SECONDS).pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
					.ignoring(ElementNotVisibleException.class);
			element = wait.until(new Function<WebDriver, WebElement>() {
				@Override
				public WebElement apply(WebDriver driver) {
					return driver.findElement(locator);
				}
			});
		} catch (Exception t) {
			System.err.println("Timeout reached when searching for element! Time: " + DEFAULT_WAIT_SECONDS + " seconds "
					+ "\n" + t.getMessage());
		}
		return element;
	}

	public WebElement getWebElement(By locator) {
		lastAction = "Find Element: " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		return findWithFluentWait(locator);
	}

	/**
	 * @param locator
	 * @return
	 */
	public void scrollWindow(int howManySwipes) {
		for (int i = 1; i <= howManySwipes; i++) {
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			System.out.println("swipe");
		}
	}

	public void scrollWindow(int howManySwipes, String logStep) {
		for (int i = 1; i <= howManySwipes; i++) {
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
			System.out.println("swipe");
		}
	}

	public void click(By locator, String logStep) {
		lastAction = "Click: " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		WebElement elm = waitForClickable(locator);
		// ((JavascriptExecutor)
		// getDriver()).executeScript("arguments[0].scrollIntoView();", elm);
		elm.click();
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
	}

	public void moveToElement(WebElement ele) {
		Actions a = new Actions(getDriver());
		a.moveToElement(ele).build().perform();
	}

	public void acceptAlert() {
		Alert alert = getDriver().switchTo().alert();
		alert.accept();
	}

	public void getAlertText() {
		Alert alert = getDriver().switchTo().alert();
		alert.getText();
	}

	/**
	 * @param linkText
	 * @return
	 */
	public void clickLink(String linkText, String logStep) {
		lastAction = "Click Link: " + linkText;
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		WebElement elm = waitForClickable(By.linkText(linkText));
		elm.click();
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
	}

	/**
	 * @param locator
	 * @return
	 */

	public String getElementText(By locator, String logStep) {
		lastAction = "Get Element text: " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		WebElement elm = waitForClickable(locator);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return elm.getText().trim();
	}

	public String getImageTitle(By locator) {
		WebElement elm = waitForVisible(locator);
		return elm.getAttribute("title");
	}

	/**
	 * @param locator
	 * @return
	 */
	public boolean isWebElementVisible(By locator, String logStep) {
		try {
			lastAction = "Check Element visible: " + locator.toString();
			// logUtil.infoLog(KeywordUtil.class, lastAction);
			WebElement elm = waitForVisible(locator);
			ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
			return elm.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isWebElementEnable(By locator, String logStep) {
		lastAction = "Check Element visible: " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		WebElement elm = waitForVisible(locator);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return elm.isEnabled();
	}

	/**
	 * @param locator
	 * @return
	 */
	public List<WebElement> getListElements(By locator, String logStep) {
		lastAction = "Get List of Elements: " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		try {
			findWithFluentWait(locator, 60, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return getDriver().findElements(locator);
	}

	public boolean isWebElementNotPresent(By locator) {
		lastAction = "Check Element not present: " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		List<WebElement> elements = (new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		if (elements.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean isWebElementPresent(By locator) {
		lastAction = "Check Element present: " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		List<WebElement> elements = getDriver().findElements(locator);
		if (elements.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean hoverOnElement(By by, String logStep) {
		WebElement element = getDriver().findElement(by);
		Actions act = new Actions(getDriver());
		act.moveToElement(element).click().build().perform();
		pause(3000);
		ExtTest.getTest().log(LogStatus.INFO, report.passStringGreenColor(logStep));
		return true;
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public void inputText(By locator, String data, String logStep) {
		lastAction = "Input Text: " + data + " - " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		WebElement elm = waitForVisible(locator);
		elm.clear();
		elm.sendKeys(data);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
	}

	public void inputText(WebElement elm, String data, String logStep) {
		elm.clear();
		elm.sendKeys(data);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
	}

	public void pressTabKey(By locator) {
		WebElement elm = waitForVisible(locator);
		elm.sendKeys(Keys.TAB);
	}

	public void pressEnter(By locator) {
		WebElement elm = waitForVisible(locator);
		elm.sendKeys(Keys.ENTER);
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public void highlightelementJS(By locator, String logStep) {
		WebElement element = waitForClickable(locator);
		((JavascriptExecutor) getDriver()).executeScript(
				"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
	}

	public void inputTextJS(By locator, String data, String logStep) {
		lastAction = "Input Text: " + data + " - " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		WebElement element = waitForVisible(locator);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].value = arguments[1]", element, data);
		if (element.getText().equalsIgnoreCase(data)) {
			ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		}
	}

	/**
	 * @param locator
	 * @return
	 */
	public boolean isRadioSelected(By locator, String logStep) {
		lastAction = "Is Radio Selected: " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		WebElement element = waitForVisible(locator);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return element.isSelected();
	}

	/**
	 * @param locator
	 * @return
	 */
	public boolean isRadioNotSelected(By locator, String logStep) {
		lastAction = "Is Radio Not Selected: " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		boolean check = isRadioSelected(locator, logStep);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return (!check);
	}

	/**
	 * @param locator
	 * @return
	 */
	public boolean clearInput(By locator) {
		WebElement element = waitForVisible(locator);
		element.clear();
		element = waitForVisible(locator);
		return element.getAttribute(VALUE).isEmpty();
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public boolean verifyCssProperty(By locator, String data, String logStep) {
		lastAction = "Verify CSS : " + data + " - " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);

		String[] property = data.split(":", 2);
		String expProp = property[0];
		String expValue = property[1];
		boolean flag = false;
		String prop = (waitForPresent(locator)).getCssValue(expProp);
		if (prop.trim().equals(expValue.trim())) {
			flag = true;
			ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
			return flag;
		} else {
			return flag;
		}
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public boolean verifyInputText(By locator, String data, String logStep) {
		lastAction = "Verify Input Expected Text: " + data + " - " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		WebElement element = waitForVisible(locator);
		String actual = element.getAttribute(VALUE);
		// logUtil.infoLog(KeywordUtil.class, "Actual:" + actual);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return actual.equalsIgnoreCase(data);
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public boolean verifyInputTextJS(By locator, String data, String logStep) {
		lastAction = "Verify Input Expected Text: " + data + " - " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		WebElement element = waitForVisible(locator);

		String message = String.format("Verified text expected \"%s\" actual \"%s\" ", data, element.getText());
		// logUtil.infoLog(KeywordUtil.class, message);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return data.equalsIgnoreCase(element.getText());
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public boolean verifyText(By locator, String data, String logStep) {
		lastAction = "Verify Expected Text: " + data + " - " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		WebElement element = waitForVisible(locator);
		String message = String.format("Verified text expected \"%s\" actual \"%s\" ", data, element.getText());
		// logUtil.infoLog(KeywordUtil.class, message);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return element.getText().equalsIgnoreCase(data);
	}

	public boolean verifyTextContains(By locator, String data, String logStep) {
		lastAction = "Verify Text Contains: " + data + " - " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		WebElement element = waitForVisible(locator);
		String message = new String(
				String.format("Verified text expected \"%s\" actual \"%s\" ", data, element.getText()));
		// logUtil.infoLog(KeywordUtil.class, message);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return element.getText().toUpperCase().contains(data.toUpperCase());
	}

	/**
	 * @param locator
	 * @return
	 */
	public boolean verifyDisplayAndEnable(By locator, String logStep) {
		lastAction = "Is Element Displayed and Enable : " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		WebElement element = waitForVisible(locator);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return element.isDisplayed() && element.isEnabled();
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public boolean clickJS(By locator, String logStep) {
		lastAction = "Click : " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		WebElement element = waitForVisible(locator);
		Object obj = ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return obj == null;
	}

	/**
	 * @param locator
	 * @param index
	 * @return
	 */
	public void selectByIndex(By locator, int index, String logStep) {
		lastAction = "Select dropdown by index : " + index + " - " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		Select sel = new Select(getDriver().findElement(locator));
		sel.selectByIndex(index);
		sel = new Select(getDriver().findElement(locator));
		if (sel.getFirstSelectedOption().isDisplayed()) {
			ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		}
	}

	/**
	 * @param locator
	 * @param value
	 * @return
	 */
	public void selectByValue(By locator, String value, String logStep) {
		lastAction = "Select dropdown by value : " + value + " - " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		Select sel = new Select(getDriver().findElement(locator));
		sel.selectByValue(value);

		// Check whether element is selected or not
		sel = new Select(getDriver().findElement(locator));
		if (sel.getFirstSelectedOption().isDisplayed()) {
			ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		}
	}

	/**
	 * @param locator
	 * @param value
	 * @return
	 */
	public void selectByVisibleText(By locator, String value, String logStep) {
		try {
			lastAction = "Select dropdown by text : " + value + " - " + locator.toString();
			// logUtil.infoLog(KeywordUtil.class, lastAction);
			Select sel = new Select(getDriver().findElement(locator));
			sel.selectByVisibleText(value);
			ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifyAllValuesOfDropDown(By locator, String data, String logStep) throws Throwable {
		lastAction = "Verify Dropdown all values: " + data + " - " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		boolean flag = false;
		WebElement element = findWithFluentWait(locator);
		List<WebElement> options = element.findElements(By.tagName("option"));
		String[] allElements = data.split(",");
		String actual;
		for (int i = 0; i < allElements.length; i++) {
			// logUtil.infoLog(KeywordUtil.class, options.get(i).getText());
			// logUtil.infoLog(KeywordUtil.class, allElements[i].trim());

			actual = options.get(i).getText().trim();
			if (actual.equalsIgnoreCase(allElements[i].trim())) {
				ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 */
	public boolean verifyDropdownSelectedValue(By locator, String data, String logStep) {
		lastAction = "Verify Dropdown selected option: " + data + " - " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		Select sel = new Select(waitForVisible(locator));
		String defSelectedVal = sel.getFirstSelectedOption().getText();
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
		return defSelectedVal.trim().equals(data.trim());
	}

	/**
	 * @param locator
	 * @param size
	 * @return
	 */
	public boolean verifyElementSize(By locator, int size, String logStep) {
		lastAction = "Verify Element size: " + size + " - " + locator.toString();
		// logUtil.infoLog(KeywordUtil.class, lastAction);
		List<WebElement> elements = getDriver().findElements(locator);
		if (elements.size() == size) {
			// logUtil.infoLog(KeywordUtil.class, "Element is Present " + size + "times");
			ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
			return true;
		} else {
			// logUtil.infoLog(KeywordUtil.class, "Element is not Present with required
			// size");
			// logUtil.infoLog(KeywordUtil.class, "Expected size:" + size + " but actual
			// size: " + elements.size());
			return false;
		}
	}

	/**
	 * @param locator
	 * @param data
	 * @return
	 * @throws InterruptedException
	 */
	public void writeInInputCharByChar(By locator, String data, String logStep) {
		WebElement element = waitForVisible(locator);
		element.clear();
		String[] b = data.split("");
		for (int i = 0; i < b.length; i++) {
			element.sendKeys(b[i]);
			pause(250);
		}
		ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
	}

	public String getElementInfo(By locator) {
		return " Locator: " + locator.toString();
	}

	public String getElementInfo(WebElement element) {
		String webElementInfo = "";
		webElementInfo = webElementInfo + "Tag Name: " + element.getTagName() + ", Locator: ["
				+ element.toString().substring(element.toString().indexOf("->") + 2);
		return webElementInfo;
	}

	/**
	 * @param locator
	 * @return
	 */
	public boolean verifyCurrentDateInput(By locator, String logStep) {
		boolean flag = false;
		WebElement element = waitForVisible(locator);
		String actual = element.getAttribute(VALUE).trim();
		DateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		dtFormat.setTimeZone(TimeZone.getTimeZone("US/Central"));
		String expected = dtFormat.format(date).trim();
		if (actual.trim().contains(expected)) {
			ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
			flag = true;
		}
		return flag;
	}

	public boolean delDirectory() {
		File delDestination = new File(System.getProperty(userDir) + "/src/test/resources/downloadFile");
		if (delDestination.exists()) {
			File[] files = delDestination.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					delDirectory();
				} else {
					files[i].delete();
				}
			}
		}
		return delDestination.delete();
	}

	public boolean doubleClick(By locator, String logStep) {
		boolean result = false;
		try {
			lastAction = "Double click: " + locator.toString();
			// logUtil.infoLog(KeywordUtil.class, lastAction);
			WebElement element = getDriver().findElement(locator);
			Actions action = new Actions(getDriver()).doubleClick(element);
			action.build().perform();
			ExtTest.getTest().log(LogStatus.PASS, report.passStringGreenColor(logStep));
			result = true;
		} catch (StaleElementReferenceException e) {
			// logUtil.infoLog("DoubleClick",locator.toString() + " - Element is not
			// attached to the page document " + e.getStackTrace());
			result = false;
		} catch (NoSuchElementException e) {
			// logUtil.infoLog("DoubleClick",locator.toString() + " - Element is not
			// attached to the page document " + e.getStackTrace());
			result = false;
		} catch (Exception e) {
			// logUtil.infoLog("DoubleClick",locator.toString() + " - Element is not
			// attached to the page document " + e.getStackTrace());
			result = false;
		}
		return result;
	}

	public boolean switchToFrame(String frameName) {
		try {
			Thread.sleep(5000);
			getDriver().switchTo().frame(frameName);
			return true;
		} catch (Exception e) {
			// logUtil.infoLog("switchToFrame", frameName + " TO FRAME FAILED" +
			// e.getStackTrace());
			return false;
		}
	}

	public void switchToWindow(String windowName) {
		try {
			getDriver().switchTo().window(getDriver().getTitle());
		} catch (Exception e) {
			// logUtil.infoLog("switchFrameToBack", windowName + " TO FRAME FAILED" +
			// e.getStackTrace());
		}
	}

	public void switchFrameToBack() {
		try {
			getDriver().switchTo().defaultContent();
		} catch (Exception e) {
			// logUtil.infoLog("switchFrameToBack", " TO FRAME FAILED" + e.getStackTrace());
		}
	}

	public void waitForPageToLoad() {
		try {
			String pageLoadStatus = "";
			do {
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				pageLoadStatus = (String) js.executeScript("return document.readyState");
				System.out.print(".");
			} while (!pageLoadStatus.equals("complete"));
		} catch (Exception e) {
			// logUtil.infoLog("Page load", " to load the page" + e.getStackTrace());
		}
	}

	public String getAttribute(String attributeType, By locator) {
		String text = "";
		switch (attributeType) {
		case "value":
			text = getDriver().findElement(locator).getAttribute("value");
			break;

		case "innerText":
			text = getDriver().findElement(locator).getAttribute("innerText");
			break;

		case "textContent":
			text = getDriver().findElement(locator).getAttribute("textContent");
			break;
		}
		return text;
	}

	public String generateRandomEmail() {
		String emailBody = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder emailFL = new StringBuilder();
		Random rnd = new Random();
		while (emailFL.length() < 6) {
			int index = (int) (rnd.nextFloat() * emailBody.length());
			emailFL.append(emailBody.charAt(index));
		}
		String email = "autoTest" + emailFL.toString() + "@g.com";
		return email;
	}

	public void switchToNewWindow() {
		String window = "";
		java.util.Set<String> handles = getDriver().getWindowHandles();
		Iterator<String> ite = handles.iterator();
		while (ite.hasNext()) {
			window = (String) ite.next();
			System.out.println(window);
		}
		switchToWindow(window);
	}
}