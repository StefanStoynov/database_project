package com.ss.database.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table is not necessary if the names matches
//@Table(name="person")
//@NamedQuery is working with Entities. in the query Person is Entity
@NamedQuery(name="find_all_persons", query = "select p from Person p")
public class Person {
    @Id
    //hibernate will take care of incrementing the id column. Creates a sequence and use it to populate id
    @GeneratedValue
    private int id;

    //@Column(name="name")
    private String name;
    private String location;
    private Date birthDate;

    //provide default no args constructor. It is a must for hibernate
    public Person() {
    }

    public Person(int id, String name, String location, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public Person(String name, String location, Date birthDate) {
        super();
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    //if we don't have this method we will receive hashcode when we log Person
    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
