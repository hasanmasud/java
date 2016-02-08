package com.smartcompute.effectivejava.chapter11.item75;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CorrectStringList implements Serializable{
	
	private transient int size;
	private transient Entry head = null;
	
	private static class Entry{
		private String data;
		private Entry next;
		private Entry previous;
	}
	
	private void writeObject(ObjectOutputStream s) throws IOException{
		s.defaultWriteObject();
		s.writeInt(this.size);
		for(Entry e = head; e!= null ; e = e.next){
			s.writeBytes(e.data);
		}
	}
	
	private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException{
		
		is.defaultReadObject();
		
		
		
	}
	
	
	
	
	
	
	
	
}
