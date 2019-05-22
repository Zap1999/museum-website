package com.softserve.academy.museum.servlets;

import com.softserve.academy.museum.db.EmployeeDao;
import com.softserve.academy.museum.entities.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet that gets employee from EmployeeDao and forwards request to employees.jsp
 * @author Taras Hlukhovetskyi
 */
@WebServlet(name = "EmployeesServlet")
public class EmployeesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Employee> employees = new EmployeeDao().getAll();
        request.setAttribute("employees", employees);
        RequestDispatcher rd = request.getRequestDispatcher("/museum-website.employees.tiles");
        rd.forward(request,response);
    }
}
