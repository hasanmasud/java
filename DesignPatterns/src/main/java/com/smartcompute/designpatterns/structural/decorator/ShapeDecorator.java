package com.smartcompute.designpatterns.structural.decorator;

public abstract class ShapeDecorator implements Shape{

	protected Shape shape;
	
	public ShapeDecorator(Shape shape) {
		this.shape = shape;
	}
	
	@Override
	public abstract void draw();
}
