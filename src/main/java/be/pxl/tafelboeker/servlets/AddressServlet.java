package be.pxl.tafelboeker.servlets;

import be.pxl.tafelboeker.domain.AddressBean;
import be.pxl.tafelboeker.domain.Boeking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Address")
public class AddressServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("address.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boeking newBoeking = null;
        AddressBean address = new AddressBean();
        address.setStraat(request.getParameter("straat"));
        address.setStad(request.getParameter("stad"));

        if(address.getStad() != null && address.getStraat() != null)
        {
            Object boeking = request.getSession().getAttribute("boeking");
            if(boeking != null)
            {
                newBoeking = (Boeking)boeking;
                newBoeking.setNaam(request.getParameter("naam"));
                newBoeking.setStad(address.getStad());
                newBoeking.setStraat(address.getStraat());
            }

            request.getSession().setAttribute("boeking",newBoeking);
            response.sendRedirect("Confirm");
        }
        else
        {
            response.getWriter().print("Gelieve alle velden in te vullen");
            response.flushBuffer();
            return;
        }





    }
}
