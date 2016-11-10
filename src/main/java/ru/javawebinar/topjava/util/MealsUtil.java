package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class MealsUtil {
    public static final int DEFAULT_CALORIES_PER_DAY = 2000;

    public static final List<UserMeal> USER_MEALs = Arrays.asList(
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
    );
    public static void main(String[] args) {


        List<UserMealWithExceed> filteredMealsWithExceeded = getFilteredWithExceeded(USER_MEALs, LocalTime.of(7, 0), LocalTime.of(12, 0), DEFAULT_CALORIES_PER_DAY);
        filteredMealsWithExceeded.forEach(System.out::println);

        System.out.println(getFilteredWithExceededByCycle(USER_MEALs, LocalTime.of(7, 0), LocalTime.of(12, 0), DEFAULT_CALORIES_PER_DAY));
    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> userMeals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumByDate = userMeals.stream()
                .collect(
                        Collectors.groupingBy(UserMeal::getDate, Collectors.summingInt(UserMeal::getCalories))
//                      Collectors.toMap(UserMeal::getDate, UserMeal::getCalories, Integer::sum)
                );

        return userMeals.stream()
                .filter(userMeal -> TimeUtil.isBetween(userMeal.getTime(), startTime, endTime))
                .map(userMeal -> createWithExceed(userMeal, caloriesSumByDate.get(userMeal.getDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }

    public static List<UserMealWithExceed> getFilteredWithExceededByCycle(List<UserMeal> userMeals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        final Map<LocalDate, Integer> caloriesSumByDate = new HashMap<>();
        userMeals.forEach(userMeal -> caloriesSumByDate.merge(userMeal.getDate(), userMeal.getCalories(), Integer::sum));

        final List<UserMealWithExceed> mealExceeded = new ArrayList<>();
        userMeals.forEach(userMeal -> {
            if (TimeUtil.isBetween(userMeal.getTime(), startTime, endTime)) {
                mealExceeded.add(createWithExceed(userMeal, caloriesSumByDate.get(userMeal.getDate()) > caloriesPerDay));
            }
        });
        return mealExceeded;
    }

    public static UserMealWithExceed createWithExceed(UserMeal userMeal, boolean exceeded) {
        return new UserMealWithExceed(userMeal.getDateTime(), userMeal.getDescription(), userMeal.getCalories(), exceeded);
    }

    public static List<UserMealWithExceed> getWithExceeded(List<UserMeal> userMeals, int caloriesPerDay) {
        return getFilteredWithExceeded(userMeals, LocalTime.MIN, LocalTime.MAX, caloriesPerDay);
    }
}