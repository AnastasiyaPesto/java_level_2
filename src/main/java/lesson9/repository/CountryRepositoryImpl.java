package lesson9.repository;

import lesson9.domain.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CountryRepositoryImpl implements CountryRepository {

    private final SessionFactory factory;

    public CountryRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Country create(String name, String capital, double population) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Country country = new Country();
        country.setName(name);
        country.setCapital(capital);
        country.setPopulation(population);

        session.persist(country);
        transaction.commit();
        session.close();

        return country;
    }

    @Override
    public void delete(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        // достали из БД. Состояние persistent
        Country country = session.get(Country.class, id);
        // Состояние removed
        session.delete(country);

        transaction.commit();
        session.close();
    }

    @Override
    public Country update(int id, String name, String capital, double population) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        // persistent
        Country country = session.get(Country.class, id);

        // перевожу объект в состояние detached (отвязываю объект от session)
        session.close();
        // вызываю все методы set, чтобы не вызывался на каждыц set свой update
        country.setName(name);
        country.setCapital(capital);
        country.setPopulation(population);
        // из detached в persistent (привязываю объект к session)
        session.update(country);

        transaction.commit();
        session.close();

        return country;
    }

}
