package edu.hogwarts.studentadmin.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject;
    private int schoolYear;
    private boolean current;
    @OneToOne
    private Teacher teacher;
    @ManyToMany
     private List<Student> students = new ArrayList<>();
    //@ElementCollection
   // private List<Integer> studentIds; // List of student IDs
//    @ManyToOne
//    private Student[] students;
public Collection<Integer> getStudentIds() {
    return students.stream()
            .map(Student::getId) // Assuming getId() returns the student's ID
            .collect(Collectors.toList());
}


    public Course(String subject, int schoolYear, boolean current, Teacher teacher, List<Student> students) {
        this.subject = subject;
        this.schoolYear = schoolYear;
        this.current = current;
        this.teacher = teacher;
        this.students = students;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

//    public Collection<Integer> getStudentIds() {
//        return students.getId();
//    }


//    public Student[] getStudents() {
//        return students;
//    }
//
//    public void setStudents(Student[] students) {
//        this.students = students;
//    }

//    public void addStudent(Student[] students) {
//        students.add(student);
//        students.getCourses().add(this); // Also add the course to the student's list of courses
//    }
//
//    public void removeStudent(Student student) {
//        students.remove(student);
//        student.getCourses().remove(this); // Remove the course from the student's list of courses
//    }


}
