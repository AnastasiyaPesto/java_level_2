package lesson9.repository;

import lesson9.domain.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import javax.persistence.Table;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CountryRepositoryTest {

    // Dummy
    // Глупый объект. иплементит интерфейс, но ничего не делает. Пишем его сами.
    // Нужен, чтобы компилятор не ругался
    // Stub
    // Переопределяем что-то и реализовываем простейшую логику работы.
    // Mock
    // Работа через рефлекцию + за нас это сделает какой-то фреймворк

    private CountryRepository repository;

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    @Before
    public void setup() {
        factory = mock(SessionFactory.class);
        session = mock(Session.class);
        transaction = mock(Transaction.class);

        repository  = new CountryRepositoryImpl(factory);

        Mockito.when(factory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
    }

    @Test
    public void testCreate_validData_returnSaveObject() {
        String name = "Russia";
        String capital = "Moscow";
        double population = 147_000_000d;

        Country country = repository.create(name, capital, population);

        assertEquals(name, country.getName());
        assertEquals(capital, country.getCapital());
        assertEquals(population, country.getPopulation(), 0.2d);

        verify(session, times(1)).persist(Matchers.any(Country.class));
        verify(transaction).commit();
        verify(session).close();
    }

    @Test
    public void testDelete_validId() {
//        doReturn(true).when(repository).delete(Matchers.anyInt());
        repository.delete(1);

        verify(session).get(Matchers.eq(Country.class), Matchers.eq(1));

        verify(transaction).commit();
        verify(session).close();
    }

    @Test
    public void testUpdate_validData_returnUpdateObject() {
        int id = 1;
        String name = "Ukraine";
        String capital = "Kiev";
        double population = 42_386_403d; //wiki

        Country country = new Country();
        country.setId(id);
        country.setName(name);
        country.setCapital(capital);
        country.setPopulation(population);

        when(session.get(Country.class, id)).thenReturn(country);
//        Country countryAdd = repository.create(name, capital,; population);
        Country countryDel = repository.update(2, name,
                capital, population);
        assertEquals(name, countryDel.getName());
        assertEquals(capital, countryDel.getCapital());
        assertEquals(population, countryDel.getPopulation(), 0.2d);

        verify(session).update(Matchers.any(Country.class));
        verify(session, times(2)).close();
        verify(transaction).commit();
    }
}

