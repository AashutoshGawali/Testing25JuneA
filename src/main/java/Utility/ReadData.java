package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

	public static String readPropertyFile(String value) throws Exception
	{
		Properties pop=new Properties();
		FileInputStream file= new FileInputStream("C:\\Users\\com\\eclipse-workspace\\SauceLabFrame1\\TestData\\config.prorperty");
	    pop.load(file);
	    return pop.getProperty(value);
	}	
	
	public static String readExcelSheet(int rownum,int colnum) throws Exception
	{
		FileInputStream file= new FileInputStream("C:\\Users\\com\\eclipse-workspace\\SauceLabFrame1\\TestData\\Book10.xlsx");
		Sheet dest = WorkbookFactory.create(file).getSheet("Sheet1");
		String value=dest.getRow(rownum).getCell(colnum).getStringCellValue();
		return value;
		
	}
}
