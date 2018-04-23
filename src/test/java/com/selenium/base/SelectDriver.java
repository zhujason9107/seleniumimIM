package com.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {
	
	public WebDriver driverName(String browser){
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.bin", "D:\\zhb\\auto_driver\\firefox_driver\\firefox.exe");
			return new FirefoxDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "D:\\zhb\\auto_driver\\chrome_driver\\chromedriver.exe");
			return new ChromeDriver();
		}
	}
}
