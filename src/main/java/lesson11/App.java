package lesson11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class App {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.connection.driver_class", "org.h2.Driver");
        properties.put("hibernate.connection.url", "jdbc:h2:mem:emp;INIT=create schema if not exists emp");
        properties.put("hibernate.connection.username", "sa");
        properties.put("hibernate.connection.password", "");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        // помогает создать нашу фабрику
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(properties).build();

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Department department = new Department();
        department.setName("Development");
        department.setCity(City.SAINT_PETERSBURG);

        Employee employee = new Employee();
        employee.setLogin("dmipro");
        employee.setName("Dmitry");
        employee.setLastName("Protsko");
        employee.setEmail("dmitr.prot@gmail.com");
//        employee.setDepartment(department);
        department.getEmployees().add(employee);

        session.persist(department);

//        employee.setName("Nikolay");
//        session.persist(employee);

        transaction.commit();
        session.close();
        factory.close();
    }


}
