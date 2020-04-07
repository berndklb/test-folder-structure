import java.util.List;
import hibernate.Student;
import hibernate.StudentDao;
import org.junit.Test;

public class StudentDaoTest {
    @Test
    public void findAllEmployee_shouldNotFail() {
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.getStudents();
        System.out.println(students.size());
        students.forEach(s -> System.out.println(s.getFirstName() + "- " +  s.getLastName()));
    }
}
