package edu.hogwarts.studentadmin.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject;
    private int schoolYear;
    private boolean current;
    @ManyToOne
    private Teacher teacher;
    @ManyToMany
     private List<Student> students = new ArrayList<>();


//public Collection<Integer> getStudentIds() {
//    return students.stream()
//            .map(Student::getId) // Assuming getId() returns the student's ID
//            .collect(Collectors.toList());
//}


    public Course(String subject, int schoolYear, boolean current, Teacher teacher, List<Student> students) {
        this.subject = subject;
        this.schoolYear = schoolYear;
        this.current = current;
        this.teacher = teacher;
        this.students = students;
    }
    public Course(String subject, int schoolYear, boolean current, Teacher teacher, Student student) {
        this.subject = subject;
        this.schoolYear = schoolYear;
        this.current = current;
        this.teacher = teacher;
        this.students = new ArrayList<>();
        this.students.add(student);
    }

    public Course() {
    }

    public Course(String subject, int schoolYear, boolean current) {
        this(subject, schoolYear, current, null, new ArrayList<>());
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

}
