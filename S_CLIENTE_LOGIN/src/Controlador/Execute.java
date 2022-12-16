/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Modelo_Persona;
import Vista.Vista_acceso;
import f_log.FuncionesLogin;
import f_log.FuncionesLogin_Service;

/**
 *
 * @author Usuario
 */
public class Execute {
    public static void main(String[] args) {
        
        //PRUEBA DE CONEXION AL SERVIDOR
//        FuncionesLogin_Service servicio = new FuncionesLogin_Service();
//        FuncionesLogin cliente = servicio.getFuncionesLoginPort();
//        System.out.println(cliente.login("Maria"));
        
        //CREAREMOS LA VISTA Y EL MODELO QUE VAN  A SER INTEGRADOS EN EL 
        //CONSTRUCTOR
        Vista_acceso vista = new Vista_acceso();
        Modelo_Persona modelo = new Modelo_Persona();
        
        Control_Persona control= new Control_Persona(modelo, vista);
        control.Inicio_Control();
//          String valor1="";
//          String nombres = "Carlos Aguirre";
//          nombres.split(valor1);
//        System.out.println(valor1);
        
    }
    
}
