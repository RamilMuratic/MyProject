package ru.myapp.listener;

import ru.myapp.ServletHelper;
import ru.myapp.clothes.ClothesService;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(">>>> ContextListener is working!");

      ServletContext sc =  sce.getServletContext();

      ClothesService ps = new ClothesService();

      sc.setAttribute(ServletHelper.SC_ATTRIBUTE_CLOTHES_SERVICE, ps);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
