/**
 * @author Craig O'Loughlin
 * @version 1.0
 * @since 06/12/2022
 */

package ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

class ContactServiceTest {
	
	Boolean verifyContact(String id, String fName, String lName, String phone, String address) {
		return contactService.getContactByID(id).getFirstName().equals(fName) &&
			   contactService.getContactByID(id).getLastName().equals(lName) &&
			   contactService.getContactByID(id).getPhone().equals(phone) &&
			   contactService.getContactByID(id).getAddress().equals(address);
	}
	
	ContactService contactService;
	@BeforeEach
	void resetContactService()  {
		contactService = new ContactService();
	}
	
	@Nested
	class ContactServiceTestAdd {
		
		@Test
		void testContactServiceAdd() {
			contactService.addContact("100", "Jim", "Bob", "5554443333", "10 Main Street");
			contactService.addContact("101", "Yolanda", "Lopez", "5551112222", "11 Main Street");
			contactService.addContact("102", "Mary", "Sue", "5552224444", "12 Main Street");
			assertFalse(contactService.getContactByID("100") == null);
			assertFalse(contactService.getContactByID("101") == null);
			assertFalse(contactService.getContactByID("102") == null);
			assertTrue(verifyContact("100", "Jim", "Bob", "5554443333", "10 Main Street"));
			assertTrue(verifyContact("101", "Yolanda", "Lopez", "5551112222", "11 Main Street"));
			assertTrue(verifyContact("102", "Mary", "Sue", "5552224444", "12 Main Street"));
		}
		
		@Test
		void testContactServiceAddMustBeUniqueID() {
			contactService.addContact("100", "Jim", "Bob", "5554443333", "10 Main Street");
			assertFalse(contactService.addContact("100", "Jim2", "Bob2", "5554443332", "10 Main Street2"));
		}
		
		@Test
		void testContactServiceAddInvalidContact() {
			assertFalse(contactService.addContact("TOOMANYCHARS", "Jim", "Bob", "5554443333", "10 Main Street"));
		}
	}
	
	@Nested
	class ContactServiceTestDelete {
		
		@Test
		void testContactServiceDelete() {
			contactService.addContact("100", "Jim", "Bob", "5554443333", "10 Main Street");
			contactService.deleteContactbyID("100");
			assertTrue(contactService.getContactByID("100") == null);
		}
		
		@Test
		void testContactServiceDeleteIDNotExist() {
			assertFalse(contactService.deleteContactbyID("100"));
		}
	}
	
	@Nested
	class ContactServiceTestUpdate {
		
		@Test 
		void testContactServiceUpdate() {
			contactService.addContact("100", "Jim", "Bob", "5554443333", "10 Main Street");
			contactService.updateByID("100", "Yolanda" , "Lopez", "5551112222", "11 Main Street");
			assertTrue(verifyContact("100", "Yolanda" , "Lopez", "5551112222", "11 Main Street"));
		}
		
		@Test
		void testContactServiceUpdateIDNotExist() {
			assertFalse(contactService.updateByID("IDONTEXIST", null, null, null, null));
		}
		
		@Test
		void testContactServiceUpdateNull() {
			contactService.addContact("100", "Jim", "Bob", "5554443333", "10 Main Street");
			contactService.updateByID("100", null, null, null, null);
			assertTrue(verifyContact("100", "Jim", "Bob", "5554443333", "10 Main Street"));		
		}
		
		@Test
		void testContactServiceUpdateInvalidParameter() {
			contactService.addContact("100", "Jim", "Bob", "5554443333", "10 Main Street");
			assertFalse(contactService.updateByID("100", "TOOMANYCHARS", "Bob", "5554443333", "10 Main Street"));
		}
	}
}
