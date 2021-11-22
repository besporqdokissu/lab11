import com.sun.source.tree.Tree;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Student student = new Student.StudentBuilder()
                .setName("Harry")
                .setSurname("Potter")
                .setRecordBookID(0)
                .setAverageScore(95.1)
                .build();

        Student student1 = new Student.StudentBuilder()
                .setName("George")
                .setSurname("Weasley")
                .setRecordBookID(1)
                .setAverageScore(83)
                .build();

        Student student2 = new Student.StudentBuilder()
                .setName("Hermione")
                .setSurname("Granger")
                .setRecordBookID(2)
                .setAverageScore(95.2)
                .build();

        Student student3 = new Student.StudentBuilder()
                .setName("Fred")
                .setSurname("Weasley")
                .setRecordBookID(3)
                .setAverageScore(90)
                .build();

        Student student4 = new Student.StudentBuilder()
                .setName("Draco")
                .setSurname("Malfoy")
                .setRecordBookID(4)
                .setAverageScore(99)
                .build();

        Student student5 = new Student.StudentBuilder()
                .setName("Narcissa")
                .setSurname("Malfoy")
                .setRecordBookID(5)
                .setAverageScore(87)
                .build();

        Student student6 = new Student.StudentBuilder()
                .setName("Gregory")
                .setSurname("Goyle")
                .setRecordBookID(6)
                .setAverageScore(61)
                .build();

        Faculty gryffindor = new Faculty.FacultyBuilder()
                .setName("Gryffindor")
                .setStudents(Set.of(student, student1, student2, student3))
                .build();

        Faculty slytherin = new Faculty.FacultyBuilder()
                .setName("Slytherin")
                .setStudents(Set.of(student4, student5, student6))
                .build();

        Institute hogwarts = new Institute.InstituteBuilder()
                .setName("Hogwarts")
                .setFaculties(Set.of(slytherin, gryffindor))
                .build();

        hogwarts.accept(new NumberOfStudentsCalculator());
        System.out.printf("\nnumber of students in %s: %d \n\n", hogwarts.getName(), hogwarts.getNumberOfStudents());

        hogwarts.accept(new PopularFacultyFinder());
        System.out.printf("most popular faculty is %s. \n\n", hogwarts.getPopularFaculty().getName());

        hogwarts.accept(new GrandStudentsFinder());
        System.out.printf("here are the best %s students: %s\n", hogwarts.getName(), hogwarts.getGrandStudents());
    }
}
