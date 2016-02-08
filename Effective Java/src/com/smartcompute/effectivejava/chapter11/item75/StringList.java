package com.smartcompute.effectivejava.chapter11.item75;

import java.io.Serializable;

public class StringList implements Serializable{
	
	private int size;
	private Entry head = null;
	
	private static class Entry implements Serializable{
		private String data;
		private Entry next;
		private Entry previous;
	}
	
	
	
}
