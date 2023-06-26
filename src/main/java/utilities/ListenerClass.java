package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.testbase.Testbase;

public class ListenerClass extends Testbase implements ITestListener
{
	ExtentSparkReporter spark;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		spark = new ExtentSparkReporter("ExtentReportPB");
		reports = new ExtentReports();
		reports.attachReporter(spark);
		
		reports.setSystemInfo("Machine", "Dell");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("username", "vishwa");
		
		spark.config().setDocumentTitle("Extent Listener Report");
		spark.config().setReportName("my first report");
		spark.config().setTheme(Theme.STANDARD);
	}
	@Override
	public void onTestStart(ITestResult result) 
	{
		configureReport();
		System.out.println("Test execution started....");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println(result.getName() + " this test case is passed");
		
		test = reports.createTest(result.getName());
		
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case :"+ result.getName(), ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println(result.getName() + " this test case is failed");
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case :"+ result.getName(), ExtentColor.RED));
	
		UtilClass.takeSS(result.getName());
		System.out.println("Screenshot captured");
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println(result.getName() + " this test case is passed");
		
		test = reports.createTest(result.getName());
		
		test.log(Status.SKIP, MarkupHelper.createLabel("NAme of the skipped test case :"+ result.getName(), ExtentColor.ORANGE));
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("Ececution completed");
		reports.flush();
	}

	@Override
	public int hashCode() 
	{
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}
