package com.selenium.page;

import org.openqa.selenium.WebElement;

import com.selenium.base.DriverBase;
import com.selenium.util.GetByLocator;


/**1.
 * 获取页面各个元素对象:需要手动修改key,配置文件的key
 * @author zhu
 * 继承BasePage
 */
public class LoginPage extends BasePage{
	
	public LoginPage(DriverBase driver) {
		super(driver);
	}
	/**
	 * 获取用户名输入框
	 */
	public WebElement getUserElement(){
		return this.element(GetByLocator.getLocator("username"));
	}
	
	/**
	 * 获取密码输入框
	 */
	
	public WebElement getPasswordElement(){
		return this.element(GetByLocator.getLocator("userpass"));
	}
	
	/**
	 * 获取登录按钮
	 */
	public WebElement getLoginButtonElement(){
		return this.element(GetByLocator.getLocator("loginbutton"));
	}
	
	/**
	 * 获取7天内自动登录 element
	 */
	
	public WebElement getAutoSigninELment(){
		return this.element(GetByLocator.getLocator("autoSignin"));
	}
}
