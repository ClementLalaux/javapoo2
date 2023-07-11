package com.example.demo.dto;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeToEmployeDto {

    public EmployeeDto convert(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());

        return employeeDto;
    }



}
