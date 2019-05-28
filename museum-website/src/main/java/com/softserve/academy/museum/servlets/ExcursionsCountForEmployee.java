package com.softserve.academy.museum.servlets;

import com.softserve.academy.museum.db.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ExcursionsCountForEmployee extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employeeId = Integer.parseInt(req.getParameter("id"));

        int excursionsCount = new EmployeeDao().getExcursionsCount(employeeId);

        resp.setStatus(200);
        resp.setContentType("text/plain");
        PrintWriter writer=resp.getWriter();
        writer.append(Integer.toString(excursionsCount));
    }
}
