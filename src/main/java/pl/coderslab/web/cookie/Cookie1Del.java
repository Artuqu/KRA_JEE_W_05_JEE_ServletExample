package pl.coderslab.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Zadanie 1 - rozwiązywane z wykładowcą
//        W projekcie stwórz trzy servlety Cookie1Set, Cookie1Get, Cookie1Del.
//        Servlet Cookie1Set ma być dostępny pod adresem /setCookie.
//        Ma nastawiać ciasteczko o nazwie User na CodersLab, z ważnością 24h.
//        Servlet Cookie1Get ma być dostępny pod adresem /showCookie.
//        Ma wyświetlać zawartość ciasteczka User.
//        Servlet Cookie1Del ma być dostępny pod adresem /deleteCookie ma kasować ciasteczko o nazwie User.
//        Jeżeli nie ma takiego ciasteczka, to powinna się wyświetlić napis: BRAK.

@WebServlet(name = "Cookie1Del", urlPatterns = {"/deleteCookie"})
public class Cookie1Del extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        boolean deleted = false;

        if(cookies != null) {
            for (Cookie c : cookies) {
                if ("User".equals(c.getName())) {
                    c.setMaxAge(0);
                    c.setPath("/");
                    resp.addCookie(c);
                    deleted=true;
                    break;
                }
            }
        }

        if(deleted){
            resp.getWriter().println("Usunięto ciasteczko");
        } else {
            resp.getWriter().println("BRAK");
        }
    }
}
