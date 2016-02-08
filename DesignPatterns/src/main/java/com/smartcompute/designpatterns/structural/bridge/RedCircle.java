package com.smartcompute.designpatterns.structural.bridge;

public class RedCircle implements DrawAPI{

	@Override
	public void drawCircle() {
		System.out.println("drawing red circle");
	}

	
}
