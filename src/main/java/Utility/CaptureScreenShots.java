package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class CaptureScreenShots extends TestBase {

	public static void captureScreenShot(String name) throws Exception
	{
		
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
	File dest= new File("C:\\Users\\com\\eclipse-workspace\\SauceLabFrame1\\Screenshots\\"+ name+ ".jpeg");	
	FileHandler.copy(source,dest);
	
	}
	
}
