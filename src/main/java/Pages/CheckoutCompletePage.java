package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckoutCompletePage extends TestBase{

	//objectRepository
	@FindBy(xpath="//button[@id='finish']") private WebElement finishButton;
	@FindBy(xpath="//h2[@class='complete-header']") private WebElement message1;
	@FindBy(xpath="//div[@class='complete-text']") private WebElement message2;
	@FindBy(xpath="//img[@alt='Pony Express']") private WebElement ponyLogo;
	@FindBy(xpath="//button[text()='Open Menu']") private WebElement menuOption;
	@FindBy(xpath="//a[@id='logout_sidebar_link']") private WebElement logoutButton;
	@FindBy(xpath="//div[@class='bot_column']") private WebElement bigLogo;
	//constructor
	public CheckoutCompletePage()
	{
		PageFactory.initElements(driver, this);
	}
	//Methods
	//Method to verify Message1
	public String verifyMessage1()
	{
		finishButton.click();
		return message1.getText();
	}
	//Method to verify Message2
	public String verifyMessage2()
	{
		finishButton.click();
		return message2.getText();
	}
	//Method to verify Pony Logo
	public boolean verifyPonyLogo()
	{
		finishButton.click();
		return ponyLogo.isDisplayed();
	}
	public boolean verifyLogOut()
	{
		menuOption.click();
		logoutButton.click();
		return bigLogo.isDisplayed();
	}
}
