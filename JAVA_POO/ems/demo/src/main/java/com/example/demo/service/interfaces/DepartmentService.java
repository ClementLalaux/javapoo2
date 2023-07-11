package com.example.demo.service.interfaces;

import com.example.demo.dto.DepartmentCreateDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentCreateDTO getDepartmentById(Integer id);
    DepartmentCreateDTO createDepartment(DepartmentCreateDTO departmentCreateDTO);
    void deleteDepartment(Integer id);
    DepartmentCreateDTO updateDepartment(Integer id, DepartmentCreateDTO departmentCreateDTO);

    List<DepartmentCreateDTO> getAllDepartements();

}
