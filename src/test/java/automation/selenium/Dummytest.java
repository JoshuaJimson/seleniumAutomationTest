package automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dummytest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
   	 System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\ChromeEXE96\\chromedriver.exe");
   	 WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[contains(@class,'homeCalender')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'January 2022')]/../..//div[contains(text(),10)]")).click();
	}

}
