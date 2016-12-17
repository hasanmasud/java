package online.smartcompute.tutorial.test.easymock.demo;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import online.smartcompute.tutorial.easymock.demo.EmployeeController;
import online.smartcompute.tutorial.easymock.demo.EmployeeService;

@RunWith(EasyMockRunner.class)
public class EmployeeControllerTest1 {
	
	@Mock
	private EmployeeService mock;
	
	@TestSubject
	private EmployeeController toBetested = new EmployeeController();
	
	@Test
	public void getEmployeeCount(){
		expect(this.mock.getEmployeeCount()).andReturn(100);
		replay(this.mock);
		int exp = toBetested.getProjectedEmployeeCount();
		assertEquals(exp,200);
		verify(this.mock);
	}

}
