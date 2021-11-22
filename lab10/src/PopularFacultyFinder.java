//2) Знайти факультет, на якому навчається найбільша кількість студентів, типізований цикл «for-each».

public class PopularFacultyFinder implements Visitor {
    public void visit(Institute institute){
        int counter = 0;
        for (Faculty faculty : institute.getFaculties()) {
            if (faculty.getNumberOfStudents() > counter) {
                counter = faculty.getNumberOfStudents();
                institute.setPopularFaculty(faculty);
            }
        }
    }
}
