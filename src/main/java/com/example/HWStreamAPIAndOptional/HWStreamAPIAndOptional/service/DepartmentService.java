package com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.service;

import com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.model.Employee;

import java.util.Collection;

public interface DepartmentService {

    String greetingsDepartments();

    Employee departmentsMinSalary(int department);
    Employee departmentsMaxSalary(int department);
    Collection<Employee> departmentList(int department);
    Collection<Employee> departmentsList();
}
