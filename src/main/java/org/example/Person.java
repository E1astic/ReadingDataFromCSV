package org.example;

import java.util.Date;

public class Person {
    private int id;
    private String name;
    private Gender gender;
    private Date birthday;
    private Division division;
    private int salary;
    public Person(int id, String name, Gender gender, Date birthday, Division division, int salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.division = division;
        this.salary = salary;
    }
}
