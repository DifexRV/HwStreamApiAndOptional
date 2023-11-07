package com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.service;

import com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.exception.EmployeeAlreadyAddedException;
import com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.exception.EmployeeNotFoundException;
import com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.exception.EmployeeStorageIsFullException;
import com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String,Employee> employees = new HashMap<>(Map.of());

    @Override
    public Collection<Employee> employeeList() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Employee addEmployee(Employee employee) throws Exception {
        if (employees.size() >= 13) {
            throw new EmployeeStorageIsFullException();
        }

        if (employees.containsKey(employee.getFullName()) == true) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.put(employee.getFullName(), employee);
        }
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) throws Exception {

        if (employees.containsKey(employee.getFullName()) == false) {
            throw new EmployeeNotFoundException();
        } else {
            return employees.remove(employee.getFullName());
        }

    }

    @Override
    public Employee findEmployee(Employee employee) throws Exception {

        if (employees.containsKey(employee.getFullName()) == false) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(employee.getFullName());
    }

}
