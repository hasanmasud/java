package com.smartcompute.designpatterns.behavioural.strategy;

public class Mute implements QuackBehaviour{

	@Override
	public void quack() {
		System.out.println("I am mute. I do not quack");
	}

}
