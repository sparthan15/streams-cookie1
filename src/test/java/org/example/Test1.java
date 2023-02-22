package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test1 {

    @Test
    void test() {
        Predicate<User> predicate = p -> p.getAge() > 18;
        Arrays.asList(new User())
                .stream()
                .filter(predicate)
                .forEach(p -> System.out.println(p));
    }

    @Test
    void findEmployeesWhoseSalaryIsGreaterThan1000() {
        Arrays.asList(Employee.createFemale("Charlie", 1000),
                        Employee.createFemale("Samuel", 900),
                        Employee.createFemale("Luis", 1500))
                .stream()
                .filter(e -> e.getSalary() > 900)
                .map(e -> e.getSalary() * (10 / 100))
                .forEach(x -> System.out.println(x));
    }

    @Test
    void test2() {
        List<Employee> maleEmployees = Arrays.asList(Employee.createMale("Charlie", 100), Employee.createFemale("Luisa", 1200),
                        Employee.createMale("Michael", 500))
                .stream()
                .filter(e -> e.isMale())
                .collect(Collectors.toList());
        System.out.println(maleEmployees);

        maleEmployees.stream()
                .forEach(e -> e.addPercentage(10));
        System.out.println(maleEmployees);

    }

    @Test
    void test3(){
        Consumer<Employee> addPercentage = e-> System.out.println(e.getSalary());
        Arrays.asList(Employee.createMale("Charli", 111))
                .stream()
                .forEach(addPercentage);

        Employee employee
                 = Employee.createMale("Charlie", 123);

        employee.validate((Employee p)->p.getSalary()>100);
    }
}
