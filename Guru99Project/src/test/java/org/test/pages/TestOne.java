package org.test.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOne {
	public static WebDriver driver;
	public static Properties props;
	
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

	@Test
	public void ExampleOne() throws Exception {
		driver.findElement(By.name("uid")).sendKeys(props.getProperty("name"));
		driver.findElement(By.name("password")).sendKeys(props.getProperty("password"));
		driver.findElement(By.name("btnLogin")).click();
	}
	
	
}
