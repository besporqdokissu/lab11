import java.util.Comparator;

public class Student {

    private String name;
    private String surname;
    private int recordBookID;
    private double averageScore;

    public Student(String name, String surname, int recordBookID, double averageScore) {
        this.name = name;
        this.surname = surname;
        this.recordBookID = recordBookID;
        this.averageScore = averageScore;
    }

    public static class StudentBuilder {
        private String name;
        private String surname;
        private int recordBookID;
        private double averageScore;

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public StudentBuilder setRecordBookID(int recordBookID) {
            this.recordBookID = recordBookID;
            return this;
        }

        public StudentBuilder setAverageScore(double averageScore) {
            this.averageScore = averageScore;
            return this;
        }

        public Student build() {
            return new Student(name, surname, recordBookID, averageScore);
        }
    }

    public static class NameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class SurnameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }

    public static class AverageScoreComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return Double.compare(o1.getAverageScore(), o2.getAverageScore());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getRecordBookID() {
        return recordBookID;
    }

    public void setRecordBookID(int recordBookID) {
        this.recordBookID = recordBookID;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "\n" + name + " " + surname + ", average score = " + averageScore;
    }

}
