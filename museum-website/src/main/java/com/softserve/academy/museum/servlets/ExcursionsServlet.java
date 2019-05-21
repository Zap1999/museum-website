package com.softserve.academy.museum.servlets;

import com.softserve.academy.museum.db.ExcursionDao;
import com.softserve.academy.museum.entities.Excursion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ExcursionsServlet")
public class ExcursionsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Excursion> excursions = new ExcursionDao().getAll();
        request.setAttribute("excursions", excursions);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/excursions.jsp");
        rd.forward(request,response);
    }
}
