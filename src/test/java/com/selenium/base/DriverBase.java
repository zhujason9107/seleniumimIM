package com.selenium.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 生成driver
 * 封装driver里面的各个方法
 * 依赖：WebDriver 、SelectDriver
 * @author zhu
 *
 */
public class DriverBase {
	public WebDriver driver;
	public DriverBase(String browser){
		SelectDriver selectDriver=new SelectDriver();
		this.driver=selectDriver.driverName(browser);
	}
	
	/**
	 * 封装Element
	 * @param by
	 * @return
	 */
	public WebElement findElement(By by){
		WebElement element=driver.findElement(by);
		return element;
	}
	
	/**
	 * 封装定位一组elements的方法
	 * */
	public List<WebElement> findElements(By by){
		return driver.findElements(by);
	}
	
	public void get(String url){
		driver.get(url);
	}
	
	public void back(){
		driver.navigate().back();
	}
	/**
	 * 
	 */
	public void stop(){
		System.out.println("stop webdriver");
		driver.close();
	}
}
