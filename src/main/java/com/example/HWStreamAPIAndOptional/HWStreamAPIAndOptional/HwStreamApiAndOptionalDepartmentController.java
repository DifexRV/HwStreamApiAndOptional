package com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional;

import com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.model.Employee;
import com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.service.DepartmentService;
import com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.service.EmployeeServiceDepartmentImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/departments")
public class HwStreamApiAndOptionalDepartmentController {

    private final DepartmentService employeeServiceDepartmentImpl;

    public HwStreamApiAndOptionalDepartmentController(DepartmentService employeeServiceDepartmentImpl) {
        this.employeeServiceDepartmentImpl = employeeServiceDepartmentImpl;
    }


    @GetMapping
    public String greetingsDepartments() {
        return employeeServiceDepartmentImpl.greetingsDepartments();
    }

    @GetMapping(path = "/min-salary")
    public Employee departmentsMinSalary(@RequestParam(value = "department", required = false) int department) {
        return employeeServiceDepartmentImpl.departmentsMinSalary(department);
    }

    @GetMapping(path = "/max-salary")
    public Employee departmentsMaxSalary(@RequestParam(value = "department", required = false) int department) {
        return employeeServiceDepartmentImpl.departmentsMaxSalary(department);
    }

    @GetMapping(path = "/all")
    public Collection<Employee> departmentList(@RequestParam(value = "department", required = false) int department) {
        return employeeServiceDepartmentImpl.departmentList(department);
    }
    @GetMapping(path = "/allDepartments")
    public Collection<Employee> departmentsList() {
        return employeeServiceDepartmentImpl.departmentsList();
    }

}
