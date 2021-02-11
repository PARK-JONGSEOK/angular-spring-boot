package com.angular.backend.EmployeeService;

import com.angular.backend.exception.UserNotFondException;
import com.angular.backend.model.Employee;
import com.angular.backend.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    // 컨트롤러에 로직을 넣으면 안되며 컨트롤러는 매우 작고 사용자의 요청만 전달한다.
    // 서비스에 비즈니스 로직을 실행한다.
    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(
                new Employee(
                        employee.getName(),
                        employee.getEmail(),
                        employee.getJobTitle(),
                        employee.getPhone(),
                        employee.getImageUrl(),
                        UUID.randomUUID().toString()));
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findEmployeeById(employeeId)
                .orElseThrow(() -> new UserNotFondException("User by id" + employeeId + "was not found"));
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteEmployeeById(employeeId);
    }
}
