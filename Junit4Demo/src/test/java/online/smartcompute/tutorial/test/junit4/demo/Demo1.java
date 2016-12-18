package online.smartcompute.tutorial.test.junit4.demo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Demo1 {
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("before the class");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("after the class");
	}
	
	@Before
	public void beforeEvryMethod(){
		System.out.println("before every method");
	}
	
	@After
	public void afterEveryMethod(){
		System.out.println("after every method");
	}
	
	@Ignore("not working properly yet")
	public void ignoreThis(){
		System.out.println("ignored");
		assertEquals(10,11);
	}
	
	@Test
	public void test1(){
		System.out.println("test 1");
	}
	
	@Test
	public void test2(){
		System.out.println("test2");
	}
	
}
