package utils;

import java.net.MalformedURLException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

	public class WebdriverFactory {
		public static WebDriver initiateWebDriver() throws MalformedURLException {
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			ChromeOptions options = new ChromeOptions();
			WebDriver driver = new RemoteWebDriver(new URL(Properties.HubUrl), options);
			options.merge(cap);
			options.addArguments("--proxy-server='direct://'");
			options.addArguments("--proxy-bypass-list=*");
 	        driver.manage().window().maximize();
			options.addArguments("--dissable-gpu");
			options.setHeadless(true);
			return driver;
		}
	}