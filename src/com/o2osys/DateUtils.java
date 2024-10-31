package com.o2osys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtils {
	public static String getDateReplace(String date) {
		date = date.replaceAll("-", "");
		date = date.replaceAll(":", "");
		date = date.replaceAll(" ", "");
		return date;
	}
	
	/**
	 * 라스트 싱크 날짜 와 데이터의 날짜 비교
	 * @param lastSyncDate
	 * @param dataDate
	 * @return true : lastSyncDate <= dateDate   ex) if (arDateRet[0].compareTo(inLastSyncDate) >= 0)
	 */
	public static boolean isLastSyncDateEquals(String lastSyncDate, String dataDate) {
		if (lastSyncDate.compareTo(dataDate) > 0)
			return false;
			
		return true;
	}
	
    /**
     * sDateNTimeForm 형식의 현재 시각 문자열을 얻는다.
     * @param sDateNTimeForm 현재시각 Formatting 문자열(년도:yyyy 월:MM 일:dd 시:HH 분:mm 초:ss)<br>
     * example - yyyyMMddHHmmss, yyyy년 MM월 dd일 HH시 mm분 ss초
     * @return 현재시간문자열
     */
    public static String getDateNTimeByForm(String sDateNTimeForm) {
        Calendar Today = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat(sDateNTimeForm);
        String sDateNTime = sdf.format(Today.getTime());

        return sDateNTime;
    }

    /**
     * sDateNTimeForm 형식의 문자열을 얻는다.
     * @param cDate 입력 날짜
     * @param sDateNTimeForm 현재시각 Formatting 문자열(년도:yyyy 월:MM 일:dd 시:HH 분:mm 초:ss)<br>
     * example - yyyyMMddHHmmss, yyyy년 MM월 dd일 HH시 mm분 ss초
     * @return 시간문자열
     */
    public static String getDateNTimeByForm(java.util.Date cDate, String sDateNTimeForm) {
        SimpleDateFormat sdf = new SimpleDateFormat(sDateNTimeForm);
        String sDateNTime = sdf.format(cDate);

        return sDateNTime;
    }
    
    /**
     * 날짜에 시간을 더하거나 뺀후 리턴
     * @param date
     * @param field
     * @param amount
     * @param ret
     * @return
     */
    public static boolean getDateCustom(String date, int field, int amount, String ret[]) {
    	if (!DateUtils.isDateCheck(date)) {
			ret[0] = "날짜형식이 잘못되었습니다.";
			return false;
		}
			
    	int nYear = 0;
		int nMonth = 0;
		int nDate = 0;
		int nHourOfDay = 0;
		int nMinute = 0;
		int nSecond = 0;
		
		try {
			nYear = Integer.parseInt(date.substring(0, 4));
			nMonth = Integer.parseInt(date.substring(4, 6));
			nDate = Integer.parseInt(date.substring(6, 8));
			nHourOfDay = Integer.parseInt(date.substring(8, 10));
			nMinute = Integer.parseInt(date.substring(10, 12));
			nSecond = Integer.parseInt(date.substring(12, 14));
		}
		catch (Exception e) {
			ret[0] = "날짜형식이 잘못되었습니다.";
			return false;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.set(nYear, nMonth - 1, nDate, nHourOfDay, nMinute, nSecond);
		cal.add(field, amount);
		ret[0] = DateUtils.getDateNTimeByForm(cal.getTime(), "yyyyMMddHHmmss");
		return true;
    }
    
    public static boolean isDateCheck(String date) {
    	if (date == null)
			return false;
    	
    	// yyyymmddhh24miss 맞는지 확인
		if (date.length() != 14)
			return false;
		
		return true;
    }
    
    /**
     * Long 형식의 Date의 문자열을 얻는다.
     * @param cDate 입력 날짜
     * example - yyyyMMddHHmmss, yyyy년 MM월 dd일 HH시 mm분 ss초
     * @return 시간문자열
     */
    public static String getLongDateNTimeByForm(long cDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String sDateNTime = sdf.format(cDate);

        return sDateNTime;
    }
    
    /*
     * 날짜 (UTC) 
    */
    public static String localtimeToUTC(String inputdatetime) {
        String utcTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
        TimeZone tz = TimeZone.getDefault();
    	 
        try {
            Date parseDate = sdf.parse(inputdatetime);
            long milliseconds = parseDate.getTime();
            int offset = tz.getOffset(milliseconds);
            utcTime = sdf.format(milliseconds - offset);
            utcTime = utcTime.replace("+0000", "");
        } catch (ParseException e) {
			return "";
		}
    	 
        return utcTime;
    }
}
