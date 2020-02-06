package com.Core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebServlet(name = "Hello", urlPatterns = {"/api/*"})
public class Servlett extends HttpServlet {


    private static final String NAME_PARAM = "name";
    private static final String LANG_PARAM = "lang";

    private final Logger logger = LoggerFactory.getLogger(Servlett.class);
    private Serwiss service;
    //Servlet container needs it
@SuppressWarnings("unused")
    public Servlett() {
        this(new Serwiss());
    }

    Servlett(Serwiss service) {
        this.service = service;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        ;
        logger.info("Request" + req.getParameterMap() + " got");
        var name = req.getParameter(NAME_PARAM);
        var parameter = Optional.ofNullable(name).orElse("world");
        var greeting = service.prepGreeting(
                req.getParameter(NAME_PARAM),
                req.getParameter(LANG_PARAM));
        resp.getWriter().write(greeting);
    }
}
