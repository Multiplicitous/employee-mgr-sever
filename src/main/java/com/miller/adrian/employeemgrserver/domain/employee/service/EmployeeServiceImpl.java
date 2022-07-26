package com.miller.adrian.employeemgrserver.domain.employee.service;

import com.miller.adrian.employeemgrserver.domain.core.ResourceCreationException;
import com.miller.adrian.employeemgrserver.domain.core.ResourceNotFoundException;
import com.miller.adrian.employeemgrserver.domain.employee.models.Employee;
import com.miller.adrian.employeemgrserver.domain.employee.repos.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) throws ResourceCreationException {
        Optional<Employee> optional = employeeRepository.findByEmail(employee.getEmail());
        if (optional.isPresent())
            throw new ResourceCreationException("Email already exist");
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) throws ResourceNotFoundException {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isEmpty())
            throw new ResourceNotFoundException("Employee Not Found");
        return optional.get();
    }

    @Override
    public Employee getByEmail(String email) throws ResourceNotFoundException {
        Optional<Employee> optional = employeeRepository.findByEmail(email);
        if (optional.isPresent())
            throw new ResourceNotFoundException("Employee Not Found");
        return optional.get();
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Employee employee) throws ResourceNotFoundException {
        Optional<Employee> optional = employeeRepository.findById(employee.getId());
        if (optional.isPresent())
            throw new ResourceNotFoundException("Employee Not Foudnd");
        optional.get().setFirstName(employee.getFirstName());
        optional.get().setFirstName(employee.getLastName());
        optional.get().setEmail(employee.getEmail());
        employee = employeeRepository.save(optional.get());
        return employee;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Employee newEmployee = getById(id);
        employeeRepository.delete(newEmployee);
    }
}
