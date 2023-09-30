package com.Actitime.TestScripts;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.GenericLibrary.ListenerImplementation;
import com.Actitime.pom.Homepage;
import com.Actitime.pom.TaskTab;
@Listeners(ListenerImplementation.class)
public class CreateCustomer extends BaseClass
{
	@Test
	public void CreateCust() throws EncryptedDocumentException, IOException
	{
		Homepage hp=new Homepage(d);
		hp.getTaskTab().click();
		TaskTab tt=new TaskTab(d);
		tt.getAddNewCustomer().click();
		tt.getNewCustomer().click();
		FileLibrary f=new FileLibrary();
		String name = f.ReadDataFromExcelSheet("Sheet1", 2, 1);
		tt.getCustomerName().sendKeys(name);
		String desc=f.ReadDataFromExcelSheet("Sheet1", 2, 2);
		tt.getCustomerDescription().sendKeys(desc);
		tt.getCreateCustomerBtn().click();
		
		String ExpectedResult = name;
		String ActualResult = d.findElement(By.xpath("(//div[.='"+name+"'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(ExpectedResult, ActualResult);
		s.assertAll();
	}
}
