package com.smartcompute.effectivejava.chapter11.item74;

import java.util.concurrent.atomic.AtomicReference;

//NonSerializable stateful class allowing serializable subclass.
public abstract class AbstractFoo {

	private int x, y;

	private enum State {
		NEW, INITIALIZING, INITIALIZED
	};

	private final AtomicReference<State> INIT = new AtomicReference<AbstractFoo.State>(
			State.NEW);
	

	protected AbstractFoo() {
	}
	
	protected AbstractFoo(int x, int y) {
		initialize(x, y);
	}

	protected final void initialize(int x2, int y2) {
		if (!INIT.compareAndSet(State.NEW, State.INITIALIZING)) {
			throw new IllegalStateException("already initialized");
		}
		this.x = x2;
		this.y = y2;
	}

	protected final int getX() {
		checkInit();
		return this.x;
	}

	protected final int getY() {
		checkInit();
		return this.y;
	}

	private void checkInit() {
		if (!(INIT.get() == State.INITIALIZED)) {
			throw new IllegalStateException("not yet initialized");
		}
	}

}
