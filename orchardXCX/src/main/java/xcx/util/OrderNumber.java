package xcx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNumber {
	private static String date;

	private static Long on =00l;

	public static  Long getOrderNo() {

		synchronized (OrderNumber.class){

			String str = new SimpleDateFormat("yyMMddHHmm").format(new Date()); //当前时间

			if (date == null || !date.equals(str)) { //判断date

				date = str;

				on = 00l; //（这里是l）不是数字的1，因为是long类型

			}

			on++;

			long orderNo = Long.parseLong(date)*1000; //将字符串转化为Long类型

			orderNo += on;  //订单其实号

			return orderNo; //拼接订单号 SY是公司名称

		}

	}
}
