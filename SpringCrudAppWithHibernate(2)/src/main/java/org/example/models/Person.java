package org.example.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name ="person")
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Min(value=1,message = "minimal age should be 1 year+")
    @Column(name="age")
    private int age;
    @NotEmpty(message = "name should not be empty!")
    @Size(min=2,max=30,message = "name should be between 2=30 characters")
    @Column(name="name")
    private String name;
//
//    @NotEmpty(message = "email should not be empty")
//    @Email(message = "wrong email validation")
//    private  String email;


    public Person() {
    }

    public Person( String name, int age, String email) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
