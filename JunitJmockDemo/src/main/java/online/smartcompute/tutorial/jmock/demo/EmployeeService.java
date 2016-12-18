package online.smartcompute.tutorial.jmock.demo;

public class EmployeeService implements EmployeeInterface{
	/**
	 * 
	 * @return
	 */
	public int getEmployeeCount() {
		throw new UnsupportedOperationException("i do not want this to be called");
	}

	/**
	 * 
	 * @param employee
	 */
	public void saveEmployee(Employee employee) {
		throw new UnsupportedOperationException("i do not want to call this");
	}

}