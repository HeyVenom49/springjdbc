package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

    @Override
    public int delete(int studentId) {
        String deleteQuery = "DELETE FROM student WHERE id=?";
        int result = this.jdbcTemplate.update(deleteQuery, studentId);
        return result;
    }

    @Override
    public Student getStudent(int studentId) {
        String selectQuery = "SELECT * FROM student WHERE id=?";
        RowMapper<Student> rowMapper = new RowMapperImplement();
        Student student = this.jdbcTemplate.queryForObject(selectQuery, rowMapper, studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        String selectQuery = "SELECT * FROM student";
        List<Student> students = this.jdbcTemplate.query(selectQuery, new RowMapperImplement());
        return students;
    }

}
