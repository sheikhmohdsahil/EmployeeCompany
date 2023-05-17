package com.demo.EmployeeCompany.repository;

import com.demo.EmployeeCompany.entity.Company;
import com.demo.EmployeeCompany.entity.Employee;
import com.demo.EmployeeCompany.entity.EmployeeCompanyXref;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpComXrefRepository extends JpaRepository<EmployeeCompanyXref, Integer>{


    @Query("select count(o.employee.id) from EmployeeCompanyXref o where  o.company.id =:companyId")
    int findCountOfEmployees(int companyId);

}
