package com.selenium;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProUtil {
	private Properties prop;
	private String filePath;
	
	public ProUtil(String filePath) {
		this.filePath=filePath;
		this.prop=this.readProperties();
	}
	
	/**
	 * 读取配置文件
	 * 
	 */
	private Properties readProperties(){
		Properties properties=new Properties();
		try {
			InputStream inputStream=new FileInputStream(filePath);
			BufferedInputStream in=new BufferedInputStream(inputStream);
			properties.load(in);
			inputStream.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	
	
	public String getPro(String key) {
		if(prop.containsKey(key)){
			String value=prop.getProperty(key);
			return value;
		}else{
			System.out.println("你获取的key值不对");
			return null;
		}
		
		
	}
	
}
