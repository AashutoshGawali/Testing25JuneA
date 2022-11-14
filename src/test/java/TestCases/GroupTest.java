package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.CaptureScreenShots;
import Utility.ReadData;

public class GroupTest extends TestBase {
	LoginPage login;
	@BeforeMethod(alwaysRun=true)
	public void setup() throws Exception
	{
		 initialization();
		 login= new LoginPage();
	}
	
	@Test(groups="Smoke")
	public void verifyAppTitleTest() throws Exception
	{
		String expResult= LoginPage.verifyAppTitle();
		Assert.assertEquals(expResult,ReadData.readExcelSheet(2, 0));
	}
	
	@Test(groups="Sanity")
	public void verifyAppUrlTest() throws Exception
	{
		String expResult= LoginPage.verifyAppUrl();
		Assert.assertEquals(expResult,ReadData.readExcelSheet(2, 1));
	}
	
	@Test(groups="Smoke")
	public void verifySwagLabsLogoTest()
	{
		boolean expResult= login.verifySwagLabsLogo();
		Assert.assertEquals(expResult,true);
	}
	@Test(groups="Sanity")
	public void verifyBigLogoTest()
	{
		boolean expResult= login.verifyBigLogo();
		Assert.assertEquals(expResult,true);
	}
	@Test(groups= {"Sanity","Smoke","Regression"})
	public void verifyLoginByUrlTest() throws Exception
	{
		String expResult=login.verifyLoginByUrl();
		Assert.assertEquals(expResult,ReadData.readExcelSheet(2, 2));	
	}
	@Test(groups="Sanity")
	public void verifyLoginByTextTest() throws Exception
	{
		String expResult=login.verifyLoginByText();
		Assert.assertEquals(expResult,ReadData.readExcelSheet(2, 3));
	}
	@Test(groups= {"Sanity","Smoke","Regression"})
	public void verifyLoginByLogoTest() throws Exception
	{
		boolean expResult=login.verifyLoginByLogo();
		Assert.assertEquals(expResult,true);
	}
	
	@AfterMethod(alwaysRun=true)
	public void close(ITestResult it) throws Exception
	{
		if(ITestResult.FAILURE==it.getStatus())
		{
			CaptureScreenShots.captureScreenShot(it.getName());
		}
		driver.close();
	}
	
}
