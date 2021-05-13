package org.example.Filters;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        servletResponse.setContentType("text/html");

        servletRequest.getRequestDispatcher("link.jsp").include(servletRequest, servletResponse);

        String firstname = servletRequest.getParameter("firstname");
        String lastname = servletRequest.getParameter("lastname");
        String email = servletRequest.getParameter("email");
        String pswd = servletRequest.getParameter("pswd");
        if (!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty() && pswd.length() >= 8){
            out.println("Data are valid! <br>");
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            out.println("Data are not valid!");
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("registration.jsp");
            requestDispatcher.include(servletRequest, servletResponse);
        }
        out.close();
    }

    @Override
    public void destroy() {

    }
}
