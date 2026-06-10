package com.mycompany.netchatapp;

import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;
import org.json.JSONException;

/**
 * Message.java - Handles message creation, validation, storage, and Part 3 features
 * Author: MANXIWA MSIMELELO
 */
public class Message {

    // === Fields: the data a message holds ===
    private String messageID;     // 10-digit auto-generated
    private int    messageNumber; // from loop counter
    private String recipient;     // validated cell number
    private String messageText;   // max 250 chars
    private String messageHash;   // auto-generated
    private String sendStatus;    // Sent, Stored, Disregarded
    private static int totalMessages = 0;

    // === Part 3 Arrays to store session data ===
    private static ArrayList<String> sentMessages        = new ArrayList<>();
    private static ArrayList<String> disregardedMessages = new ArrayList<>();
    private static ArrayList<String> storedMessages      = new ArrayList<>();
    private static ArrayList<String> messageHashes       = new ArrayList<>();
    private static ArrayList<String> messageIDs          = new ArrayList<>();

    // === Constructor: initializes a new message ===
    public Message(String messageID, int messageNumber, String recipientCell, String messageText){
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipientCell;
        this.messageText = messageText;
        totalMessages++;
    }

    // === Validation Methods (Part 2) ===
    // Checks if the message ID is valid (<= 10 digits)
    public boolean checkMessageID(){
        return messageID.length() <= 10;
    }

    // Validates recipient cell number (must start with + and be <= 10 chars)
    public String checkRecipient(){
        if (recipient.length() <= 10 && recipient.startsWith("+")){
            return "Cell phone number successfully captured.";
        } else {
            return "Invalid recipient cell number.";
        }
    }

    // Ensures message length does not exceed 250 characters
    public String checkMessageLength(){
        if (messageText.length() <= 250){
            return "Message successfully captured.";
        } else {
            int excess = messageText.length() - 250;
            return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
        }
    }

    // === Hash Creation ===
    // Creates a unique hash using ID, number, first and last words
    public String createMessageHash(){
        String[] words = messageText.split(" ");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();
        messageHash = messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord;
        messageHashes.add(messageHash);
        messageIDs.add(messageID);
        return messageHash;
    }

    // === Send/Store/Disregard ===
    // Updates sendStatus and stores message in the correct array
    public String sentMessage(String choice){
        switch (choice.toLowerCase()){
            case "send":
                sendStatus = "Sent";
                sentMessages.add(messageText);
                System.out.println("Message sent successfully!");
                break;
            case "store":
                sendStatus = "Stored";
                storedMessages.add(messageText);
                System.out.println("Message stored.");
                break;
            case "disregard":
                sendStatus = "Disregarded";
                disregardedMessages.add(messageText);
                System.out.println("Message disregarded.");
                break;
            default:
                return "Invalid choice.";
        }
        return sendStatus;
    }

    // === Print Single Message ===
    public String printMessages(){
        return "Message ID: " + messageID +
                "\nMessage Number: " + messageNumber +
                "\nRecipient: " + recipient +
                "\nText: " + messageText +
                "\nHash: " + messageHash +
                "\nStatus: " + sendStatus;
    }

    // Returns total number of messages created
    public int returnTotalMessages(){
        return totalMessages;
    }

    // === Store Message in JSON ===
    public JSONObject storeMessage() throws JSONException{
        JSONObject json = new JSONObject();
        json.put("MessageID", messageID);
        json.put("MessageNumber", messageNumber);
        json.put("Recipient", recipient);
        json.put("MessageText", messageText);
        json.put("MessageHash", messageHash);
        json.put("SendStatus", sendStatus);
        return json;
    }

    // === Part 3 Features ===

    // Loads stored messages from a JSON array (simulating file read)
    public static void loadStoredMessages(JSONArray jsonArray) throws JSONException{
        storedMessages.clear();
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            storedMessages.add(obj.getString("MessageText"));
        }
    }

    // Searches for a message by its ID
    public static String searchByMessageID(String id){
        int index = messageIDs.indexOf(id);
        if (index != -1){
            return "Message found with ID " + id + ": " + storedMessages.get(index);
        }
        return "Message ID not found.";
    }

    // Searches for a message by recipient cell number
    public static String searchByRecipient(String recipientCell){
        for (String msg : storedMessages){
            if (msg.contains(recipientCell)){
                return "Message found for recipient " + recipientCell + ": " + msg;
            }
        }
        return "No message found for recipient.";
    }

    // Deletes a message using its hash
    public static String deleteByHash(String hash){
        int index = messageHashes.indexOf(hash);
        if (index != -1){
            String removed = storedMessages.remove(index);
            messageHashes.remove(index);
            messageIDs.remove(index);
            return "Message deleted: " + removed;
        }
        return "Message hash not found.";
    }

    // Displays a report of all stored messages
    public static void displayReport(){
        System.out.println("=== Stored Messages Report ===");
        for (int i = 0; i < storedMessages.size(); i++){
            System.out.println("ID: " + messageIDs.get(i) +
                               " | Hash: " + messageHashes.get(i) +
                               " | Text: " + storedMessages.get(i));
        }
    }

    // Finds and displays the longest stored message
    public static String displayLongestMessage(){
        String longest = "";
        for (String msg : storedMessages){
            if (msg.length() > longest.length()){
                longest = msg;
            }
        }
        return longest.isEmpty() ? "No messages stored." : "Longest message: " + longest;
    }
}
