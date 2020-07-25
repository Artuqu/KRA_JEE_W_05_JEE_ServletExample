package pl.coderslab.web.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Get2", urlPatterns = {"/get2"})
public class Get2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Map<String, String[]> parameters = request.getParameterMap();

        Set<String> paramNames = parameters.keySet();

        for(String paramName : paramNames){
            String paramValue = request.getParameter(paramName);
            response.getWriter().println(paramName + " : " + paramValue + "<br/>");
        }

    }
}
