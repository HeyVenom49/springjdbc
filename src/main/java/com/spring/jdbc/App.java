package com.spring.jdbc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
// import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("My program started.............");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        // JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

        // // insert query
        // String insertQuery = "INSERT INTO student(id, name, email, age) VALUES (?, ?,
        // ?, ?);";

        // // fire query
        // int result = template.update(insertQuery, 2, "Ayush", "ayush@test.com", 21);

        // System.out.println("Number of record inserted.." + result);

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        // ! Insert
        // Student student1 = new Student(3, "Abhinav", "abhinav@test.com", 20);

        // int result = studentDao.insert(student1);

        // ! Update
        // Student student1 = new Student(1, "John", "john@test.com", 19);

        // int result = studentDao.update(student1);

        // ! Delete
        int result = studentDao.delete(1);

        System.out.println(result);
        context.close();
    }
}
