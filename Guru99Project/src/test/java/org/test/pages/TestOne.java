package org.test.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOne {
	public static WebDriver driver;
	
	@BeforeTest
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.demo.guru99.com/V4/");
	}
	@AfterTest
	public void end() {
		driver.close();
	}

	@Test
	public void ExampleOne() throws Exception {
		driver.findElement(By.name("uid")).sendKeys("mngr542415");
		driver.findElement(By.name("password")).sendKeys("123456@12");
		driver.findElement(By.name("btnLogin")).click();
	}
}
