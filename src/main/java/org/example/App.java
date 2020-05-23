package org.example;

import org.example.data_access.Course;
import org.example.data_access.ScannerCallingClass;
import org.example.data_access.Student;
import org.example.model.CourseDao;
import org.example.model.CourseDaoList;
import org.example.model.StudentDao;
import org.example.model.StudentDaoList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * School Management
 */
public class App {
    public static char permitOperationContinue() {
        char s3 = ' ';
        char Op = ScannerCallingClass.scannerCharacter(s3);
        return Op;
    }

    public static void invokemenu() {
        System.out.println("You have following options (in Vending Machine              ");
        System.out.println("add()                                               (s) Add (save) Student record ");
        System.out.println("deleteStudent(Student student                       (d) Delete Student");
        System.out.println("List<Student> findAll                               (a) Find All Students");

        System.out.println("\n");
        System.out.println("Course saveCourse(Course course);                   (c) Add (save) Course ");
        System.out.println("boolean removeCourse(Course course);                (k) Delete Course");
        System.out.println("List<Course> findAll();                             (m) Find All (courses)");//  System.out.println("View all products                              (f) Full description");

        System.out.println("\n");
        System.out.println("public void register(Student student)               (r) Register course         ");
        System.out.println("public void unregister(Student student)             (u) Register course         ");

        System.out.println("\n");
        System.out.println("Advanced search Students");
        System.out.println("Student findByEmail(String email);                  (e) Find (Student) by Email ");
        System.out.println("Student findById(int id);                           (i) Find (Student) by Id ");
        System.out.println("List<Student> findByName(String name)               (n) Find List by Name");

        System.out.println("\n");
        System.out.println("Advanced search Courses");
        System.out.println("List<Course> findByDate(LocalDate date);            (b) Find (Course) by Date  ");
        System.out.println("Course findById(int id);                            (f) Find (Course) by Id ");
        System.out.println("List<Course> findByName(String name)                (g) Find (Course) List by Name");
    }

    public static LocalDate dateInput(String userInput) {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate date = LocalDate.parse(userInput, dateFormat);


        System.out.println(date);
        return date;
    }

    public static void main(String[] args) {

        System.out.println("SM");

        StudentDaoList StudentDao = new StudentDaoList();
        CourseDaoList CourseDao = new CourseDaoList();

        boolean hogia = false;
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Do you want to enter operation (Press y ) or you want to exit the program .....(Press n)  (y/n)");
            char flag = sc.next().charAt(0);
            if (flag == 'y') {
                System.out.println();
                System.out.println("Enter your choice");
                invokemenu();
                char permit = sc.next().charAt(0);

                switch (permit) {
                    //Add (or Save) student
                    case 's': {
                        Scanner sc1 = new Scanner(System.in);
                        System.out.println("Enter student name");
                        String studentName = sc1.nextLine();

                        System.out.println("Enter student email");
                        Scanner sc2 = new Scanner(System.in);
                        String studentEmail = sc1.nextLine();

                        System.out.println("Enter student address");
                        Scanner sc3 = new Scanner(System.in);
                        String studentAddress = sc1.nextLine();

                        Student student1 = new Student(studentName, studentEmail, studentAddress);
                        Student addedStudent = StudentDao.saveStudent(student1);
                       }
                    break;
                    //Find by email
                    case 'e': {
                        Scanner sc24 = new Scanner(System.in);
                        System.out.println("Enter the email of the student to search in the list");
                        String studentEmail = sc24.nextLine();
                        StudentDao.findByEmail(studentEmail);

                    }
                    break;
                    //Find by Id
                    case 'i': {
                        Scanner sc24 = new Scanner(System.in);
                        System.out.println("Enter the student Id to search in the list");
                        int studentId = sc24.nextInt();
                        StudentDao.findById(studentId);
                       }
                    break;
                    //Find Student by email
                    case 'n': {

                        Scanner sc24 = new Scanner(System.in);
                        System.out.println("Enter the name of the student to search in the list");
                        String studentName = sc24.nextLine();
                        List<Student> sObject = StudentDao.findByName(studentName);
                    }
                    break;
                    //int delete (or remove) a student
                    case 'd':
                        System.out.println("Enter the NAME of the student, you want to remove from the Student List ");
                        Scanner sc1 = new Scanner(System.in);
                        String idValue = sc1.nextLine();

                        List<Student> reciveStudentList = StudentDao.findAll();

                        for (Student s : reciveStudentList) {
                            if (s.getName().equals(idValue))

                                hogia = StudentDao.deleteStudent(s);
                            if (hogia)
                                System.out.println("The student is successfully deleted from the student list");
                        }
                        break;
                    //Find by name

                    case 'a':
                        List<Student> reciveStudentList1 = StudentDao.findAll();
                        for (Student s : reciveStudentList1)
                            System.out.println(s);
                        break;
                    //Add course
                    case 'c': {
                        Scanner sc24 = new Scanner(System.in);
                        System.out.println("Enter course name");
                        String courseName = sc24.nextLine();

                        System.out.println("Enter course duratoin");
                        Scanner sc21 = new Scanner(System.in);
                        int courseDuration = sc21.nextInt();

                        System.out.println("Enter course start date Date Format 3/3/2019 ");

                        Scanner sc25 = new Scanner(System.in);

                        String userInput = sc25.nextLine();

                        LocalDate startDate = dateInput(userInput);

                        List<Student> students = new ArrayList<>();
                        Course course1 = new Course(courseName, startDate, courseDuration, students);

                        Course addedCourse = CourseDao.saveCourse(course1);

                    }
                    break;
                    //Remove course
                    case 'k': {
                        System.out.println("Enter the NAME of the course, you want to remove from the course List ");
                        Scanner sc15 = new Scanner(System.in);
                        String idValue1 = sc15.nextLine();

                        List<Course> reciveCourseList = CourseDao.findAll();

                        for (Course c : reciveCourseList) {

                            if (c.getCourseName().equals(idValue1))
                                hogia = CourseDao.removeCourse(c);

                            if (hogia)
                                System.out.println("The course is successfully deleted from the course list");
                        }
                    }
                    break;
                    //Find all courses Mazmoon
                    case 'm': {
                        List<Course> recievedCourseList = CourseDao.findAll();
                        for (Course c : recievedCourseList)
                            System.out.println(c);

                    }
                    break;
                    //Finding Course by Date
                    case 'b': {
                        Scanner sc24 = new Scanner(System.in);
                        System.out.println("Enter the Course start date to search in the list");
                        String dateInput = sc24.nextLine();
                        LocalDate courseDate = dateInput(dateInput);
                        CourseDao.findByDate(courseDate);

                    }
                    break;
                    //Finding Course by Id
                    case 'f': {
                        Scanner sc24 = new Scanner(System.in);
                        System.out.println("Enter the Course Id to search in the list");
                        int courseId = sc24.nextInt();
                        CourseDao.findById(courseId);
                        // CourseDao.findAll(courseId);

                        //System.out.println("The Course Id belongs to "+ course);

                    }
                    break;
                    //Finding Course by Name
                    case 'g': {
                        Scanner sc24 = new Scanner(System.in);
                        System.out.println("Enter the name of the course to search in the list");
                        String courseName = sc24.nextLine();
                        CourseDao.findByName(courseName);
                    }
                    break;
                    //Register Course
                    case 'r':



                        Scanner sc31 = new Scanner(System.in);

                        System.out.println("Enter student name for registering the course");
                        String studentNameReg = sc31.nextLine();

                        System.out.println("Enter the course name");
                        String courseNameReg = sc31.nextLine();

                        List<Student> studentList = StudentDao.findAll();

                        for (Student everyStudent : studentList)
                            if (everyStudent.getName().equalsIgnoreCase(studentNameReg))
                                CourseDao.register(everyStudent);

                        break;
                    //Un-register Course
                    case 'u':
                        Scanner sc312 = new Scanner(System.in);

                        System.out.println("Enter student name for Un-registering the course");
                        String studentNameUnReg = sc312.nextLine();

                        System.out.println("Enter the course name");
                        String courseNameUnReg = sc312.nextLine();

                        List<Student> studentListUnReg = StudentDao.findAll();

                        for (Student everyStudentUn : studentListUnReg)
                            if (everyStudentUn.getName().equalsIgnoreCase(studentNameUnReg))
                                CourseDao.unregister(everyStudentUn);
                        break;
                }
            }// if condition
            else running = false;
        }// while
    }
}
