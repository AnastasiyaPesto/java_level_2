package lesson7;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateExample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Department department = new Department("Dev", "Spb"); // состояние transient
        session.save(department); // состояние persistent
        department.setCity("Moscow");

        transaction.commit();
        session.close();

        // состояние department = detached
    }
}
