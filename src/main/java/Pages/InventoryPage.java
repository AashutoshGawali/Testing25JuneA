package Pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.ReadData;

public class InventoryPage extends TestBase{
	//TC1- Verify Url
	//TC2- Add 6 products to cart and go Next
	//TC3- Remove 2 Products from cart and gp next
	
    //object Repository
	@FindBy(xpath= "//select[@class='product_sort_container']") private WebElement priceDropDown;
	@FindBy(xpath= "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement addToSauceLabsBackpack;
	@FindBy(xpath= "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement addToSauceLabsBikeLight;
	@FindBy(xpath= "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement addToSauceLabsBoltTShirt;
	@FindBy(xpath= "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement addToSauceLabsFleeceJacket;
	@FindBy(xpath= "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement addToSauceLabsOnesie;
	@FindBy(xpath= "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement addToTestAllTheThingsTShirt;
	@FindBy(xpath= "//span[@class='shopping_cart_badge']") private WebElement addToCartBucket;
	@FindBy(xpath= "//button[@id='remove-sauce-labs-bike-light']") private WebElement RemoveToSauceLabsBikeLight;
	@FindBy(xpath= "//button[@id='remove-sauce-labs-backpack']") private WebElement RemoveToSauceLabsBackpack;
	
	//constructor to initialize webElement
	public InventoryPage()
	{
	 PageFactory.initElements(driver,this);
	}
	
	//Methods
	//Method to verify Url
	public String verifyUrl()
	{
		return driver.getCurrentUrl();
	}
	
	//Method to verify Add 6 Products in Cart
	public String verifyAddProduct() throws Exception
	{
		
		Select a= new Select(priceDropDown);
		a.selectByVisibleText(ReadData.readExcelSheet(6, 0));
		addToSauceLabsBackpack.click();
		addToSauceLabsBikeLight.click();
		addToSauceLabsBoltTShirt.click();
		addToSauceLabsFleeceJacket.click();
		addToSauceLabsOnesie.click();
		addToTestAllTheThingsTShirt.click();
		return addToCartBucket.getText();
	}
	
	//Method to verify Remove 2 Products in Cart
	public String verifyRemoveProduct() throws Exception
	{
		InventoryPage invent= new InventoryPage();
		invent.verifyAddProduct();
		
		Thread.sleep(2000);
		RemoveToSauceLabsBackpack.click();
		RemoveToSauceLabsBikeLight.click();
		return addToCartBucket.getText();
	}
}
