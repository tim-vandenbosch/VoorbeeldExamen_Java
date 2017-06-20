package be.pxl.tafelboeker.servlets;

import be.pxl.tafelboeker.domain.Boeking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name="BoekTafelServlet", value = "/BoekTafel")
public class BoekTafelServlet extends HttpServlet {

    private String restaurant;

    @Override
    public void init() throws ServletException {
        restaurant = getInitParameter("restaurant");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("restaurantnaam",restaurant);
        request.getRequestDispatcher("boektafel.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uurParam = request.getParameter("uur");
        String dagParam = request.getParameter("dag");

        Integer uur = Integer.parseInt(uurParam.substring(0,2));
        Date dag = null;

        try {
            dag = DateUtil.parse(dagParam);
        } catch (ParseException pe){
            System.err.println("Datum kan niet geparsed worden");
            response.getWriter().print("Foutieve datum, probeert u het opnieuw");
            response.flushBuffer();
            return;
        }

        // TODO STUDENT : vergeet niet om de boeking toe te voegen aan de sessie
        Boeking boeking = new Boeking();
        boeking.setDag(dag);
        boeking.setUur(uur);
        request.getSession().setAttribute("boeking",boeking);

        response.sendRedirect("Address");
    }
}
