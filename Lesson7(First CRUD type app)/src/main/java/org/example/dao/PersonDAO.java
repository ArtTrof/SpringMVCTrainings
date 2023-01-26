package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Name1"));
        people.add(new Person(++PEOPLE_COUNT, "Name2"));
        people.add(new Person(++PEOPLE_COUNT, "Name3"));
        people.add(new Person(++PEOPLE_COUNT, "Name4"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().
                filter(person -> person.getId() == id).
                findAny().
                orElse(null);
    }

}
