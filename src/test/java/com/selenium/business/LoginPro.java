package com.selenium.business;

import com.selenium.base.DriverBase;
import com.selenium.handle.LoginPageHanle;

/**
 * 业务层
 * @author zhu
 *
 */
public class LoginPro {
	public LoginPageHanle lph;
	public LoginPro(DriverBase driver){
		lph=new LoginPageHanle(driver);
	}
	
	public void login(String user,String password){
		if(lph.assertLoginPage()){
			lph.sendKeysUser(user);
			lph.sendKeysPassword(password);
			lph.clickAutoSignin();
			lph.clickLoginButton();
		}else{
			System.out.println("页面不存在或者状态不正确");
		}
		
	}
}
