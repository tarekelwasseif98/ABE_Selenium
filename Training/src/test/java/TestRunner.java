import java.util.Arrays;

import org.testng.TestNG;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestSuites(Arrays.asList("Batch1_CorporateLoans_MurabahaFinancing.xml"));
        testng.setSuiteThreadPoolSize(2);
        testng.run();
    }
}