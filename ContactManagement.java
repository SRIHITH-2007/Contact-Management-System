import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class ContactManagement {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1: addContact(); break;
                case 2: viewContacts(); break;
                case 3: editContact(); break;
                case 4: deleteContact(); break;
                case 5: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\n--- Contact List ---");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    static void editContact() {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter contact number to edit: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number!");
            return;
        }

        System.out.print("New name: ");
        String name = sc.nextLine();

        System.out.print("New phone: ");
        String phone = sc.nextLine();

        System.out.print("New email: ");
        String email = sc.nextLine();

        contacts.set(index, new Contact(name, phone, email));
        System.out.println("Contact updated successfully!");
    }

    static void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter contact number to delete: ");
        int index = sc.nextInt() - 1;

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number!");
            return;
        }

        contacts.remove(index);
        System.out.println("Contact deleted successfully!");
    }
}

