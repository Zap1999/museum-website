package com.softserve.academy.museum.servlets;

import com.softserve.academy.museum.db.EmployeeDao;
import com.softserve.academy.museum.entities.Employee;
import com.softserve.academy.museum.entities.Position;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeesByPositionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String position = req.getParameter("position");

        if (position.isEmpty()) {
            resp.sendRedirect("");
            return;
        }

        ArrayList<Employee> list = new EmployeeDao().getByPosition(Position.getPos(position));
        req.setAttribute("employees", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/employees.jsp");
        dispatcher.forward(req, resp);

    }
}
