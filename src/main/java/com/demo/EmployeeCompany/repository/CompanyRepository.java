package com.demo.EmployeeCompany.repository;

import com.demo.EmployeeCompany.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
