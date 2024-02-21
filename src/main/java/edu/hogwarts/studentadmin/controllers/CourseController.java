package edu.hogwarts.studentadmin.controllers;

import edu.hogwarts.studentadmin.models.Course;
import edu.hogwarts.studentadmin.models.Student;
import edu.hogwarts.studentadmin.models.Teacher;
import edu.hogwarts.studentadmin.repositories.CourseRepository;
import edu.hogwarts.studentadmin.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping
public class CourseController {


    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;



    public CourseController(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/courses")
    public List<Course> allCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getOneCourse(@PathVariable int id) {
        return ResponseEntity.of(courseRepository.findById(id));
    }

    @GetMapping("/courses/{id}/teacher")
    public ResponseEntity<Teacher> getCourseTeacher(@PathVariable int id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            if (optionalCourse.get().getTeacher() != null) {
                return ResponseEntity.ok(optionalCourse.get().getTeacher());
            } else {
                return ResponseEntity.noContent().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }

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


    @PutMapping("/courses/{courseId}/students/{studentId}")
    public ResponseEntity<Course> addStudentToCourse(@PathVariable int courseId, @PathVariable int studentId) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalCourse.isEmpty() || optionalStudent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Course course = optionalCourse.get();
        Student student = optionalStudent.get();

        // Add the student to the course
        //List<Student> students = studentRepository.findAll();
        course.addStudent(student);
        courseRepository.save(course);

        return ResponseEntity.ok(course);
    }


    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable int id) {
        Optional<Course> deleteCourse = courseRepository.findById(id);
        courseRepository.deleteById(id);
        return ResponseEntity.of(deleteCourse);
    }





}
