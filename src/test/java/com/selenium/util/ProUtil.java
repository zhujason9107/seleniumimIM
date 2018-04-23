package com.selenium.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProUtil {
	private Properties properties;
	private String filePath;
	
	
	public ProUtil(String filePath) {
		
		this.filePath = filePath;
		this.properties=this.readProperties();
	}
	
	private Properties readProperties() {
		properties=new Properties();
		
		try {
			InputStream inputStream=new FileInputStream(filePath);
			BufferedInputStream in=new BufferedInputStream(inputStream);
			properties.load(in);
			inputStream.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
		
		}
		
		return properties;
	}

	public String getPro(String key){//传配置文件的key
		if(properties.containsKey(key)){
			String value=properties.getProperty(key);
			return value;
		}else{
			System.out.println("你获取的key值不对");
			return "";
		}
	}
	
	
}
