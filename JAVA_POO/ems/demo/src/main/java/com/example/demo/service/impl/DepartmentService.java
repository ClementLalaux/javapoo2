package com.example.demo.service.impl;

import com.example.demo.dto.DepartmentCreateDTO;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.utils.DtoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements com.example.demo.service.interfaces.DepartmentService {

    @Autowired
    private DtoUtils dtoUtils;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentCreateDTO getDepartmentById(Integer id) {
        Department department = departmentRepository.findById(id).get();
        return dtoUtils.convertToDto(department, new DepartmentCreateDTO(), DepartmentCreateDTO.class);
    }

    @Override
    public DepartmentCreateDTO createDepartment(DepartmentCreateDTO departmentCreateDTO) {
        Department department = dtoUtils.convertToEntity(departmentCreateDTO , new Department(), Department.class);
        Department department1 = departmentRepository.save(department);
        return dtoUtils.convertToDto(department1,new DepartmentCreateDTO(), DepartmentCreateDTO.class);

    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentRepository.delete(departmentRepository.findById(id).get());
    }

    @Override
    public DepartmentCreateDTO updateDepartment(Integer id, DepartmentCreateDTO departmentCreateDTO) {
        Department department = departmentRepository.findById(id).orElseThrow(()->new RuntimeException());
        department.setDescription(departmentCreateDTO.getDepartmentDescription());
        department.setName(departmentCreateDTO.getDepartmentName());
        departmentRepository.save(department);
        return dtoUtils.convertToDto(department,new DepartmentCreateDTO(), DepartmentCreateDTO.class);
    }

    @Override
    public List<DepartmentCreateDTO> getAllDepartements() {
        List<DepartmentCreateDTO> departmentCreateDTOS = new ArrayList<>();
        List<Department> liste = (List<Department>) departmentRepository.findAll();
        liste.stream().forEach(department -> {
            departmentCreateDTOS.add(dtoUtils.convertToDto(department,new DepartmentCreateDTO(), DepartmentCreateDTO.class));
        });
        return departmentCreateDTOS;
    }


}
