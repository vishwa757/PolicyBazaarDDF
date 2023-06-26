package com.qa.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.Testbase;

public class PBSigninPage extends Testbase
{
	
	public PBSigninPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[text()='Sign in']") private WebElement signIN;
	
	public void clickPBLoginPageSignIN()
	{
		signIN.click();
	}	

}
