package com.mycom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycom.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
