package com.nicklaus.web.filter;

import com.nicklaus.bean.UserBean;
import com.nicklaus.bean.UserManagerBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/home.jsf","/home.xhtml","/project.jsf","/project.xhtml","/create.jsf",
"/create.xhtml","/edit.jsf","/edit.xhtml"})
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //cast
        HttpServletRequest request = (HttpServletRequest) req;

        UserManagerBean user = (UserManagerBean)request.getSession().getAttribute("userManager");

        UserBean loginUser = null;

        try {
            loginUser = user.getLoginUser();
        } catch (Exception e) {

        }

        //If loginUser exists
        if (loginUser != null){
            //Release
            chain.doFilter(req, resp);
        }else{
            request.getRequestDispatcher("/deny.jsf").forward(request,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }

}
