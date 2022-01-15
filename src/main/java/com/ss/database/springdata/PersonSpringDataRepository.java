package com.ss.database.springdata;

import com.ss.database.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
//JpaRepository<class, primary key>
public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {
}
