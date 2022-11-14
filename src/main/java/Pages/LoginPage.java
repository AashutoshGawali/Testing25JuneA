package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

import Base.TestBase;
import Utility.ReadData;

public class LoginPage extends TestBase {
//Test cases
//TC1- Verify Application Title
//TC2- Verify Web Application Url
//TC3- Verify Logo1
//TC4- Verify Logo2
//TC5- Verify userLogin Successfully

  //Object Repository
	@FindBy(xpath="//div[@class='login_logo']") private WebElement swagLabsLogo;
	@FindBy(xpath="//div[@class='bot_column']") private WebElement bigLogo; 
	@FindBy(xpath="//input[@id='user-name']")private WebElement userNameTextBox;
	@FindBy(xpath="//input[@id='password']")private WebElement passwordTextBox;
	@FindBy(xpath="//input[@id='login-button']")private WebElement LoginBotton;
	@FindBy(xpath="//span[text()='Products']")private WebElement productText;
	@FindBy(xpath="//div[@class='peek']")private WebElement peekLogo;
	
  //constructor to initialize webElements
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
  //Methods
	//Method to Verify Application Title
	public static String verifyAppTitle()
	{
		return driver.getTitle();	
	}
	
	//Method to Verify Application Url
	public static String verifyAppUrl()
	{
		return driver.getCurrentUrl();
	}
	
	//Method to Verify Application logo1
	public boolean verifySwagLabsLogo()
	{
		return swagLabsLogo.isDisplayed();
		
	}
	//Method to Verify Application logo2
	public boolean verifyBigLogo()
	{
		return bigLogo.isDisplayed();
	}
	//Method to Verify Application login by Url
	public String verifyLoginByUrl() throws Exception
	{
		userNameTextBox.sendKeys(ReadData.readPropertyFile("Username"));
		passwordTextBox.sendKeys(ReadData.readPropertyFile("Password"));
		LoginBotton.click();
		return driver.getCurrentUrl();
	}
	//Method to Verify Application login by Product text
	public String verifyLoginByText() throws Exception
	{
		verifyLoginByUrl();
		return productText.getText();	
	}
	//Method to Verify Application login by Logo
	public boolean verifyLoginByLogo() throws Exception
	{
		verifyLoginByUrl();
		return peekLogo.isDisplayed();
	}
}
