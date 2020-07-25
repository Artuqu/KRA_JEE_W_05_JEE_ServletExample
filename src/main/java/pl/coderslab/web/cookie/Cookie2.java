package pl.coderslab.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie2", urlPatterns = {"/addToCookies"})
public class Cookie2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        String value = req.getParameter("value");

        if(key == null || value == null || key.length() == 0 || value.length() == 0){
            resp.getWriter().println("Nie można utworzyć ciasteczka z podanych wartości");
        } else {
            Cookie cookie = new Cookie(key, value);
            cookie.setPath("/");

            resp.addCookie(cookie);
            resp.getWriter().println("Dodano ciasteczko: " + key);
        }
    }
}
