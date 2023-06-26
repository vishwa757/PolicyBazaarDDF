package com.qa.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.Testbase;

public class PBMyAccPage extends Testbase
{
	
	public PBMyAccPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()=' My profile ']") private WebElement myProfile;
	
	public void clickPBMyAccPageMyProfile() 
	{
		myProfile.click();
	}

}
