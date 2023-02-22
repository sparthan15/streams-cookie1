package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    public static double PERCENTAGE = 0.1;
    private final List<Employee> employees = List.of(Employee.createMale("Charlie", 1200),
            Employee.createFemale("Maggie", 200),
            Employee.createMale("Pepito", 2000));
    @Test
    void canCreateFemaleEmployee(){
        Employee employee = Employee.createFemale("Susan", 1200);
        assertNotNull(employee);
        assertFalse(employee.isMale());
        assertNotNull(employee.getSalary());
    }

    @Test
    void canCreateMaleEmployee(){
        Employee employee = Employee.createMale("Charlie", 1200);
        assertTrue(employee.isMale());
    }

    @Test
    void canCreateMaleEmployees(){
        Employee employee = Employee.createMale("Charlie", 1000);
        assertTrue(employee.isMale());
    }

    @Test
    void fetchEmployeesWithSalaryGreaterThan1000(){
        employees.stream()
                .filter(e->e.getSalary()>1000)
                .collect(Collectors.toList());
    }

    @Test
    void givenEmployeesAddPercentageToMaleEmployees(){
        employees.stream()
                .filter(Employee::isMale)
                .forEach(e->e.addPercentage(PERCENTAGE));
        assertEquals(1320, employees.get(0).getSalary());
        assertEquals(200, employees.get(1).getSalary());
        assertEquals(2200, employees.get(2).getSalary());
    }

    @Test
    void sumTheSalary(){
        double total =  employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        assertEquals(3400, total);
    }

    @Test
    void createMapByGenre(){
        Map<Employee.Genre, List<Employee>> employeesByGenre = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGenre));
        assertEquals(2, employeesByGenre.get(Employee.Genre.MALE).size());
        assertEquals(1, employeesByGenre.get(Employee.Genre.FEMALE).size());
    }

}
