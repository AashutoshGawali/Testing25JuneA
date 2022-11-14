package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Cart_Page;
import Pages.CheckOutInfoPage;
import Pages.CheckoutCompletePage;
import Pages.CheckoutOverviewPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.ReadData;

public class CheckoutCompletePageTest extends TestBase {

	LoginPage login;
	InventoryPage invt;
	CheckoutOverviewPage checkInfo; 
	CheckoutCompletePage check1;
    @BeforeMethod
    public void setup() throws Exception
    {
	initialization();
	login= new LoginPage();
	login.verifyLoginByUrl();
	invt= new InventoryPage();
	 invt.verifyAddProduct();
	 Cart_Page cart = new Cart_Page();
	 cart.verifyRemovProducts();
	 CheckOutInfoPage check= new CheckOutInfoPage();
	 check.checkContinueBotton();
	 check1= new CheckoutCompletePage();
    }
    
    @Test
    public void verifyMessage1Test() throws Exception
    {
      	String expResult=check1.verifyMessage1();
      	Assert.assertEquals(expResult,ReadData.readExcelSheet(22, 0));
    }
    @Test
    public void verifyMessage2Test() throws Exception
    {
      	String expResult=check1.verifyMessage2();
      	Assert.assertEquals(expResult,ReadData.readExcelSheet(24, 0));
    }
    @Test
    public void verifyPonyLogoTest()
    {
    	boolean expResult=check1.verifyPonyLogo();
    	Assert.assertEquals(expResult,true);
    }
    @Test
    public void verifyLogOut()
    {
    	boolean expResult=check1.verifyLogOut();
    	Assert.assertEquals(expResult,true);
    }
    @AfterMethod
    public void close()
    {
    	driver.close();
    }
    
    
    
}
