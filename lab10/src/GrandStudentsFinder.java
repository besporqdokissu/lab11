import java.util.Iterator;

public class GrandStudentsFinder implements Visitor {

    public void visit(Institute institute){
        Iterator facultyIterator = institute.getFaculties().iterator();
        while (facultyIterator.hasNext()) {
            Faculty faculty = (Faculty) facultyIterator.next();
            institute.getGrandStudents().addAll(faculty.getGrandStudent());
        }
    }
}
