package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

/**
 * Created by Sergii on 02.11.2016.
 */
public interface UserMealRepository {
    Meal save (Meal meal);

    void delete(int id);
    Meal get (int id);

    Collection<Meal> getAll();
}
