package com.softserve.academy.museum.servlets;

import com.softserve.academy.museum.db.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class WorkTimeByDateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String satrtDateString = req.getParameter("startDate");
        String endDateString = req.getParameter("endDate");
        int employeeId = Integer.parseInt(req.getParameter("id"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDate = LocalDateTime.parse(satrtDateString, formatter);
        LocalDateTime endDate = LocalDateTime.parse(endDateString, formatter);

        int workTime = new EmployeeDao().getWorkTime(employeeId, startDate, endDate);

        resp.setStatus(200);
        resp.setContentType("text/plain");
        PrintWriter writer=resp.getWriter();
        writer.append(Integer.toString(workTime));

    }
}
