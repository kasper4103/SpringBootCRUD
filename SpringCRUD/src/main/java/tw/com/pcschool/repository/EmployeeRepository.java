package tw.com.pcschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.pcschool.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
