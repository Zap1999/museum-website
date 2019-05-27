package com.softserve.academy.museum.servlets;

import com.softserve.academy.museum.db.EmployeeDao;
import com.softserve.academy.museum.entities.Employee;
import com.softserve.academy.museum.entities.Position;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EmployeesByDateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String satrtDateString = req.getParameter("startDate");
        String endDateString = req.getParameter("endDate");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDate = LocalDateTime.parse(satrtDateString, formatter);
        LocalDateTime endDate = LocalDateTime.parse(endDateString, formatter);

        ArrayList<Employee> list;
        list = new EmployeeDao().getFreeGuides(startDate, endDate);
        req.setAttribute("employees", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/employees.jsp");
        dispatcher.forward(req, resp);
    }
}
