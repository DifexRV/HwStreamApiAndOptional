package com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional;

import com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.model.Employee;
import com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class HwStreamApiAndOptionalController {
    private final EmployeeService employeeServiceimpl;

    public HwStreamApiAndOptionalController(EmployeeService employeeServiceImpl) {
        this.employeeServiceimpl = employeeServiceImpl;
    }

    @GetMapping(path = "/employee")
    public Collection<Employee> employeeList() {
        return employeeServiceimpl.employeeList();
    }

    @GetMapping(path = "/employee/add")
    public Employee addEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                @RequestParam(value = "lastName", required = false) String lastName,
                                @RequestParam(value = "department", required = false) int department,
                                @RequestParam(value = "salary", required = false) int salary) throws Exception {

        Employee employee = new Employee(firstName, lastName, department, salary);
        try {
            employeeServiceimpl.addEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }


    @GetMapping(path = "/employee/remove")
    public Employee removeEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                   @RequestParam(value = "lastName", required = false) String lastName,
                                   @RequestParam(value = "department", required = false) int department,
                                   @RequestParam(value = "salary", required = false) int salary) throws Exception {
        Employee employee = new Employee(firstName, lastName, department, salary);
        try {
            employeeServiceimpl.removeEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @GetMapping(path = "/employee/find")
    public Employee findEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                 @RequestParam(value = "lastName", required = false) String lastName,
                                 @RequestParam(value = "department", required = false) int department,
                                 @RequestParam(value = "salary", required = false) int salary) throws Exception {
        Employee employee = new Employee(firstName, lastName, department, salary);
        try {
            employeeServiceimpl.findEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

}
