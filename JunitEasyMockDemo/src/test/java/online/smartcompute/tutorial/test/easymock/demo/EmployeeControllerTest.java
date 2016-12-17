package online.smartcompute.tutorial.test.easymock.demo;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMockRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import online.smartcompute.tutorial.easymock.demo.EmployeeController;
import online.smartcompute.tutorial.easymock.demo.EmployeeService;

@RunWith(EasyMockRunner.class)
public class EmployeeControllerTest {
	
	private EmployeeService mock;
	
	private EmployeeController toBetested;
	
	@Before
	public void setUp(){
		this.mock =  createMock(EmployeeService.class);
		this.toBetested = new EmployeeController();
		this.toBetested.setEmployeeService(this.mock);
	}
	
	@Test
	public void getEmployeeCount(){
		expect(this.mock.getEmployeeCount()).andReturn(100);
		replay(this.mock);
		int exp = toBetested.getProjectedEmployeeCount();
		assertEquals(exp,200);
		verify(this.mock);
	}

}
