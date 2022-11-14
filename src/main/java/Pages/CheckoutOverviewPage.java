package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckoutOverviewPage extends TestBase {

	//object Repository
    @FindBy(xpath="//div[text()='SauceCard #31337']") private WebElement paymentInfo;
    @FindBy(xpath="//div[text()='FREE PONY EXPRESS DELIVERY!']") private WebElement ShippingInfo;
    @FindBy(xpath="//div[@class='summary_total_label']") private WebElement total;
	//Constructor
    public  CheckoutOverviewPage()
    {
    	PageFactory.initElements(driver,this);
    }
    
	//Methods
    //Method to verify Payment Information
	public String verifyPaymentInfo()
	{
		return paymentInfo.getText();
	}
	
	//Method to verify Shipping Information
	public String verifyShippingInfo()
	{
		return ShippingInfo.getText();
	}
	//Method to verify Total Of Transaction
	public String verifyTotalOfTransaction()
	{
		return total.getText();
	}
	
}
