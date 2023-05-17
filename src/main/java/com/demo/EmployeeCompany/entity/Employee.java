package com.demo.EmployeeCompany.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false)
    private String empName;

    @Column(nullable = false)
    private int salary;


    @Column(nullable = false)
    private String email;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private int pincode;

    @Column(nullable = false)
    private int age;


}
