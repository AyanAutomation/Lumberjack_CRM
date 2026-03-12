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
        spark.config().setCss("\n"
        		+ "            \".nav-wrapper { background: linear-gradient(90deg, #141e30, #243b55) !important; }\" +\n"
        		+ "            \".brand-logo { font-weight: 600 !important; font-size: 20px !important; }\" +\n"
        		+ "            \".card-panel, .test-content, .node { border-radius: 12px !important; }\" +\n"
        		+ "            \".badge { font-size: 11px !important; padding: 4px 8px !important; border-radius: 10px !important; }\" +\n"
        		+ "            \".test-name { font-weight: 600 !important; }\" +\n"
        		+ "            \".category-status { font-size: 12px !important; }\" +\n"
        		+ "            \".step-details { white-space: pre-wrap !important; line-height: 1.5 !important; }\" +\n"
        		+ "            \".timeline-card { border-radius: 12px !important; }\" +\n"
        		+ "            \"body { font-family: 'Segoe UI', sans-serif !important; }\"");
		ExtentReports report = new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("Automated By", "Ayan Sengupta");
		report.setSystemInfo("Framework", "Selenium + TestNG");
		report.setSystemInfo("Report Type", "Extent Spark HTML");
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));
		report.setSystemInfo("User", System.getProperty("user.name"));
		return report;
		
		
	}
	
	
	
	
	
}
