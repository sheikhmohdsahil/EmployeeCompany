package com.demo.EmployeeCompany.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class CompanyEmployeeDto {

    private String companyName;

    private String address;

    private String email;

    private int phoneNumber;

    @JsonIgnore
    private List<EmployeeDto> employeeDto;
}
