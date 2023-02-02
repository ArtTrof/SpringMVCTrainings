package org.example.dao;

import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        //here we write usual hibernate code
        List<Person>people =  session.createQuery("select p from Person p", Person.class).getResultList();
        return people;
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session =sessionFactory.getCurrentSession();
        return  session.get(Person.class,id);
    }

    @Transactional
    public void save(Person person) {
        Session session =sessionFactory.getCurrentSession();
        session.save(person);
    }

    public void update(int id, Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.get(Person.class,id);
        session.update(person);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class,id);
        session.remove(person);

    }


}
