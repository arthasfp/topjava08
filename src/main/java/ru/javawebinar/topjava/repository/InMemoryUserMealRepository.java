package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.Collection;

/**
 * Created by Sergii on 10.11.2016.
 */
public class InMemoryUserMealRepository implements UserMealRepository {


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
