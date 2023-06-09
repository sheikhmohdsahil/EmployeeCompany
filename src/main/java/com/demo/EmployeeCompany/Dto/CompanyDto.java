package com.demo.EmployeeCompany.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto {


    private String companyName;

    private String address;

    private String email;

    private int phoneNumber;


   private List<EmployeeDto> employeeDto;
}
