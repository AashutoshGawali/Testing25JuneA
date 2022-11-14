package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.CaptureScreenShots;
import Utility.ReadData;


public class InventoryPageTest extends TestBase {
	LoginPage login;
	InventoryPage invent;
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login= new LoginPage();
		login.verifyLoginByUrl();
		invent= new InventoryPage();
	}
	@Test
	public void verifyUrlTest() throws Exception
	{
		String expResult=invent.verifyUrl();
		Assert.assertEquals(expResult,ReadData.readExcelSheet(6, 1));		
	}
	@Test
	public void verifyAddProductTest() throws Exception
	{
	
	    Thread.sleep(2000);
		String expResult=invent.verifyAddProduct();
		Assert.assertEquals(expResult, ReadData.readExcelSheet(6, 2));
	}
	
	@Test
	public void verifyRemoveProductTest() throws Exception
	{
		String expResult=invent.verifyRemoveProduct();
		Assert.assertEquals(expResult, ReadData.readExcelSheet(6, 3));
	}
    @AfterMethod
    public void close(ITestResult it) throws Exception
    {
    	if(ITestResult.FAILURE==it.getStatus())
    	{
    		CaptureScreenShots.captureScreenShot(it.getName());
    	}
    	driver.close();
    }
}