import java.util.HashMap;
import java.util.Map;

public class ContactsManager {

    private Map<String, String> contacts;

    public ContactsManager() {

        contacts = new HashMap<>();
    }
    public boolean addContact(String name, String phoneNumber) {
        boolean added = false;
        if (name.isEmpty() || phoneNumber.isEmpty() ) {
            System.out.println("Invalid name or phone number. Please provide valid inputs.");
            return added;
        } else if (contacts.containsKey(name)) {
            System.out.println("Contact with the same name already exists. Please use a different name.");
            return added;
        } else {
            contacts.put(name, phoneNumber);
            added = true;
            System.out.println("Contact added: " + name + " - " + phoneNumber);
            return added;
        }
    }

    public boolean viewContacts() {
        boolean notEmpty;
        if (contacts.isEmpty()) {
            System.out.println("No contacts added yet.");
            notEmpty = false;
            return notEmpty;
        } else {
            System.out.println("Contacts:");
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            notEmpty = true;
            return notEmpty;
        }

    }

    public boolean deleteContact(String name) {
        boolean deleted;
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid name. Please provide a valid name.");
            deleted = false;
            return deleted;
        } else if (contacts.containsKey(name)) {
            String phoneNumber = contacts.remove(name);
            System.out.println("Contact removed: " + name + " - " + phoneNumber);
            deleted = true;
            return deleted;
        } else {
            System.out.println("Contact not found.");
            deleted = false;
            return deleted;
        }
    }

//    public void addContact(String name, String phoneNumber) {
//        contacts.put(name, phoneNumber);
//        System.out.println("Contact added: " + name + " - " + phoneNumber);
//    }
//
//    public void viewContacts() {
//        if (contacts.isEmpty()) {
//            System.out.println("No contacts added yet.");
//        } else {
//            System.out.println("Contacts:");
//            for (Map.Entry<String, String> entry : contacts.entrySet()) {
//                System.out.println(entry.getKey() + " - " + entry.getValue());
//            }
//        }
//    }
//
//    public void deleteContact(String name) {
//        if (contacts.containsKey(name)) {
//            String phoneNumber = contacts.remove(name);
//            System.out.println("Contact removed: " + name + " - " + phoneNumber);
//        } else {
//            System.out.println("Contact not found.");
//        }
//    }
}
