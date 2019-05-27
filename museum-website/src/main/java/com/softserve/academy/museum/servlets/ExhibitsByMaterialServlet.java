package com.softserve.academy.museum.servlets;

import com.softserve.academy.museum.entities.Exhibit;
import com.softserve.academy.museum.services.ExhibitService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ExhibitsByMaterialServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ExhibitsByAuthorServlet.class);
    private static final ExhibitService EXHIBIT_SERVICE = new ExhibitService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String material = request.getParameter("material");
            ArrayList<Exhibit> exhibits;
            if(material.isEmpty()) {
                exhibits = EXHIBIT_SERVICE.getAll();
            } else {
                exhibits = EXHIBIT_SERVICE.getByMaterial(material);
            }

            request.setAttribute("exhibits", exhibits);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/exhibits.jsp");
            rd.forward(request, response);

        } catch (NumberFormatException ex) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
            LOGGER.error("Invalid parameter in request", ex);
            rd.forward(request, response);
        } catch (Exception ex) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
            LOGGER.error(ex);
            rd.forward(request, response);
        }
    }
}
