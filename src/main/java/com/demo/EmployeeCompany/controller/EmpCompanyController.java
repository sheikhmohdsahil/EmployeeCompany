package com.demo.EmployeeCompany.controller;

import com.demo.EmployeeCompany.Dto.CompanyDto;
import com.demo.EmployeeCompany.Dto.EmpCompanyXrefDto;
import com.demo.EmployeeCompany.Dto.EmployeeDto;
import com.demo.EmployeeCompany.entity.Employee;
import com.demo.EmployeeCompany.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmpCompanyController {

    @Autowired
    private Service service;

    @PostMapping("/add/company")
    public String addCompany(@RequestBody CompanyDto companyDto) {
        service.saveCompany(companyDto);
        return "company saved successfully";
    }

    @PostMapping("/add/employee")
    public String addEmployee(@RequestBody EmployeeDto employeeDto) {
        service.saveEmployee(employeeDto);
        return "employee saved successfully";
    }

    @GetMapping("/get/all/employee")
    public List<Employee> fetchAllEmployee() {
       return service.findAll();
    }

    @GetMapping("/get/employee-name")
    public List<Employee> fetchAllEmpWithChar(@RequestParam String ch){
        return service.fetchNameWithA(ch);
    }


    @GetMapping("/month")
    public List<Employee> fetchingMonth(@RequestParam int n){
        return service.fetchWithMonth(n);
    }

    @PostMapping("/employeCompanyXref")
    public void employeCompanyXref(@RequestBody EmpCompanyXrefDto empCompanyXrefDto) throws Exception {
        service.comanyEmployeeMapping(empCompanyXrefDto);
    }

    @GetMapping("/ascendingOrder")
    public List<Employee> findEmployeesBySorting() {
        return service.getEmployeeBySorting();
    }


    @GetMapping("/salary")
    public List<Employee> getEmpByNthHighestSalary(@RequestParam int n) {
        return service.findEmpByNthHighestSalary(n);
        }

    @GetMapping("/count/of/employees")
    public int  countBYCompanyId(@RequestParam int companyId){
        return service.findByCompanyId(companyId);
    }

    @GetMapping("/salary/checking")
    public List<Employee> chechBySalary(@RequestParam int salary){
     return service.checkBySalary(salary);

    }
}
