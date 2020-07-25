package pl.coderslab.web.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get1", urlPatterns = {"/get1"})
public class Get1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String startStr = request.getParameter("start");
        String endStr = request.getParameter("end");

        try{
            int start = Integer.parseInt(startStr);
            int end = Integer.parseInt(endStr);
            for(int i=start; i<=end;i++){
                response.getWriter().println(i+"<br/>");
            }
        } catch (NumberFormatException e){
            response.getWriter().println("BRAK");
        }
    }
}
