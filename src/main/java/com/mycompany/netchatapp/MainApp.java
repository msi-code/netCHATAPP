package com.mycompany.netchatapp;

import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * MainApp.java - Entry point for the NetChatApp
 * Demonstrates Login (Part 1), Messaging (Part 2), and Arrays/Search/Delete/Report (Part 3)
 * Author: MANXIWA MSIMELELO
 */
public class MainApp {

    public static void main(String[] args) throws JSONException {
        Scanner input = new Scanner(System.in);
        MainApp login = new MainApp();

        // === REGISTRATION SECTION ===
        System.out.println("=== USER REGISTRATION ===");
        System.out.print("Enter a username: ");
        String username = input.nextLine();

        System.out.print("Enter a password: ");
        String password = input.nextLine();

        System.out.print("Enter your South African phone (+27...): ");
        String phone = input.nextLine();

        // Register user and display result
        String response = login.registerUser(username, password, phone);
        System.out.println(response);

        // === LOGIN SECTION ===
        System.out.println("\n=== USER LOGIN ===");
        System.out.print("Enter your username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter your password: ");
        String loginPassword = input.nextLine();

        boolean loggedIn = login.loginUser(loginUsername, loginPassword);
        System.out.println(login.returnLoginStatus(loggedIn));

        // === MESSAGING SECTION (Part 2 + Part 3) ===
        if (loggedIn) {
            System.out.println("\n=== MESSAGING ===");

            System.out.print("Enter recipient cell (+27...): ");
            String recipient = input.nextLine();

            System.out.print("Enter your message text: ");
            String messageText = input.nextLine();

            // Create new message object
            Message msg = new Message("MSG1234567", 1, recipient, messageText);

            // Validate recipient and message length
            System.out.println(msg.checkRecipient());
            System.out.println(msg.checkMessageLength());

            // Create hash
            String hash = msg.createMessageHash();
            System.out.println("Generated Hash: " + hash);

            // Ask user what to do with the message
            System.out.print("Do you want to [send/store/disregard]? ");
            String choice = input.nextLine();
            msg.sentMessage(choice);

            // Print message details
            System.out.println(msg.printMessages());

            // === PART 3 MENU ===
            boolean exit = false;
            while (!exit) {
                System.out.println("\n=== PART 3 MENU ===");
                System.out.println("1. Load stored messages (simulate JSON)");
                System.out.println("2. Search by Message ID");
                System.out.println("3. Search by Recipient");
                System.out.println("4. Delete by Hash");
                System.out.println("5. Display Report");
                System.out.println("6. Display Longest Message");
                System.out.println("7. Exit");

                System.out.print("Choose an option: ");
                int option = input.nextInt();
                input.nextLine(); // consume newline

                switch (option) {
                    case 1:
                        // Simulate loading stored messages from JSON
                        JSONArray arr = new JSONArray();
                        arr.put(msg.storeMessage());
                        Message.loadStoredMessages(arr);
                        System.out.println("Stored messages loaded.");
                        break;
                    case 2:
                        System.out.print("Enter Message ID to search: ");
                        String id = input.nextLine();
                        System.out.println(Message.searchByMessageID(id));
                        break;
                    case 3:
                        System.out.print("Enter Recipient to search: ");
                        String rec = input.nextLine();
                        System.out.println(Message.searchByRecipient(rec));
                        break;
                    case 4:
                        System.out.print("Enter Hash to delete: ");
                        String delHash = input.nextLine();
                        System.out.println(Message.deleteByHash(delHash));
                        break;
                    case 5:
                        Message.displayReport();
                        break;
                    case 6:
                        System.out.println(Message.displayLongestMessage());
                        break;
                    case 7:
                        exit = true;
                        System.out.println("Exiting Part 3 menu...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }

    private String registerUser(String username, String password, String phone) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean loginUser(String loginUsername, String loginPassword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean returnLoginStatus(boolean loggedIn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
