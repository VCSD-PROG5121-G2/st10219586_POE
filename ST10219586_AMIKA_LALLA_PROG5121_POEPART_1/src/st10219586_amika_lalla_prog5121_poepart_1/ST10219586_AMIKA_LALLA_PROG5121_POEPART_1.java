/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st10219586_amika_lalla_prog5121_poepart_1;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author DISD3
 */
public class ST10219586_AMIKA_LALLA_PROG5121_POEPART_1 {

    static String userName;
    static String password;
    static String LoginUsername;
    static String LoginPassowd;
    static String storedUserName;
    static String storedPassword;
    static String storedFirstName;
    static String storedLastName;
    static String firstName;
    static String lastName;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        checkUserName();
        checkPasswordComplexity();
        registerUser();
        returnLoginStatus(loggedIn);
    }
    public static boolean checkUserName()
    {
        userName = JOptionPane.showInputDialog(null, "Enter username ");
        firstName = JOptionPane.showInputDialog(null, "Enter first name ");
        lastName = JOptionPane.showInputDialog(null, "Enter last name ");
        Pattern patternCapitalLetters = Pattern.compile("(?=.*[A-Z)");
        Matcher matcher = patternCapitalLetters.matcher(userName);
        boolean IsCapitalLetters =  matcher.find();
        if (userName.length()>=4 && userName.contains("_") && IsCapitalLetters == true)
        {
            JOptionPane.showMessageDialog(null, " ");
            return true;
        }
        else
        {
            return false;
        }
    }
    

    public static boolean checkPasswordComplexity()
    {
        password = JOptionPane.showInputDialog(null, "Enter password ");
        Pattern patternCapitalLetters = Pattern.compile("(?=.*[A-Z)");
        Pattern SpecialCharacters = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = patternCapitalLetters.matcher(password);
        Matcher matcher2 = SpecialCharacters.matcher(password);
        boolean IsCapitalLetters =  matcher.find();
        boolean IsSpecialCharacters = matcher2.find();
        if (password.length()>=8 && IsCapitalLetters == true && IsSpecialCharacters == true ) 
        {
            
            return true;
        }
        else
        {
          return false;
        }
    }
    
    
   
    
    public static String registerUser()
    {
      String returnedMessage =null;
      
        if (checkUserName()&& checkPasswordComplexity()) 
        {
             returnedMessage = "User successfully registered";
             storedUserName = userName;
             storedPassword = password;
             storedFirstName = firstName;
             storedLastName = lastName;
        }
        
        
        
        else if (!checkUserName())
        
        {
                    
            returnedMessage  = "UserName is not correctly formatted, missing underscore or more than 5 characters";
        }
        
        
        else if  (!checkPasswordComplexity())
        {
        
            returnedMessage = "Password is not correctly formatted, please "
                    + "ensure that the password contains at least 8 characters, "
                    + "a capital letter, a number and a special character";
        
        }
        
        return  returnedMessage;
  
    }
    
    public boolean loginUser(String userName, String password)
    {
        LoginUsername = JOptionPane.showInputDialog(null, "Enter usrname name ");
        LoginPassowd = JOptionPane.showInputDialog(null, "Enter usrname name ");
        boolean successfulLogin = false;
        
        if (storedUserName.equals(LoginUsername) && storedPassword.equals(LoginPassowd )) 
        {
            return true;
        }
        
        else 
        {
        
            return false;
        }
        
        
    
      }
    
    
    public String returnLoginStatus(boolean loggedIn)
    {
        String loginMessage= null;
       
        if (loggedIn) 
        {
            loginMessage = "Welcome " + storedFirstName + " " + storedLastName +
                    " " + "it is great to see you again";
        }
        
        else
        {
            loginMessage = "Username or password incorrect, please try again";
        
        }
    
          return loginMessage;
    }
    
}
