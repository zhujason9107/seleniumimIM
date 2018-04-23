package com.selenium.util;

import org.openqa.selenium.By;

public class GetByLocator {
	public static By getLocator(String key){//配置文件的key
		ProUtil pro=new ProUtil("element.properties");
		String locator=pro.getPro(key);
		String locatorType=locator.split(">")[0];
		String locatorValue=locator.split(">")[1];
		
		if(locatorType.equalsIgnoreCase("id")){ //1
			return By.id(locatorValue);
		}else if(locatorType.equalsIgnoreCase("className")){//2
			return By.className(locatorValue);
		}else if(locatorType.equalsIgnoreCase("name")){ //3
			return By.name(locatorValue);
		}else if(locatorType.equalsIgnoreCase("cssSelector")){//4
			return By.cssSelector(locatorValue);
		}else if(locatorType.equalsIgnoreCase("linkText")){//5
			return By.linkText(locatorValue);
		}else if(locatorType.equalsIgnoreCase("partialLinkText")){ //6
			return By.partialLinkText(locatorValue);
		}else if(locatorType.equalsIgnoreCase("tagName")){ //7
			return By.tagName(locatorValue);
		}else { //8
			return By.xpath(locatorValue);
		}
	}
}
