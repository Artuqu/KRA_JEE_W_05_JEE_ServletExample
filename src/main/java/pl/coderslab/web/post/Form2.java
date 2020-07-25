package pl.coderslab.web.post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Form2", urlPatterns = {"/post2"})
public class Form2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userText = request.getParameter("userText");
        String acknowledge = request.getParameter("acknowledge");

        if(acknowledge == null){
            userText = Censor.doCensor(userText);
        }

        response.getWriter().println(userText);
    }
}
