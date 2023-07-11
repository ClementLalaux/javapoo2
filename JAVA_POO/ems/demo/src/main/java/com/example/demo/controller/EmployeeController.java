package com.example.demo.controller;

import com.example.demo.dto.EmployeeCreateDTO;
import com.example.demo.dto.EmployeeUpdateDTO;
import com.example.demo.dto.EmployeeViewDTO;
import com.example.demo.service.impl.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public List<EmployeeViewDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeViewDTO> getEmployeeById(@PathVariable Integer id){
        if(employeeService.getEmployeeById(id) == null){
            throw new RuntimeException("Employé non trouve");
        }
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.FOUND);
    }

    @PostMapping("")
    public EmployeeViewDTO createEmployee(@Valid @RequestBody EmployeeCreateDTO employeeCreateDTO){
        return employeeService.createEmployee(employeeCreateDTO);
    }

    @PutMapping("/{id}")
    public EmployeeViewDTO updateEmployee(@PathVariable Integer id, @RequestBody EmployeeUpdateDTO employeeUpdateDTO){
        try {
            return employeeService.updateEmployee(id,employeeUpdateDTO);
        } catch (Exception e){
            throw new RuntimeException("Probleme");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEmploye(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }

}
