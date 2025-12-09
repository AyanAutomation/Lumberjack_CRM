package Listerners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Report.Reports;

public class Report_Listen extends Reports implements ITestListener{
	
	
	ExtentReports report = Get_reports();
	public static final ThreadLocal<ExtentTest> log_report = new ThreadLocal<ExtentTest>();
	ExtentTest Test_result;
	
	public static ExtentTest log_print_in_report(){
		
		return log_report.get();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		String Test_Method_name = result.getMethod().getMethodName();
		 log_report.set(report.createTest(Test_Method_name));	  // Here Log_reader is storing the MEthod name and since
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		log_report.get().log(Status.PASS, "Test passed"); 
		/* Since createTest()(Log_reader also storing extent report) and method_Name has been Stored in "Log_reader" object on " onTestStart(ITestResult result)" 
		so in this Method execution no need to write it
		( Code :- "String method_Name = result.getMethod().getMethodName();" ) here again. */
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
       log_report.get().log(Status.FAIL, result.getThrowable());
		
		/* Since createTest()(Log_reader also storing extent report) and method_Name has been Stored in "Log_reader" object on " onTestStart(ITestResult result)" 
		so in this Method execution no need to write it
		( Code :- "String method_Name = result.getMethod().getMethodName();" ) here again. */
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		ITestListener.super.onTestSkipped(result);
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
	
		ITestListener.super.onFinish(context);
		report.flush();
	}
	
	
	
	
	
	

}
