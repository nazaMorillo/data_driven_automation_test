package com.project.helpers;

public class StaticWiter {
	public static void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
