package com.angular.backend.repository;

import com.angular.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long employeeId);

    Optional<Employee> findEmployeeById(Long employeeId);
}
