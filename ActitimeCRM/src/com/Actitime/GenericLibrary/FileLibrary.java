package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains Generic Methods for read the Data from Property file and Excel sheet.
 * @author Roshan(Bunty)
 *
 */
public class FileLibrary 
{
	/**
	 * This Method is Generic Method which is used to read Data from Property file.
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	
	public String ReadDataFromPropertyFile(String Key) throws IOException
	{
		FileInputStream f=new FileInputStream("./Test Data/CommonData.property");
		Properties p=new Properties();
		p.load(f);
		String value = p.getProperty(Key);
		return value;
	}
	
	/**
	 * This Method is Generic Method which is used to read Data from Excel sheet.
	 * @param Sheet
	 * @param Row
	 * @param Cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
    public String ReadDataFromExcelSheet(String Sheet,int Row,int Cell) throws EncryptedDocumentException, IOException
    {
    	FileInputStream f=new FileInputStream("./Test Data/BankingInfo.xlsx");
    	Workbook wb = WorkbookFactory.create(f);
    	String Data = wb.getSheet(Sheet).getRow(Row).getCell(Cell).getStringCellValue();
    	return Data;
    }
}
