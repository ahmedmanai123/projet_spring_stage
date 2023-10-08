package com.ang.spring.projet.Service;

import com.ang.spring.projet.Dto.EmployeeDto;
import com.ang.spring.projet.Models.Employee;
import com.ang.spring.projet.Models.Services;
import com.ang.spring.projet.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImpl implements EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;



    @Override
    public String addEmployee(EmployeeDto employeeDto) {
        Employee employee=new Employee(
                employeeDto.getId(),
                employeeDto.getNom(),
                employeeDto.getDate_dembouche(),
                employeeDto.getMail(),
                employeeDto.getTel(),
                employeeDto.getDateAeith(),
                employeeDto.getMatricle(),
                employeeDto.getNom_service()


        );
        Services service = employeeDto.getNom_service();
        employee.setNom_service(service);
        employeeRepo.save(employee);
                return employee.getNom();

    }

    @Override
    public String updateEmployee(EmployeeDto employeeDto) {
        if (employeeRepo.existsById(employeeDto.getId())) {
            Employee employee = employeeRepo.getById(employeeDto.getId());
            employee.setNom(employeeDto.getNom());
            employee.setDate_dembouche(employeeDto.getDate_dembouche());
            employee.setMail(employeeDto.getMail());
            employee.setTel(employeeDto.getTel());
            employee.setDateAeith(employeeDto.getDateAeith());
            employee.setMatricle(employeeDto.getMatricle());
            employee.setNom_service(employeeDto.getNom_service());
            employeeRepo.save(employee);
            return "Employé mis à jour avec succès.";
        } else {
            return "Employé non trouvé.";
        }
    }



    @Override
    public EmployeeDto getEmployeeById(int id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
            return employeeDto;
        }
        return null;
    }

    @Override
    public void deleteEmployee(int id) {
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
        } else {
            throw new RuntimeException("Employee en ID " + id + " ne  exist pas.");
        }
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee>getEmployees=employeeRepo.findAll();
        List<EmployeeDto>employeeDtoList=new ArrayList<>();
        for (Employee e:getEmployees){
            EmployeeDto employeeDto=new EmployeeDto(
                    e.getId(),
                    e.getNom(),
                    e.getDate_dembouche(),
                    e.getMail(),
                    e.getTel(),
                    e.getDateAeith(),
                    e.getMatricle(),
                    e.getNom_service()

            );
            employeeDtoList.add(employeeDto);
        }
        return employeeDtoList;
    }

    @Override
    public List<Employee> searchEmployees(String keyword) {

        return employeeRepo.findByNomOrMatricle(keyword, keyword);
    }

    @Override
    public List<Employee> getEmployeesByNom(String nom) {

        return employeeRepo.findBynom(nom);
    }


}
