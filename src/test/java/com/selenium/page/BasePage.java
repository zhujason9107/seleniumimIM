package com.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.base.DriverBase;


/** 基于页面的封装
 * 封装页面所有'公用'的方法：获取元素 输入框输入参数、点击、
 * 比如一个页面输入框有很多，那么在此页面只需要封装一个输入框对象，然后谁继承此类，都可以用此输入框对象
 * @author zhu
 *
 */
public class BasePage {
	public DriverBase driver;

	public BasePage(DriverBase driver){
		this.driver=driver;
	}
	
	/**
	 * 定位元素
	 * @param  By by
	 * 
	 */
	public WebElement element(By by){
		WebElement element=driver.findElement(by);
		return element;
	}
	
	/**
	 * 封装点击
	 */
	
	public void click(WebElement element){
		if(element!=null){
			element.click();
		}else{
			System.out.println("元素没有定位到，点击失败");
		}
	}
	
	/**
	 * 封装输入
	 */
	
	public void sendKeys(WebElement element,String value){
		if(element!=null){
			element.sendKeys(value);
		}else{
			System.out.println(element+":元素没有定位到，输入失败"+value);
		}
		
	}
	
	/**
	 * 封装元素是否显示
	 * @param element
	 * 
	 */
	public boolean assertElementIs(WebElement element){
		return element.isDisplayed();
	}
	
}
