package com.softserve.academy.museum.servlets;

import com.softserve.academy.museum.db.ExhibitDao;
import com.softserve.academy.museum.entities.Author;
import com.softserve.academy.museum.entities.Excursion;
import com.softserve.academy.museum.entities.Exhibit;
import com.softserve.academy.museum.entities.Hall;
import com.softserve.academy.museum.services.AuthorService;
import com.softserve.academy.museum.services.ExhibitService;
import com.softserve.academy.museum.services.HallService;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Author> authors = AUTHOR_SERVICE.getAll();
        request.setAttribute("authors", authors);

        ArrayList<Exhibit> exhibits = EXHIBIT_SERVICE.getAll();
        request.setAttribute("exhibits", exhibits);

        ArrayList<Hall> halls = HALL_SERVICE.getAll();
        request.setAttribute("halls", halls);

        RequestDispatcher rd = request.getRequestDispatcher("/museum-website.exhibits.tiles");
        rd.forward(request,response);
    }
}
