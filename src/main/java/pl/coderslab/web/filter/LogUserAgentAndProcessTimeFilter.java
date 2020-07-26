package pl.coderslab.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LogUserAgentAndProcessTimeFilter", urlPatterns = {"/*"})
public class LogUserAgentAndProcessTimeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String ua = ((HttpServletRequest) req).getHeader("User-Agent");
        System.out.println(ua);
        long startTime = System.currentTimeMillis();
        chain.doFilter(req, resp);
        long endTime = System.currentTimeMillis();
        System.out.println("Processing took: "+(endTime-startTime)+"ms");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
