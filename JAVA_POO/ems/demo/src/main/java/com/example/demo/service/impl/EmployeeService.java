package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeCreateDTO;
import com.example.demo.dto.EmployeeUpdateDTO;
import com.example.demo.dto.EmployeeViewDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements com.example.demo.service.interfaces.EmployeeService {

    @Autowired
    private DtoUtils dtoUtils;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeViewDTO> getAllEmployees() {
        List<EmployeeViewDTO> employeeViewDTOS = new ArrayList<>();
        List<Employee> liste = (List<Employee>) employeeRepository.findAll();
        liste.stream().forEach(employee->{
            employeeViewDTOS.add(dtoUtils.convertToDto(employee,new EmployeeViewDTO(),EmployeeViewDTO.class));
        });
        return employeeViewDTOS;
    }

    @Override
    public EmployeeViewDTO getEmployeeById(Integer id) {
        return dtoUtils.convertToDto(employeeRepository.findById(id).orElseThrow(()->new RuntimeException()),new EmployeeViewDTO(), EmployeeViewDTO.class);
    }

    @Override
    public EmployeeViewDTO createEmployee(EmployeeCreateDTO employeeCreateDTO) {
        Department department = departmentRepository.findById(employeeCreateDTO.getDepartmentId()).get();
        Employee employee = employeeRepository.save(new Employee(employeeCreateDTO.getId(),employeeCreateDTO.getFirstName(),employeeCreateDTO.getLastName(), employeeCreateDTO.getEmail(), department));
        if(employee == null){
            throw new RuntimeException();
        }
        return dtoUtils.convertToDto(employee,new EmployeeViewDTO(), EmployeeViewDTO.class);
    }

    @Override
    public EmployeeViewDTO updateEmployee(Integer id, EmployeeUpdateDTO employeeUpdateDTO) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException());
        employee.setLastName(employeeUpdateDTO.getLastName());
        employee.setEmail(employeeUpdateDTO.getEmail());
        employee.setFirstName(employeeUpdateDTO.getFirstName());
        employeeRepository.save(employee);
        return dtoUtils.convertToDto(employee,new EmployeeViewDTO(), EmployeeViewDTO.class);
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException());
        employeeRepository.deleteById(employee.getId());
    }

}
