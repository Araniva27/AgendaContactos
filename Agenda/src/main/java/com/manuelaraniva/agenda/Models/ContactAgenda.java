/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manuelaraniva.agenda.Models;

import java.util.Scanner;

/**
 *
 * @author Manuel Araniva
 */
public class ContactAgenda {

    //Array attribute to store elements of type contact
    private Contact[] contacts;
    //Array attribute to store searched contacts
    private Contact[] searchedContact;
    //Attribute to count the number of contacts
    private int contactsQuantity;

    //Constructor of the ContactAgenda class
    public ContactAgenda() {
        //Definition of the maximum size of the contacts array
        contacts = new Contact[10];
        //Definition of the maximun size of the searched contacts
        searchedContact = new Contact[10];
        //Initial quantity of the contact agenda
        contactsQuantity = 0;
    }

    /**
     * Adds a new contact to the phonebook
     *
     * @param contact The contact to add
     */
    public void addContact(Contact contact) {
        //Checks if the number of contacts is less than 10
        if (contactsQuantity < 10) {
            if (contact != null) {
                //Checks if the contact's name already exists in the agenda
                if (checkContactExistence(contact.getContactName())) {
                    System.out.println("AVISO: El nombre de contacto ya existe");
                    //Adds the contact to the phonebook
                    contacts[contactsQuantity] = contact;
                    //Increasing the contactQuantity counter by 1
                    contactsQuantity++;
                    System.out.println("Contacto agregado en la agenda");
                } else {
                    //Adds the contact to the phonebook
                    contacts[contactsQuantity] = contact;
                    //Increasing the contactQuantity counter by 1
                    contactsQuantity++;
                    System.out.println("Contacto agregado en la agenda");

                }
            } else {
                System.out.println("No se ha recibido información, verificar");
            }
        } else {
            System.out.println("La agenda ya alcanzó su capacidad máxima (10 contactos), no se puede registrar este contacto");
        }
    }

    /**
     * Checks if a contact with the given name already exists in the agenda
     *
     * @param name The name of the contact to check, the param is a string
     * @return True if a contact with the given name exists, otherwise false
     */
    public boolean checkContactExistence(String name) {
        //Iterates through the existing contacts in the agenda
        for (int i = 0; i < contactsQuantity; i++) {
            //Compares the name of each contact with the given name
            if (contacts[i].getContactName().equalsIgnoreCase(name)) {
                //Returns true if a contact with the given name is found
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for contacts whose names contain the given string in the agenda
     * Prints the details of found contacts
     *
     * @param name The string to search for in contact names
     */
    public void searchContact(String name) {
        // Checks if there are contacts in the agenda
        if (contactsQuantity > 0) {
            //Variable to define the position of the element in searchedContacts array 
            int arraySearchedPosition = 0;
            //Iterates through the existing contacts in the agenda
            for (int i = 0; i < contactsQuantity; i++) {
                // Checks if the name of the contact contains the given string
                if (contacts[i].getContactName().toLowerCase().contains(name.toLowerCase())) {
                    //Assignment of the element to the respective position of the searchedContacts array
                    searchedContact[arraySearchedPosition] = contacts[i];
                    //Increasing the contactQuantity counter by 1
                    arraySearchedPosition++;
                }
            }

            //Check if there are elements in the searchedContacts array
            if (arraySearchedPosition == 0) {
                System.out.println("No se encontraron contactos con el nombre '" + name + "'.");
            } else {
                //Prints the details of found contacts
                System.out.println("Contactos encontrados con el nombre '" + name + "':");
                System.out.println("              CONTACTOS ENCONTRADOS                ");
                for (int i = 0; i < arraySearchedPosition; i++) {
                    System.out.println("**************************************************************");
                    System.out.println("Nombre del contacto: " + searchedContact[i].getContactName());
                    System.out.println("Número telefónico del contacto: " + searchedContact[i].getContactNumber());
                    System.out.println("**************************************************************");
                }
                //Reset the searchedContact array for future searches
                searchedContact = new Contact[10];
            }
        } else {
            System.out.println("Aún no se han registrado contactos en la agenda ");
        }

    }

    /**
     * Updates the name and phone number of a contact in the agenda
     *
     * @param nameToUpdate The name of the contact to update
     * @param newName The new name to assign to the contact
     * @param newPhone The new phone number to assign to the contact
     */
    public void updateContact(String nameToUpdate, String newName, String newPhone) {
        //Iterates through the existing contacts in the phonebook
        for (int i = 0; i < contactsQuantity; i++) {
            //Checks if the name of the contact matches the name to update
            if (contacts[i].getContactName().equalsIgnoreCase(nameToUpdate)) {
                //Modifying the name of the contact in its respective position
                contacts[i].setContactName(newName);
                //Modifying the contact number of the contact in its respective position
                contacts[i].setContactNumber(newPhone);
                System.out.println("El Contacto ha sido modificado correctamente");
            }
        }
    }

    /**
     * Deletes a contact with the specified name from the agenda
     *
     * @param nameToDelete The name of the contact to delete
     */
    public void deleteContact(String nameToDelete) {
        //Iterates through the existing contacts in the agenda
        for (int i = 0; i < contactsQuantity; i++) {
            //Checks if the name of the contact matches the name to delete
            if (contacts[i].getContactName().equalsIgnoreCase(nameToDelete)) {
                //Moving one position back to the remaining contacts
                for (int j = i; j < contactsQuantity - 1; j++) {
                    //The position where the contact was delete will now contain the element one position ahead and so on
                    contacts[j] = contacts[j + 1];
                }
                //Reducing the contactsQuantity counter by one
                contactsQuantity--;
                System.out.println("Contacto eliminado correctamente");
                break;
            }
        }
    }

    /**
     * Displays all contacts stored in the agenda
     */
    public void showAllContacts() {
        //Checks if there are contacts in the agenda
        if (contactsQuantity > 0) {
            System.out.println("****************CONTACTOS****************");
            //Iterates through the existing contacts in the agenda            
            for (int i = 0; i < contactsQuantity; i++) {
                System.out.println("" + (i + 1) + "- Nombre: " + contacts[i].getContactName() + "  Número teléfonico: " + contacts[i].getContactNumber());
            }
            System.out.println("*****************************************");
        } else {
            System.out.println("No hay contactos en la agenda");
        }
    }

    /**
     * Deletes all contacts from the agenda after user confirmation
     */
    public void deleteAllContacts() {
        //Creates a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        //Asks the user for confirmation to delete all contacts
        System.out.println("¿Está seguro que desea vaciar todos los elementos?, se eliminarán todos los registros (si/no): ");
        String deleteValidation = scanner.nextLine();

        if (deleteValidation.toLowerCase().equalsIgnoreCase("si")) {
            //Deletes all contacts and resets contactsQuantity
            contacts = new Contact[10];
            contactsQuantity = 0;
            System.out.println("Se ha vaciado la lista de contactos");
        } else if (deleteValidation.toLowerCase().equalsIgnoreCase("no")) {
            System.out.println("No se eliminarán los contactos");
        }

    }

}
