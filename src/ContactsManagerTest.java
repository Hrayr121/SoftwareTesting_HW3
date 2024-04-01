import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactsManagerTest {

    @Test
    public void addingWithEmptyNameShouldReturnFalse(){
        var contactsManager = new ContactsManager();
        assertFalse(contactsManager.addContact("", "091000000"));
    }

    @Test
    public void addingWithEmptyPhoneNumberShouldReturnFalse(){
        var contactsManager = new ContactsManager();
        assertFalse(contactsManager.addContact("Jim ", ""));
    }

    @Test
    public void addingWith2EmptyParametersShouldReturnFalse(){
        var contactsManager = new ContactsManager();
        assertFalse(contactsManager.addContact("", ""));
    }
    @Test
    public void addingWithValidParameters(){
        var contactsManager = new ContactsManager();
        assertTrue(contactsManager.addContact("Jim ", "091063609"));
    }
    @Test
    public void addingDuplicateContactsShouldReturnFalse(){  //checks with the name as the key
        var contactsManager = new ContactsManager();
        contactsManager.addContact("Jim", "099999999");
        assertFalse(contactsManager.addContact("Jim", "099999999"));
    }

    @Test
    public void viewingWhenWeHaveNoContactsShouldReturnFalse(){
        var contactsManager = new ContactsManager();
        assertFalse(contactsManager.viewContacts());
    }
    @Test
    public void viewingWhenWeHaveSomeContactsShouldReturnTrue(){
        var contactsManager = new ContactsManager();
        contactsManager.addContact("Harrison", "000000");
        assertTrue(contactsManager.viewContacts());
    }
    @Test
    public void deletingContactByPassingNullShouldReturnFalse(){
        var contactsManager = new ContactsManager();
        assertFalse(contactsManager.deleteContact(null));
    }
    @Test
    public void deletingContactByPassingEmptyNameShouldReturnFalse(){
        var contactsManager = new ContactsManager();
        assertFalse(contactsManager.deleteContact(""));
    }
    @Test
    public void deletingContactWhichExistsShouldReturnTrue(){
        var contactsManager = new ContactsManager();
        contactsManager.addContact("Harrison", "000000");
        assertTrue(contactsManager.deleteContact("Harrison"));
    }

    @Test
    public void deletingContactWhichDoesNotExistsShouldReturnFalse(){
        var contactsManager = new ContactsManager();
        contactsManager.addContact("Harrison", "000000");
        assertFalse(contactsManager.deleteContact("Harr"));
    }
}