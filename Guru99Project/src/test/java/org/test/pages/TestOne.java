package org.test.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOne {
	public static WebDriver driver;
	public static Properties props;
	public static WebDriverWait driverWait;
	
	@BeforeTest
	public void start() throws IOException {
		props = new Properties();
		File fs = new File(System.getProperty("user.dir")+"\\src\\test\\java\\utils\\config.properties");
		FileInputStream fis = new FileInputStream(fs);
		props.load(fis);
		if (props.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(props.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new EdgeDriver();
		}
		driver.get(props.getProperty("url"));
	}
	@AfterTest
	public void end() {
		driver.close();
	}

	@Test(dataProvider = "TestProvider")
	public void ExampleOne(String uid,String passcode) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.findElement(By.name("uid")).sendKeys(uid);
		driver.findElement(By.name("password")).sendKeys(passcode);
		driver.findElement(By.name("btnLogin")).click();
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		driverWait.until(ExpectedConditions.alertIsPresent()).dismiss();
		
	}
	
	@DataProvider(name = "TestProvider")
	public Object[][] dataProvides(){
		return new Object[][] {{"hello","hel"},{"hell","ello"},{"heko","heloo"}};
	}
	
	
}
