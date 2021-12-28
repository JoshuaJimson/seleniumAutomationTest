package automation.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class App 
{
	public WebDriver driver;
	public Properties properties;
	
    public WebDriver initializeDriver() throws IOException{
    {
     properties = new Properties();
     FileInputStream fs = new FileInputStream("C:\\Users\\user\\SeleniumPOC\\src\\main\\java\\resources\\config.properties");
     properties.load(fs);
     String browserName = properties.getProperty("Browser");
     if(browserName.equalsIgnoreCase("chrome")) {
    	 System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\ChromeEXE96\\chromedriver.exe");
    	 driver = new ChromeDriver();
     }
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}
    
    public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
    {
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	File source =ts.getScreenshotAs(OutputType.FILE);
    	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
    	FileUtils.copyFile(source,new File(destinationFile));
    	return destinationFile;
    }
    

}
