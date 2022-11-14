package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Cart_Page;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.CaptureScreenShots;
import Utility.ReadData;

public class Cart_PageTest extends TestBase{
	Cart_Page cart;
	InventoryPage invt;
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		
		LoginPage login= new LoginPage();
		login.verifyLoginByUrl();
		cart= new Cart_Page();
		invt= new InventoryPage();
		
	}
	@Test(enabled= true)
	public void verifyCartPageTitleTest() throws Exception
	{
		invt.verifyAddProduct();
		String expeResult=cart.verifyCartPageTitle();
		Assert.assertEquals(expeResult, ReadData.readExcelSheet(10, 2));
	}
	@Test
	public void verifyCartPageUrlTitle() throws Exception
	{
		invt.verifyAddProduct();
		String expResult=cart.verifyCartPageUrl();
		Assert.assertEquals(expResult, ReadData.readExcelSheet(10, 0));
	}
	@Test(enabled= true)
	public void verifyRemovProductsTest() throws Exception
	{
		invt.verifyAddProduct();
		String expResult=cart.verifyRemovProducts();
		Assert.assertEquals(expResult, ReadData.readExcelSheet(10,1));
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
