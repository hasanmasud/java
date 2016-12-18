package online.smartcompute.tutorial.test.powermock.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import online.smartcompute.tutorial.powermock.demo.EmployeeController;
import online.smartcompute.tutorial.powermock.demo.EmployeeService;

@RunWith(PowerMockRunner.class)
public class EmployeeControllerTest {

	@Test
	public void shouldGetCountOfEmployees() {
		EmployeeController employeeController = new EmployeeController(new EmployeeService());
		Assert.assertEquals(10, employeeController.getProjectedEmployeeCount());
	}

	/**
	 * generic test
	 */
	@Test
	public void shouldGetCountOfEmployeesMock() {
		EmployeeService mock = PowerMockito.mock(EmployeeService.class);
		PowerMockito.when(mock.getEmployeeCount()).thenReturn(8);
		EmployeeController employeeController = new EmployeeController(mock);
		Assert.assertEquals(16, employeeController.getProjectedEmployeeCount());
	}

}
