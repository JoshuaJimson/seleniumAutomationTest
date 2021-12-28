package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import automation.selenium.App;
import automation.selenium.CommonFunctions;

public class LandingPage extends App{

	public WebDriver driver;
	WebElement element;
	List<WebElement> elements;
	CommonFunctions cf = new CommonFunctions(driver);
	By radioButton_OneWay = By.xpath("//*[contains(text(),'One way')]");
	By select_adultsWE=By.xpath("//div[@class='mb-4']/select");
	By select_childWE=By.xpath("//div[@class='mb-4']/following-sibling::div[2]/select");
	By dropdown_FromWE=By.xpath("//*[contains(@placeholder,'Any worldwide city or airport')]");
	By dropdown_fromitemsWE=By.xpath("//*[contains(@class,'dropdown__item ')]/p");
	By dropdown_ToWE=By.xpath("(//*[contains(@placeholder,'Any worldwide city or airport')])[2]");
	By dropdown_ToitemsWE=By.xpath("//*[contains(@class,'dropdown__item ')]/p");
	By departOnButton=By.xpath("//*[contains(@class,'homeCalender')]");
	//By dayPickerButton=By.xpath("//*[contains(text(),'February 2022')]/../..//div[contains(text(),10)]");
	String dayPickerButtonXpath="//*[contains(text(),'monthAndYear')]/../..//div[contains(text(),date)]";
	By rightArrowButton=By.xpath("//*[@data-testid='rightArrow']");
	
	public LandingPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getRadioButton_OneWay(WebDriver driver) {
		element = driver.findElement(radioButton_OneWay);
		try {
		Assert.assertTrue(element.isDisplayed());
		}catch (Exception e) {
		}
		return element;	
	}
	
	public WebElement Select_AdultsFun(WebDriver driver) {
		element = driver.findElement(select_adultsWE);
		try {
		Assert.assertTrue(element.isDisplayed());
		}catch (Exception e) {
		}
		return element;	
	}
	public WebElement Select_ChildFun(WebDriver driver) {
		element = driver.findElement(select_childWE);
		try {
		Assert.assertTrue(element.isDisplayed());
		}catch (Exception e) {
		}
		return element;	
	}
	public WebElement Dropdown_FromFun(WebDriver driver) {
		element = driver.findElement(dropdown_FromWE);
		try {
		Assert.assertTrue(element.isDisplayed());
		}catch (Exception e) {
		}
		return element;	
	}
	public List<WebElement> Dropdown_FromcontentFun(WebDriver driver) {
		elements = driver.findElements(dropdown_fromitemsWE);
		return elements;	
	}
	public WebElement Dropdown_ToFun(WebDriver driver) {
		element = driver.findElement(dropdown_ToWE);
		try {
		Assert.assertTrue(element.isDisplayed());
		}catch (Exception e) {
		}
		return element;	
	}
	public List<WebElement> Dropdown_TocontentFun(WebDriver driver) {
		elements = driver.findElements(dropdown_ToitemsWE);
		return elements;	
	}
	
	public WebElement getDepartOnButton(WebDriver driver) {
		element = driver.findElement(departOnButton);
		try {
		Assert.assertTrue(element.isDisplayed());
		}catch (Exception e) {
		}
		return element;	
	}

	public WebElement getRightArrowButton(WebDriver driver) {
		element = driver.findElement(rightArrowButton);
		try {
		Assert.assertTrue(element.isDisplayed());
		}catch (Exception e) {
		}
		return element;	
	}
	public WebElement getMonth(WebDriver driver,String month) {
		//element = driver.findElement(By.xpath("//*[contains(text(),'"+month+"' 2022)]"));
		//String a=month+" 2022";
		element = driver.findElement(By.xpath("//*[contains(text(),'February 2022')]"));
		//element = driver.findElement(By.xpath("//*[contains(text(),'"+a+"')]"));
		try {
		Assert.assertTrue(element.isDisplayed());
		}catch (Exception e) {
		}
		return element;	
	}
	public WebElement getDay(WebDriver driver) {
		
		String[] target={"monthAndYear","date"};
		String[] replacement={"February 2022","17"};
		if(cf.isElementPresent(By.xpath(cf.replaceXpathVariables(dayPickerButtonXpath,target,replacement)),driver))
		{
		element = driver.findElement(By.xpath(dayPickerButtonXpath.replace("monthAndYear", "February 2022").replace("date", "17")));
		return element;
		}
		else
			return null;
	}
	
	
	public void setDate(WebElement day,WebElement rightArrow,WebDriver driver) {

		while(getDay(driver)==null)
		{
			cf.ClickObject(rightArrow, "right arrow button");
		
		}
		cf.ClickObject(getDay(driver), "day");
		
	}
	
}
