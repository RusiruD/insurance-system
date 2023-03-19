package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  ArrayList<String> names = new ArrayList<String>();
  ArrayList<String> ages = new ArrayList<String>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
      // checks if array list of names of clients is empty and if 
      //so outputs a print statement saying the database has no profiles
      if(names.isEmpty()){
      
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");  }
        
        else{
          // if the array list of names isnt empty it assigns a string variable to the size of the array list 
          String amount_of_names=Integer.toString(names.size());
          
           // checks if the size of the names array list is equal to 1 and if so prints the appropriate 
           //output statements as defined in the assignment document
          if(names.size()==1){
            MessageCli.PRINT_DB_POLICY_COUNT.printMessage(amount_of_names, "", ":");
            MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(amount_of_names,names.get(0), ages.get(0)," %s: %s, %s");
            
          }
          
       
    }}
  
     
    public void createNewProfile(String userName, String age) {
    
    
      
      
      
      // sets int_age to be a integer array equivalent to the string value age
      int int_age =Integer.parseInt(age);
      // checks if the age of the profile is greater than or equal to 0
      // if the name is already contained in the database
      // and if the username length is greater than or equal to 3 and if so adds the profile to the database
      if (int_age>=0 && !names.contains(userName) && userName.length()>=3){
        names.add(userName);
        ages.add(age);
        
        MessageCli.PROFILE_CREATED.printMessage(userName, age,"New profile created for %s with age %s.");
        //System.out.println("hdh");
        
        
        //Profile =new Profile(userName, age);
        
       
       
        
      }
      
        
        
  
    }      
        



  
    
    
    
     
     
      
    
    
      
      

  

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
