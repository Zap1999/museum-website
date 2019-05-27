package com.softserve.academy.museum.servlets;

import com.softserve.academy.museum.db.ExcursionDao;
import com.softserve.academy.museum.entities.Excursion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ExcursionsFilterByDateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startDateString = req.getParameter("startDate");
        String endDateString = req.getParameter("endDate");

        ArrayList<Excursion> list;
        ExcursionDao dao = new ExcursionDao();

        if(startDateString.contains("null") || endDateString.contains("null")) {

            list = dao.getAll();

        } else {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime startDate = LocalDateTime.parse(startDateString, formatter);
            LocalDateTime endDate = LocalDateTime.parse(endDateString, formatter);

            list = dao.getAvailableExcursions(startDate, endDate);

        }
        req.setAttribute("excursions", list);
        req.setAttribute("excursionsCount", list.size());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/excursions.jsp");
        dispatcher.forward(req, resp);
    }
}
