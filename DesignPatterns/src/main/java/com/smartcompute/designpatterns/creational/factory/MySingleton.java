package com.smartcompute.designpatterns.creational.factory;

public class MySingleton {
	
	private static final MySingleton INSTANCE = new MySingleton();
	
	public static  MySingleton getInstance(){
		return INSTANCE;
	}

}
