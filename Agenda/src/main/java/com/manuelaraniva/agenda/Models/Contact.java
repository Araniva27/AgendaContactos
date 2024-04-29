/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manuelaraniva.agenda.Models;

/**
 *
 * @author Manuel Araniva
 */

/**
 * Represents a contact in the agenda
 */
public class Contact {
    private String contactName; //The name of the contact
    private String contactNumber; //The phone number of the contact

    /**
     * Constructs a new contact with the given name and phone number
     * @param contactName The name of the contact
     * @param contactNumber The phone number of the contact
     */
    public Contact(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }
    
    /**
     * Retrieves the name of the contact
     * @return The name of the contact
     */
    public String getContactName() {
        return contactName;
    }
    
    /**
     * Sets the name of the contact
     * @param contactName The new name of the contact
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    
    /**
     * Retrieves the phone number of the contact
     * @return The phone number of the contact
     */
    public String getContactNumber() {
        return contactNumber;
    }
    
    /**
     * Sets the phone number of the contact
     * @param contactNumber The new phone number of the contact
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
