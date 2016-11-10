package ru.javawebinar.topjava.web;

/**
 * Created by Sergii on 27.09.2016.
 */

import org.slf4j.Logger;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to mealList");


        request.setAttribute("mealList", MealsUtil.getWithExceeded(MealsUtil.USER_MEALs, MealsUtil.DEFAULT_CALORIES_PER_DAY));
        request.getRequestDispatcher("mealList.jsp").forward(request, response);
    }
}