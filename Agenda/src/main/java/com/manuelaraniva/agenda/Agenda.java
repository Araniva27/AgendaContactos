/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.manuelaraniva.agenda;

/**
 *
 * @author Manuel Araniva
 */
import Utils.Validator;
import com.manuelaraniva.agenda.Models.Contact;
import com.manuelaraniva.agenda.Models.ContactAgenda;
import java.util.Scanner;

public class Agenda {

    public static void main(String[] args) {
        
        
        Scanner scanner = new Scanner(System.in);
        int optionSelected; //Variable that defines the option selected by the user
        //Represents an instance of the ContactAgenda class, used for managing contacts
        ContactAgenda agenda = new ContactAgenda();
        Validator validator = new Validator();
       
        do {            
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
            System.out.println("*        6-Vaciar lista de contactos      *");
            System.out.println("*        7-Salir                          *");
            System.out.println("*******************************************");
            System.out.println("\n");
            System.out.print("Ingrese su selección: ");
            optionSelected = scanner.nextInt();
            scanner.nextLine();

            switch (optionSelected) {
                case 1: //This option is for adding a new contact in the agenda
                    System.out.println("*******************************************");
                    System.out.println("*          Registro de contacto           *");
                    System.out.println("*******************************************");
                    System.out.println("\n");
                    String name;
                    String phoneNumber;
                    boolean flagEmptyFields,flagPhoneNumber;
                    do {
                        System.out.print("Ingrese nombre del contacto: ");
                        name = scanner.nextLine();
                        System.out.print("Ingrese el teléfono del contacto: ");
                        phoneNumber = scanner.nextLine();
                        flagEmptyFields = validator.validateEmptyData(name, phoneNumber); //Validating that name and phoneNumber are not empty
                        flagPhoneNumber = validator.validatePhoneFormat(phoneNumber); //Validating phone format ####-####
                    } while (!flagEmptyFields || !flagPhoneNumber);  
                   

                    Contact newContact = new Contact(name, phoneNumber);
                    agenda.addContact(newContact);
                    System.out.println("Presiona una tecla para continuar...");
                    scanner.nextLine();
                break;
                case 2: //This option is for searching a specific contact in the agenda
                    System.out.println("*******************************************");
                    System.out.println("*          Búsqueda de contacto           *");
                    System.out.println("*******************************************");
                    System.out.println("\n");
                    String nameToSearch;
                    do {
                        System.out.print("Ingrese nombre del contacto a buscar: ");
                        nameToSearch = scanner.nextLine();
                    } while (nameToSearch.trim().isEmpty()); //Validating that name to search is not empty

                    agenda.searchContact(nameToSearch);
                    System.out.println("Presiona una tecla para continuar...");
                    scanner.nextLine();

                break;
                case 3: //This option is for updating the information of a specific contact 
                    System.out.println("*******************************************");
                    System.out.println("*          Modificación de contacto       *");
                    System.out.println("*******************************************");
                    System.out.println("\n");
                    String nameToUpdate;                                                          
                    System.out.print("Ingrese nombre del contacto a actualizar: ");
                    nameToUpdate = scanner.nextLine();                    
                    boolean flagEmptyFieldsUpdate,flagPhoneNumberUpdate;
                    String newName;
                    String newPhone;
                    if (agenda.checkContactExistence(nameToUpdate)) {                           
                        do {
                            System.out.print("Ingrese el nuevo nombre del contacto: ");
                            newName = scanner.nextLine();   
                            System.out.print("Ingrese el nuevo número telefónico del contacto: ");
                            newPhone = scanner.nextLine();
                            flagEmptyFieldsUpdate = validator.validateEmptyData(newName, newPhone);
                            flagPhoneNumberUpdate = validator.validatePhoneFormat(newPhone); //Validating phone format ####-####
                        } while (!flagEmptyFieldsUpdate || !flagPhoneNumberUpdate);
                                                
                        agenda.updateContact(nameToUpdate, newName, newPhone);
                        System.out.println("Presiona una tecla para continuar...");
                        scanner.nextLine();
                    } else {
                        System.out.print("No se ha encontrado contacto para modificar");     
                        System.out.println("Presiona una tecla para continuar...");
                        scanner.nextLine();
                    }
                break;
                case 4: //This option is for deleting a specific contact
                    System.out.println("*******************************************");
                    System.out.println("*          Eliminación de contacto        *");
                    System.out.println("*******************************************");
                    System.out.println("\n");
                    System.out.print("Ingrese el nombre de contacto que se desea eliminar: ");                      
                    String nameToDelete = scanner.nextLine();      
                    
                    if (agenda.checkContactExistence(nameToDelete)) {                        
                        agenda.deleteContact(nameToDelete);
                        System.out.println("Presiona una tecla para continuar...");
                        scanner.nextLine();
                    } else {
                        System.out.print("No se ha encontrado el contacto que se desea eliminar"); 
                        System.out.println("Presiona una tecla para continuar...");
                        scanner.nextLine();
                    }
                break;
                case 5: //This option is for showing all the contacts in the agenda
                    System.out.println("*******************************************");
                    System.out.println("*          Todos los contactos            *");
                    System.out.println("*******************************************");
                    agenda.showAllContacts();
                    System.out.println("Presiona una tecla para continuar...");
                    scanner.nextLine();
                break;
                case 6: //This option is for deleting all the contacts in the agenda
                    System.out.println("*******************************************");
                    System.out.println("*          Vaciar contactos               *");
                    System.out.println("*******************************************");
                    System.out.println("\n");
                    agenda.deleteAllContacts();
                    System.out.println("Presiona una tecla para continuar...");
                    scanner.nextLine();
                break;  
                case 7: //This
                    System.out.println("Adios, gracias por usar la agenda");
                break;
                default:
                    System.out.println("Ingrese una opción válida (1-7)");
                break;
            }
        } while (optionSelected != 7);

    }
}
