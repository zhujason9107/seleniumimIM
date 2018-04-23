package com.selenium.testCase;

import org.testng.Assert;

public class TestAssert {
	public static void main(String[] args) {
//		Assert.assertEquals("1", "2");//"1"：找到的，"2"：预期值  。expected [2] but found [1] ：预期是2但找到的是1
//		Assert.assertEquals("1", "2", "这两个值不一样");//第三个参数是：当实际的结果与预期不同，输出的信息是第三个自定义提示
		Assert.assertNotNull(null, "现在为null");//assertNotNull ：预期不为空。第一个参数如果为null,那么输入第二个参数
	}
}
