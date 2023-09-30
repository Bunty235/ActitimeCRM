package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Actitime.pom.LoginPage;

public class BaseClass 
{
	public WebDriver d;
	FileLibrary dd=new FileLibrary();
	
	@BeforeSuite
	public void ConnectToDatabase()
	{
		Reporter.log("Database Connected",true);
	}
    @AfterSuite
    public void DisconnectToDatabase()
    {
    	Reporter.log("Database Disconnected",true);
    }
    @BeforeTest
    public void LaunchTheBrowser() throws IOException
    {
    	d=new ChromeDriver();
    	d.manage().window().maximize();
    	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	String Url = dd.ReadDataFromPropertyFile("url");
		d.get(Url);
    	Reporter.log("Browser Launched",true);
    }
    @AfterTest
    public void CloseTheBrowser()
    {
    	d.close();
    	Reporter.log("Closw Browser",true);
    }
    @BeforeMethod
    public void LoginToApplication() throws IOException
    {
    	LoginPage lp=new LoginPage(d);
		String UN = dd.ReadDataFromPropertyFile("username");
		lp.getUntbx().sendKeys(UN);
		String PW = dd.ReadDataFromPropertyFile("password");
		lp.getPwtbx().sendKeys(PW);
		lp.getLgbtn().click();
    	Reporter.log("Login Successfully",true);
    }
    @AfterMethod
    public void LogoutFromApplication()
    {
    	d.findElement(By.id("logoutLink")).click();
    	Reporter.log("Logout Successfully",true);
    }
}
