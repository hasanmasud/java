package com.smartcompute.designpatterns.structural.bridge;

public abstract class Shape {

	protected DrawAPI drawApi;
	
	public Shape(DrawAPI drawAPI){
		this.drawApi = drawAPI;
	}
	
	public abstract void draw();
	
}
