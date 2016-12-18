package online.smartcompute.tutorial.powermock.demo;

public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

	public int getProjectedEmployeeCount() {
		final int actualEmployeeCount = employeeService.getEmployeeCount();
		return actualEmployeeCount * 2;
	}

	public void saveEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
	}
	
	
	public Long generateEmpId(){
		return IdGenerator.generateId();
	}
}