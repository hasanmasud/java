package online.smartcompute.tutorial.test.junit4.demo;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class DemoRule implements TestRule{
	@Override
	public Statement apply(Statement stmnt, Description desc) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try{
					System.out.println("before execution");
					stmnt.evaluate();
				}finally {
					System.out.println("after execution");
				}
			}
		};
	}
}
