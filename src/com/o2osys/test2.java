package com.o2osys;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class test2 {
	
	public int solution(int i, int j, int k) {
        int answer = 0;
        String dfdf = "";
        
        for (int a = 0; a <= j; a++) {
        	dfdf += a;
        }
        
        for (int a = 0; a < dfdf.length(); a++) {
        	if (String.valueOf(dfdf.charAt(i)).equals(String.valueOf(k))) {
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        HashMap<String, String> dbInfo = new HashMap<>();
        
        for (int i = 0; i < db.length; i++) {
        	dbInfo.put(db[i][0], db[i][1]);
        }
        
        if (dbInfo.get(id_pw[0]) == null) {
        	return "fail";
        }
        
        if (dbInfo.get(id_pw[0]).equals(id_pw[1])) {
        	answer = "login";
        } else if (!dbInfo.get(id_pw[0]).equals(id_pw[1])) {
        	answer = "wrong pw";
        } 
        
        return answer;
    }
	
	public static int solution(String[] strArr) {
        int answer = 0;
        HashMap<Integer, Integer> a = new HashMap<>();
        ArrayList<Integer> c = new ArrayList<>();
        
        for (String b : strArr) {
        	a.put(b.length(), a.getOrDefault(b.length(), 0) + 1);
        }
        
        for (int i = 0; i < strArr.length; i++) {
        	c.add(a.get(strArr[i].length()));
        }
        
        Collections.sort(c);
        
        answer = c.get(c.size() - 1);
        
        
        return answer;
    }
	
	public static int[] solution2(String my_string) {
        
        HashMap<String, Integer> a = new HashMap<>();
        String alphbet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] answer = new int[alphbet.length()];
        
        for (int i = 0; i < alphbet.length(); i++) {
        	a.put(String.valueOf(alphbet.charAt(i)), a.getOrDefault(String.valueOf(alphbet.charAt(i)), 0));
        }
        
        for (int i = 0; i < my_string.length(); i++) {
        	a.put(String.valueOf(my_string.charAt(i)), a.getOrDefault(String.valueOf(my_string.charAt(i)), 0) + 1);
        }
        
        System.out.println(a);
        
        for (int i = 0; i < alphbet.length(); i++) {
        	answer[i] = a.get(String.valueOf(alphbet.charAt(i))) ;
        }
        
        System.out.println();
        
        return answer;
    }
	
	public int solution(int[] common) {
        int answer = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        for (int i = 0; i <= 2; i++) {
        	a.add(common[i+1] - common[i]);
        }
        
        if (a.get(0) == a.get(1)) {
        	answer = common[common.length - 1] + a.get(0);
        } else {
        	answer = common[common.length - 1] * (a.get(1) / a.get(0));
        }
        
        return answer;
    } 
	
	public String solution(String bin1, String bin2) {
        String answer = "";
        int a = Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2);
        
        answer = Integer.toBinaryString(a);
        
        return answer;
    }
	
	public ArrayList<String> solution(String my_str, int n) {
        ArrayList<String> a = new ArrayList<>();
        
        int b = my_str.length() / n;
        int c = my_str.length() % n;
        
        for (int i = 1; i <= b; i++) {
        	a.add(my_str.substring((i - 1) * n, n * i));
        }
        
        a.add(my_str.substring(my_str.length() - c, my_str.length()));
        
        return a;
    }
	
	public int solution(int[] numbers, int k) {
        int answer = 0;
        
        for (int i = 0; i < k; i++) {
        	if (i == 0) {
        		answer = numbers[i];
        	} else {
        		answer = numbers[i+1];
        	}
        }
        
        return answer;
    }
	
	public static String getLongDateNTimeByForm(Long cDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sDateNTime = sdf.format(cDate);

        return sDateNTime;
    }
	
	public String getHmacSha256(String input, String key) throws NoSuchAlgorithmException,
	InvalidKeyException, IllegalStateException, UnsupportedEncodingException {
	if (input == null || key == null || input.length() < 1 || key.length() < 1) {
		return null;
	}
	
	Mac mac = Mac.getInstance("HmacSHA256");
	SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
	mac.init(keySpec);
	
	String hmac = Base64.encodeBase64String(mac.doFinal(input.getBytes()));
	byte[] inBytes = input.getBytes("UTF-8");
	byte[] encBytes = mac.doFinal(inBytes);
	return hmac;
    }
	
	public String solution(String my_string) {
        String answer = "";

        for (int i = 0; i < my_string.length(); i++) {
        	if ((int) my_string.charAt(i) >= 65 && (int) my_string.charAt(i) < 97) {
        		answer += String.valueOf((int) my_string.charAt(i) + 32);
        	} else {
        		answer += String.valueOf((int) my_string.charAt(i) - 32);
        	}
        }
        
        return answer;
    }
	
	public static int[] solution(String[] keyinput, int[] board) {
        int[] answer = {};
        int[] center = {0, 0};
        
        for (int i = 0; i < keyinput.length; i++) {
        	if (keyinput[i].equals("up")) {
        		if (center[1] <= board[1]/2) {
        			center[0] = center[0];
            		center[1] = center[1] + 1;
        		}
        		System.out.println("A");
        	} else if (keyinput[i].equals("down")) {
        		if (center[1] <= -board[1]/2) {
	        		center[0] = center[0];
	        		center[1] = center[1] - 1;
        		}
        		System.out.println("B");
        	} else if (keyinput[i].equals("left")) {
        		if (center[0] >= -board[0]/2) {
	        		center[0] = center[0] - 1;
	        		center[1] = center[1];
        		}
        		System.out.println("C");
        	} else {
        		if (center[0] <= board[0]/2) {
	        		center[0] = center[0] + 1;
	        		center[1] = center[1];
        		}
        		System.out.println("D");
        	}
        	
        	System.out.println(center[0] + " , " + center[1]);
        }
        
        answer = center;
        return answer;
    }
	
	private static Mac mac;
	
	public static void main(String[] args) throws Exception {
		
	}
}
