package com.selenium.testCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.base.DriverBase;
import com.selenium.business.LoginPro;

public class Login extends CaseBase{
	public DriverBase driver;
	public LoginPro loginPro;
	public static Logger logger=Logger.getLogger(Login.class);
	public Login() {
		this.driver=initDriver("chrome");
		loginPro=new LoginPro(driver);
	}
	@Test
	public void getLoginHome(){
		System.out.println("sss");
		driver.get("http://www.imooc.com");
		driver.findElement(By.id("js-signin-btn")).click();
		System.out.println("来到这里了吗");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods={"getLoginHome"})
	public void testLogin(){
		logger.debug("这是第一次login4j打印日志~~~");
		loginPro.login("1565328905@qq.com", "abc6611162");
	}
	
	/**
	 * 获取课程信息
	 */
	public String getCourseTest(WebElement element){
		return element.getText();
	}
	
	/**
	 * 下单流程
	 */
	@Test(dependsOnMethods={"testLogin"})
	public void buyCourse(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("http://coding.imooc.com/class/105.html");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//商品详情页的 第一页商品的名称
		String courseDetil=driver.findElement(By.className("path")).findElement(By.tagName("span")).getText();
		driver.findElement(By.id("buy-trigger")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.linkText("提交订单")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String orderText=driver.findElement(By.className("order")).getText();
		System.out.println("orderText:"+orderText);
		if(orderText!=null){//如果订单号不为null
			
			String orderString=driver.findElement(By.xpath("//dt")).getText();//支付中心的商品名称 driver.findElement(By.className("item")).findElement(By.className("left")).findElement(By.tagName("dt")).getText()
			Assert.assertEquals(courseDetil, orderString,"购买的商品信息不一致");
		}
	}
}
