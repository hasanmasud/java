package com.smartcompute.designpatterns.structural.decorator;

public class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("drawing a rectangle");
	}

}
