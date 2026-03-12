package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpliment implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        // insert query
        String insertQuery = "INSERT INTO student(id, name, email, age) VALUES (?, ?, ?, ?);";

        // fire query
        int result = this.jdbcTemplate.update(insertQuery, student.getId(), student.getName(), student.getEmail(),
                student.getAge());

        return result;
    }

    @Override
    public int update(Student student) {
        String updateQuery = "UPDATE student SET name=?, email=?, age=? WHERE id=? ";
        int result = this.jdbcTemplate.update(updateQuery, student.getName(), student.getEmail(), student.getAge(),
                student.getId());
        return result;
    }

}
