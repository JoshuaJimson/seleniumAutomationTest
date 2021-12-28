package automation.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class LandingPageTest extends App{

	public WebDriver driver;
	CommonFunctions cf = new CommonFunctions(driver);
	LandingPage lp = new LandingPage(driver);
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		cf.OpenBrowserWithURL(properties.getProperty("URL"),driver);
		//driver.get(properties.getProperty("URL"));
	}
	
	@Test
	public void SearchFlights() {
		
		cf.ClickObject(lp.getRadioButton_OneWay(driver), "One way");
	}
	
	@Test
	public void SelectAdults() {

		cf.Selectclasss(lp.Select_AdultsFun(driver), "select adult", "5");
	}
	
	@Test
	public void SelectChild() {

		cf.Selectclasss(lp.Select_ChildFun(driver), "select child", "2");
	}
	
	@Test
	public void calendar() throws InterruptedException  {

		cf.ClickObject(lp.getDepartOnButton(driver), "click on calendar");
		Thread.sleep(5000);
		lp.setDate(lp.getDay(driver),lp.getRightArrowButton(driver), driver);

	}
	@Test
	public void SelectFromDropdown() throws InterruptedException {

		cf.ClickObject(lp.Dropdown_FromFun(driver), "click drop down");
		cf.SendKeysToObject(lp.Dropdown_FromFun(driver), "send value", "Koc");
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cf.Dropdown(lp.Dropdown_FromcontentFun(driver), "send value", "KCZ");
	}
	
	@Test
	public void SelectToDropdown() throws InterruptedException {

		cf.ClickObject(lp.Dropdown_ToFun(driver), "click drop down");
		cf.SendKeysToObject(lp.Dropdown_ToFun(driver), "send value", "Bang");
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cf.Dropdown(lp.Dropdown_TocontentFun(driver), "send value", "Bangalore");
	}
	

}
