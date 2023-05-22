package com.demo.EmployeeCompany.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEmployeeDto {

     private List<CompanyDto> companyDto;



   // private List<EmployeeDto> employeeDto;
}
