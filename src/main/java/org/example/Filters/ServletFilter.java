package org.example.Filters;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;

public class ServletFilter implements Filter {

    FilterConfig config;

    public void init(FilterConfig config) throws ServletException {
        this.config=config;
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");


        String permission = config.getInitParameter("permission");

        if(permission.equalsIgnoreCase("true")){
            out.println("You have a permission! <br>");
            chain.doFilter(req, resp);
        }else{
            out.println("You do not have a permission! <br>");
        }
        out.close();
    }
    public void destroy() {}
}
