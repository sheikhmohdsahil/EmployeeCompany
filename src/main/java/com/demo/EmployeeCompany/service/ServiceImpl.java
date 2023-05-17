package com.demo.EmployeeCompany.service;

import com.demo.EmployeeCompany.Dto.CompanyDto;
import com.demo.EmployeeCompany.Dto.CompanyEmployeeDto;
import com.demo.EmployeeCompany.Dto.EmpCompanyXrefDto;
import com.demo.EmployeeCompany.Dto.EmployeeDto;
import com.demo.EmployeeCompany.entity.Company;
import com.demo.EmployeeCompany.entity.Employee;
import com.demo.EmployeeCompany.entity.EmployeeCompanyXref;
import com.demo.EmployeeCompany.repository.CompanyRepository;
import com.demo.EmployeeCompany.repository.EmpComXrefRepository;
import com.demo.EmployeeCompany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceImpl  implements Service{

    @Autowired
    private EmpComXrefRepository empComXrefRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
//    @Autowired
//    private EmployeeCompanyXref employeeCompanyXref;

    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public void saveCompany(CompanyDto companyDto) {
        Company company = Company.builder()
                .companyName(companyDto.getCompanyName())
                .address(companyDto.getAddress())
                .email(companyDto.getEmail())
                .phoneNumber(companyDto.getPhoneNumber())
                .build();
        companyRepository.save(company);


    }

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee = Employee.builder()
                .empName(employeeDto.getEmpName())
                .dateOfBirth(employeeDto.getDateOfBirth())
                .email(employeeDto.getEmail())
                .pincode(employeeDto.getPincode())
                .salary(employeeDto.getSalary())
                .age(employeeDto.getAge())
                .build();
        employeeRepository.save(employee);

    }

    @Override
    public void saveAllEmployee(List<EmployeeDto> employeeDto) {

        List<EmployeeDto> empList=new ArrayList<>();

    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<EmployeeCompanyXref> findAllComp() {
        return empComXrefRepository.findAll();
    }

    @Override
    public List<Employee> fetchNameWithA(String ch) {
        List<Employee> empList=employeeRepository.fetchWithNameStartWithA(ch);

    return empList;
    }

//    @Override
//    public Employee fetchNthHighestSalary(Integer n) {
//        return employeeRepository.fetchWithGivenSalary(n);
//    }

    @Override
    public List<Employee> fetchWithMonth(int n) {
        return employeeRepository.fetchingWithGivenMonth(n);
    }







    @Override
    public List<Employee> getEmployeeBySorting() {
        return employeeRepository.findEmployeeWitAscEmpName();
    }

    @Override
    public List<CompanyEmployeeDto> fetchAllCompany() {

        List<CompanyEmployeeDto> comEmpList = new ArrayList<>();
        List<Company> compList = companyRepository.findAll();


        compList.stream().forEach(company -> {
            comEmpList.add((CompanyEmployeeDto) compList);
        });

        return comEmpList;
    }

    public List<Employee> findEmpByNthHighestSalary(int n) {
        Pageable pageable = PageRequest.of(n - 1, 1, Sort.by("salary").descending());
        return employeeRepository.findEmpByNthHighestSalary(pageable);
    }

    @Override
    public void comanyEmployeeMapping(EmpCompanyXrefDto empCompanyXrefDto) throws Exception {

        EmployeeCompanyXref employeeCompanyXref=null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(empCompanyXrefDto.getEmployeeId());
        if (optionalEmployee.isPresent()) {
            employeeCompanyXref.setEmployee(optionalEmployee.get());
        } else {
            throw new Exception("employee not present");
        }
        Optional<Company> optionalCompany=companyRepository.findById(empCompanyXrefDto.getCompanyId());
        if( optionalCompany.isPresent()){
            employeeCompanyXref.setCompany(optionalCompany.get());
        }
        else {
            throw new Exception("Company Id  not present");
        }

        empComXrefRepository.save(employeeCompanyXref);
    }

    @Override
    public int findByCompanyId(int companyId) {
        int number=  empComXrefRepository.findCountOfEmployees(companyId);
 return number;

    }

    @Override
    public List<Employee> checkBySalary(int salary) {
        return employeeRepository.findByGivenSalary(salary);
    }

}
