package com.springboot.sqlserver.util;

import java.text.SimpleDateFormat;
import java.util.Random;

public class CriffUtil {
	public int ranDomNum() throws InterruptedException {
		Random r = new Random(System.currentTimeMillis());
		Thread.sleep(200);
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	
	public String timeStamp() {
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		return timestamp;
	}
	 
}
