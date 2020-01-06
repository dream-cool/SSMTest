package com.clt.servlet;

import org.apache.log4j.BasicConfigurator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = {},loadOnStartup = 2)
public class WebPathServlet  extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext().setAttribute("ctx",config.getServletContext().getContextPath());
        BasicConfigurator.configure();
        super.init();
    }
}
