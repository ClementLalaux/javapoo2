package com.example.demo.controller;

import com.example.demo.dto.DepartmentCreateDTO;
import com.example.demo.dto.EmployeeUpdateDTO;
import com.example.demo.dto.EmployeeViewDTO;
import com.example.demo.service.interfaces.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("")
    public DepartmentCreateDTO createDepartment(@Valid @RequestBody DepartmentCreateDTO departmentCreateDTO){
        return departmentService.createDepartment(departmentCreateDTO);
    }

    @GetMapping("")
    public List<DepartmentCreateDTO> getAllDepartements(){
        return departmentService.getAllDepartements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentCreateDTO> getDepartmentById(@PathVariable Integer id){
        if(departmentService.getDepartmentById(id) == null){
            throw new RuntimeException("Departement pas trouvé");
        }
        return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer id){
        if(departmentService.getDepartmentById(id) == null){
            throw new RuntimeException("Departement pas trouvé");
        }
        try {
            departmentService.deleteDepartment(id);
            return ResponseEntity.status(204).build();
        }catch (Exception e){
            throw new RuntimeException("Pas réussi a supprimer");
        }
    }

    @PutMapping("/{id}")
    public DepartmentCreateDTO updateEmployee(@PathVariable Integer id, @RequestBody DepartmentCreateDTO departmentCreateDTO){
        try {
            return departmentService.updateDepartment(id,departmentCreateDTO);
        } catch (Exception e){
            throw new RuntimeException("Probleme");
        }
    }
}
