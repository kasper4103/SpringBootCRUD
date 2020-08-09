package tw.com.pcschool.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.pcschool.dao.EmployeeDAO;
import tw.com.pcschool.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	EmployeeDAO employeeDAO;

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		
		return employeeDAO.save(emp);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeDAO.findAll();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empid){
		Employee emp= employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empid,@Valid @RequestBody Employee empDetails){
		Employee emp= employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		emp.setUserName(empDetails.getUserName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		
		Employee updateEmployee=employeeDAO.save(emp);
		
		return ResponseEntity.ok().body(updateEmployee);
	}
	
	@DeleteMapping("/note/{id}")
	public ResponseEntity<Employee>  deleteEmployee(@PathVariable(value = "id") Long empId){
		
			Employee emp=employeeDAO.findOne(empId);
			if(emp==null) {
				return ResponseEntity.notFound().build();
			}
			employeeDAO.delete(emp);
			
		return ResponseEntity.ok().build();
	}
	
	
	
}





















