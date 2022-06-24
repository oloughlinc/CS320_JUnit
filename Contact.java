/**
 * @author Craig O'Loughlin
 * @version 1.0
 * @since 06/12/2022
 */

/**
 * Class for holding contact information referenced by ID in memory.
 * @author Craig O'Loughlin
 * @version 05/22/2022
 * 
 */

package ContactService;
class Contact  {

	// data storage fields
    private final String ID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    
    /**
     * All contact information is required upon creation of a new contact. 
     * @param ID			Unique string (10 chars or less)
     * @param firstName		Contact first name (10 chars or less)
     * @param lastName		Contact last name (10 chars or less)
     * @param phone			Contact phone number (must be exactly 10 chars)
     * @param address		Contact address (30 chars or less)
     * @throws IllegalArgumentException when fields are too long or not provided.
     */
    public Contact(String ID, String firstName, String lastName, String phone, String address) 
    throws IllegalArgumentException {

    	// check ID restrictions first
        if (ID == null) throw new IllegalArgumentException("ID field cannot be null.");
        if (ID.length() > 10) throw new IllegalArgumentException("ID field must be 10 characters or less.");
        this.ID = ID;

        // set the rest of the values
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }
    
    public void setFirstName(String firstName)
    throws IllegalArgumentException {

        if (firstName == null) throw new IllegalArgumentException("First name field cannot be null.");
        if (firstName.length() > 10) throw new IllegalArgumentException("First name field must be 10 characters or less.");
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    throws IllegalArgumentException {

        if (lastName == null) throw new IllegalArgumentException("Last name field cannot be null.");
        if (lastName.length() > 10) throw new IllegalArgumentException("Last name field must be 10 characters or less.");
        this.lastName = lastName;
    }

    public void setPhone(String phone)
    throws IllegalArgumentException {

        if (phone == null) throw new IllegalArgumentException("Phone field cannot be null.");
        if (phone.length() != 10) throw new IllegalArgumentException("Phone field must be exactly 10 characters.");
        this.phone = phone;
    }

    public void setAddress(String address)
    throws IllegalArgumentException {

        if (address == null) throw new IllegalArgumentException("Address field cannot be null.");
        if (address.length() > 30) throw new IllegalArgumentException("Address field must be 30 characters or less.");
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
