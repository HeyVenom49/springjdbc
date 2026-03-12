package com.spring.jdbc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("My program started.............");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

        // insert query
        String insertQuery = "INSERT INTO student(id, name, email, age) VALUES (?, ?, ?, ?);";

        int result = template.update(insertQuery, 2, "Ayush", "ayush@test.com", 21);

        System.out.println("Number of record inserted.." + result);

        context.close();
    }
}
