package com.demo.EmployeeCompany.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpCompanyXrefDto {

    @JsonIgnore
    private Integer id;
    private Integer employeeId;

    private Integer companyId;

}
