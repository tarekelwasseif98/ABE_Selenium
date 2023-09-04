package listeners;

//import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//import utils.ScreenshotUtils;

public class Listeners implements ITestListener {
	int steps = 0;
	public void onTestStart(ITestResult result) {  
	// TODO Auto-generated method stub  
	}  
	  
	public void onTestSuccess(ITestResult result) {  
	// TODO Auto-generated method stub
//		ITestContext context = result.getTestContext();
//		WebDriver driver = (WebDriver)context.getAttribute("WebDriver");
//	steps++;
	System.out.println("Success of test cases and its details are : "+result.getInstance());  
	}  
	  
	  
	public void onTestFailure(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	  
	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	  
	  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	  
	public void onStart(ITestContext context) {  
	// TODO Auto-generated method stub  
	}  
	  
	  
	public void onFinish(ITestContext context) {  
	// TODO Auto-generated method stub  
	}  
}
