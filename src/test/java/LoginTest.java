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
public class LoginTest {
     
    LoginTest LoginTest = new LoginTest();
    
    @Test
    public void testValidUsername(){
        
        //This check the username must have the underscore"_"
        //also check the length of the username must not be more than 5 (e.g "Abong_")
        assertTrue(LoginTest.checkUserName("ab_1"));
    }
   
    @Test
    public void testInvalidUsername(){
        //reason why it is False, the username is more than 5 characters
        //it was suppose to be 5 (e.g "abong_")
        assertFalse(LoginTest.checkUsername("abongile_"));
    }
    
    @Test
    public void testvalidPassword(){
        //check if this the correct password
        assertTrue(LoginTest.checkUsername("Ch&&sec@ke99!"));
    }
    
    @Test
    public void testInvalidPassword_NoSpecialKeys(){
        //check if this has numbers or special case
        assertTrue(LoginTest.checkPassword("password"));
    }

    @Test
    public void testvalidphonenuber(){
        //check if the user used the correct formart
        assertTrue(LoginTest.checkCellPhoneNumber("+27838968976"));
        
    }
    @Test
    public void teastInvalidPhoneNumber_Formart(){
        //
        assertFalse(LoginTest.checkCellPhoneNumber("0838968976"));
    
    }
    
    @Test
    public void testLoginSuccess(){
        // Register with VALID detail first
        LoginTest.registerUser("abongile_","Ch&&sec@ke99!","+27838968976");
        
        //Attempt login with same correct details
        assertTrue(LoginTest.loginUser("abongile_","Ch&&sec@ke99!","+27838968976"));
    
    }
    
    @Test
    public void testLoginFailed(){
        // Register with VALID details first
        LoginTest.registerUser("abongile_","Ch&&sec@ke99!","+27838968976");
        
        // Attempt Login with WRONG password
        assertFalse(LoginTest.loginUsername("ab_1","password","0838968976"));
        
    
    }

    private boolean checkUserName(String ab_1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean checkPassword(String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean checkCellPhoneNumber(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean checkUsername(String abongile_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean loginUsername(String ab_1, String password, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void registerUser(String abongile_, String chsecke99, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean loginUser(String abongile_, String chsecke99, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

