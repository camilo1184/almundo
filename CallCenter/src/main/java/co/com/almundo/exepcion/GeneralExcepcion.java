/*
 * +-----------------------------------------------------------------+
 * | Camilo Munoz                           Copyright (c) 2018-2020  |
 * +-----------------------------------------------------------------+
 * | Proyecto                                                        |
 * +-----------------------------------------------------------------+
 */
package co.com.almundo.exepcion;

import co.com.almundo.fachada.ExcepcionFachada;

/**
 *
 * @author Camilo Munoz
 */
public class GeneralExcepcion extends Exception {

    public GeneralExcepcion(String mensaje) {
        super(mensaje);
    }

    public GeneralExcepcion(String mensaje, Exception excepcion) {
        super(mensaje, excepcion);
    }
    
    /**
     * Almcenar un error en la base de datos
     * @param clase
     * @param e 
     */
    
    public void almacenarError(String clase, Exception e) {

        ExcepcionFachada fachada = new ExcepcionFachada();
        
        try {
            fachada.almacenarError(clase, e);
        } catch (Exception ex) {
            e.printStackTrace();
        }

    }
}
