package com.delazeri.clock.controllers;

import com.delazeri.clock.dtos.EmployeeDTO;
import com.delazeri.clock.entities.Employee;
import com.delazeri.clock.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(this.employeeService.createEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Employee>> get(@PathVariable UUID id) {
        return new ResponseEntity<>(this.employeeService.findById(id), HttpStatus.FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> update(
            @PathVariable UUID id,
            @RequestBody  @Valid EmployeeDTO employeeDTO
    ) {
        return new ResponseEntity<>(this.employeeService.update(id, employeeDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        employeeService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
