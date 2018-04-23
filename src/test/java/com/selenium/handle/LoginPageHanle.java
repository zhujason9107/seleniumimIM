package com.selenium.handle;

import com.selenium.base.DriverBase;
import com.selenium.page.LoginPage;

/**
 * 操作层
 * @author zhu
 * 操作谁：LoginPage 
 * 依赖：DriverBase 、LoginPage
 */
public class LoginPageHanle {
	public DriverBase driver;
	public LoginPage lp;
	public LoginPageHanle(DriverBase driver) {
		this.driver=driver;
		lp=new LoginPage(driver);
	}
	
	/**
	 * 输入用户名
	 * @param username
	 */
	public void sendKeysUser(String username){
		lp.sendKeys(lp.getUserElement(), username);
	}
	
	/**
	 * 输入密码
	 * @param password
	 */
	public void sendKeysPassword(String password){
		lp.sendKeys(lp.getPasswordElement(), password);
	}
	
	/**
	 * 点击登录
	 */
	public void clickLoginButton(){
		lp.click(lp.getLoginButtonElement());
	}
	
	/**
	 * 点击自动登录
	 */
	public void clickAutoSignin(){
		lp.click(lp.getAutoSigninELment());
	}
	
	/**
	 * 判断是否是登录页面：有歧义
	 * @return
	 */
	public boolean assertLoginPage(){
		return lp.assertElementIs(lp.getUserElement());
	}
}
