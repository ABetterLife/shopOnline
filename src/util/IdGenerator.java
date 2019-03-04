package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class IdGenerator {
	//自动生成主键
	 public static String getPrimaryKey() {
		 return UUID.randomUUID().toString();
	 }
	 public static String getOrdersNum() {
		 Date now = new Date();
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			String str = df.format(now)+System.currentTimeMillis();
			return str;
		 
	 }

}
