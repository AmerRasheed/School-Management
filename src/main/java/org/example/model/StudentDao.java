package org.example.model;

import org.example.data_access.Student;

import java.util.List;

public interface StudentDao {

    Student saveStudent(Student student);  // Actually it is adding student
    Object findByEmail(String email);
    List<Student> findByName(String name);
    Student findById(int id);
    List<Student> findAll();
    boolean deleteStudent(Student student);


}