/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo_Persona;
import Vista.*;
import f_log.FuncionesLogin;
import f_log.FuncionesLogin_Service;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Control_Persona {

    Modelo_Persona modelo;
    Vista_acceso vista;
    Vista_cuenta vista_cuenta = new Vista_cuenta();
    Vista_registro vista_registro = new Vista_registro();
    //AFUNCIONES SOAP
    FuncionesLogin_Service servicio = new FuncionesLogin_Service();
    FuncionesLogin cliente = servicio.getFuncionesLoginPort();

    public Control_Persona(Modelo_Persona modelo, Vista_acceso vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void Inicio_Control() {
        //Dar nombre a la interfaz principal
        vista.setName("Principal");
        //CARGAR METODO DE DATOS QUEMADOS
        modelo.Datos();

        //BOTON INGRESAR
        vista.getBtn_ingresar().addActionListener(l -> Ingresar());
        //Boton registrar 
        vista.getBtn_registra().addActionListener(l->Registrar());
        
        //-----------------------
        //VISTA REGISTRO
        vista_registro.getBtn_registrar().addActionListener(l->Insertar_datos());
        
        //-----------------------
        //VISTA CUENTA
        vista_cuenta.getBtn_aceptar().addActionListener(l->Transaccion());
    }

    //Metodo de iniciar sesión
    public void Ingresar() {
        if (Listar_Datos() == true) {
            vista_cuenta.setVisible(true);
        }
        vista.setVisible(false);

        //Se ejecuta al pulsar el botón ingresar
    }
    //VISTA REGISTRAR
    public void Registrar(){
        vista_registro.setVisible(true);
        
    }
    public void Insertar_datos(){
        double saldo;
        saldo=Double.parseDouble(vista_registro.getTxt_saldo().getText());
        modelo.Ingreso_datos(vista_registro.getTxt_user().getText(),
                vista_registro.getTxt_clave().getText(),saldo);
        modelo.Listar();
        vista_registro.setVisible(false);
    }

    
    public boolean Listar_Datos() {
        
        boolean bandera = false;
        boolean consulta;
        String usuario;
        String clave;
        double saldo;
        
        usuario = vista.getTxt_user().getText();
        clave = vista.getTxt_password().getText();
        
        //MOSTRAR NOMBRE
        
        
        System.out.println("HOLAAA SOY LA VENTANA PRINCIPAL"+vista.getName());
        System.out.println("HOLAAA SOY LA VENTANA REGISTRO"+vista_registro.getName());
        System.out.println("HOLAAA SOY LA VENTANA ACCESO: "+vista_cuenta.getName());
        
        consulta = modelo.Listar_Param(usuario,clave);
        //Cargamos el saldo y almacenamos en una variable
        saldo = modelo.Listar_saldo(usuario,clave);
        //consulta = cliente.login(usuario);
        
        if (consulta==false) {
            JOptionPane.showMessageDialog(null, "Usuario"
                    + " o Contraseña incorrectos!");

        } else {
            vista_cuenta.getLbl_usuario().setText(usuario);
            vista_cuenta.getLbl_saldo().setText(String.valueOf(saldo));
            
            bandera = true;
        }

        return bandera;
    }
    public void Transaccion(){
        //vista_cuenta.getRbtn_deposito().addActionListener(l->retiro_deposito(1));
        //vista_cuenta.getRbtn_retiro().addActionListener(l->retiro_deposito(2));
        if(vista_cuenta.getRbtn_deposito().isSelected()){
            retiro_deposito(1);
        }
        if(vista_cuenta.getRbtn_retiro().isSelected()){
            retiro_deposito(2);
        }
    }
    
    public void retiro_deposito(int num){
        double saldo;
        double total;
        double resultado;
        double valor_final;
        if(num==1){
            saldo=Double.parseDouble(vista_cuenta.getLbl_saldo().getText());
            total = Double.parseDouble(vista_cuenta.getTxt_valor().getText());
            resultado= saldo+total;
            valor_final=Actualizar_saldo(resultado);
            System.out.println("SU SALDO ACTUAL ES:"+valor_final);
            
        }else{
            saldo=Double.parseDouble(vista_cuenta.getLbl_saldo().getText());
            total = Double.parseDouble(vista_cuenta.getTxt_valor().getText());
            resultado= saldo-total;
            System.out.println("SU SALDO ACTUAL ES:"+resultado);
        }
        
    }
    public double Actualizar_saldo(double saldo){
        String usuario;
        String clave;
        usuario= vista_cuenta.getLbl_usuario().getText();
        clave= JOptionPane.showInputDialog("Ingrese la clave");
        
        //Actualizamos el saldo
        modelo.Actualizar_datos(usuario, clave, saldo);
    return saldo;}
    
    

}
