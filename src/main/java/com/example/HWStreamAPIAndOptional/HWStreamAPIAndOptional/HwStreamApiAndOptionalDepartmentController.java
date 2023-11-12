package com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional;

import com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.model.Employee;
import com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HwStreamApiAndOptionalDepartmentController {

    private final DepartmentService employeeServiceDepartmentImpl;

    public HwStreamApiAndOptionalDepartmentController(DepartmentService employeeServiceDepartmentImpl) {
        this.employeeServiceDepartmentImpl = employeeServiceDepartmentImpl;
    }


    @GetMapping
    public String greetingsDepartments() {
        return employeeServiceDepartmentImpl.greetingsDepartments();
    }

    @GetMapping(path = "/departments/min-salary")
    public Employee departmentsMinSalary(@RequestParam(value = "department", required = false) Integer department) {
        return employeeServiceDepartmentImpl.departmentsMinSalary(department);
    }

    @GetMapping(path = "/departments/max-salary")
    public Employee departmentsMaxSalary(@RequestParam(value = "department", required = false) Integer department) {
        return employeeServiceDepartmentImpl.departmentsMaxSalary(department);
    }

    @GetMapping(path = "/departments/all")
    public ResponseEntity<?> departmentList(@RequestParam(value = "department", required = false) Integer department) {
        return department == null ?
                ResponseEntity.ok(employeeServiceDepartmentImpl.departmentsMap())
                :
                ResponseEntity.ok(employeeServiceDepartmentImpl.departmentList(department));
    }

}
