package com.qinke.pemadmin.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TransitionUtils {

	private static SimpleDateFormat longFormateDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	 //获得当天0点时间
    public static Date getTimesmorning(Date date){
    	if(date ==null){
    		return null;
    	}
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    return cal.getTime();
    }
    //获得当天24点时间
    public static Date getTimesnight(Date date){
    	if(date ==null){
    		return null;
    	}
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.set(Calendar.HOUR_OF_DAY, 24);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    return cal.getTime();
    }

    public static Date getFirstDayOfMohth(Date date){
    	Calendar cal = Calendar.getInstance();
    	if(date ==null){
    		date = new Date();
    	}
    	cal.setTime(date);
    	cal.set(Calendar.DAY_OF_MONTH,1);
    	cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
    	cal.set(Calendar.MINUTE,cal.getMinimum(Calendar.MINUTE));
    	cal.set(Calendar.SECOND,cal.getMinimum(Calendar.SECOND));
    	return cal.getTime();
    }
    public static Date getLastDayOfMohth(Date date){
    	Calendar cal = Calendar.getInstance();
    	if(date ==null){
    		date = new Date();
    	}
    	cal.setTime(date);
    	cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//    	cal.set(Calendar.DAY_OF_MONTH,30);
    	cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
    	cal.set(Calendar.MINUTE,cal.getActualMaximum(Calendar.MINUTE));
    	cal.set(Calendar.SECOND,cal.getActualMaximum(Calendar.SECOND));
    	return cal.getTime();
    }
	public static Boolean transitionBoolean(String flag){
		Boolean dataFlag = false;
		switch (flag) {
		case "Y":
			dataFlag = true;
			break;
		case "N":
			dataFlag = false;
			break;
		}
		return dataFlag;
	}

	public static Double transitionDouble(Double param){
		if(param == null){

			param = 0d;
		}
		return param;
	}

	public static String unboxBoolean(Boolean param){
		String result = null;
		if(param != null){

			result = param ? "是":"否";
		}
		return result;
	}

	public static String transitionDate(Date param){

		String result = null;
		if(param != null){

			result = longFormateDate.format(param);
		}
		return result;
	}
}
