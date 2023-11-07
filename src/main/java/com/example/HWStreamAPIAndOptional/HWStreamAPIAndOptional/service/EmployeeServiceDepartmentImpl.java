package com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.service;

import com.example.HWStreamAPIAndOptional.HWStreamAPIAndOptional.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class EmployeeServiceDepartmentImpl implements DepartmentService {

    List<Employee> departments = new ArrayList<>(List.of(
            new Employee("Тролль", "Борис", 1, 23000),
            new Employee("Кранова", "Матильда", 1, 13000),
            new Employee("Врунишкин", "Аркадий", 2, 35000),
            new Employee("Грустный", "Олег", 3, 11000),
            new Employee("Бристоль", "Матеос", 1, 20000),
            new Employee("Медлеходов", "Бронислав", 2, 30000),
            new Employee("Горгона", "Медуза", 3, 18000),
            new Employee("Наглышов", "Глав", 2, 37000),
            new Employee("Простофилин", "Иван", 3, 7000)));


    @Override
    public String greetingsDepartments() {
        return "<b>Добро пожаловать в раздел Депортаментов</b>";
    }


    @Override
    public Employee departmentsMinSalary(int department) {

        return departments.stream().filter(dep -> dep != null && dep.getDepartment() == department)
                .min(Comparator.comparingInt(dep -> dep.getSalary()))
                .orElseThrow(() -> new RuntimeException("Позиция не найдена"));

    }

    @Override
    public Employee departmentsMaxSalary(int department) {

        return departments.stream().filter(dep -> dep != null && dep.getDepartment() == department)
                .max(Comparator.comparingInt(dep -> dep.getSalary()))
                .orElseThrow(() -> new RuntimeException("Позиция не найдена"));

    }


    @Override
    public Collection<Employee> departmentList(int department) {

        List<Employee> depList = departments.stream().filter(dep -> dep != null && dep.getDepartment() == department)
                .sorted(Comparator.comparingInt(dep -> dep.getSalary()))
                .collect(Collectors.toList());

        return Collections.unmodifiableList(depList);
    }

    @Override
    public Collection<Employee> departmentsList() {
        departments = departments.stream().sorted(Comparator.comparingInt(e -> e.getDepartment()))
                .collect(Collectors.toList());

        return Collections.unmodifiableList(departments);
    }
}
