package be.pxl.tafelboeker.servlets;

import be.pxl.tafelboeker.domain.Boeking;
import be.pxl.tafelboeker.services.BoekingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Overzicht")
public class OverzichtServlet extends HttpServlet {

    private BoekingService service = new BoekingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Boeking> boekingen = service.getAll();
        if(boekingen != null)
        {
            req.getSession().setAttribute("boeking",boekingen);
        }
        req.getRequestDispatcher("overzicht.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
