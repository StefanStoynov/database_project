package com.ss.database.jpa;

import com.ss.database.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
//Transaction -all query successful or revert
@Transactional
public class PersonJpaRepository {

    //connect to DB
    @PersistenceContext
    EntityManager entityManager;

    //we need to use JPQL Java Persistence Query Language

    public List<Person> findAll(){
      TypedQuery<Person> namedQuery =  entityManager.createNamedQuery("find_all_persons", Person.class);
      //we expect a list as result, and we use .getResultList()
      return namedQuery.getResultList();
    }

    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }
    //same as update, no difference
    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        //first we need to find a person and then delete it. That's how JPA works
       Person person=  findById(id);
        entityManager.remove(person);
    }


}
