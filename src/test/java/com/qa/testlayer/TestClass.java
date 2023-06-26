package com.qa.testlayer;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pagelayer.PBHomePage;
import com.qa.pagelayer.PBMobnoPage;
import com.qa.pagelayer.PBMyAccPage;
import com.qa.pagelayer.PBProfilePage;
import com.qa.pagelayer.PBPwdPage;
import com.qa.pagelayer.PBSigninPage;
import com.qa.testbase.Testbase;

import utilities.UtilClass;

public class TestClass extends Testbase
{
	
	
		
		@BeforeMethod
		public void login() throws InterruptedException, IOException
		{
			PBSigninPage signin = new PBSigninPage(driver);
			signin.clickPBLoginPageSignIN();
			
			PBMobnoPage mob = new PBMobnoPage(driver);
			mob.inpPBMobNumPageMobNum(UtilClass.getPFData("mob"));
			Thread.sleep(1000);
			mob.clickPBMobNumPageSignInWithPwd();
			
			PBPwdPage pwd = new PBPwdPage(driver);
			pwd.inpPBPwdPagePWD(UtilClass.getPFData("password"));
			pwd.clickPBPwdPageSignIn();
			Thread.sleep(1000);
			
		}
		
		@Test
		public void mouseOver() throws InterruptedException, EncryptedDocumentException, IOException
		{
			PBHomePage home = new PBHomePage(driver);
			home.openDDOptionPBHomePageMyAcc();
			
			Thread.sleep(1000);
			
			PBMyAccPage ac = new PBMyAccPage(driver);
			ac.clickPBMyAccPageMyProfile();
			
			Thread.sleep(8000);
			
			
			PBProfilePage profile = new PBProfilePage(driver);
			profile.switchToSwitchChildWindow();
			String actualName = profile.getPBProfilePageFullName();
			String expectedName = UtilClass.getData(0, 2);
			
			Assert.assertEquals(actualName,expectedName , "Failed: both names are diff- ");
			
		
		}
		
		@AfterMethod
		public void name() 
		{
			
			
		}
}
