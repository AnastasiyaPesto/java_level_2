package lesson9.repository;

import lesson9.domain.Country;

public interface CountryRepository {

    Country create(String name, String capital, double population);

}
