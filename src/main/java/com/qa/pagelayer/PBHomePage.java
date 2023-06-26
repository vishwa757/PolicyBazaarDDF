package com.qa.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.Testbase;

public class PBHomePage extends Testbase
{
	public PBHomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='My Account']") private WebElement myAcc;
	
	
	public void openDDOptionPBHomePageMyAcc() 
	{		
		myAcc.click();
	}

}
