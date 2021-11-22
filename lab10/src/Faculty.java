import java.util.Set;
import java.util.TreeSet;

public class Faculty implements Comparable<Faculty> {

    private String name;
    private Set<Student> students = new TreeSet<>(new Student.AverageScoreComparator());
    private Set<Student> grandStudent = new TreeSet<>(new Student.AverageScoreComparator());

    public Faculty(String name, Set<Student> students) {
        this.name = name;
        this.students.addAll(students);
        initializeGrandStudent(students);
    }

    public static class FacultyBuilder{
        private String name;
        private Set<Student> students = new TreeSet<>(new Student.AverageScoreComparator());

        public FacultyBuilder setName(String name){
            this.name = name;
            return this;
        }

        public FacultyBuilder setStudents(Set<Student> students){
            this.students.addAll(students);
            return this;
        }

        public Faculty build(){
            return new Faculty(name, students);
        }
    }
    public void enrollStudent(Student student) {
        this.students.add(student);
        initializeGrandStudent(student);
    }

    public void enrollAllStudent(Set<Student> students) {
        this.students.addAll(students);
        initializeGrandStudent(students);
    }

    public void expelStudent(Student student) {
        this.students.remove(student);
        this.grandStudent.remove(student);
    }

    public void expelAllStudent(Set<Student> student) {
        this.students.removeAll(student);
        this.grandStudent.removeAll(student);
    }

    private void initializeGrandStudent(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageScore() > 95) {
                grandStudent.add(student);
            }
        }
    }

    private void initializeGrandStudent(Student student) {
        if (student.getAverageScore() > 95) {
            grandStudent.add(student);
        }
    }

    public Set<Student> getGrandStudent() {
        return grandStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return Set.copyOf(students);
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public void setStudents(Set<Student> students) {
        this.students = new TreeSet<>(students);
    }

    @Override
    public int compareTo(Faculty o) {
        return Integer.compare(getNumberOfStudents(), o.getNumberOfStudents());
    }
}
