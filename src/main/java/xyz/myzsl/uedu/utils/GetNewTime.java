package xyz.myzsl.uedu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取当前时间的工具类
 */
public class GetNewTime {
	public static String getNewTime() {
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sim.format(new Date());
		return date;
	}
}
