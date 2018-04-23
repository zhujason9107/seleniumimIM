package com.selenium.testCase;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.selenium.base.DriverBase;

public class TestCourseList extends CaseBase {
	public DriverBase driver;
	public TestCourseList() {
		this.driver=initDriver("chrome");
	}
	
	@Test
	public void courseList(){
		driver.get("http://coding.imooc.com");
		List<String> listString=this.listElement();
		for(int i=0;i<listString.size();i++){
			driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")).click();
			driver.back();
		}
	}
	
	/**
	 * 获取所有课程的list :解决StaleElementReferenceException
	 * @return
	 */
	public List<String> listElement(){
		List<String> listString=new ArrayList<String>();
		WebElement element=driver.findElement(By.className("shizhan-course-list"));
		List<WebElement> listElement=element.findElements(By.className("shizhan-course-box"));
		for(WebElement el:listElement){
			listString.add(el.findElement(By.className("shizan-desc")).getText());
		}
		return listString;
	}
}
