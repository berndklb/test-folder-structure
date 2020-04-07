package hibernate;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

    public StudentDao() {

    }

    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(student);
            // commit transaction
            transaction.commit();
        }
        catch (HibernateException hibernateEx) {
            if (transaction != null) {
                transaction.rollback();
            }
            hibernateEx.printStackTrace();
        }
    }

    public List<Student> getStudents() {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }

}
