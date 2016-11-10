package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Sergii on 10.11.2016.
 */
public class InMemoryUserMealRepository implements UserMealRepository {
    private Map<Integer, UserMeal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);




    @Override
    public UserMeal save(UserMeal userMeal) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public UserMeal get(int id) {
        return null;
    }

    @Override
    public Collection<UserMeal> getAll() {
        return null;
    }
}
