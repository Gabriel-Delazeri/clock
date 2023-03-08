package com.delazeri.clock.services;

import com.delazeri.clock.dtos.EmployeeDTO;
import com.delazeri.clock.entities.Employee;
import com.delazeri.clock.repositories.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employee.setCreatedAt(LocalDate.now());
        return this.employeeRepository.save(employee);
    }

    public Optional<Employee> findById(UUID id) {
        return this.employeeRepository.findById(id);
    }

    public void delete(UUID id) {
        this.employeeRepository.deleteById(id);
    }

    public Employee update(UUID id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.getReferenceById(id);
        updateData(employee, employeeDTO);
        return employeeRepository.save(employee);
    }

    public void updateData(Employee currentEmployee, EmployeeDTO employeeDTO) {
        currentEmployee.setFirstName(employeeDTO.getFirstName());
        currentEmployee.setSurname(employeeDTO.getSurname());
    }
}
