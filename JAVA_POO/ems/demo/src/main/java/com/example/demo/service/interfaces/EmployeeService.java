package com.example.demo.service.interfaces;

import com.example.demo.dto.EmployeeCreateDTO;
import com.example.demo.dto.EmployeeUpdateDTO;
import com.example.demo.dto.EmployeeViewDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeViewDTO> getAllEmployees();
    EmployeeViewDTO getEmployeeById(Integer id);
    EmployeeViewDTO createEmployee(EmployeeCreateDTO employeeCreateDTO);
    EmployeeViewDTO updateEmployee(Integer id, EmployeeUpdateDTO employeeUpdateDTO);
    void deleteEmployee(Integer id);

}
