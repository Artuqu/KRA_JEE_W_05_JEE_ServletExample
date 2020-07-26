package pl.coderslab.web.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Mvc12", urlPatterns = {"/mvc12"})
public class Mvc12 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String startStr = request.getParameter("start");
            String endStr = request.getParameter("end");
            int start = Integer.parseInt(startStr);
            int end = Integer.parseInt(endStr);
            start += 10;
            end += 10;

            request.setAttribute("start", start);
            request.setAttribute("end", end);
        } catch (Exception e){
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp2.jsp")
                .forward(request, response);
    }
}
