/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Message;

/**
 *
 * @author MANXIWA MSIMELELO
 */
public class message {
    
    // Field - the data a message holds
    private String messageID;     // 10-digit auto-generated
    private int    messageNumber; // from loop counter 
    private String recipient;     // validated cell number
    private String messageText;   // max 250 chars
    private String messageHash;   // auto- generated
    private String sendStatus;    // sent, Stored, Disregarded
    private static int totalMessages = 0;
    // Constuctor
    public Message(String messageID, int messageNumber, String recipientCell, String messageText){
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        totalMessages++;
    }
    
    public boolean checkMessageID(){
        return messageID.length() <=10;
    
    }
    public String checkRecipient(){
        if (recipient.length()<= 10 && recipient.startsWith("+")){
            return "Cell phone number successfully capatured.";
        
        }else{
            return "Invalid recipient cell number.";
        
        }
    }
    public String checkMessageLength(){
        if (messageText.length() <=250){
            return "Message successfully captured";
        }else{
            int excess = messageText.length() - 250;
            return "Message exceeds 250 characters by" + excess + "; please reduce the size.";
        }
    }
    public String createMessageHash(){
        String[] words = messageText.split(" ");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();
        messageHash = messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord;
        return messageHash;
    
    }
    public String sentMessage(String choice){
        switch (choice.toLowerCase()){
            case "send":
                sendStatus = "Sent";
                System.out.println("Message sent successfully!");
            case "store":
                sendStatus = "Stored";
                System.out.println("Message stored");
            case "disregard":
                sendStatus = "Disregaeded";
                System.out.println("Disregarded");
            default:
                return "Invalid choice.";
                
        
        }
    
    }
    public String printMessages(){
        return "Message ID: " + messageID +
                "\nMessage Number: " + messageID +
                "\nRecipient: " + recipient +
                "\nText: " + messageText +
                "\nHash: " + messageHash +
                "\nStatus: " + sendStatus;
    
    }
    public int returnTotalMessges(){
        return totalMessages;
    
    }
    public JSONObject storeMessage(){
        JOSNObject json = new JSONObjectID();
        json.put("MessageID", messageID);
        json.put("MessagesNumber", messageNumber);
        json.put("Message", recipient);
        json.put("MessageText", messageText);
        json.put("MessageHesh", messageHash);
        json.put("SendStatus", sendStatus);
        return json;
    }
}
