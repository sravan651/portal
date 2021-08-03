package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HTMLReportUtil {

	static String html;

	public String testFailTakeScreenshot(String imagePath) {
		File src = ((TakesScreenshot) new GlobalUtil().getDriver()).getScreenshotAs(OutputType.FILE);
		File des = new File(imagePath);
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(des);
		return des.getAbsolutePath();
	}

	public String failStringRedColor(String stepName) {
		html = "<span style='color:red'><b>" + stepName + "</b></span>";
		return html;
	}

	public String passStringGreenColor(String stepName) {
		html = "<span style='color:#008000'><b>" + stepName + " - PASSED" + "</b></span>";
		return html;
	}

	public String passStringBlueColor(String stepName) {
		html = "<span style='color:#3F51B5'><b>" + stepName + " - PASSED" + "</b></span>";
		return html;
	}
}