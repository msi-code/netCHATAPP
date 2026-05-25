/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MANXIWA MSIMELELO
 */
public class mesageTest {
    private Message message1;
    private Message message2;

    @Before
    public void setUp() {
        // Test data from POE guide
        message1 = new Message("0012345678", 1, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");
        message2 = new Message("0098765432", 2, "08575975889",
                "Hi Keegan, did you receive the payment?");
    }

    // --- Message Length Tests ---
    @Test
    public void testCheckMessageLength_validMessage_returnsSuccess() {
        assertEquals("Message successfully captured", message1.checkMessageLength());
    }

    @Test
    public void testCheckMessageLength_over250chars_returnsFailureWithCount() {
        String longText = "a".repeat(251);
        Message msg = new Message("1234567890", 3, "+2712345678", longText);
        assertEquals("Message exceeds 250 characters by 1; please reduce the size.",
                     msg.checkMessageLength());
    }

    @Test
    public void testCheckMessageLength_exactlyAtLimit_returnsSuccess() {
        String exactText = "a".repeat(250);
        Message msg = new Message("1234567890", 4, "+2712345678", exactText);
        assertEquals("Message successfully captured", msg.checkMessageLength());
    }

    @Test
    public void testCheckMessageLength_oneOver_returnsFailureWithCountOf1() {
        String overText = "a".repeat(251);
        Message msg = new Message("1234567890", 5, "+2712345678", overText);
        assertEquals("Message exceeds 250 characters by 1; please reduce the size.",
                     msg.checkMessageLength());
    }

    // --- Recipient Cell Tests ---
    @Test
    public void testCheckRecipientCell_validNumber_returnsSuccess() {
        assertEquals("Cell phone number successfully captured.", message1.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCell_invalidNumber_returnsFailure() {
        assertEquals("Invalid recipient cell number.", message2.checkRecipientCell());
    }

    // --- Message Hash Tests ---
    @Test
    public void testCreateMessageHash_correctFormat_endsWithExpectedWords() {
        String hash = message1.createMessageHash();
        assertTrue(hash.endsWith("HITONIGHT"));
    }

    @Test
    public void testCreateMessageHash_isUppercase() {
        String hash = message1.createMessageHash();
        assertEquals(hash.toUpperCase(), hash);
    }

    @Test
    public void testCreateMessageHash_multipleMessages_loopTest() {
        String hash1 = message1.createMessageHash();
        String hash2 = message2.createMessageHash();
        assertNotEquals(hash1, hash2);
    }

    // --- Message ID Tests ---
    @Test
    public void testCheckMessageID_generatedID_isNotNull() {
        assertNotNull(message1.checkMessageID());
    }

    @Test
    public void testCheckMessageID_generatedID_isExactly10Chars() {
        assertTrue(message1.checkMessageID());
    }

    // --- Sent Message Tests ---
    @Test
    public void testSentMessage_userSelectsSend_returnsCorrectString() {
        assertEquals("Message sent successfully!", message1.sentMessage("send"));
    }

    @Test
    public void testSentMessage_userSelectsDisregard_returnsCorrectString() {
        assertEquals("Message disregarded.", message2.sentMessage("disregard"));
    }

    @Test
    public void testSentMessage_userSelectsStore_returnsCorrectString() {
        assertEquals("Message stored.", message1.sentMessage("store"));
    }
}