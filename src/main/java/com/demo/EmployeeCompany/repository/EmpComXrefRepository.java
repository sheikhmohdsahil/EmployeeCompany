package com.demo.EmployeeCompany.repository;

import com.demo.EmployeeCompany.entity.Employee;
import com.demo.EmployeeCompany.entity.EmployeeCompanyXref;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpComXrefRepository extends JpaRepository<EmployeeCompanyXref, Integer>{


    @Query("select count(o.employee.id) from EmployeeCompanyXref o where  o.company.id =:companyId")
    int findCountOfEmployees(int companyId);


    @Query("select o.employee from EmployeeCompanyXref o where o.company.id=:companyId")
    List<Employee> findAllEmployees(Integer companyId);
}
