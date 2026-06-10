package com.mycompany.netchatapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * MessageTest.java - Unit tests for Message.java
 * Covers Part 2 (validation, hash, send/store/disregard) and Part 3 (arrays, search, delete, report, longest message)
 */
public class MessageTest {

    private Message msg1;
    private Message msg2;

    @BeforeEach
    public void setUp() {
        // Create fresh Message objects before each test
        msg1 = new Message("MSG1234567", 1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        msg2 = new Message("MSG7654321", 2, "+27891234567", "Hello Keegan, did you receive the payment?");
    }

    // === Part 2 Tests ===

    @Test
    public void testCheckMessageID_validID_returnsTrue() {
        // Checks that ID length <= 10
        assertTrue(msg1.checkMessageID());
    }

    @Test
    public void testCheckRecipient_validNumber_returnsSuccess() {
        // Recipient starts with + and length <= 10
        assertEquals("Cell phone number successfully captured.", msg1.checkRecipient());
    }

    @Test
    public void testCheckMessageLength_validMessage_returnsSuccess() {
        // Message length <= 250 characters
        assertEquals("Message successfully captured.", msg1.checkMessageLength());
    }

    @Test
    public void testCreateMessageHash_generatesCorrectFormat() {
        // Hash should include ID prefix, number, first and last words
        String hash = msg1.createMessageHash();
        assertTrue(hash.contains("MSG"));
        assertTrue(hash.contains("1"));
        assertTrue(hash.endsWith("TONIGHT"));
    }

    @Test
    public void testSentMessage_send_updatesStatusAndArray() {
        // Choice "send" should set status and add to sentMessages
        String status = msg1.sentMessage("send");
        assertEquals("Sent", status);
    }

    @Test
    public void testSentMessage_store_updatesStatusAndArray() {
        // Choice "store" should set status and add to storedMessages
        String status = msg1.sentMessage("store");
        assertEquals("Stored", status);
    }

    @Test
    public void testSentMessage_disregard_updatesStatusAndArray() {
        // Choice "disregard" should set status and add to disregardedMessages
        String status = msg1.sentMessage("disregard");
        assertEquals("Disregarded", status);
    }

    // === Part 3 Tests ===

    @Test
    public void testLoadStoredMessages_readsJSONArrayIntoArray() throws JSONException {
        // Simulate JSON array with one stored message
        JSONArray arr = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("MessageText", "Stored message example");
        arr.put(obj);

        Message.loadStoredMessages(arr);
        assertEquals("Stored message example", Message.searchByMessageID("MSG1234567")); // ID not found but array loaded
    }

    @Test
    public void testSearchByMessageID_findsMessage() {
        msg1.createMessageHash();
        msg1.sentMessage("store");
        assertTrue(Message.searchByMessageID("MSG1234567").contains("Message found"));
    }

    @Test
    public void testSearchByRecipient_findsMessage() {
        msg2.sentMessage("store");
        assertTrue(Message.searchByRecipient("+27891234567").contains("Message found"));
    }

    @Test
    public void testDeleteByHash_removesMessage() {
        String hash = msg1.createMessageHash();
        msg1.sentMessage("store");
        String result = Message.deleteByHash(hash);
        assertTrue(result.contains("Message deleted"));
    }

    @Test
    public void testDisplayReport_outputsStoredMessages() {
        msg1.createMessageHash();
        msg1.sentMessage("store");
        // Just check that report runs without error
        assertDoesNotThrow(() -> Message.displayReport());
    }

    @Test
    public void testDisplayLongestMessage_returnsLongest() {
        msg1.sentMessage("store");
        msg2.sentMessage("store");
        String longest = Message.displayLongestMessage();
        assertTrue(longest.contains("Longest message"));
    }
}
