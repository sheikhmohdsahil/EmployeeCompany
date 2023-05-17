package com.demo.EmployeeCompany.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpCompanyXrefDto {

    private Integer id;
    private Integer employeeId;

    private Integer CompanyId;

}
