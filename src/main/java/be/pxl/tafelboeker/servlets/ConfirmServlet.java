package be.pxl.tafelboeker.servlets;

import be.pxl.tafelboeker.domain.Boeking;
import be.pxl.tafelboeker.services.BoekingService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Confirm")
public class ConfirmServlet extends HttpServlet {

    private BoekingService service = new BoekingService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("confirm.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO STUDENT : boek tafel, toon gelukt.jsp indien de boeking gelukt is en toon mislukt.jsp indien de tafel niet geboekt kan worden

        Object boeking = request.getSession().getAttribute("boeking");
        if(boeking != null)
        {
            Boeking newBoeking = (Boeking) boeking;
            boolean posted = service.boekTafel(newBoeking);
            if(posted)
            {
                request.getSession().removeAttribute("boeking");
                request.getRequestDispatcher("gelukt.jsp").forward(request,response);
            }
            else
            {
                request.getSession().removeAttribute("boeking");
                request.getRequestDispatcher("mislukt.jsp").forward(request,response);

            }
        }

    }
}
