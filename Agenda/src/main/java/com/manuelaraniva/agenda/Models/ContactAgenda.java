/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manuelaraniva.agenda.Models;

/**
 *
 * @author Manuel Araniva
 */
public class ContactAgenda {
    //Array attribute to store elements of type contact
    private Contact[] contacts;
    
    //Attribute to count the number of contacts
    private int contactsQuantity;

    //Constructor of the ContactAgenda class
    public ContactAgenda() {
        //Definition of the maximum size of the contacts array
        contacts = new Contact[10];        
        //Initial quantity of the contact agenda
        contactsQuantity = 0;
    }
    
    public void addContact(Contact contact)
    {
        if(contactsQuantity < 10){
            if(contact != null){
                if(checkContactExistence(contact.getContactName())){
                    System.out.println("AVISO: El nombre de contacto ya existe");
                    contacts[contactsQuantity] = contact;
                    contactsQuantity++;
                    System.out.println("Contacto agregado en la agenda");
                }else{
                    contacts[contactsQuantity] = contact;
                    contactsQuantity++;
                    System.out.println("Contacto agregado en la agenda");                    
                    
                }
            }else{
                System.out.println("No se ha recibido información, verificar");
            }
        }else{
            System.out.println("La agenda ya alcanzó su capacidad máxima (10 contactos)");
        }
    }
    
    public boolean checkContactExistence(String name)
    {
        for(int i = 0; i<contactsQuantity; i++)
        {
            if(contacts[i].getContactName().equalsIgnoreCase(name)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    
  
}
