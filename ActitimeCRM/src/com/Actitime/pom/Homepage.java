package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	//declaration
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement TaskTab;
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement ReportsTab;
	@FindBy(xpath = "//div[.='Users']")
	private WebElement UsersTab;
	@FindBy(id = "logoutLink")
	private WebElement LogoutLink;
	
	//initialization
	public Homepage(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}

	//utilization
	public WebElement getTaskTab() {
		return TaskTab;
	}

	public WebElement getReportsTab() {
		return ReportsTab;
	}

	public WebElement getUsersTab() {
		return UsersTab;
	}

	public WebElement getLogoutLink() {
		return LogoutLink;
	}
}
