package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DepartmentCreateDTO {

    private Integer id;
    @NotEmpty
    private String departmentName;
    @NotEmpty
    private String departmentDescription;

}
