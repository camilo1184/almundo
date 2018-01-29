/*
 * +-----------------------------------------------------------------+
 * | Camilo Munoz                           Copyright (c) 2018-2020  |
 * +-----------------------------------------------------------------+
 * | Proyecto                                                        |
 * +-----------------------------------------------------------------+
 */
package co.com.almundo.entidades;

import java.util.Date;

/**
 *
 * @author camilo Munoz
 */
public class Llamada {
    
    private int idLlamada; //Lo asignaria automaticamente cuando persista la información
    private Date fechaLlamada;
    private String estado;
    private Empleado operador;
    

    public Llamada(Date fechaLlamada, String estado) {
        this.fechaLlamada = fechaLlamada;
        this.estado = estado;
    }

    public int getIdLlamada() {
        return idLlamada;
    }

    public void setIdLlamada(int idLlamada) {
        this.idLlamada = idLlamada;
    }

    public Date getFechaLlamada() {
        return fechaLlamada;
    }

    public void setFechaLlamada(Date fechaLlamada) {
        this.fechaLlamada = fechaLlamada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleado getOperador() {
        return operador;
    }

    public void setOperador(Empleado operador) {
        this.operador = operador;
    }
    
}
