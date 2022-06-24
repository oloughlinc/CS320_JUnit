/**
 * @author Craig O'Loughlin
 * @version 1.0
 * @since 06/12/2022
 */

package ContactService;

import java.util.ArrayList;

/**
 * Service for storing multiple contacts using Contact objects.
 * @author Craig O'Loughlin
 * @version 05/22/2022
 *
 */
public class ContactService {

	// backed by a private ArrayList
    private ArrayList<Contact> contacts;

    ContactService() {
        contacts = new ArrayList<Contact>();
    }

    /**
     * Get the contact stored by reference ID number.
     * @param ID unique identification string.
     * @return Contact object if found or null.
     */
    public Contact getContactByID(String ID) {
    	// search each in list and return if equals id
    	for (var contact : contacts) {
            if (contact.getID().equals(ID)) {
                return contact;
            }
        }
        return null;
    }
    
    // return true if this ID has an assoc. object
    private Boolean IDExistsInContacts(String ID) {
        for (var contact : contacts) {
            if (contact.getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add a new contact. 
     * @param ID			Unique string (10 chars or less)
     * @param firstName		Contact first name (10 chars or less)
     * @param lastName		Contact last name (10 chars or less)
     * @param phone			Contact phone number (must be exactly 10 chars)
     * @param address		Contact address (30 chars or less)
     * @return true if successful else false
     */
    public Boolean addContact(String ID, String firstName, String lastName, String phone, String address) {

    	// check for unique ID
        if (IDExistsInContacts(ID)) {
            System.out.println("Contact ID: " + ID + " already exists.");
            return false;
        }
        
        // add contact. catch error if a field is invalid.
        try {
            contacts.add(new Contact(ID, firstName, lastName, phone, address));
            System.out.println("Contact ID: " + ID + " added.");
            return true;
        } catch (RuntimeException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * Delete the contact associated with this ID from memory.
     * @param ID Unique identification string.
     * @return true if an object was deleted else false.
     */
    public Boolean deleteContactbyID(String ID) {

    	// search each and remove from list if ID matches
        for (var contact : contacts) {
            if (contact.getID().equals(ID)) {
                contacts.remove(contact);
                System.out.println("Contact ID: " + ID + " removed.");
                return true;
            }
        }
        System.out.println("Contact ID: " + ID + " not found.");
        return false;
    }

    /**
     * Update field(s) of an existing contact by ID. Pass null for any parameter that you do not wish to update.
     * @param ID			Unique identification string
     * @param firstName		Contact first name (10 chars or less)
     * @param lastName		Contact last name (10 chars or less)
     * @param phone			Contact phone number (must be exactly 10 chars)
     * @param address		Contact address (30 chars or less)
     * @return true if update was successful else false.
     */
    public Boolean updateByID(String ID, String firstName, String lastName, String phone, String address) {

    	// find the contact by ID
        for (var contact : contacts) {
            if (contact.getID().equals(ID)) {

            	// update each field where a string was passed
                try {
                    if (firstName != null) contact.setFirstName(firstName);
                    if (lastName != null)  contact.setLastName(lastName);
                    if (phone != null)     contact.setPhone(phone);
                    if (address != null)   contact.setAddress(address);
                    return true;

                } catch (RuntimeException e) {
                    System.out.println(e.toString());
                    return false;
                }
            }
        }
        System.out.println("Contact ID: " + ID + " not found.");
        return false;
        
    }
}
