package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Pages.LoginPage;
import Utility.CaptureScreenShots;
import Utility.ReadData;

public class FailedTestCases extends TestBase{

	LoginPage login;
	@BeforeMethod
	public void setup() throws Exception
	{
		 initialization();
		 login= new LoginPage();
	}
	
	@Test
	public void verifyAppTitleTest() throws Exception
	{ 
	    SoftAssert a= new SoftAssert();
		String expResult= LoginPage.verifyAppTitle();
		a.assertEquals(expResult, ReadData.readExcelSheet(2,0));
//		Assert.assertEquals(expResult,ReadData.readExcelSheet(2,0));
		System.out.println("Hiii");
		a.assertAll();
		
	}
	
	@Test(enabled=true,priority=0,timeOut=1000)
	public void verifyAppUrlTest() throws Exception
	{
		String expResult= LoginPage.verifyAppUrl();
		Assert.assertEquals(expResult,ReadData.readExcelSheet(2, 1));
	}
	
	@Test(enabled=true,priority=2)
	public void verifySwagLabsLogoTest()
	{
		boolean expResult= login.verifySwagLabsLogo();
		Assert.assertEquals(expResult,true);
	}
	@Test(enabled=true,priority=3)
	public void verifyBigLogoTest()
	{
		boolean expResult= login.verifyBigLogo();
		Assert.assertEquals(expResult,true);
	}
	@Test(enabled=true,priority=4)
	public void verifyLoginByUrlTest() throws Exception
	{
		String expResult=login.verifyLoginByUrl();
		Assert.assertEquals(expResult,ReadData.readExcelSheet(2, 2));	
	}
	@Test(enabled=true,dependsOnMethods="verifyLoginByUrlTest")
	public void verifyLoginByTextTest() throws Exception
	{
		String expResult=login.verifyLoginByText();
		Assert.assertEquals(expResult,ReadData.readExcelSheet(2, 3));
	}
	@Test(enabled=false)
	public void verifyLoginByLogoTest() throws Exception
	{
		boolean expResult=login.verifyLoginByLogo();
		Assert.assertEquals(expResult,true);
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
