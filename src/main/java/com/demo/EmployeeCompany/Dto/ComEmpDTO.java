package com.demo.EmployeeCompany.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComEmpDTO {

    private String companyName;

    private String address;

    private String email;

    private int phoneNumber;

    private List<EmployeeDto> employeeDto;


}
