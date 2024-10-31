package com.o2osys;

import java.util.function.IntFunction;

public class test3 {
	
	public static int ass (int a, int b) {
		
		return a > b ? a: b;
	} 
	
	public static void main(String[] args) throws Exception {
		IntFunction intSum = (x) -> x+2;
		
		System.out.println(intSum.apply(15));
	}
}
