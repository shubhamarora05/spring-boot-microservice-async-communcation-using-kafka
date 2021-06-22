package com.example.dept.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;    
}
