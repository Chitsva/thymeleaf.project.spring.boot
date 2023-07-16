package thymeleaf.project.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thymeleaf.project.spring.boot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
