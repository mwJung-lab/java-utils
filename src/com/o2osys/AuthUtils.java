package com.o2osys;

import java.util.Base64;

public class AuthUtils {
	@SuppressWarnings("unused")
	private static final String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password; 
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }
}
