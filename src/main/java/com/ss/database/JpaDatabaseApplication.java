package com.ss.database;

import com.ss.database.entity.Person;
import com.ss.database.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//commented because of JpaDatabaseApplication. If used JpaDatabaseApplication - uncomment
//@SpringBootApplication
public class JpaDatabaseApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("User with id 100001 -> {}", repository.findById(10001));
        //it is void method so no log possible
        repository.deleteById(10002);

        logger.info("Inserting person -> Number of rows updated {}", repository.insert(new Person("Stefan", "Sofia", new Date())));
        logger.info("Updating user -> Number of rows updated {}", repository.update(new Person(1, "Stefan", "Plovdiv", new Date())));
        logger.info("All users -> {}", repository.findAll());
    }
}
