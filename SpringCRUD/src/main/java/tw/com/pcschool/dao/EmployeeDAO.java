package tw.com.pcschool.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tw.com.pcschool.model.Employee;
import tw.com.pcschool.repository.EmployeeRepository;

public class EmployeeDAO {
	@Autowired
	EmployeeRepository  employeeRepository;
	//save
	
	public  Employee save(Employee emp) {
		
		return employeeRepository.save(emp);
	}
	
	public Employee findOne(Long id) {
		return employeeRepository.getOne(id);
	}
	
	
	
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}
	
	
	//search
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	
	
}