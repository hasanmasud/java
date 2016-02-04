package com.smartcompute.effectivejava.chapter11.item74;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Serializable subclass of a stateful no serializable superclass

public class Foo extends AbstractFoo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6147641824766764430L;

	public Foo(int x, int y) {
		super(x, y);
	}

	private void readObject(ObjectInputStream s) throws IOException,
			ClassNotFoundException {
		s.defaultReadObject();
		int x = s.readInt();
		int y = s.readInt();
		initialize(x, y);
	}

	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();
		s.writeInt(getX());
		s.writeInt(getY());
	}
}
