package org.example.model;

import org.example.data_access.Course;
import org.example.data_access.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CourseDaoList implements CourseDao {
    private static List<Course> courses = new ArrayList<>();
    StudentDaoList studentDao = new StudentDaoList();
    @Override
    public Course saveCourse(Course course) {
        List<Student> reciveStudentList2 =   studentDao.findAll();
        System.out.println("Course name is "+ course.getCourseName());
        System.out.println("Week duration during the course is " +course.getWeekDuration());
        System.out.println("Start Date is "+course.getStartDate());
        System.out.println("Students are "+ reciveStudentList2);
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        /*for(Student s:students) {
            if(s.getStudentId()==id)
                System.out.println("Yes, the student is in the student list");
        }
        return students;*/
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        for(Course c:courses) {
            if(c.getCourseName().equalsIgnoreCase(name))
                System.out.println("Yes, the Course is in the course list");
        }
        return courses;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean removeCourse(Course course) {
        boolean flag=false;
        System.out.println(course.getCourseName());

        // students.remove(student.getName());
        Iterator<Course> iterator = courses.iterator();    // Iterator
        while (iterator.hasNext()) {
            Course c  = iterator.next(); // Practiced iterator.next(). Also itertor.next moves pointer a step ahead and thus loop functions forward.
            if (c.getCourseName().equals(course.getCourseName())) {
                iterator.remove();      // practiced iterator.remove()
            }
        }

        flag=true;
        return flag;
    }
}
