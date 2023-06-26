package utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.Testbase;

public class UtilClass extends Testbase
{
	public UtilClass()
	{
		
		PageFactory.initElements(driver, this);
	}
	

	public static String getData(int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\kavya\\Desktop\\Sanjay_sir_javaRevision\\Book1.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		
		String value = sh.getRow(0).getCell(cell).getStringCellValue();
		
		return value;
	}
	
	public static String getPFData(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\kavya\\eclipse-workspace\\PolicyBazaarDDF_Utility\\PropertyFile.properties");
		Properties p = new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		
		return value;
	}
	
	
	
	public static void takeSS(String filename)
	{
		String path = "C:\\Users\\kavya\\eclipse-workspace\\PolicyBazaarDDF_Utility\\src\\FailedTCSS";
		try 
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(path+filename+".png");
			FileHandler.copy(src, des);
			
		}
		catch(IOException e)
		{
			System.out.println("File path is wrong");

		
		}	
	}
}
