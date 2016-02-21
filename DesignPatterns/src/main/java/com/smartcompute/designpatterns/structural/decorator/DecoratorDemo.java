package com.smartcompute.designpatterns.structural.decorator;

public class DecoratorDemo {
	
	public static void main(String ...args){
		
		Shape redCircle = new RedShapeDecorator(new Circle());
		redCircle.draw();
		
		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		redRectangle.draw();
		
		
	}
}
