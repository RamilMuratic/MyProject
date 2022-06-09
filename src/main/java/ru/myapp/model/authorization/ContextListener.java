package ru.myapp.model.authorization;
//import ru.javavision.dao.UserDAO;

import ru.myapp.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;


/**
 * ContextListener put user dao to servlet context.
 */
@WebListener

public class ContextListener implements ServletContextListener {



    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Map<String, User> logPass = new HashMap<>();
        logPass.put("admin", new User("admin", "123"));



        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("logPass", logPass);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Object logPass = null;
    }
}
