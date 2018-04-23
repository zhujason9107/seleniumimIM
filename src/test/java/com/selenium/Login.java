package com.selenium;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;





public class Login {
	public WebDriver driver;
	
	public void sleep(int second){
		try {
			Thread.sleep(second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void initDriver(){
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.imooc.com");
//		driver.manage().window().maximize();
		this.element(By.id("js-signin-btn")).click();
	}
	
	
	public void loginScript(String username,String userpass){
		this.initDriver();

		this.sleep(3000);
		WebElement user=this.element(this.byStr("username"));
		System.out.println("email输入框状态2:"+user.isDisplayed());
		WebElement password=this.element(this.byStr("userpass"));
		System.out.println("password输入框状态:"+password.isDisplayed());
		WebElement loginButton=this.element(this.byStr("loginbutton"));
		System.out.println("登录按钮的状态"+loginButton.isDisplayed());
		user.sendKeys(username);
		password.sendKeys(userpass);
		loginButton.click();
		
		this.sleep(3000);
		
		WebElement header=this.element(this.byStr("header"));
			
		System.out.println("header的状态2:"+header.isDisplayed());
		Actions actions=new Actions(driver);
		actions.moveToElement(header).perform();
		
		String userInfo=this.element(this.byStr("nameInfo")).getText();
		System.out.println(userInfo);
		if(userInfo.equals("qq_Jason_434195603")){
			this.takeScreenShot();
			System.out.println("登陆成功了");
		}else{
			System.out.println("登录失败");
		}
		driver.close();
	}
	
	public By byStr(String key){//之前是定位方式，定位值，现在改成key(配置文件)
		ProUtil properties=new ProUtil("element.properties");
		
		String locator=properties.getPro(key);//key
		System.out.println("key值:"+locator);
		String locatorType=locator.split(">")[0];
		String locatorValue=locator.split(">")[1];
		if(locatorType.equalsIgnoreCase("id")){
			return By.id(locatorValue);
		} else if(locatorType.equalsIgnoreCase("name")){
			return By.name(locatorValue);
		}else if(locatorType.equalsIgnoreCase("className")){
			return By.className(locatorValue);
		}else{
			return By.xpath(locatorValue);
		}
		
	}
	
	/**
	 * 
	 * 封装FindElement()
	 */
	public WebElement element(By by){
		WebElement ele=driver.findElement(by);
		return ele;
	}
	
	/**
	 * 截图
	 * @throws IOException 
	 */
	public void takeScreenShot() {
		Long date=System.currentTimeMillis();
		String path=String.valueOf(date);
		String curPath=System.getProperty("user.dir");//获取系统的当前路径
		path=path+".png";
		System.out.println(curPath);
		String screenPath=curPath+"/"+path;
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File(screenPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void loginpage(){
		this.loginScript("1565328905@qq.com","abc6611162");
	}
	
	public static void main(String[] args) {
		Login login=new Login();
		
//		login.loginScript("1565328905@qq.com","abc6611162");
		

		HashMap<String,String> user=new HashMap<String,String>();
		
		user.put("18513199586", "111111");
		user.put("1565328905@qq.com", "abc6611162");
		
		Iterator<Entry<String, String>>  us=user.entrySet().iterator();
		while(us.hasNext()){
			Map.Entry<String,String> entry=us.next();
			String username=entry.getKey().toString();
			String password=entry.getValue().toString();
			System.out.println(username+password);
			login.loginScript(username,password);
		}
	}
}
