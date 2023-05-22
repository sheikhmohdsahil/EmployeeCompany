package com.demo.EmployeeCompany.repository;


import com.demo.EmployeeCompany.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query("Select o from Employee o where o.empName like :ch%")
    List<Employee> fetchWithNameStartWithA(String ch);

    @Query("Select o from Employee o  where MONTH(o.dateOfBirth) = :n")
    List<Employee> fetchingWithGivenMonth(int n);

    @Query("select o from Employee o order by length(o.empName), o.empName asc")
     List<Employee> findEmployeeWitAscEmpName();

    @Query("select distinct o.salary from Employee o order by o.salary desc")
    List<Employee> findEmpByNthHighestSalary(Pageable pageable);

    @Query("select o from Employee o where o.salary =:salary or o.salary >:salary")
    List<Employee> findByGivenSalary(int salary);

}
