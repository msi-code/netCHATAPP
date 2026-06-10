/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import com.mycompany.netchatapp.Login;
import java.util.Scanner;

/**
 *
 * @author MANXIWA MSIMELELO
 */
public class MainApp {
     public static void main(String[] args){
        
        //Scannr allows the user to enter information
        Scanner input = new Scanner(System.in);
        
        //Create an object of the login class so we can call its methods
            Login Login = new Login();
        
        //---REGISTRATION SECTION---
        System.out.println("===USER REGISRATION===");
        
        System.out.println("Enter a username: ");
        String username =input.nextLine();
        
        System.out.println("Enter a password: ");
        String password =input.nextLine();
        
        System.out.println("Enter your South African phone (+27...)");
        String phone =input.nextLine();
        
        //Call the registerUser method and store the message it returns
        String response = Login.registerUser(username, password, phone);
        
        // Show the registerUser method and store the message it returns
        System.out.println(response);
        
         //---LOGIN SCTION---
         System.out.println("\n=== USER LOGIN ===");
         
         System.out.println("Enter your username: ");
         String loginUsername = input.nextLine();
         
         System.out.println("Enter your password: ");
         String loginPassword = input.nextLine();
         
         //Call loginUser to check if details
          boolean loggedln = Login.loginUser(loginUsername, loginPassword);
          
          //Print out the correct login message
          String loginMessage = Login.returnLoginStatus(loggedln);
          System.out.println(loginMessage);
    }
}
