# ST10501039

# PROG5121
# NetChatApp – Part 3 POE

## Overview
This project extends the **NetChatApp** from Part 2 by adding advanced message handling features as required in the **PROG5121 Part 3 Guide**.  
The focus is on **arrays, JSON integration, searching, deleting, reporting, and testing**.

---

## Features Implemented
- **Static Arrays**  
  - Store Sent, Stored, Disregarded messages, Hashes, and IDs.
- **JSON Integration**  
  - `loadStoredMessages()` reads messages from `messages.json`.
- **Search Methods**  
  - `searchByMessageID()` → find a message by its unique ID.  
  - `searchByRecipient()` → locate messages by recipient number.
- **Delete Method**  
  - `deleteByHash()` → remove a message using its hash.
- **Report Method**  
  - `displayReport()` → outputs all stored messages neatly.
- **Longest Message**  
  - `displayLongestMessage()` → identifies and displays the longest text message.
- **Polished Part 2 Methods**  
  - Validation (`checkRecipient`, `checkMessageLength`) and hashing improved for clarity and marks.

---

## Testing
A separate **MessageTest.java** file includes **JUnit stubs** for:
- Search methods  
- Delete method  
- Report generation  
- Longest message display  

This ensures compliance with Part 3’s testing requirements.

---

## 📂 Project Structure
