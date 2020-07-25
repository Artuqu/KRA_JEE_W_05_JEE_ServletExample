package pl.coderslab.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet12 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello  Servlet 12");
        response.getWriter().println("<h1>Content12</h1>");
        response.getWriter().println(request.getHeader("User-Agent"));
        response.getWriter().println(request.getRemoteAddr());
    }
}
