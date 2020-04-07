import java.util.List;
import hibernate.Student;
import hibernate.StudentDao;

public class TestMain
{

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.getStudents();
        System.out.println("Student size: " + students.size());
        students.forEach(s -> System.out.println(s.getFirstName() + "- " +  s.getLastName()));
    }
}
