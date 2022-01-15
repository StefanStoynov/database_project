package com.ss.database;

import com.ss.database.entity.Person;
import com.ss.database.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//commented because of JpaDatabaseApplication. If used SpringJdbcDatabaseApplication - uncomment
//@SpringBootApplication
public class SpringJdbcDatabaseApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJdbcDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", dao.findAll());
        logger.info("User with id 100001 -> {}", dao.findById(10001));
        logger.info("Deleting user with id 100002 -> Number of rows deleted {}", dao.deleteById(10002));
        logger.info("All users -> {}", dao.findAll());

        logger.info("Inserting person with id 100004 -> Number of rows updated {}", dao.insert(new Person(100004,"Stefan", "Sofia",new Date())));
        logger.info("All users -> {}", dao.findAll());

        logger.info("Updating user with id 10004 -> Number of rows updated {}", dao.update(new Person(100004,"Stefan", "Plovdiv",new Date())));
        logger.info("User with id 100004 -> {}", dao.findById(100004));

    }
}
