package com.qa.pagelayer;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.Testbase;

public class PBProfilePage extends Testbase
{
	WebDriver driver1;
	public  PBProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		driver1=driver;
	}
	
	@FindBy(xpath = "//input[@name='personName']") private WebElement fullName;
	
	public void switchToSwitchChildWindow()
	{
		Set<String> allIds = driver1.getWindowHandles();
		ArrayList<String> al=new ArrayList<String>(allIds);
		driver1.switchTo().window(al.get(1));
	}
	
	public String getPBProfilePageFullName() 
	{
		String actFullName = fullName.getAttribute("value");
		return actFullName;
	}
}
