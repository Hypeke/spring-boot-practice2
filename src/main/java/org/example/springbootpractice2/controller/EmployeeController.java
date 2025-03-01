package org.example.springbootpractice2.controller;

import lombok.AllArgsConstructor;
import org.example.springbootpractice2.dto.EmployeeDto;
import org.example.springbootpractice2.entity.Employee;
import org.example.springbootpractice2.mapper.EmployeeMapper;
import org.example.springbootpractice2.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeId, employeeDto), HttpStatus.OK);
    }
}
