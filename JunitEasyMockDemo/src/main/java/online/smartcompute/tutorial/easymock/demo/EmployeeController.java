package online.smartcompute.tutorial.easymock.demo;

/**
 * 
 * @author Masud
 *
 */
public class EmployeeController {
	
	private EmployeeService employeeService;
	
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
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
}