/*
 * +-----------------------------------------------------------------+
 * | Camilo Munoz                           Copyright (c) 2018-2020  |
 * +-----------------------------------------------------------------+
 * | Proyecto                                                        |
 * +-----------------------------------------------------------------+
 */
package co.com.almundo.servlet;

import co.com.almundo.fachada.LlamadasFachada;
import co.com.almundo.entidades.Llamada;
import co.com.almundo.enumeracion.Estados;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;

/**
 *
 * @author Camilo Munoz
 */
@WebServlet(name = "LlamadasDispatcher", urlPatterns = {"/llamadasDispatcher"})
public class LlamadasDispatcher extends HttpServlet {

    @Inject
    private LlamadasFachada llamadaFachada;

    @Inject
    Logger logger;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dispatchCall();
    }

    /**
     * Invoca el proceso para la asignación de la llamada a un empleado
     */
    private void dispatchCall() {
        new Thread(limitedCall).start();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    Runnable limitedCall = new Runnable() {
        final Random rand = new Random();
        final Semaphore available = new Semaphore(10);
        int count = 0;

        int Max = (10) + 1;
        int Min = 5;

        public void run() {
            //Duerme el hilo simulando la llamada de 5 a 10 segundos
            int tiempoLLamada = ((int) (Math.random() * (Max - Min)) + Min);
            int num = count++;

            try {
                available.acquire();

                logger.info("Duración de la llamada {} segundos ", tiempoLLamada);
                llamadaFachada.asignarLlamada(new Llamada(new Date(), Estados.EN_ESPERA.getId()));
                Thread.sleep(tiempoLLamada * 1000);

                logger.info("Hilo Finalizado # {} ! ", num);

                available.release();
            } catch (InterruptedException intEx) {
                intEx.printStackTrace();
            }
        }
    };

}
