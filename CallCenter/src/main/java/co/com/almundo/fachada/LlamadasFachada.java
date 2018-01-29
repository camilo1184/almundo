/*
 * +-----------------------------------------------------------------+
 * | Camilo Munoz                           Copyright (c) 2018-2020  |
 * +-----------------------------------------------------------------+
 * | Proyecto                                                        |
 * +-----------------------------------------------------------------+
 */
package co.com.almundo.fachada;

import co.com.almundo.dao.LlamadaDAO;
import co.com.almundo.entidades.Empleado;
import co.com.almundo.entidades.Llamada;
import co.com.almundo.enumeracion.Estados;
import co.com.almundo.exepcion.GeneralExcepcion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author Camilo Munoz
 */
@Singleton
public class LlamadasFachada {

    @Inject
    Logger logger;
    
    @Inject 
    LlamadaDAO llamadaDAO;

    private List operadorLista;
    private List supervisorLista;
    private List directorLista;

    public void asignarLlamada(Llamada llamada) {

        try {
            getListaEmpleados();
            Empleado operadorTurno = null;

            for (Object operador : operadorLista) {
                operadorTurno = (Empleado) operador;
            }

            if (operadorTurno != null) {
                for (Object operador : supervisorLista) {
                    operadorTurno = (Empleado) operador;
                }

                if (operadorTurno != null) {
                    for (Object operador : directorLista) {
                        operadorTurno = (Empleado) operador;
                    }
                }
            }

            //TODO: Si todos estan ocupados que haria
            if (operadorTurno != null) {
                //que hace con la llamada
                llamada.setEstado(Estados.NO_ASIGNADA.getId());
                logger.debug("Llamada NO asignada a un operador");
            } else {
                llamada.setOperador(operadorTurno);
                llamada.setEstado(Estados.ASIGNADA.getId());
                asignarLLamadaEmpleado(llamada);
                logger.debug("Asignada llamada a un operador");
            }
        } catch (GeneralExcepcion ex) {
            logger.error("Se presento un error en la clase {} ", ex.getMessage());
            ex.almacenarError(LlamadasFachada.class.toString(), ex);
        }

    }

    /**
     * Recuperar la lista de los empleados disponibles, con algun mecanismo de
     * cache
     */
    private void getListaEmpleados() {
        operadorLista = new ArrayList<>();
        supervisorLista = new ArrayList<>();
        directorLista = new ArrayList<>();
    }

    private void asignarLLamadaEmpleado(Llamada llamada) throws GeneralExcepcion {
        //Asiga la llamada y luego actualiza las listas de disponibilidad
        
        //Se deberia persistir la informción de la llamada
        llamadaDAO.asignaLlamada(llamada);
    }
}
