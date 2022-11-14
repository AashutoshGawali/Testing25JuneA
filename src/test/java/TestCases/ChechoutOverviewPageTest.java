package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Cart_Page;

import Pages.CheckOutInfoPage;
import Pages.CheckoutOverviewPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.ReadData;

public class ChechoutOverviewPageTest extends TestBase{
	LoginPage login;
	InventoryPage invt;
	CheckoutOverviewPage checkInfo; 
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
	 checkInfo= new CheckoutOverviewPage();
    }
  @Test
  public void verifyPaymentInfoTest() throws Exception
  {
	  String expResult=checkInfo.verifyPaymentInfo();
	  Assert.assertEquals(expResult, ReadData.readExcelSheet(18, 1));
  }
  @Test
	public void verifyShippingInfoTest() throws Exception
	{
	  String expResult=checkInfo.verifyShippingInfo();
	  Assert.assertEquals(expResult, ReadData.readExcelSheet(18, 2));
	}
  @Test
   public void verifyTotalOfTransactionTest() throws Exception
   {
	  String expResult=checkInfo.verifyTotalOfTransaction();
	  Assert.assertEquals(expResult, ReadData.readExcelSheet(18, 3));
   }
  
  @AfterMethod
  public void close() throws Exception
  {
	
	driver.close();
  }
	
}
