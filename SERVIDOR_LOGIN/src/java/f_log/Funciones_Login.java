/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package f_log;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Modelo.*;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "Funciones_Login")
public class Funciones_Login{
    Modelo_Persona modelo = new Modelo_Persona();
    

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "usuario") String usuario) {
        String valor="";
        modelo.Datos();
        valor=modelo.Listar_Param(usuario);
        
        return valor;
    }

    
}
