package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Cart_Page;
import Pages.CheckOutInfoPage;
import Pages.LoginPage;
import Utility.CaptureScreenShots;
import Utility.ReadData;

public class CheckOutPageTest extends TestBase {
	LoginPage login;
	CheckOutInfoPage check;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login= new LoginPage();
		login.verifyLoginByUrl();
		Cart_Page cart= new Cart_Page();
		cart.verifyCartPageTitle();
		check= new CheckOutInfoPage();
	}
	
    @Test
     public void verifyTitleTest() throws Exception
   {
	 String expResult=check.verifyTitle();
	 Assert.assertEquals(expResult,ReadData.readExcelSheet(14, 0)); 
   }
    @Test
    public void checkContinueBotton() throws Exception
    {
    	String expResult=check.checkContinueBotton();
    	Assert.assertEquals(expResult,ReadData.readExcelSheet(18, 0));
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
