package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {

	
public ExtentReports Get_reports(){
		
		
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "//Report_folder//report.html");
		
		spark.config().setReportName("Lumberjack");
		spark.config().setDocumentTitle("Automation Report Document");
		spark.config().setTheme(Theme.DARK); // Options: STANDARD / DARK
        spark.config().setEncoding("UTF-8");
        spark.config().setTimelineEnabled(true); // Adds execution timeline bar
        spark.config().setCss(".badge { font-size: 12px; padding: 4px; }");
		ExtentReports report = new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("Automated By", "Ayan Sengupta");
		report.setSystemInfo("Framework", "Selenium + TestNG");
		report.setSystemInfo("Report Type", "Extent Spark HTML");
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));
		return report;
		
		
	}
	
	
	
	
	
}
