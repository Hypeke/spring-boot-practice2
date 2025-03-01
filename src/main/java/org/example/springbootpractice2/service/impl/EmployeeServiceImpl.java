package org.example.springbootpractice2.service.impl;

import lombok.AllArgsConstructor;
import org.example.springbootpractice2.dto.EmployeeDto;
import org.example.springbootpractice2.entity.Employee;
import org.example.springbootpractice2.exception.ResourceNotFoundException;
import org.example.springbootpractice2.mapper.EmployeeMapper;
import org.example.springbootpractice2.repository.EmployeeRepository;
import org.example.springbootpractice2.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.toEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.toEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id " + employeeId + " not found"));
        return EmployeeMapper.toEmployeeDto(employee);
    }
}
