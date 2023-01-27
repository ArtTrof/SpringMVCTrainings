package org.example.dao;

import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    //    private static int PEOPLE_COUNT;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("Select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
      return jdbcTemplate.query("Select * from person where id =?",new Object[]{id},new BeanPropertyRowMapper<>(Person.class))
              .stream().findAny().orElse(null);
    }

    public void save(Person person) {
       jdbcTemplate.update("Insert into person values (1,?,?,?)",
                person.getName(),person.getAge(),person.getEmail());
    }

    public void update(int id, Person person) {
       jdbcTemplate.update("Update person set name=?,age=?,email=? where id =?",
               person.getName(),person.getAge(),person.getEmail(),id);
    }

    public void delete(int id) {
       jdbcTemplate.update("Delete from person where id=?",id);
    }
}
