package com.qa.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.Testbase;

public class PBMobnoPage extends Testbase
{
	
	public PBMobnoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@id='central-login-module-sign-mobile'])[2]") private WebElement mobNum;
	@FindBy(xpath="(//span[text()='Sign in with Password'])[2]") private WebElement signInWithPwd;
	
	
	public void inpPBMobNumPageMobNum(String mobileNum)
	{
		mobNum.sendKeys(mobileNum);
	}
	
	public void clickPBMobNumPageSignInWithPwd() 
	{
		signInWithPwd.click();
	}
	
	
}
