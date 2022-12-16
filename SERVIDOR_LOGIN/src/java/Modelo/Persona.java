/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Persona {
    private String usuario;
    private String clave;

    public Persona() {
    }

    public Persona(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Persona{" + "usuario=" + usuario + ", clave=" + clave + '}';
    }
    
    
    
}
