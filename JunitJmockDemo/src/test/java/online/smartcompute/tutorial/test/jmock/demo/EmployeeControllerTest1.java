package online.smartcompute.tutorial.test.jmock.demo;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import online.smartcompute.tutorial.jmock.demo.EmployeeController;
import online.smartcompute.tutorial.jmock.demo.EmployeeInterface;
import online.smartcompute.tutorial.jmock.demo.EmployeeService;

public class EmployeeControllerTest1 {
	
	private EmployeeInterface mock;
	private EmployeeController tobeTested = new EmployeeController();
	 
	 private Mockery context = new JUnit4Mockery();
	 
	 @Before
	 public void setUp(){
		 this.mock = this.context.mock(EmployeeInterface.class);
		 this.tobeTested.setEmployeeService(this.mock);
	 }
	 
	 
	 @Test
	 public void getCount(){
		 
		 this.context.checking(new Expectations(){
			 {
				 oneOf(mock).getEmployeeCount(); will(returnValue(100));
			 }
		 });
		 
		 int expv = this.tobeTested.getProjectedEmployeeCount();
		 assertEquals(expv, 200);
	 }
	 
}
