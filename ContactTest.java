/**
 * @author Craig O'Loughlin
 * @version 1.0
 * @since 06/12/2022
 */

package ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

class ContactTest {

	@Test
	void testContactConstructor() {
		var contact = new Contact("100", "Jim", "Bob", "5554443333", "10 Main Street");
		assertTrue(contact.getID().equals("100"));
		assertTrue(contact.getFirstName().equals("Jim"));
		assertTrue(contact.getLastName().equals("Bob"));
		assertTrue(contact.getPhone().equals("5554443333"));
		assertTrue(contact.getAddress().equals("10 Main Street"));
	}
	
	@Nested
	class ContactTestID {
		
		@Test
		void testContactIDTooLong() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Contact("TOOMANYCHARS", "Jim", "Bob", "5554443333", "10 Main Street");
			});
		}
		
		@Test
		void testContactIDIsNull() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Contact(null, "Jim", "Bob", "5554443333", "10 Main Street");
			});
		}
	}
	
	@Nested
	class ContactTestFirstName {
		
		@Test
		void testContactFirstNameTooLong() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Contact("100", "TOOMANYCHARS", "Bob", "5554443333", "10 Main Street");
			});
		}
		
		@Test
		void testContactFirstNameIsNull() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Contact("100", null, "Bob", "5554443333", "10 Main Street");
			});
		}
	}
	
	@Nested
	class ContactTestLastName {
		
		@Test
		void testContactLastNameTooLong() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Contact("100", "Jim", "TOOMANYCHARS", "5554443333", "10 Main Street");
			});
		}
		
		@Test
		void testContactLastNameIsNull() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Contact("100", "Jim", null, "5554443333", "10 Main Street");
			});
		}
	}
	
	@Nested
	class ContactTestPhone {
		
		@Test
		void testContactPhoneTooLong() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Contact("100", "Jim", "Bob", "TOOMANYCHARS", "10 Main Street");
			});
		}
		
		@Test
		void testContactPhoneTooShort() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Contact("100", "Jim", "Bob", "FEWCHARS", "10 Main Street");
			});
		}
		
		@Test
		void testContactPhoneIsNull() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Contact("100", "Jim", "Bob", null, "10 Main Street");
			});
		}
	}
	
	@Nested
	class ContactTestAddress {
		
		@Test
		void testContactAddressTooLong() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Contact("100", "Jim", "Bob", "5554443333", "WAYYYYYYYYYYTOOOOOOMANNNNYYYCHARRRRSSSSSSSSSSSSSSSSSSSSSSSSS");
			});
		}
		
		@Test
		void testContactAddressIsNull() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Contact("100", "Jim", "Bob", "5554443333", null);
			});
		}	
	}
}
