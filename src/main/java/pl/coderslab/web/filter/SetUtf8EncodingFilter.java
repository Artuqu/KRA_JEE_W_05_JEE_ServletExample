package pl.coderslab.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "SetUtf8EncodingFilter", urlPatterns = {"/*"})
public class SetUtf8EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        System.out.println("filtr set utf-8");
        chain.doFilter(req, resp);
        System.out.println("way back filtr set utf-8");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
