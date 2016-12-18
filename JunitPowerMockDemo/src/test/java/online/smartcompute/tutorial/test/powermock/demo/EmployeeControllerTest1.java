package online.smartcompute.tutorial.test.powermock.demo;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import online.smartcompute.tutorial.powermock.demo.EmployeeController;
import online.smartcompute.tutorial.powermock.demo.IdGenerator;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IdGenerator.class)
public class EmployeeControllerTest1 {
	
	/**
	 * mock static methods
	 */
	@Test
	public void generateIdTest() {
		long expectedId = 42;
		EmployeeController employeeController = new EmployeeController();
		mockStatic(IdGenerator.class);
		expect(IdGenerator.generateId()).andReturn(expectedId);
		replay(IdGenerator.class);
		long actualId = employeeController.generateEmpId();
		verify(IdGenerator.class);
		assertEquals(expectedId, actualId);
	}
	

}
