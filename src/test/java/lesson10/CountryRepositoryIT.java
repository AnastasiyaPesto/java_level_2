package lesson10;

import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;
import lesson9.domain.Country;
import lesson9.repository.CountryRepository;
import lesson9.repository.CountryRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.*;

import java.util.List;

public class CountryRepositoryIT {

    private static SessionFactory factory;
    private CountryRepository countryRepository =
            new CountryRepositoryImpl(factory);

    @BeforeClass
    public static void setupFactory() {
        factory = TestHibernateUtils.getFactory();
    }

    @Test
    public void testCreate_validParams_returnNewlyCreatedCountry() {
        String name = "England";
        String capital = "London";
        double population = 21_523_231d;

        // этот объект реальный и лежит в реальной базе
        Country country = countryRepository.create(name, capital, population);
        Assert.assertNotEquals(0, country.getId());
    }

    @Test
    public void testGetById_entityExists_returnEntity() {
        String name = "Russia";
        String capital = "Moscow";
        double population = 42_000_000d;

        Country country = countryRepository.create(name, capital, population);
        Country result = countryRepository.getById(country.getId());

        Assert.assertNotNull(result);
        Assert.assertEquals(country.getId(), result.getId());
    }

    @Test
    public void testGetById_entityNotExists_returnNull() {
        Country result = countryRepository.getById(100_000_000);
        Assert.assertNull(result);
    }

    @Test
    public void testGetCountriesWithMillionPopulation_countriesExists_returnList() {
        countryRepository.create("name1", "capital1", 10_123_123);
        countryRepository.create("name2", "capital2", 7_888_999);
        countryRepository.create("name3", "capital3", 100);
        countryRepository.create("name4", "capital4", 8_893_00);
        countryRepository.create("name5", "capital5", 4_222_465);

        List<Country> countries = countryRepository.getCountriesWithMillionPopulation();
        Assert.assertEquals(3, countries.size());
    }

    @Test
    public void testGetCountriesWithMillionPopulation_countriesNotExists_returnEmpty() {
        countryRepository.create("name6", "capital6", 524_123);
        countryRepository.create("name7", "capital7", 524_123);
        countryRepository.create("name8", "capital8", 524_123);

        List<Country> countries = countryRepository.getCountriesWithMillionPopulation();
        Assert.assertEquals(0, countries.size());
    }

    @After
    public void clearDatabase() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete from Country")
                .executeUpdate();

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void closeFactory() {
        factory.close();
    }
}
