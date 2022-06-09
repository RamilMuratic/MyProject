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

    /*
     * Fake database connector.
     */

   /* private AtomicReference<UserDAO> dao;*/

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Map<String, User> logPass = new HashMap<>();
        logPass.put("admin", new User("admin", "123"));


      /*  dao = new AtomicReference<>(new UserDAO());

        dao.get().add(new User(1, "Pavel", "1", ADMIN));
        dao.get().add(new User(2, "Egor", "1", USER));*/

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("logPass", logPass);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Object logPass = null;
    }
}
