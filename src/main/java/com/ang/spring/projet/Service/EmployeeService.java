package com.ang.spring.projet.Service;

import com.ang.spring.projet.Dto.EmployeeDto;
import com.ang.spring.projet.Models.Employee;

import java.util.List;

public interface EmployeeService {
    String addEmployee(EmployeeDto employeeDto);

    String updateEmployee( EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(int id);

    void deleteEmployee(int id);

    List<EmployeeDto> getAllEmployee();

    List<Employee> searchEmployees(String keyword);
    public List<Employee> getEmployeesByNom(String lastnom);
}
