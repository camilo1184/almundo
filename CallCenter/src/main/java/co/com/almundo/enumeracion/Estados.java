/*
 * +-----------------------------------------------------------------+
 * | Camilo Munoz                           Copyright (c) 2016-2020  |
 * +-----------------------------------------------------------------+
 * | Proyecto                                                        |
 * +-----------------------------------------------------------------+
 */
package co.com.almundo.enumeracion;

/**
 *
 * @author Camilo Munoz
 */
public enum Estados {

    EN_ESPERA("En_espera", "EE"),
    FINALIZADA("Finalizada", "FN"),
    NO_ASIGNADA("No_asignada", "NS"),
    ASIGNADA("Asignada", "AS");

    private final String descripcion;
    private final String id;

    Estados(String descripcion, String id) {
        this.descripcion = descripcion;
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getId() {
        return id;
    }
}
