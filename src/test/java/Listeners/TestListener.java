package Listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{
	
	private static final Logger logger = LogManager.getLogger(TestListener.class);
	
	public void onTestStart(ITestResult result) {
		logger.info("test started "+result.getMethod().getMethodName());
		
	    // not implemented
	  }

	 public void onTestSuccess(ITestResult result) {
		    // not implemented
		 logger.info("test passed "+result.getMethod().getMethodName());
		 logger.info("test description "+result.getMethod().getDescription());
		  }
	 public void onTestFailure(ITestResult result) {
		    // not implemented
		 logger.info("test failed "+result.getMethod().getMethodName());
		  }
	 public  void onTestSkipped(ITestResult result) {
		    // not implemented
		 logger.info("test skipped "+result.getMethod().getMethodName());
	  }
	 public void onStart(ITestContext context) {
		    // not implemented
		 logger.info("test suite started!!!");
	
	  }
	 public void onFinish(ITestContext context) {
		    // not implemented
		 logger.info("test suite completed!!!");
		  }

}
