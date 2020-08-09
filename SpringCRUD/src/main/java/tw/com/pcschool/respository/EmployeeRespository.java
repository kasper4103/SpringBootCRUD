package tw.com.pcschool.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.pcschool.model.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Long>{
	
}
