package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class CheckOutInfoPage extends TestBase {

	//Object Repository
	@FindBy(xpath="//span[text()='Checkout: Your Information']") private WebElement checkoutText;
	@FindBy(xpath="//input[@placeholder=\"First Name\"]") private WebElement firstNameTextBox;
	@FindBy(xpath="//input[@placeholder=\"Last Name\"]") private WebElement lastNameTextBox;
	@FindBy(xpath="//input[@placeholder=\"Zip/Postal Code\"]") private WebElement zopcodeTextBox;
	@FindBy(xpath= "//span[@class='shopping_cart_badge']") private WebElement addToCartdBucket;
	@FindBy(xpath= "//button[@id='checkout']") private WebElement checkOutBotton;
	@FindBy(xpath= "//input[@id='continue']") private WebElement continueBotton;
	@FindBy(xpath= "//span[text()='Checkout: Overview']") private WebElement CheckoutOverviewText;
	
	//Constructor
	public CheckOutInfoPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Methods
	//Method to verify Title
	public String verifyTitle()
	{
		checkOutBotton.click();
		return checkoutText.getText();
	}
	
	//Method to verify Continue Botton
	public String checkContinueBotton() throws Exception
	{
		Thread.sleep(2000);
		checkOutBotton.click();
		Thread.sleep(2000);
		firstNameTextBox.sendKeys(ReadData.readPropertyFile("FirstName"));
//		firstNameTextBox.sendKeys("a");
		lastNameTextBox.sendKeys(ReadData.readPropertyFile("LastName"));
		zopcodeTextBox.sendKeys(ReadData.readPropertyFile("Zipcode"));
		continueBotton.click();
		return CheckoutOverviewText.getText();
	}
	
}
