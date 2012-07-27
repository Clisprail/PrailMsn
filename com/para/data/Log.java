package com.para.data;

public class Log {
	private static boolean debug = true;
	
	public static void print(String str) {
		if(debug) {
			System.out.println(str);
		}
	}
	
	public static void setDebug(boolean enabled) {
		debug = enabled;
	}

}
