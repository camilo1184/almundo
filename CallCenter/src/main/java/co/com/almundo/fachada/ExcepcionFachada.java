/*
 * +-----------------------------------------------------------------+
 * | Camilo Munoz                           Copyright (c) 2018-2020  |
 * +-----------------------------------------------------------------+
 * | Proyecto                                                        |
 * +-----------------------------------------------------------------+
 */
package co.com.almundo.fachada;

import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author Camilo Munoz
 */
@Stateless
public class ExcepcionFachada {
    
    @Inject
    Logger logger;
    
    public void almacenarError(String clase, Exception e) {
        //LLAMAR UN DAO QUE REALIZAR LAS OPERACIONES SOBRE LA TABLA ERROR EN LA BASE DE DATROS
        logger.info("Inserto el error en la base de datos");
    }
    
}
