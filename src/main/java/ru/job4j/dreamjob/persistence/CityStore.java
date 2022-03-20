package ru.job4j.dreamjob.persistence;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.City;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
@Repository
public class CityStore {
    private static final AtomicInteger CITY_ID = new AtomicInteger(4);
    private final Map<Integer, City> cityStore = new ConcurrentHashMap<>();

    public CityStore() {
        cityStore.put(1, new City(1, "Moscow"));
        cityStore.put(2, new City(2, "SPb"));
        cityStore.put(3, new City(3, "Ekb"));
        cityStore.put(4, new City(4, "Perm"));
    }

    public Collection<City> findAllCity() {
        return cityStore.values();
    }

    public City findCityById(int id) {
        return cityStore.get(id);
    }
}
