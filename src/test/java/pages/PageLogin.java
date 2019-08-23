package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helpers.Helpers;

public class PageLogin {
	Helpers helper = new Helpers();
	
	private WebDriver driver;
	public PageLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String domain,String user, String pass) {
		driver.findElement(By.name("domain")).sendKeys(domain);
		helper.sleepSeconds(2);
		driver.findElement(By.name("username")).sendKeys(user);
		helper.sleepSeconds(2);
		driver.findElement(By.name("password")).sendKeys(pass);
		helper.sleepSeconds(2);
		driver.findElement(By.id("login")).click();
		helper.sleepSeconds(2);
	}
}
