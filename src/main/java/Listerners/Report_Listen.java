package Listerners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Report.Reports;

public class Report_Listen implements ITestListener {

	// This report object is the single shared Extent Report instance
	// used by both TestNG flow and Cucumber flow.
	public static final ExtentReports report = new Reports().Get_reports();

	// This ThreadLocal is storing current running ExtentTest thread wise.
	// If parallel execution happens, each thread gets its own separate test node.
	public static final ThreadLocal<ExtentTest> log_report = new ThreadLocal<ExtentTest>();

	// This method is used from anywhere in framework where logging is needed like:
	// Report_Listen.log_print_in_report().log(Status.INFO, "message");
	public static ExtentTest log_print_in_report() {

		return log_report.get();
	}

	@Override
	public void onTestStart(ITestResult result) {

		// Fetching current executing TestNG method name
		String Test_Method_name = result.getMethod().getMethodName();

		// IMPORTANT:
		// When Cucumber runs through AbstractTestNGCucumberTests,
		// TestNG internally triggers a wrapper method named "runScenario".
		//
		// If we create Extent report node for that wrapper also,
		// report will show an extra unwanted "runScenario" entry.
		//
		// So for "runScenario", we skip report creation here.
		// Real scenario node will be created separately from Base_cucumber
		// using cucumber_test_initializer(scenarioName).
		if (Test_Method_name.equals("runScenario")) {
			return;
		}

		// Normal TestNG flow:
		// create report node using actual TestNG method name
		log_report.set(report.createTest(Test_Method_name));
	}

	// This method is specially created for Cucumber execution path.
	// Base_cucumber calls this in @Before using current scenario name.
	public static void cucumber_test_initializer(String scenarioName) {

		log_report.set(report.createTest(scenarioName));
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		// Logging PASS status in current report node
		log_report.get().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		// Logging FAILURE status and throwable details in current report node
		log_report.get().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		// Logging SKIPPED status in current report node
		log_report.get().log(Status.SKIP, "Test skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {

		// Once execution finishes, flush the report
		report.flush();

		// Clean current thread's report object after execution ends
		log_report.remove();
	}

	// Helper method for Cucumber AfterAll if needed
	public static void cucumber_report_flush() {

		report.flush();
	}
}