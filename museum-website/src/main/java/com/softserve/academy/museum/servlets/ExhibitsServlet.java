package com.softserve.academy.museum.servlets;

import com.softserve.academy.museum.db.ExhibitDao;
import com.softserve.academy.museum.entities.Author;
import com.softserve.academy.museum.entities.Exhibit;
import com.softserve.academy.museum.services.AllAuthorsService;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Exhibit> exhibits = new ExhibitDao().getAll();
        request.setAttribute("exhibits", exhibits);

        ArrayList<Author> authors = new AllAuthorsService().getAll();
        request.setAttribute("authors", authors);
        RequestDispatcher rd = request.getRequestDispatcher("/museum-website.exhibits.tiles");
        rd.forward(request,response);
    }
}
