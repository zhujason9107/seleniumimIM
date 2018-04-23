package com.selenium.testCase;

import com.selenium.base.DriverBase;

/**
 * 生成driver,因为很多地方需要用到driver,所以将driver抽取出来
 * @author zhu
 *
 */
public class CaseBase {
	public DriverBase initDriver(String browser){
		return new DriverBase(browser);
	}
}
