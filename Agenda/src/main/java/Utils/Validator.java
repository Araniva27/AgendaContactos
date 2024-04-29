/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.regex.Pattern;

/**
 *
 * @author Manuel Araniva
 */
/**
 * This class provide methods to validate contact information 
 */
public class Validator {
    
    /**
     * Validates if the provided contact name and contact phone are not empty.
     *
     * @param contactName The name of the contact.
     * @param contactPhone The phone number of the contact.
     * @return true if both contactName and contactPhone are not empty; otherwise, false.
     */
    public boolean validateEmptyData(String contactName, String contactPhone)
    {
        if(!contactName.isEmpty() && !contactPhone.isEmpty()){
            return true;
        }
        System.out.println("El nombre y el número de teléfono no pueden ser nulos");
        return false;
    }
    
    /**
     * Validates the format of the provided contact phone number.
     *
     * @param contactPhone The phone number of the contact.
     * @return true if the contactPhone has the format "####-####"; otherwise, false.
     */
    public boolean validatePhoneFormat(String contactPhone)
    {
        String regex = "^[0-9]{4}-[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        if(pattern.matcher(contactPhone).matches()){
            return true;
        }
        System.out.println("Formato de telefono incorrecto");
        return false;
    }        
        
}
