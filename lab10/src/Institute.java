import java.util.*;

public class Institute implements Element{

    private String name;
    private SortedSet<Faculty> faculties = new TreeSet<>();
    private Faculty popularFaculty;
    private int numberOfStudents;
    private Set<Student> grandStudents = new TreeSet<>(new Student.AverageScoreComparator().reversed());

    public Institute(String name, Set<Faculty> faculties) {
        this.name = name;
        this.faculties.addAll(faculties);
    }

    public static class InstituteBuilder{
        private String name;
        private Set<Faculty> faculties = new TreeSet<>();

        public InstituteBuilder setName(String name){
            this.name = name;
            return this;
        }

        public InstituteBuilder setFaculties(Collection<Faculty> faculties){
            this.faculties.addAll(faculties);
            return this;
        }

        public Institute build(){
            return new Institute(name, faculties);
        }
    }

    public void accept(Visitor visitor){
       visitor.visit(this);
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void addAllFaculty(Set<Faculty> faculty) {
        faculties.addAll(faculty);
    }

    public void removeFaculty(Faculty faculty) {
        this.faculties.remove(faculty);
    }

    public void removeAllFaculty(Set<Faculty> faculties) {
        this.faculties.removeAll(faculties);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = new TreeSet<>(faculties);
    }

    public Faculty getPopularFaculty() {
        return popularFaculty;
    }

    public void setPopularFaculty(Faculty popularFaculty) {
        this.popularFaculty = popularFaculty;
    }

    public Set<Student> getGrandStudents(){
        return grandStudents;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Set<Faculty> getFaculties() {
        return Set.copyOf(faculties);
    }
}
