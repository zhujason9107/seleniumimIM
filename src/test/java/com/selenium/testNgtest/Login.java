package com.selenium.testNgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
	public WebDriver driver;
	
	@Test
	public void initDriver(){
		System.setProperty("webdriver.chrome.driver", "D:\\zhb\\auto_driver\\chrome_driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.imooc.com");
//		driver.manage().window().maximize();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods={"initDriver"})
	public void userLogin() throws InterruptedException{
		driver.findElement(By.id("js-signin-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("1565328905@qq.com");
		driver.findElement(By.name("password")).sendKeys("asd6611162");;
		driver.findElement(By.className("btn-red")).click();
		driver.close();
	}
}
