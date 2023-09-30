package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//declaration
    @FindBy(id = "username")
    private WebElement Untbx;
    
    @FindBy(name = "pwd")
    private WebElement Pwtbx;
    
    @FindBy(xpath = "//div[.='Login ']")
    private WebElement lgbtn;
    
    //initialization
    public LoginPage(WebDriver d)
    {
    	PageFactory.initElements(d, this);
    }

    //utilization
    //Go to Source --> Generate Getters and Setters --> Select Getters --> Generate
	public WebElement getUntbx() {
		return Untbx;
	}

	public WebElement getPwtbx() {
		return Pwtbx;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}

}
