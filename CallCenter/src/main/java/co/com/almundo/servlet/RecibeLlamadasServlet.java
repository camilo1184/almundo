/*
 * +-----------------------------------------------------------------+
 * | Camilo Munoz                           Copyright (c) 2018-2020  |
 * +-----------------------------------------------------------------+
 * | Proyecto                                                        |
 * +-----------------------------------------------------------------+
 */
package co.com.almundo.servlet;

import java.io.IOException;
import java.util.concurrent.Semaphore;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Camilo Munoz
 */
@WebServlet(name = "RecibellamadasServlet", urlPatterns = {"/recibeLlamadas"})
public class RecibeLlamadasServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Thread searcher;
    Semaphore available = new Semaphore(10);
   
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
            request.getRequestDispatcher("/llamadasDispatcher").forward(request, response);
    }

}
