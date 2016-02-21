package com.smartcompute.designpatterns.structural.decorator;

public class RedShapeDecorator extends ShapeDecorator{

	public RedShapeDecorator(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		this.shape.draw();
		setRedBorder(this.shape);
	}
	
	private void setRedBorder(Shape decoratedShape){
	      System.out.println("Border Color: Red");
	   }
}
