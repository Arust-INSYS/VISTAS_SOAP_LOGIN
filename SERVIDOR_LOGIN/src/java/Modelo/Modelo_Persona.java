/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Modelo_Persona extends Persona {

    static ArrayList<Persona> lista_persona = new ArrayList<Persona>();

    Scanner sc = new Scanner(System.in);
    String nombre;
    String clave;
    String usuario;

    //Constructores
    public Modelo_Persona() {
    }

    public Modelo_Persona(String usuario, String clave) {
        super(usuario, clave);
    }

    //DATOS QUEMADOS
    //Datos();
    //ALAMACENAMIENTO DE ARRAY DE OBJETOS
    public void Ingreso_datos() {
        for (int i = 0; i < 3; i++) {
            Persona persona = new Persona();
            //Ingrese el nombre
            if (i == 0) {
                System.out.println("Ingrese el usuario:");
            } else {
                System.out.println("Ingrese otro usuario:");
            }

            nombre = sc.nextLine();
            persona.setUsuario(nombre);
            lista_persona.add(persona);

        }
    }

    //LISTAR LOS REGISTROS DEL ARRAY LIST
    /*Listar();
        //BÚSQUEDA DEL USUSARIO
        System.out.println("Escriba el usuario que desea consultar:");
        usuario = sc.nextLine();
        Listar_Param( usuario);
                
     */
    public void Listar() {
        for (int i = 0; i < lista_persona.size(); i++) {
            System.out.println("Usuario: " + lista_persona.get(i).getUsuario());
        }

    }

    public String Listar_Param(String usuario) {
        String valor="";
        boolean bandera = false;
        for (int i = 0; i < lista_persona.size(); i++) {
            if (lista_persona.get(i).getUsuario().equals(usuario)) {
                valor=lista_persona.get(i).getUsuario();
                System.out.println("Usuario: " + lista_persona.get(i).getUsuario());
                bandera = true;
            }

        }
        if (bandera == false) {
            System.out.println("El usuario no existe, o ha ingresado mal los datos!");
        }

    return valor;}

    //METODO DE DATOS QUEMADOS
    public void Datos() {
        Persona persona1 = new Persona();
        persona1.setUsuario("Ariel");
        Persona persona2 = new Persona();
        persona2.setUsuario("Carlos");
        Persona persona3 = new Persona();
        persona3.setUsuario("Pedro");
        Persona persona4 = new Persona();
        persona4.setUsuario("Juan");
        Persona persona5 = new Persona();
        persona5.setUsuario("John");
        Persona persona6 = new Persona();
        persona6.setUsuario("Mady");

        lista_persona.add(0, persona1);
        lista_persona.add(1, persona2);
        lista_persona.add(2, persona3);
        lista_persona.add(3, persona4);
        lista_persona.add(4, persona5);
        lista_persona.add(5, persona6);
    }
}
