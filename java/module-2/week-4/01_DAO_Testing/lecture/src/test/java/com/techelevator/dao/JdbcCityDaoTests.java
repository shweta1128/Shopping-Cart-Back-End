package com.techelevator.dao;

import com.techelevator.model.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
public class JdbcCityDaoTests extends BaseDaoTests {

    private static final City CITY_1 = new City(1, "City 1", "AA", 11,111);
    private static final City CITY_2 = new City(2, "City 2", "BB", 22,222);
    private static final City CITY_4 = new City(4, "City 4", "AA", 44,444);

    private City testCity;

    private JdbcCityDao sut;

    @Before
    public void setup() {
        sut = new JdbcCityDao(dataSource);
        testCity = new City(0, "Test City", "CC", 99, 999);
    }

    @Test
    public void getCity_returns_correct_city_for_id() {
        City testCity = sut.getCity(1);
    //    Assert.assertEquals(111,testCity.getArea(), 0.01);
         assertCitiesMatch(CITY_1, testCity);
// we use assertCitiesMatches for all the attributes of city_id

    }

    @Test
    public void getCity_returns_null_when_id_not_found() {
     City testCity = sut.getCity(5);
   //  Assert.assertEquals(null, testCity);
     Assert.assertNull(testCity);
    //   we can use either of the assert for comparing the data

    }



    @Test
    public void getCitiesByState_returns_all_cities_for_state() {

      List<City> citiesReturned = sut.getCitiesByState("AA");

      Assert.assertEquals(2, citiesReturned.size());

      assertCitiesMatch(CITY_1, citiesReturned.get(0));
      assertCitiesMatch(CITY_4, citiesReturned.get(1));
    }

    @Test
    public void getCitiesByState_returns_empty_list_for_abbreviation_not_in_db() {
        Assert.fail();
    }

    @Test
    public void createCity_returns_city_with_id_and_expected_values() {
        City insertCity =  sut.createCity(testCity);
        Assert.assertEquals(true, insertCity.getCityId() > 0);
        insertCity.setCityName(CITY_1.getCityName());
        insertCity.setStateAbbreviation(CITY_1.getStateAbbreviation());
        insertCity.setPopulation(CITY_1.getPopulation());
        insertCity.setArea(CITY_1.getArea());



    }



    @Test
    public void created_city_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void updated_city_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void deleted_city_cant_be_retrieved() {
        Assert.fail();
    }

    private void assertCitiesMatch(City expected, City actual) {
        Assert.assertEquals(expected.getCityId(), actual.getCityId());
        Assert.assertEquals(expected.getCityName(), actual.getCityName());
        Assert.assertEquals(expected.getStateAbbreviation(), actual.getStateAbbreviation());
        Assert.assertEquals(expected.getPopulation(), actual.getPopulation());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
    }
}
