package org.example.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @Min(value=1,message = "minimal age should be 1 year+")
    private int age;
    @NotEmpty(message = "name should not be empty!")
    @Size(min=2,max=30,message = "name should be between 2=30 characters")
    private String name;

    @NotEmpty(message = "email should not be empty")
    @Email(message = "wrong email validation")
    private  String email;

    public Person() {
    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
