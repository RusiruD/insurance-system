package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  ArrayList<String> names = new ArrayList<String>();

  ArrayList<Profile> profiles = new ArrayList<>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    // checks if array list of names of clients is empty and if
    // so outputs a print statement saying the database has no profiles
    if (names.isEmpty()) {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else {
      // if the array list of names isnt empty it assigns a string variable to the size of the array
      // list
      String profileAmount = Integer.toString(names.size());

      // checks if the size of the names array list is equal to 1 and if so prints the appropriate
      // output statements as defined in the assignment document
      if (names.size() == 1) {
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(profileAmount, "", ":");
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            profileAmount,
            profiles.get(0).returnUserName(),
            profiles.get(0).returnAge(),
            " %s: %s, %s");
      }
      // if the amount of profiles is greater than 1 the names and ages are output one after each
      // other depending on the position they are in the databse as
      // they are output according to a strict format where it goes space rank colon space there
      // name comma and space and there age
      else {
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(profileAmount, "s", ":");
        for (int i = 0; i < names.size(); i++) {
          String rank = Integer.toString(i + 1);
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

    // sets int_age to be a integer array equivalent to the string value age
    Profile newProfile = new Profile(userName, age);
    // int ageInteger = Integer.parseInt(age);
    // checks if the age of the profile is greater than or equal to 0
    // if the name is already contained in the database
    // and if the username length is greater than or equal to 3 and if so adds the profile to the
    // database
    if (newProfile.returnIntAge() >= 0
        && !names.contains(userName)
        && newProfile.returnUserName().length() >= 3) {
      names.add(userName);

      MessageCli.PROFILE_CREATED.printMessage(
          userName, age, "New profile created for %s with age %s.");
      // System.out.println("hdh");

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
    else if (names.contains(userName)) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(
          userName, "Usernames must be unique. No profile was created for '%s'.");
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
