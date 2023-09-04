package utils;

import org.testng.AssertJUnit;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;

public class AssertionFactory {
	private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private static final String nameTimeStamp = sdf3.format(timestamp);
	public static void assertTrue(WebDriver driver, boolean boolValue, String result) throws Exception {
		AssertJUnit.assertEquals(true, boolValue);
		System.err.println("Assertion Class: " + result);
		File file = new File("C://local//Run" + nameTimeStamp + "_" + result);
		file.mkdirs();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String timeStampString = sdf3.format(timestamp);
		String fileWithPath = "C://local//Run" + nameTimeStamp + "_" + result + "//" + timeStampString + "_" + result + ".png";
		ScreenshotUtils.takeSnapShot(driver, fileWithPath);
	}
}