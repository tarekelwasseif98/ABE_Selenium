package utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenshotUtils {
	  public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        File srcFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);

	        //Call getScreenshotAs method to create image file

//	                File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(fileWithPath);

	                //Copy file at destination

	                Files.copy(srcFile, DestFile);

	    }

}
