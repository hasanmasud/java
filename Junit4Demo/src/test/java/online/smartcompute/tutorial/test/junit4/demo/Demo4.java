package online.smartcompute.tutorial.test.junit4.demo;

import org.junit.Rule;
import org.junit.Test;

public class Demo4 {

	@Rule
	public DemoRule rule1 = new DemoRule();
	
//	@Rule
//	public DemoRule rule2 = new DemoRule();
	
	@Test
	public void test(){
		System.out.println("execution");
	}
}
