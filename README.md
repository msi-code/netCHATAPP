# ST10501039

# PROG5121 Part 2 – Message Application

## 📌 Overview
This project implements a **Message class** and supporting tests as required in the PROG5121 Part 2 Practical Assignment.  
It demonstrates **object-oriented programming**, **validation logic**, **hash generation**, and **unit testing with JUnit**.

---

## 🧩 Features
- **Message Class**
  - Fields: `messageID`, `messageNumber`, `recipientCell`, `messageText`, `messageHash`, `sendStatus`
  - Methods:
    - `checkMessageID()` → validates ID length (≤ 10 chars)
    - `checkRecipientCell()` → validates recipient cell number format
    - `checkMessageLength()` → ensures text ≤ 250 characters
    - `createMessageHash()` → generates hash in format `ID:first+last word`
    - `sentMessage()` → handles Send, Store, Disregard actions
    - `printMessages()` → displays message details
    - `returnTotalMessages()` → tracks total messages
    - `storeMessage()` → saves message in JSON format

- **JUnit Tests**
  - Covers all methods using **Arrange–Act–Assert** pattern
  - Validates correct return strings and error messages
  - Uses POE test data (Mike’s dinner invite, Keegan’s payment message)

---

## ⚙️ Requirements
- **Java 17+**
- **Apache NetBeans 15+** (or IntelliJ/Eclipse)
- **JUnit 4.13.2**
- **org.json library** for JSON storage  
  - Add via Maven:
    ```xml
    <dependency>
      <groupId>org.json</groupId>
      <artifactId>json</artifactId>
      <version>20230227</version>
    </dependency>
    ```
  - Or download from [https://github.com/stleary/JSON-java](https://github.com/stleary/JSON-java)

---

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/msi-code/netCHATAPP.git
