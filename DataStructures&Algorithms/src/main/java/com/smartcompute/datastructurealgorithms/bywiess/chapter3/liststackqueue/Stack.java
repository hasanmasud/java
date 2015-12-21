package com.smartcompute.datastructurealgorithms.bywiess.chapter3.liststackqueue;

public class Stack {
	
	private int array [] ;
	private int topOfStack;
	
	public Stack(){
		array = new int[Integer.MAX_VALUE];
		topOfStack = -1;
	}
	
	public int pop() throws UnsupportedOperationException{
		if(topOfStack == -1){
			throw new UnsupportedOperationException();
		}
		return array[topOfStack--];
	}
	
	public void push(int x){
		array[++topOfStack] = x;
	}

}
