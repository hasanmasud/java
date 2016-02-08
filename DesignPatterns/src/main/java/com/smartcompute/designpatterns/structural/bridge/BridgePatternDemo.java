package com.smartcompute.designpatterns.structural.bridge;

public class BridgePatternDemo {

	public static void main(String ...args){
		
		Shape shape1 = new Circle(new RedCircle());
		Shape shape2 = new Circle(new GreenCircle());
		
		shape1.draw();
		shape2.draw();
	}
	
}
