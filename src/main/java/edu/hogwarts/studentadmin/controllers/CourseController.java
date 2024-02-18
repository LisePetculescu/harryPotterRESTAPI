package edu.hogwarts.studentadmin.controllers;

import edu.hogwarts.studentadmin.models.Course;
import edu.hogwarts.studentadmin.models.Student;
import edu.hogwarts.studentadmin.repositories.CourseRepository;
import edu.hogwarts.studentadmin.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {


    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses")
    public List<Course> allCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getOneCourse(@PathVariable int id) {
        return ResponseEntity.of(courseRepository.findById(id));
    }

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
        course.setId(id);
        return courseRepository.save(course);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable int id) {
        Optional<Course> deleteCourse = courseRepository.findById(id);
        courseRepository.deleteById(id);
        return ResponseEntity.of(deleteCourse);
    }

    @PostMapping("/courses/{courseId}/students/{studentId}")
    public ResponseEntity<Course> addStudentToCourse(@PathVariable int courseId, @PathVariable int studentId) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalCourse.isEmpty() || optionalStudent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Course course = optionalCourse.get();
        Student student = optionalStudent.get();

        // Add the student to the course
        course.addStudent(student);
        courseRepository.save(course);

        return ResponseEntity.ok(course);
    }





}
