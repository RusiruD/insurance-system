package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  ArrayList<String> names = new ArrayList<String>();
  ArrayList<String> ages= new ArrayList<String>();
  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
      // checks if array list of names of clients is empty and if 
      //so outputs a print statement saying the database has no profiles
      if(names.isEmpty()){
      
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");  }
      else{}
        
        

        
  }

  public void createNewProfile(String userName, String age) {
    
    
    
     
     
      
    
    
      
      

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
