package com.smartcompute.designpatterns.structural.bridge;

public class Circle extends Shape{

	public Circle(DrawAPI drawAPI) {
		super(drawAPI);
	}

	@Override
	public void draw() {
		this.drawApi.drawCircle();
	}

}
