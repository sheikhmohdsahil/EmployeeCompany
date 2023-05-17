package com.demo.EmployeeCompany.Dto;


import com.demo.EmployeeCompany.entity.Company;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String empName;
    private int salary;


    private String email;


    private Date dateOfBirth;


    private int pincode;

    private int age;




}
