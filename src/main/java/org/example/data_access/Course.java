package org.example.data_access;

//import org.example.data_access.CourseDaoList;
//import org.example.data_access.StudentDaoList;

import org.example.model.CourseDaoList;
import org.example.model.StudentDaoList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    public static int counter = 0;
    private int courseId;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    public Course(String courseName, LocalDate startDate, int weekDuration, List<Student> students) {
        this.courseId = ++counter;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public List<Student> getStudents() {

        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getCourseId() == course.getCourseId() &&
                getWeekDuration() == course.getWeekDuration() &&
                Objects.equals(getCourseName(), course.getCourseName()) &&
                Objects.equals(getStartDate(), course.getStartDate()) &&
                Objects.equals(getStudents(), course.getStudents());
    }

    @Override
    public int hashCode() {
        // return Objects.hash(getCourseId(), getCourseName(), getWeekDuration(), getStudents());
        return Objects.hash(getCourseId(), getCourseName(), getWeekDuration());
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }

    StudentDaoList studentDao = new StudentDaoList();
    CourseDaoList courseDao = new CourseDaoList();
    List<Student> courseRegisteredList = new ArrayList<>();
    List<Course> rseRegister = new ArrayList<>();
    public void register(Student student) {

        System.out.println("Registration is in process...........DONE");

        courseRegisteredList.add(student);

    }

    public void unregister(Student student) {

        System.out.println("De-registration is in process.......DONE");

        courseRegisteredList.remove(student);

    }
}

