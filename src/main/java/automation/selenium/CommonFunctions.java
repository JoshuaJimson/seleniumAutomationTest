package automation.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonFunctions extends App {

	public WebDriver driver;

	public CommonFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public void OpenBrowserWithURL(String url, WebDriver driver) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void ClickObject(WebElement element, String objectName) {
		try {
			if (element.isDisplayed()) {
				element.click();
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void SendKeysToObject(WebElement element, String objectName, String input) {
		try {
			if (element.isDisplayed()) {
				element.sendKeys(input);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	public void Selectclasss(WebElement element, String objectName, String input) {
		try {
			if (element.isDisplayed()) {
				Select s = new Select(element);
				s.selectByValue(input);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	public void Dropdown(List<WebElement> elements, String objectName, String input) {

		for (WebElement o : elements) {
			if (o.getText().contains(input)) {
				o.click();
				break;
			}
		}

	}

	
	public boolean isElementPresent(By locatorKey, WebDriver driver) {

	    
	    	if(driver.findElements(locatorKey).size()>0)	        
	        return true;
	    	else
	    		return false;

	}
	
	public String replaceXpathVariables(String xpath, String[] target, String[] replacement)
	{
		int arraySize=target.length;
		String finalXpath=null;
		
		for(int i=0;i<arraySize;i++)
		{
			finalXpath=xpath.replace(target[i], replacement[i]);
			xpath=finalXpath;
		}
		
		return xpath;
	}
}
