package com.example.demo.controller;


import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeDtoToEmployee;
import com.example.demo.dto.EmployeeToEmployeDto;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeDtoToEmployee employeeDtoToEmployee;

    @Autowired
    private EmployeeToEmployeDto employeeToEmployeDto;

    @PostMapping("/create_employee")
    public ResponseEntity<EmployeeDto>addEmployee(@RequestBody Employee employee){

        Employee employee1 = employeeService.save(employee);

        return new ResponseEntity<EmployeeDto>(employeeToEmployeDto.convert(employee1), HttpStatus.OK);

    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>>findAll(){
        List<Employee> employees = employeeService.findAll();

        List<EmployeeDto> employeeDtos = new ArrayList<>();

        for (Employee e: employees) {
            employeeDtos.add(employeeToEmployeDto.convert(e));
        }
        return new ResponseEntity<List<EmployeeDto>>(employeeDtos,HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto>findById(@PathVariable("id") Integer id){
        Employee employee = employeeService.findById(id).get();
        return new ResponseEntity<EmployeeDto>(employeeToEmployeDto.convert(employee), HttpStatus.OK);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable("id") Integer id, @RequestBody EmployeeDto employeeDto){
        Optional<Employee> employee = employeeService.findById(id);
        if(employee.isPresent()){
            Employee employee1 = employee.get();
            employee1.setEmail(employeeDto.getEmail());
            employee1.setFirstName(employeeDto.getFirstName());
            employee1.setLastName(employeeDto.getLastName());
            employeeService.save(employee1);
            return new ResponseEntity<EmployeeDto>(employeeToEmployeDto.convert(employee1), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
