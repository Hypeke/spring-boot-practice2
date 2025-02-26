package org.example.springbootpractice2.repository;

import org.example.springbootpractice2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
