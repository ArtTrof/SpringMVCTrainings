package org.example.dao;

import org.example.models.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional(readOnly = true)
    public void testNPlus1() {
        Session session = entityManager.unwrap(Session.class);
        //1 request get all people
//        List<Person> people=session.createQuery("select p from Person p",Person.class)
//                .getResultList();
//        //n request to bd
//        for(Person person:people){
//            System.out.println("Person"+person.getName()+ " items:"+person.getItems());//n+1 problem
//solution -> left join
        Set<Person>people=new HashSet<Person>(
                session.createQuery("select p FROM Person p left join fetch p.items")
                        .getResultList() );
        for(Person person:people){
            System.out.println(person.getName()+person.getItems());
        }

    }

}
