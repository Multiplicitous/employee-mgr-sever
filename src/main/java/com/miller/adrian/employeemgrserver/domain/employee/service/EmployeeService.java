package com.miller.adrian.employeemgrserver.domain.employee.service;

import com.miller.adrian.employeemgrserver.domain.core.ResourceCreationException;
import com.miller.adrian.employeemgrserver.domain.core.ResourceNotFoundException;
import com.miller.adrian.employeemgrserver.domain.employee.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee) throws ResourceCreationException;
    Employee getById(Long id) throws ResourceNotFoundException;
    Employee getByEmail(String email) throws ResourceNotFoundException;
    List<Employee> getAll();
    Employee update(Employee employee) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
