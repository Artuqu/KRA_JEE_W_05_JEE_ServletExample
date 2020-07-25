package pl.coderslab.web.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Session2", urlPatterns = {"/session2"})
public class Session2 extends HttpServlet {
    private final String formStr="    <form method=\"POST\">\n" +
            "        <label>\n" +
            "            Ocena:\n" +
            "            <input  name=\"grade\">\n" +
            "        </label>\n" +
            "        <input type=\"submit\">\n" +
            "    </form>";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        response.getWriter().println(formStr);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        List<Integer> gradesInSession = (List<Integer>)session.getAttribute("gradesInSession");

        if (gradesInSession==null){
            gradesInSession = new ArrayList<>();
        }

        try {
            String gradeStr = request.getParameter("grade");
            int grade = Integer.parseInt(gradeStr);
            gradesInSession.add(grade);
        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        session.setAttribute("gradesInSession", gradesInSession);

        double avg = getAvg(gradesInSession);

        response.getWriter().println(formStr);
        response.getWriter().println("grades="+gradesInSession.toString());
        response.getWriter().println("avg="+avg);
    }

    private double getAvg(List<Integer> grades) {
        if (grades.size()==0){
            return Double.NaN;
        }

        long sum = 0;

        for(int grade : grades){
            sum+= grade;
        }

        return sum/(double)grades.size();
    }
}
