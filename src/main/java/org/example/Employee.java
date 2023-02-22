package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Predicate;

@AllArgsConstructor
@Data
public class Employee {

    private final String name;
    private double salary;
    private final Genre genre;
    public static Employee createFemale(String name, int salary) {
        Employee employee = new Employee(name, salary, Genre.FEMALE);
        return employee;
    }

    public static void hello(String greetings){
        System.out.println(greetings+"asdadas");
    }

    public static Employee createMale(String name, int salary){
        Employee employee = new Employee(name, salary, Genre.MALE);
        return employee;
    }
    public enum Genre{
        MALE, FEMALE
    }

    public void addPercentage(double percentage){
        this.salary =  this.salary+(this.salary*percentage);
    }

    public boolean isMale(){
        return this.genre.equals(Genre.MALE);
    }

    public boolean validate(Predicate<Employee> p){
        return p.test(this);
    }

}
