package online.smartcompute.tutorial.jmock.demo;

/**
 * 
 * @author Masud
 *
 */
public class EmployeeController {
	
	private EmployeeInterface employeeService;
	
	/**
	 * 
	 * @return
	 */
	public Long generateEmpId(){
		return IdGenerator.generateId();
	}

	/**
	 * 
	 * @return
	 */
	public int getProjectedEmployeeCount() {
		final int actualEmployeeCount = employeeService.getEmployeeCount();
		
		return actualEmployeeCount * 2;
	}

	/**
	 * 
	 * @param employee
	 */
	public void saveEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
	}

	/**
	 * @param employeeService the employeeService to set
	 */
	public void setEmployeeService(EmployeeInterface employeeService) {
		this.employeeService = employeeService;
	}

	
	
}