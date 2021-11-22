import java.util.Iterator;

public class NumberOfStudentsCalculator implements Visitor {

    //1) Знайти загальну кількість студентів, що навчається в інституті, типізований ітератор
    public void visit(Institute institute){
        int counter = 0;

        Iterator<Faculty> facultyIterator = institute.getFaculties().iterator();
        while (facultyIterator.hasNext()) {
            Faculty faculty = facultyIterator.next();
            counter += faculty.getNumberOfStudents();
        }
        institute.setNumberOfStudents(counter);
    }

}
