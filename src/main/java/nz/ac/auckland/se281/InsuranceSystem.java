package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  ArrayList<Profile> profiles = new ArrayList<>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    // checks if array list of names of clients is empty and if
    // so outputs a print statement saying the database has no profiles
    if (profiles.isEmpty()) {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else {
      // if the array list of names isnt empty it assigns a string variable to the size of the array
      // list
      String profileAmount = Integer.toString(profiles.size());

      // checks if the size of the names array list is equal to 1 and if so prints the appropriate
      // output statements as defined in the assignment document
      if (profiles.size() == 1) {
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(profileAmount, "", ":");

        // checks if the profiles its trying to print is loaded and if so prints asteriks before
        // displaying it
        if (profiles.get(0).returnProfileLoaded() == 1) {
          String asteriks = "*** ";
          MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage(
              asteriks,
              profileAmount,
              profiles.get(0).returnUserName(),
              profiles.get(0).returnAge(),
              " %s%s: %s, %s");
        }
        // else if the profile isnt loaded the output message is displayed as normal
        else {
          MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
              profileAmount,
              profiles.get(0).returnUserName(),
              profiles.get(0).returnAge(),
              " %s: %s, %s");
        }
      }
      // if the amount of profiles is greater than 1 the names and ages are output one after each
      // other depending on the position they are in the databse as
      // they are output according to a strict format where it goes space rank colon space there
      // name comma and space and there age
      else {
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(profileAmount, "s", ":");
        for (int i = 0; i < profiles.size(); i++) {
          String rank = Integer.toString(i + 1);

          // checks if the profiles its trying to print is loaded and if so prints asteriks before
          // displaying it
          if (profiles.get(i).returnProfileLoaded() == 1) {
            String asteriks = "*** ";
            MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage(
                asteriks,
                rank,
                profiles.get(i).returnUserName(),
                profiles.get(i).returnAge(),
                " %s%s: %s, %s");
            continue;
          }

          MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
              rank, profiles.get(i).returnUserName(), profiles.get(i).returnAge(), " %s: %s, %s");
        }
      }
    }
  }

  public void createNewProfile(String userName, String age) {

    // formats the inputted userName into titlecase where the first letter is capitalised only
    userName =
        (userName.substring(0, 1).toUpperCase()
            + userName.substring(1, userName.length()).toLowerCase());

    // creates new profile named newProfile with username and age inputted
    Profile newProfile = new Profile(userName, age, 0);

    // sets contains variable to 0
    int contains = 0;
    // checks if the username has ever been inputted into the database previously
    for (int i = 0; i < profiles.size(); i++) {
      if (profiles.get(i).returnUserName().contains(newProfile.returnUserName())) {
        contains = 1;
      }
    }
    // checks if the age of the profile is greater than or equal to 0
    // if the name is already contained in the database
    // and if the username length is greater than or equal to 3 and if so adds the profile to the
    // database
    if (newProfile.returnIntAge() >= 0
        && contains == 0
        && newProfile.returnUserName().length() >= 3) {

      MessageCli.PROFILE_CREATED.printMessage(
          userName, age, "New profile created for %s with age %s.");
      // adds new user profile to profiles array
      profiles.add(newProfile);

    }
    // if the user name length is less than 3 characters an error message is printed
    else if (newProfile.returnUserName().length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(
          userName,
          "'%s' is an invalid username, it should be at least 3 characters long. No profile was"
              + " created.");
    }

    // if the age is less than 0 a error message is printed
    else if (newProfile.returnIntAge() < 0) {
      MessageCli.INVALID_AGE.printMessage(
          age,
          userName,
          "'%s' is an invalid age, please provide a positive whole number only. No profile was"
              + " created for %s.");
    }

    // if the username inputted is already in the database an error message is printed
    else if (contains == 1) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(
          userName, "Usernames must be unique. No profile was created for '%s'.");

    } else {
    }
  }

  public void loadProfile(String userName) {
    // format username inputted by user to title case
    userName =
        (userName.substring(0, 1).toUpperCase()
            + userName.substring(1, userName.length()).toLowerCase());

    int loaded = 0;
    // iterate through array list of profiles to find the correct profile to load
    for (int i = 0; i < profiles.size(); i++) {
      if (userName.equals(profiles.get(i).returnUserName())) {
        loaded = 1;

        // unloads all previously loaded profiles
        for (int j = 0; j < profiles.size(); j++) {
          profiles.get(j).profileUnloaded();
        }
        profiles.get(i).profileLoaded();
        MessageCli.PROFILE_LOADED.printMessage(userName, "Profile loaded for %s.");
      }
    }
    // outputs message if not profile is found to load
    if (loaded == 0) {
      MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(
          userName, "No profile found for %s. Profile not loaded.");
    }

    // TODO: Complete this method.
  }

  public void unloadProfile() {
    int profilesLoaded = 0;
    // checks which profile is loaded currently so it can be unloaded
    for (int j = 0; j < profiles.size(); j++) {
      if (profiles.get(j).returnProfileLoaded() == 1) {
        profilesLoaded = 1;
        profiles.get(j).profileUnloaded();
        MessageCli.PROFILE_UNLOADED.printMessage(
            profiles.get(j).returnUserName(), "Profile unloaded for %s.");
      }
    }
    // if no profile is loaded a message is output declaring this
    if (profilesLoaded == 0) {
      MessageCli.NO_PROFILE_LOADED.printMessage("No profile is currently loaded.");
    }
  }

  public void deleteProfile(String userName) {
    // format username inputted into titelcase
    userName =
        (userName.substring(0, 1).toUpperCase()
            + userName.substring(1, userName.length()).toLowerCase());

    int deleted = 0;
    // iterates through profiles arraylist to find the profile to delete
    for (int i = 0; i < profiles.size(); i++) {
      if (profiles.get(i).returnUserName().contains(userName)
          && profiles.get(i).returnProfileLoaded() == 0) {
        deleted = 1;
        MessageCli.PROFILE_DELETED.printMessage(userName, "Profile deleted for %s.");
        profiles.remove(i);
      }
      // if the profile is found but is loaded it isnt deleted and a message is output
      else if (profiles.get(i).returnUserName().contains(userName)
          && profiles.get(i).returnProfileLoaded() == 1) {
        MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(
            userName, "Cannot delete profile for %s while loaded. No profile was deleted.");
      }
    }
    // if the profile was not found a message is output to user saying it wasnt found
    if (deleted == 0) {
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(
          userName, "No profile found for %s. No profile was deleted.");
    }
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
