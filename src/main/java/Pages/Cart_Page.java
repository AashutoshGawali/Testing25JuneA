package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class Cart_Page extends TestBase {

	//Object Repository
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartBucket;
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement removeSauceLabsOnesie;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeSauceLabsBoltShirt;
	@FindBy(xpath="//span[text()='Your Cart']") private WebElement yourCartText;
	//Constructor
	
	public Cart_Page()
	{
		
		PageFactory.initElements(driver,this);
		
	}
	
    //Methods
	//Method to verify Cart Page Title
	public String verifyCartPageTitle()
	{
		cartBucket.click();
		return yourCartText.getText();
		
	}
	//Method to verify Cart Page Url
	public String verifyCartPageUrl()
	{
		cartBucket.click();
		return driver.getCurrentUrl();
	}		
	//Method to verify remove 2 products
	public String verifyRemovProducts() throws Exception
	{
		
		cartBucket.click();
		removeSauceLabsOnesie.click();
		removeSauceLabsBoltShirt.click();
		return cartBucket.getText();
	}
	

	
}
