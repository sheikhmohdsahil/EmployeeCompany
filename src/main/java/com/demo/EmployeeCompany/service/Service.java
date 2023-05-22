package com.demo.EmployeeCompany.service;

import com.demo.EmployeeCompany.Dto.*;
import com.demo.EmployeeCompany.entity.Company;
import com.demo.EmployeeCompany.entity.Employee;
import com.demo.EmployeeCompany.entity.EmployeeCompanyXref;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Service {

    public void  saveCompany(CompanyDto companyDto);

    public void saveEmployee(EmployeeDto employeeDto);

    public void saveAllEmployee(List<EmployeeDto> employeeDto);


    List<Employee> findAll();

    List<EmployeeCompanyXref> findAllComp();

//    List<Employee> fetchNameWithA(char ch);

    List<Employee> fetchNameWithA(String ch);

//    Employee fetchNthHighestSalary(Integer n);

    List<Employee> fetchWithMonth(int n);


//    void addingEmpComXref(EmpCompanyXrefDto empCompanyXrefDto);


    List<Employee> getEmployeeBySorting();

    CompanyEmployeeDto fetchAllCompany() throws Exception;

//    List<Employee> findEmpByNthHighestSalary(int n);

    void comanyEmployeeMapping(EmpCompanyXrefDto empCompanyXrefDto) throws Exception;

    int findByCompanyId(int companyId);

    List<Employee> checkBySalary(int salary);

    List<Employee> findEmpByNthHighestSalary(int n);

    List<EmployeeCompanyXref> findAllcompanies();

    List<ComEmpDTO> fetchAllCompanywithEmployee();
}
