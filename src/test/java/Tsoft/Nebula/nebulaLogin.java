package Tsoft.Nebula;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import helpers.Helpers;
import pages.PageLogin;


public class nebulaLogin {
	
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\erick.gacitua\\eclipse-workspace\\Nebula\\src\\test\\resource\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://170.84.208.68/login");
		
		Helpers helper = new Helpers();
		helper.sleepSeconds(4);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/section/h2")).getText().contains("Bienvenido"));
	}
	
	@Test
	public void pruebaUno() {
		Helpers helper = new Helpers();
		
		PageLogin  pageLogin = new PageLogin(driver); 
		pageLogin.login("santander", "joab.gonzalez", "admin");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[2]")).click();
		helper.sleepSeconds(2);
		driver.findElement(By.id("heading-5")).click();
		helper.sleepSeconds(2);
		driver.findElement(By.xpath("//*[@id=\"collapse5\"]/div/div/div[2]/div")).click();
		helper.sleepSeconds(2);
		driver.findElement(By.xpath("//*[@id=\"category\"]/div[2]/div")).click();
		helper.sleepSeconds(2);
		driver.findElement(By.id("create")).click();
		helper.sleepSeconds(2);
		
		Select drpProvider = new Select(driver.findElement(By.name("provider")));
		drpProvider.selectByIndex(1);
		helper.sleepSeconds(2);
		
		Select drpFlavor = new Select(driver.findElement(By.name("flavor")));
		drpFlavor.selectByIndex(1);
		helper.sleepSeconds(2);
		
		Select drpImg = new Select(driver.findElement(By.name("image")));
		drpImg.selectByIndex(1);
		helper.sleepSeconds(2);
		
		driver.findElement(By.name("name")).sendKeys("Test");
		helper.sleepSeconds(2);
		
		driver.findElement(By.name("quantity")).sendKeys("1");
		helper.sleepSeconds(2);
		
		driver.findElement(By.id("createInstances")).click();
	}
	
	@AfterMethod
	public void tearDonw() {
		//driver.close();
	}
}
