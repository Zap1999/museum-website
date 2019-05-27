package com.softserve.academy.museum.servlets;

import com.softserve.academy.museum.db.ExhibitDao;
import com.softserve.academy.museum.entities.*;
import com.softserve.academy.museum.services.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ExhibitsServlet")
public class ExhibitsServlet extends HttpServlet {

    private static final AuthorService AUTHOR_SERVICE = new AuthorService();
    private static final ExhibitService EXHIBIT_SERVICE = new ExhibitService();
    private static final HallService HALL_SERVICE = new HallService();
    private static final MaterialService MATERIAL_SERVICE = new MaterialService();
    private static final TechniqueService TECHNIQUE_SERVICE = new TechniqueService();
    private static final EmployeeService EMPLOYEE_SERVICE = new EmployeeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Author> authors = AUTHOR_SERVICE.getAll();
        request.setAttribute("authors", authors);

        ArrayList<Exhibit> exhibits = EXHIBIT_SERVICE.getAll();
        request.setAttribute("exhibits", exhibits);

        ArrayList<Hall> halls = HALL_SERVICE.getAll();
        request.setAttribute("halls", halls);

        ArrayList<String> materials = MATERIAL_SERVICE.getAll();
        request.setAttribute("materials", materials);

        ArrayList<String> techniques = TECHNIQUE_SERVICE.getAll();
        request.setAttribute("techniques", techniques);

        ArrayList<Employee> employees = EMPLOYEE_SERVICE.getAllManagersOnHall();
        request.setAttribute("employees", employees);

        RequestDispatcher rd = request.getRequestDispatcher("/museum-website.exhibits.tiles");
        rd.forward(request,response);
    }
}
