package edu.hogwarts.studentadmin;

import edu.hogwarts.studentadmin.models.Course;
import edu.hogwarts.studentadmin.models.House;
import edu.hogwarts.studentadmin.models.Student;
import edu.hogwarts.studentadmin.models.Teacher;
import edu.hogwarts.studentadmin.repositories.CourseRepository;
import edu.hogwarts.studentadmin.repositories.HouseRepository;
import edu.hogwarts.studentadmin.repositories.StudentRepository;
import edu.hogwarts.studentadmin.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {
    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private HouseRepository houseRepository;

    public InitData(StudentRepository studentRepository, TeacherRepository teacherRepository, CourseRepository courseRepository, HouseRepository houseRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.houseRepository = houseRepository;


//
//



        // list of students from 1991
       // List<Student> hogwartsStudents1991 = new ArrayList<>();

        // students from Gryffindor
       // Student harry = new Student("Harry", "James", "Potter", LocalDate.of(1980, 7, 31), gryffindor, true, 1991, 1998, true);
//        hogwartsStudents1991.add(new Student("Hermione", "Jean", "Granger", LocalDate.of(1979, 9, 19), gryffindor, true, 1991, 1998, true));
//        hogwartsStudents1991.add(new Student("Ronald", "Bilius", "Weasley", LocalDate.of(1980, 3, 1), gryffindor, true, 1991, 1998, true));
//
//        // students from Hufflepuff
//        hogwartsStudents1991.add(new Student("Cedric", "", "Diggory", LocalDate.of(1977, 9, 1), hufflepuff, false, 1991, 1998, true));
//        hogwartsStudents1991.add(new Student("Hannah", "", "Abbott", LocalDate.of(1979, 6, 12), hufflepuff, false, 1991, 1998, true));
//        hogwartsStudents1991.add(new Student("Ernie", "", "Macmillan", LocalDate.of(1980, 8, 22), hufflepuff, false, 1991, 1998, true));
//
//        // students from Ravenclaw
//        hogwartsStudents1991.add(new Student("Luna", "", "Lovegood", LocalDate.of(1981, 2, 13), ravenclaw, false, 1991, 1998, true));
//        hogwartsStudents1991.add(new Student("Cho", "", "Chang", LocalDate.of(1979, 9, 3), ravenclaw, false, 1991, 1998, true));
//        hogwartsStudents1991.add(new Student("Terry", "", "Boot", LocalDate.of(1980, 5, 7), ravenclaw, false, 1991, 1998, true));
//
//        // students from Slytherin
//        hogwartsStudents1991.add(new Student("Draco", "", "Malfoy", LocalDate.of(1980, 6, 5), slytherin, false, 1991, 1998, true));
//        hogwartsStudents1991.add(new Student("Pansy", "", "Parkinson", LocalDate.of(1980, 2, 2), slytherin, false, 1991, 1998, true));
//        hogwartsStudents1991.add(new Student("Vincent", "", "Crabbe", LocalDate.of(1980, 9, 12), slytherin, false, 1991, 1998, true));

        // Create the Hogwarts course
        // Course hogwartsCourse = new Course("Potions", 1991, true, snape, hogwartsStudents1991);



    }



    public void run(String... args) throws Exception {
        // houses:
        House slytherin = new House("Slytherin", "Salazar Slytherin", List.of(new String[]{"Green", "Silver"}));
        House gryffindor = new House("Gryffindor", "Godric Gryffindor", List.of(new String[]{"Red", "Gold"}));
        House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff", List.of(new String[]{"Yellow", "Black"}));
        House ravenclaw = new House("Ravenclaw", "Rowena Ravenclaw", List.of(new String[]{"Blue", "Bronze"}));

        houseRepository.save(slytherin);
        houseRepository.save(gryffindor);
        houseRepository.save(hufflepuff);
        houseRepository.save(ravenclaw);

        // Create Professor Snape
        Teacher snape = new Teacher("Severus", "", "Snape", LocalDate.of(1960, 1, 9), slytherin, true, EmpType.Tenured, LocalDate.of(1981, 9, 1), LocalDate.of(1998, 4, 2));
        teacherRepository.save(snape);

//        Student harry = new Student("Harry", "James", "Potter", LocalDate.of(1980, 7, 31), gryffindor, true, 1991, 1998, true);
//        studentRepository.save(harry);
        // Create and save Harry
        Student harry = new Student("Harry", "James", "Potter", LocalDate.of(1980, 7, 31), gryffindor, true, 1991, 1998, true);
        studentRepository.save(harry);

// Create and save Hermione
        Student hermione = new Student("Hermione", "Jean", "Granger", LocalDate.of(1979, 9, 19), gryffindor, true, 1991, 1998, true);
        studentRepository.save(hermione);

// Create and save Ronald
        Student ronald = new Student("Ronald", "Bilius", "Weasley", LocalDate.of(1980, 3, 1), gryffindor, true, 1991, 1998, true);
        studentRepository.save(ronald);

// Create and save Cedric
        Student cedric = new Student("Cedric", "", "Diggory", LocalDate.of(1977, 9, 1), hufflepuff, false, 1991, 1998, true);
        studentRepository.save(cedric);

// Create and save Hannah
        Student hannah = new Student("Hannah", "", "Abbott", LocalDate.of(1979, 6, 12), hufflepuff, false, 1991, 1998, true);
        studentRepository.save(hannah);

// Create and save Ernie
        Student ernie = new Student("Ernie", "", "Macmillan", LocalDate.of(1980, 8, 22), hufflepuff, false, 1991, 1998, true);
        studentRepository.save(ernie);

// Create and save Luna
        Student luna = new Student("Luna", "", "Lovegood", LocalDate.of(1981, 2, 13), ravenclaw, false, 1991, 1998, true);
        studentRepository.save(luna);

// Create and save Cho
        Student cho = new Student("Cho", "", "Chang", LocalDate.of(1979, 9, 3), ravenclaw, false, 1991, 1998, true);
        studentRepository.save(cho);

// Create and save Terry
        Student terry = new Student("Terry", "", "Boot", LocalDate.of(1980, 5, 7), ravenclaw, false, 1991, 1998, true);
        studentRepository.save(terry);

// Create and save Draco
        Student draco = new Student("Draco", "", "Malfoy", LocalDate.of(1980, 6, 5), slytherin, false, 1991, 1998, true);
        studentRepository.save(draco);

// Create and save Pansy
        Student pansy = new Student("Pansy", "", "Parkinson", LocalDate.of(1980, 2, 2), slytherin, false, 1991, 1998, true);
        studentRepository.save(pansy);

// Create and save Vincent
        Student vincent = new Student("Vincent", "", "Crabbe", LocalDate.of(1980, 9, 12), slytherin, false, 1991, 1998, true);
        studentRepository.save(vincent);

// Retrieve all students from the database
        List<Student> students = studentRepository.findAll();

// Create the course and set Snape as the teacher and all the students
        Course hogwartsCourse = new Course("Potions", 1991, true, snape, students);
        courseRepository.save(hogwartsCourse);


//        Course hogwartsCourse = new Course("Potions", 1991, true, snape, List.of(harry));
//        courseRepository.save(hogwartsCourse);
    }
}
