package com.o2osys;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TimeZone;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.annotation.JsonProperty;

import mannaPlanet.hermes.util.Utils;

public class test {
	
	public String getStringPatternNumberSA(String str) {
		if (str == null || str.equals("")) return "";
		str = str.replaceAll("[^-0-9]", "");
		return str;
	}
	
	public test (String a) {
		System.out.println("Strat : ");
		
		System.out.println("this : " + getStringPatternNumberSA("-1,500"));
		
		System.out.println("End : ");
	}
	
//	public static StringBuilder solution(String my_string) {
//        StringBuilder answer = null;
//        ArrayList<String> array = new ArrayList<String>();
//        
//        my_string = my_string.toLowerCase();
//        
//        for (int i = 0; i < my_string.length(); i++) {
//        	array.add(String.valueOf(my_string.charAt(i)));
//        }
//        
//        Collections.sort(array);
//        
//        StringBuilder c = new StringBuilder();
//        for (int j = 0; j < array.size(); j++) {
//        	
//        	answer = c.append(String.valueOf(array.get(j)));
//        }
//        
//        return answer;
//    }
	
//	public int solution(int[] array) {
//        int answer = 0;
//        
//        ArrayList<String> b = new ArrayList<String>();
//        StringBuilder a = new StringBuilder();
//        
//        for (int i = 0; i < array.length; i++) {
//        	b.add(String.valueOf(array[i]));
//        }
//        
//        for (int j = 0; j < b.size(); j++) {
//        	a = a.append(b.get(j));
//        }
//        
//        for (int k = 0; k < a.length(); k++) {
//        	if (a.charAt(k)=='7') {
//        		answer++;
//        	}
//        }
//        
//        return answer;
//    }
	
//	public int solution(int order) {
//        int answer = 0;
//        
//        String a = String.valueOf(order);
//        
//        for (int i = 0; i < a.length(); i++) {
//        	if (String.valueOf(a.charAt(i)).equals("3") || String.valueOf(a.charAt(i)).equals("6") || String.valueOf(a.charAt(i)).equals("9")) {
//        		answer++;
//        	}
//        }
//
//        
//        return answer;
//    }
	
//	public static int solution(int n) {
//        int answer = 1;
//        
//        for (int i = 1; i < n; i++) {
//            answer = i * i+1;
//            if (answer == n) {
//            	answer = i;
//            }
//        }
//        return answer;
//    }
	
	public static int solution(String s) {
        int answer = 0;
        s = s.replaceAll(" ", "");
        int index = 0;
        int[] a = new int[s.length()];
        System.out.println(s);
        
        for (int i = 0; i < s.length(); i++) {
        	if (s.contains("Z")) {
        		index = s.indexOf("Z");
        		s = s.replace("Z", String.valueOf(s.charAt(index-1)));
        	}
        }
        
        System.out.println(index);
        System.out.println(s);
        
        for (int j = 0; j < s.length(); j++) {
        	a[j] = Integer.parseInt(String.valueOf(s.charAt(j)));
        }
        
        for (int k = 0; k < a.length; k++) {
        	if (k != index) {
        		answer += a[k];
        	}
        	else {
        		answer = answer - a[index-1];
        	}
        }
        
        System.out.println(answer);
        
        return answer;
    }
	
//	public static int[] solution(String[] name, int[] yearning, String[][] photo) {
//        int[] answer = {};
//        HashMap<String, Integer> a = new HashMap<>();
//        int[][] b = new int[][] {};
//        
//        for (int i = 0; i < name.length; i++) {
//        	a.put(name[i], yearning[i]);
//        }
//        System.out.println("map : " + a);
//        
//        //["may", "kein", "kain", "radi"]
//        //[5, 10, 1, 3]
//        //[["may", "kein", "kain", "radi"],["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]
//        //[19, 15, 6]
////        for (int i = 0; i < name.length; i++) {
////        	name[i] = String.valueOf(yearning[i]);
////        	System.out.println(name[i]);
////        }
//        
//        for (int i = 0; i < photo.length; i++ ) {
//        	for (int j = 0; j < photo[i].length; j++) {
//        		if (a.containsKey(photo[i][j])) {
//        			b[i][j] = a.get(photo[i][j]);
//        			System.out.println("ddd : " + a.containsKey(photo[i][j]));
//        		}
//        	}
//        	if (b.length > 0) {
//        		int[][] d = b;
//        		answer[i] = Arrays.stream(d[i]).sum();
//        		System.out.println("d : " + d);
//        	}
//        	System.out.println("ccc : " + b);
//        }
//        System.out.println(b);
//        
//        return answer;
//    }
	
	public static int[] solution(String[] name, int[] yearning, String[][] photo) {
	    int[] answer = new int[photo.length]; // Initialize answer array with size

	    HashMap<String, Integer> a = new HashMap<>();
	    int maxColumns = 0; // Variable to store maximum number of columns
	    for (int i = 0; i < name.length; i++) {
	        a.put(name[i], yearning[i]);
	    }
	    System.out.println("map : " + a);

	    for (int i = 0; i < photo.length; i++) {
	        maxColumns = Math.max(maxColumns, photo[i].length); // Update maxColumns
	    }
	    
	    System.out.println("maxColumns : " + maxColumns);
	    int[][] b = new int[photo.length][maxColumns]; // Initialize b array with correct size
	    
	    for (int i = 0; i < photo.length; i++) {
	        for (int j = 0; j < photo[i].length; j++) {
	            if (a.containsKey(photo[i][j])) {
	                b[i][j] = a.get(photo[i][j]);
	                System.out.println("ddd : " + a.containsKey(photo[i][j]));
	                System.out.println(b[i][j]);
	            }
	        }
	        int rowSum = 0; // Variable to store sum of values in each row
	        for (int j = 0; j < b[i].length; j++) {
	            rowSum += b[i][j];
	        }
	        System.out.println("rowSum : " + rowSum);
	        answer[i] = rowSum; // Assign rowSum to answer array
	        System.out.println("ccc : " + Arrays.toString(b[i]));
	    }
	    System.out.println(Arrays.toString(answer));

	    return answer;
	}
	
	public static String solution(String my_string, int num1, int num2) {
        String answer = "";
        String[] a = my_string.split("");
        String temp;
        
        temp = a[num1];
        a[num1] = a[num2];
        a[num2] = temp;
        
        answer = String.join("", a);
        
        return answer;
    }
	
	public static StringBuilder solution(String my_string, int n) {
		StringBuilder answer = new StringBuilder();
        char[] b = my_string.toCharArray();
        
        for (char k : b) {
        	for (int i = 0; i < n; i++) {
        		answer.append(k);
        	}
        }
        
        System.out.println(answer);
        
        return answer;
    }
	
//	public static int solution(int[] common) {
//        int answer = 0;
//        
//        if (common[1] - common[0] == 1) {
//        	answer = common[common.length - 1] + (common[1] - common[0]);
//        }
//        
//        
//        else if (common[1] - common[0] != 1) {
//        	answer = common[common.length - 1] * (common[1] - common[0]);
//        }
//        return answer;
//    }
	
	public static String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        int index = 0;

        
        
        return answer;
    }
	
	public static boolean isDateCheck(String date) {
    	if (Utils.isEmpty(date))
			return false;
    	
    	// yyyymmddhh24miss 맞는지 확인
		if (date.length() != 14)
			return false;
		
		return true;
    }
	
	public static String getDateNTimeByForm(java.util.Date cDate, String sDateNTimeForm) {
        SimpleDateFormat sdf = new SimpleDateFormat(sDateNTimeForm);
        String sDateNTime = sdf.format(cDate);

        return sDateNTime;
    }
	
	public static String getDateNTimeByForm(long cDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String sDateNTime = sdf.format(cDate);

        return sDateNTime;
    }
	
	public static boolean getDateCustom(String date, int field, int amount, String ret[]) {
    	if (!isDateCheck(date)) {
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
			System.out.println("nYear : " + nYear);
			nMonth = Integer.parseInt(date.substring(4, 6));
			System.out.println("nMonth : " + nMonth);
			nDate = Integer.parseInt(date.substring(6, 8));
			System.out.println("nDate : " + nDate);
			nHourOfDay = Integer.parseInt(date.substring(8, 10));
			System.out.println("nHourOfDay : " + nHourOfDay);
			nMinute = Integer.parseInt(date.substring(10, 12));
			System.out.println("nMinute : " + nMinute);
			nSecond = Integer.parseInt(date.substring(12, 14));
			System.out.println("nSecond : " + nSecond);
		}
		catch (Exception e) {
			ret[0] = "날짜형식이 잘못되었습니다.";
			return false;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.set(nYear, nMonth - 1, nDate, nHourOfDay, nMinute, nSecond);
		cal.add(field, amount);
		System.out.println("CAL : " + cal);
		System.out.println("getTime : " + cal.getTime());
		ret[0] = getDateNTimeByForm(cal.getTime(), "yyyyMMddHHmmss");
		System.out.println("ret[0] : " + ret[0]);
		return true;
    }
	
	public static String getDateNTimeByForm(String sDateNTimeForm) {
        Calendar Today = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat(sDateNTimeForm);
        String sDateNTime = sdf.format(Today.getTime());

        return sDateNTime;
    }
	
	public static String signature(String bhkey, String snddate, String cscode) throws InvalidKeyException, NoSuchAlgorithmException {
        final String plainText = bhkey + snddate + cscode;
        return signatureSHA512(plainText);
      }
	
	private static String signatureSHA512(final String plainText) throws NoSuchAlgorithmException, InvalidKeyException {
        final MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(plainText.getBytes());
        return String.format("%64x", new BigInteger(1, md.digest()));
      }
	
	public static String alg = "AES";
    private final static String key = getDateNTimeByForm("yyyyMMddHHmmss"); // 32byte
    private static String iv = "1"; // 16byte
	
	public static String encryptAES256(String text) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }
	
	private static final SimpleDateFormat aaa = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final SimpleDateFormat bbb = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    
    /*
     * 날짜 형식 변환 
    */
    public static synchronized String getDateFormatMannaToOliveYoung(String dateTime) {
    	if (Utils.isEmpty(dateTime)) return "";
    	
		try {
			Date date = aaa.parse(dateTime);
			return bbb.format(date);
		} catch (ParseException e) {
			return "";
		}
    }
    
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> c = new ArrayList<Integer>();
        
        for (int[] b : commands) {
        	for (int i = b[0] - 1; i < b[1]; i++) {
        		a.add(array[i]);
        	}
        	
        	Collections.sort(a);
        	c.add(a.get(b[2] - 1));
        	a.clear();
        }
        
        return c;
    }
    
    public static ArrayList<Integer> solution(int []arr) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        for (int i = 0; i < arr.length - 1; i++) {
        	if (i == 0) {
        		a.add(arr[i]);
        	} else if (arr[i] != arr[i - 1] || arr[i] != arr[i + 1]) {
        		a.add(arr[i]);
        	} else {
        		break;
        	}
        }
        
        if (a.get(a.size() - 1) != arr[arr.length - 1]) {
        	a.add(arr[arr.length - 1]);
        }

        return a;
    }
    
    public interface StringConcat {
        public void makeString(String s1, String s2);
    }
    
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
    
    /*
     * 날짜 형식 변환 
    */
    public static synchronized String getDateFormatMannaToYogiyo(String dateTime) {
    	if (Utils.isEmpty(dateTime)) return "";
    	
		try {
			Date date = MANNA_DATE_FORMAT.parse(dateTime);
			return YOGIYO_DATE_FORMAT.format(date);
		} catch (ParseException e) {
			return "";
		}
    }
    
    /*
     * 날짜 형식 변환 
    */
    public static Long getUnixTime(String dateTime) {
    	if (Utils.isEmpty(dateTime)) return null;
    	
		try {
			Date date = MANNA_DATE_FORMAT.parse(dateTime);
			
			// Java 시간 더하기
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			long unixTime = cal.getTimeInMillis() / 1000;
			
			return unixTime;
		} catch (ParseException e) {
			return null;
		}
    }
    
    public static class LoginInfo {
    	
    	@JsonProperty("GRP_CODE")
		private String grpCode;
		
		@JsonProperty("GRP_TYPE")
		private String grpType;
    }
    
    public static class userLoginInfoSDReqDto {
    	private ArrayList<LoginInfo> loginInfo;
    }
    
    private static final SimpleDateFormat MANNA_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final SimpleDateFormat BAEMIN_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS");
    private static final SimpleDateFormat YOGIYO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static final SimpleDateFormat VROONG_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+09:00");
    
    public static void byte_to_ascii(byte[] b) {
    	System.out.print("Text [Ascii Format] : ");
    	for (int i = 0; i < b.length; i ++) {
    		System.out.print((int) b[i] + ";");
    		
    	}
    	System.out.println();
    }
    
	public static void main(String[] args) throws Exception {
		    String a = "@![고객용]\r\n" + 
		    		"a!B!8a요기요 방문식사\r\n" + 
		    		"a!B!a[예약] 06월 22일(수) 오후06:09\r\n" + 
		    		"a!B------------------------------------------\r\n" + 
		    		"!방문인원: 4명\r\n" + 
		    		"a!B!방문식사번호: #1310\r\n" + 
		    		"a!B!결제 방법: 요기요결제완료\r\n" + 
		    		"a!B------------------------------------------\r\n" + 
		    		"!요청 사항:\r\n" + 
		    		"a!B!가게 사장님께: 많이 주세요~~!!\r\n" + 
		    		"a!B------------------------------------------\r\n" + 
		    		"!연락처: 000000000\r\n" + 
		    		"a!B------------------------------------------\r\n" + 
		    		"!메뉴명                      수량      가격\r\n" + 
		    		"a!B------------------------------------------\r\n" + 
		    		"!네네 반반시리즈: 뼈 반반      1     17,000\r\n" + 
		    		"a!B!- 반마리 선택: 레드마요반     1      2,500\r\n" + 
		    		"a!B!- 반마리 선택: 매콤치즈스노   1      2,000\r\n" + 
		    		"윙반                                      \r\n" + 
		    		"a!B------------------------------------------\r\n" + 
		    		"!합계:                               21,500\r\n" + 
		    		"a!B------------------------------------------\r\n" + 
		    		"!주문 매장: 네네치킨-광양중동점\r\n" + 
		    		"a!B!주문 번호: F2206221731JWUF7\r\n" + 
		    		"a!B!주문 일자: 2022년 06월 22일(수) 오후05:32\r\n" + 
		    		"a!B------------------------------------------\r\n" + 
		    		"!원산지: 닭고기(국내산)\r\n" + 
		    		"a!B\r\n" + 
		    		"\r\n" + 
		    		"\r\n" + 
		    		"\r\n" + 
		    		"\r\n" + 
		    		"\r\n" + 
		    		"\r\n" + 
		    		"i@![매장용]\r\n" + 
		    		"a!B!8a요기요 방문식사\r\n" + 
		    		"a!B!a[예약] 06월 22일(수) 오후06:09\r\n" + 
		    		"a!B------------------------------------------\r\n" + 
		    		"!방문인원: 4명\r\n" + 
		    		"a!B!방문식사번호: #1310\r\n" + 
		    		"a!B------------------------------------------\r\n" + 
		    		"!요청 사항:\r\n" + 
		    		"a!BB!가게 사장님께: 많이 주세요~~!!\r\n" + 
		    		"a!B------------------------------------------\r\n" + 
		    		"!메뉴명                                수량\r\n" + 
		    		"a!B------------------------------------------\r\n" + 
		    		"!네네 반반시리즈: 뼈 반반                 1\r\n" + 
		    		"a!B!- 반마리 선택: 레드마요반                1\r\n" + 
		    		"a!B!- 반마리 선택: 매콤치즈스노윙반          1\r\n" + 
		    		"a!B------------------------------------------\r\n" + 
		    		"!주문 일자: 2022년 06월 22일(수) 오후05:32\r\n" + 
		    		"a!B\r\n" + 
		    		"\r\n" + 
		    		"\r\n" + 
		    		"\r\n" + 
		    		"\r\n" + 
		    		"i";
		    
		    byte[] bytes = a.getBytes("EUC-KR");
		    byte_to_ascii(bytes);
		    
		    String b = new String(bytes);
	}
}
