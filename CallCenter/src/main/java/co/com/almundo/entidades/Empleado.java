/*
 * +-----------------------------------------------------------------+
 * | Camilo Munoz                           Copyright (c) 2018-2020  |
 * +-----------------------------------------------------------------+
 * | Proyecto                                                        |
 * +-----------------------------------------------------------------+
 */
package co.com.almundo.entidades;

/**
 *
 * @author Camilo Munoz
 */
public class Empleado extends Persona{
       
    private Rol rol;        //Vamos a suponer que un empleado unicamente tiene un rol

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
}
