package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

/**
 * This class will get date and time and it will rename the file with date and
 * time
 *
 */
public class GlobalUtil {

	private static CommonSettings commonSettings = new CommonSettings();
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static int totalSuites = 0;
	private static boolean suitesRunStarted = false;
	private static int lastRunId = 0;
	private static Exception testException;
	private static String currentBrowser;
	private static String currentSuiteName;
	private static String currentUserEmail;
	private static String currentUserType;
	static String currentUserFirstName;
	static String currentUserLastName;
	public String currentUserFullName;
	public Map<String, String> propertyCurrentRecord = new HashMap<>();
	public HashMap<String, String> propertyDeletedRecord = new HashMap<>();
	public HashMap<String, String> updatesScheduleRecord = new HashMap<>();
	public HashMap<String, String> propertyRestoredRecord = new HashMap<>();
	public ArrayList<String> listOfClients = new ArrayList<>();
	public ArrayList<String> listOfProperties = new ArrayList<>();
	public HashMap<String, String> client = new HashMap<>();
	static String clientFullName = "FullName";
	static String clientEmail = "Email";
	public String result_FolderName = System.getProperty("user.dir") + "/target/cucumber-html-report";

	public String ErrorMsg;
	public Throwable e;
	public final String PROPERTYADDRESSKEY = "Address";
	public final String PROPERTYDATETIMEKEY = "DateTime";
	public final String PROPERTYCLIENTKEY = "Client";
	public final String PROPERTYAGENTKEY = "Agent";
	public final String PROPERTYNOTEKEY = "Note";
	public HashMap<String, String> dataMap;
	//public final LogUtil logUtil = new LogUtil();
	public final ConfigReader config = new ConfigReader();

	/**
	 * Get date and time stamp
	 */

	public String getDateTime() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateOfExecution = dateFormat.format(date);
		return dateOfExecution;
	}

	/**
	 * Update filename with time stamp
	 */
	public void renameFile() {

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
		String timeStamp = dateFormat.format(date);
		try {
			File oldFile = new File(System.getProperty("user.dir") + config.getValue("testResultExcelPath"));
			String newFilePath = oldFile.getAbsolutePath().replace(oldFile.getName(), "") + "/ReportHistory/"
					+ timeStamp + "-TestResult.xlsx";
			File newFile = new File(newFilePath);
			FileUtils.copyFile(oldFile, newFile);
			//logUtil.infoLog(GlobalUtil.class, "History File created successfully");
		} catch (IOException e) {
		//	logUtil.errorLog(GlobalUtil.class, "Exception caught", e);
		}
	}

	public CommonSettings getCommonSettings() {
		return commonSettings;
	}

	/**
	 * @param commonSettings
	 */
	public void setCommonSettings(CommonSettings commonSettings) {
		GlobalUtil.commonSettings = commonSettings;
	}

	public int getTotalSuites() {
		return totalSuites;
	}

	/**
	 * @param totalSuites
	 */
	public void setTotalSuites(int totalSuites) {
		GlobalUtil.totalSuites = totalSuites;
	}

	public boolean isSuitesRunStarted() {
		return suitesRunStarted;
	}

	/**
	 * @param suitesRunStarted
	 */
	public void setSuitesRunStarted(boolean suitesRunStarted) {
		GlobalUtil.suitesRunStarted = suitesRunStarted;
	}

	public int getLastRunId() {
		return lastRunId;
	}

	/**
	 * @param lastRunId
	 */
	public void setLastRunId(int lastRunId) {
		GlobalUtil.lastRunId = lastRunId;
	}

	public Exception getTestException() {
		return testException;
	}

	/**
	 * @param testException
	 */
	public void setTestException(Exception testException) {
		GlobalUtil.testException = testException;
	}

	/**
	 * @return the currentBrowser
	 */
	public String getCurrentBrowser() {
		return currentBrowser;
	}

	/**
	 * @param currentBrowser
	 *            the currentBrowser to set
	 */
	public void setCurrentBrowser(String currentBrowser) {
		GlobalUtil.currentBrowser = currentBrowser;
	}

	/**
	 * @return the currentSuiteName
	 */
	public String getCurrentSuiteName() {
		return currentSuiteName;
	}

	/**
	 * @param currentSuiteName
	 *            the currentSuiteName to set
	 */
	public void setCurrentSuiteName(String currentSuiteName) {
		GlobalUtil.currentSuiteName = currentSuiteName;
	}

	/**
	 * @return the currentUserEmail
	 */
	public String getCurrentUserEmail() {
		return currentUserEmail;
	}

	/**
	 * @param currentUserEmail
	 *            the currentUserEmail to set
	 */
	public void setCurrentUserEmail(String currentUserEmail) {
		GlobalUtil.currentUserEmail = currentUserEmail;
	}

	/**
	 * @return the currentUserType
	 */
	public String getCurrentUserType() {
		return currentUserType;
	}

	/**
	 * @param currentUserType
	 *            the currentUserType to set
	 */
	public void setCurrentUserType(String currentUserType) {
		GlobalUtil.currentUserType = currentUserType;
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public WebDriver getTitle(String window) {
		getDriver().getTitle();
		return driver.get();

	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver(WebDriver driver) {
		GlobalUtil.driver.set(driver);
	}

	public String createZipFile() throws IOException {
		result_FolderName = result_FolderName.replace("\\", "/");
		String outputFile = result_FolderName + ".zip";
		FileOutputStream fos = new FileOutputStream(outputFile);
		ZipOutputStream zos = new ZipOutputStream(fos);
		packCurrentDirectoryContents(result_FolderName, zos);
		zos.closeEntry();
		zos.close();
		fos.close();
		return outputFile;
	}

	public void packCurrentDirectoryContents(String directoryPath, ZipOutputStream zos) throws IOException {
		for (String dirElement : new File(directoryPath).list()) {
			String dirElementPath = directoryPath + "/" + dirElement;
			if (new File(dirElementPath).isDirectory()) {
				packCurrentDirectoryContents(dirElementPath, zos);
			} else {
				ZipEntry ze = new ZipEntry(dirElementPath.replaceAll(result_FolderName + "/", ""));
				zos.putNextEntry(ze);
				FileInputStream fis = new FileInputStream(dirElementPath);
				byte[] bytesRead = new byte[512];

				int bytesNum;
				while ((bytesNum = fis.read(bytesRead)) > 0) {
					zos.write(bytesRead, 0, bytesNum);
				}
				fis.close();
			}
		}
	}
}