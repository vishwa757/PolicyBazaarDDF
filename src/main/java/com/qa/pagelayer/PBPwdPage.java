package com.qa.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.Testbase;

public class PBPwdPage extends Testbase
{
	
	public PBPwdPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='password']") private WebElement pwd;
	@FindBy(xpath = "//span[text()='Sign in']")private WebElement signIn;
	
	
	public void inpPBPwdPagePWD(String password) 
	{
		pwd.sendKeys(password);
	}
	
	public void clickPBPwdPageSignIn()
	{
		signIn.click();
	}

}
