package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskTab 
{
	//declaration
	@FindBy(xpath = "//div[.='Add New']")
	private WebElement AddNewCustomer;
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement NewCustomer;
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement CustomerName;
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement CustomerDescription;
	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement CreateCustomerBtn;
	@FindBy(xpath = "//div[@class='greyButton cancelBtn']")
	private WebElement CancelBtn;
	
	//initialization
	public TaskTab(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}

	//utilization
	public WebElement getAddNewCustomer() {
		return AddNewCustomer;
	}

	public WebElement getNewCustomer() {
		return NewCustomer;
	}

	public WebElement getCustomerName() {
		return CustomerName;
	}

	public WebElement getCustomerDescription() {
		return CustomerDescription;
	}

	public WebElement getCreateCustomerBtn() {
		return CreateCustomerBtn;
	}

	public WebElement getCancelBtn() {
		return CancelBtn;
	}
}
