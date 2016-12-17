package online.smartcompute.tutorial.test.easymock.demo;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import online.smartcompute.tutorial.easymock.demo.EmployeeController;
import online.smartcompute.tutorial.easymock.demo.EmployeeService;

@RunWith(EasyMockRunner.class)
public class EmployeeControllerTest2 extends EasyMockSupport {
	
	private EmployeeService mock;
	
	private EmployeeController tobeTested;
	
	@Before
	public void setUp(){
		this.mock = createMock(EmployeeService.class);
		this.tobeTested = new EmployeeController();
		this.tobeTested.setEmployeeService(this.mock);
	}
	
	@Test
	public void getCoubnt(){
		EasyMock.expect(this.mock.getEmployeeCount()).andReturn(100);
		replayAll();
		assertEquals(this.tobeTested.getProjectedEmployeeCount(), 200);
		verifyAll();
	}
	
}
