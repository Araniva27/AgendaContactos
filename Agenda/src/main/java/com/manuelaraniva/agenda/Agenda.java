/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.manuelaraniva.agenda;

/**
 *
 * @author Manuel Araniva
 */
import com.manuelaraniva.agenda.Models.Contact;
import com.manuelaraniva.agenda.Models.ContactAgenda;
import java.util.Scanner;
public class Agenda {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int optionSelected;
        ContactAgenda agenda = new ContactAgenda();
        do{           
            System.out.println("\n");
            System.out.println("*******************************************");
            System.out.println("*             ¡BIENVENIDO!                *");
            System.out.println("*            AGENDA PERSONAL              *");
            System.out.println("*     Por favor selecciona una opción     *");
            System.out.println("*******************************************");
            System.out.println("*               MENÚ                      *");
            System.out.println("*******************************************");
            System.out.println("*        1-Agregar contacto nuevo         *");
            System.out.println("*        2-Buscar contacto por nombre     *");
            System.out.println("*        3-Modificar un contacto          *");
            System.out.println("*        4-Eliminar un contacto           *");
            System.out.println("*        5-Mostrar listado de contactos   *");
            System.out.println("*        6-Eliminar todos los contactos   *");
            System.out.println("*        7-Salir                          *");
            System.out.println("*******************************************");
            System.out.println("\n");
            System.out.print("Ingrese su selección: ");
            optionSelected = scanner.nextInt();
            scanner.nextLine();
            
            switch(optionSelected){
                case 1:
                    System.out.println("*******************************************");
                    System.out.println("*          Registro de contacto           *");
                    System.out.println("*******************************************");
                    System.out.println("\n");
                    String name;
                    String phoneNumber;
                    do {
                        System.out.print("Ingrese nombre del contacto: ");
                        name = scanner.nextLine();
                    } while (name.trim().isEmpty()); 

                    do {
                        System.out.print("Ingrese el teléfono del contacto: ");
                        phoneNumber = scanner.nextLine();
                    } while (phoneNumber.trim().isEmpty());
                    
                    Contact newContact = new Contact(name, phoneNumber);                                        
                    agenda.addContact(newContact);
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }while(optionSelected != 7);
        
    }
}
