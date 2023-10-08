package com.ang.spring.projet.Controller;

import com.ang.spring.projet.Dto.EmployeeDto;
import com.ang.spring.projet.Models.Employee;
import com.ang.spring.projet.Models.Report;
import com.ang.spring.projet.Models.StringResult;
import com.ang.spring.projet.Service.EmployeeService;
import com.ang.spring.projet.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ang.spring.projet.Repo.EmployeeRepo;;
import java.sql.SQLException;
import java.util.List;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    @Qualifier("reportService")
    ReportService reportService;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDto) {
        String id = employeeService.addEmployee(employeeDto);
        return id;

    }

    @GetMapping(path = "/getAllEmployee")
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeDto> allEmployees = employeeService.getAllEmployee();
        return allEmployees;
    }

    @PutMapping(path = "/update")
    @ResponseBody
    public String updateEmployee(@RequestBody EmployeeDto employeeDto) {
        String updatedId = employeeService.updateEmployee(employeeDto);
        return updatedId;
    }

    @GetMapping(path = "getEmployeeById/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(Integer.parseInt(String.valueOf(id)));
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping(path = "/printEmployee")
    public StringResult getallEmployee(@RequestBody Report report) {
        try {
            return reportService.createReport(report);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String keyword) {
        System.out.println("Received search request with keyword: " + keyword);
        return employeeService.searchEmployees(keyword);
    }

    @GetMapping("/searchs/{nom}")
    public ResponseEntity<List<Employee>> getEmployeesByNom(@PathVariable String nom) {
        List<Employee> employeeDtos = employeeService.getEmployeesByNom(nom);
        return ResponseEntity.ok(employeeDtos);
    }


}