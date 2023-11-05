import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task3 {

    private Map<String, Contact> contacts;
    private Scanner scanner;

    public task3() {
        contacts = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\nContact Manager");
            System.out.println("1. Add new contact");
            System.out.println("2. View contact list");
            System.out.println("3. Edit contact");
            System.out.println("4. Delete contact");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline not consumed by nextInt()

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter contact email address: ");
        String emailAddress = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber, emailAddress);
        contacts.put(name, newContact);
        System.out.println("Contact added successfully.");
    }

    private void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to display.");
            return;
        }

        System.out.println("\nContact List:");
        for (Contact contact : contacts.values()) {
            System.out.println(contact);
        }
    }

    private void editContact() {
        System.out.print("Enter the name of the contact you want to edit: ");
        String name = scanner.nextLine();

        Contact contact = contacts.get(name);
        if (contact == null) {
            System.out.println("No contact found with that name. Please try again.");
            return;
        }

        System.out.println("\nCurrent contact details:");
        System.out.println(contact);

        System.out.println("\nEnter new contact details:");
        System.out.print("Enter contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter contact phone number: ");
        String newPhoneNumber = scanner.nextLine();
        System.out.print("Enter contact email address: ");
        String newEmailAddress = scanner.nextLine();

        Contact updatedContact = new Contact(newName, newPhoneNumber, newEmailAddress);
        contacts.put(newName, updatedContact);
        if (!newName.equals(name)) {
            contacts.remove(name);
        }
        System.out.println("Contact updated successfully.");
    }

    private void deleteContact() {
        System.out.print("Enter the name of the contact you want to delete: ");
        String name = scanner.nextLine();

        Contact contact = contacts.get(name);
        if (contact == null) {
            System.out.println("No contact found with that name. Please try again.");
            return;
        }

        contacts.remove(name);
        System.out.println("Contact deleted successfully.");
    }

    public static void main(String[] args) {
        task3 manager = new task3();
        manager.run();
    }
}

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email Address: " + emailAddress;
    }
}