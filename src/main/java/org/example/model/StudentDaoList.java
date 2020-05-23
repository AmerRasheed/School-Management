package org.example.model;

import org.example.data_access.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentDaoList implements StudentDao {
    private static List<Student> students = new ArrayList<>();

    @Override
    public Student saveStudent(Student student) {
        //Student student1 = new Student(student.getName(),student.getEmail(),student.getAddress());
        System.out.println("Student name is "+ student.getName());
        System.out.println("Student email is " +student.getEmail());
        System.out.println("Student address city is "+ student.getAddress());
        students.add(student);
        return student;
    }

    @Override
    public List<Student> findByEmail(String email) {
        for(Student s:students) {
            if(s.getEmail().equalsIgnoreCase(email))
                System.out.println("Yes, the student with this email is in the student list");
        }
        return students;
    }


    @Override
    public List<Student> findByName(String name) {

            for(Student s:students) {
                if(s.getName().equalsIgnoreCase(name))
                    System.out.println("Yes, the student is in the student list");
            }
        return students;
    }

    @Override
    public Student findById(int id) {
        /*for(Student s:students) {
            if(s.getStudentId()==id)
                System.out.println("Yes, the student is in the student list");
        }
        return students;*/
        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
        boolean flag=false;
        System.out.println(student.getName());
// students.remove(student.getName());
        Iterator<Student> iterator = students.iterator();    // Iterator
        while (iterator.hasNext()) {
            Student s = iterator.next(); // Practiced iterator.next(). Also itertor.next moves pointer a step ahead and thus loop functions forward.
            if (s.getName().equals(student.getName())) {
                iterator.remove();      // practiced iterator.remove()
            }
        }
        flag=true;
        return flag;
    }
}
