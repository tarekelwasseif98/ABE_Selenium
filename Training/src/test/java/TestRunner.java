import java.util.Arrays;

import org.testng.TestNG;

public class TestRunner {
	
	public static void executionListRunner(String executionList, int threadCount) {
        TestNG testng = new TestNG();
        testng.setTestSuites(Arrays.asList(executionList));
        testng.setSuiteThreadPoolSize(threadCount);
        testng.run();
	}
    public static void main(String[] args) {
    	//executionListRunner("Batch1_CorporateLoans_MurabahaFinancing.xml", 2);
    	executionListRunner("Batch1_MudarabahCASA_TUA", 2);
    }
}