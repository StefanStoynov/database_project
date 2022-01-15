package com.ss.database.jdbc;

import com.ss.database.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //select * from person"
    public List<Person> findAll(){
       //new BeanPropertyRowMapper<>(Person.class) maps the result with Person class
       return jdbcTemplate.query("select * from person",new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id){
        //queryForObject querying for specific object
        return jdbcTemplate.queryForObject("select * from person where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    //update will return how many rows were deleted
    public int deleteById(int id){
        //update use for update or delete an object
        return jdbcTemplate.update("delete from person where id = ?",
                new Object[]{id});
    }

    //update will return how many rows were deleted
    public int insert(Person person){
        //use small caps
        return jdbcTemplate.update("insert into person (id, name, location, birth_date )\n" +
                                        "values(?, ?, ?, ?);",
                new Object[]{
                        person.getId(),person.getName(),
                        person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
    }

    //update will return how many rows were deleted
    public int update(Person person){
        //use small caps
        return jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ? \n" +
                        "where id = ?;",
                new Object[]{
                        person.getName(), person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime()), person.getId()});
    }
}
