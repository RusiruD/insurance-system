package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  // create array lists which will contain profiles and policies
  ArrayList<Profile> profiles;
  ArrayList<CarInsurance> carPolicies;
  ArrayList<HomeInsurance> homePolicies;
  ArrayList<LifeInsurance> lifePolicies;

  public InsuranceSystem() {
    profiles = new ArrayList<>();
    carPolicies = new ArrayList<>();
    homePolicies = new ArrayList<>();
    lifePolicies = new ArrayList<>();

    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {

    /*  checks if array list of names of clients is empty and if
    so outputs a print statement saying the database has no profiles*/

    if (profiles.isEmpty()) {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else {
      // if the array list of names isnt empty it assigns a string variable to the size of the array
      // list
      String profileAmount = Integer.toString(profiles.size());

      /* checks if the size of the names array list is equal to 1 and if so sets a variable so that
      output statements are grammatically accurate */
      String pluralProfiles = "s";
      if (profiles.size() == 1) {
        pluralProfiles = "";
      }

      // amount of profiles in database is printed
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(profileAmount, pluralProfiles, ":");

      // for loop goes through every profile in the profiles array
      for (int i = 0; i < profiles.size(); i++) {

        String rank = Integer.toString(i + 1);
        String asteriks = "";
        String pluralPolicies = "ies";

        /*  checks if the profiles its trying to print is loaded and if so sets a variable so
        asteriks are outputted in print statement */
        if (profiles.get(i).returnProfileLoaded() == 1) {
          asteriks = "*** ";
        }

        /*  checks if the profile its found has only 1 insurance policy and if so sets string
        variable so output statement is grammatically correct */
        if (profiles.get(i).returnPolicies() == 1) {
          pluralPolicies = "y";
        }

        /*  3 array lists are created which will contain the positions within the respective policy
        type array list the profiles policy is in */

        ArrayList<Integer> carPolicysPositions = new ArrayList<>();
        ArrayList<Integer> lifePolicysPositions = new ArrayList<>();
        ArrayList<Integer> homePolicysPositions = new ArrayList<>();

        int totalPremium = 0;

        /*  sets variable stating the amount of policies the profile has into each policys class
        checks if the profile has any home policies so it can add the cost to the profiles total
         premium and to add the position of this home policy position to an array */

        for (int k = 0; k < homePolicies.size(); k++) {

          if (checkIfNameContained((homePolicies.get(k)), i)) {
            updateAmountPolicies(homePolicies.get(k), i);
            homePolicysPositions.add(k);

            totalPremium = totalPremium + homePolicies.get(k).returnDiscountedPremiumInt();
          }
        }

        /*  checks if the profile has any life policies so it can add the cost to the profiles total
        premium and to add the position of this life policy position to an array */
        for (int k = 0; k < lifePolicies.size(); k++) {

          if (checkIfNameContained(lifePolicies.get(k), i)) {
            updateAmountPolicies(lifePolicies.get(k), i);
            lifePolicysPositions.add(k);

            totalPremium = totalPremium + lifePolicies.get(k).returnDiscountedPremiumInt();
          }
        }
        /*  checks if the profile has any car policies so it can add the cost to the profiles total
        premium and to add the position of this car policy position to an array */
        for (int k = 0; k < carPolicies.size(); k++) {

          if (checkIfNameContained(carPolicies.get(k), i)) {
            updateAmountPolicies(carPolicies.get(k), i);

            carPolicysPositions.add(k);

            totalPremium = totalPremium + carPolicies.get(k).returnDiscountedPremiumInt();
          }
        }

        // the name,age,amount of policies and total premium are printed out
        MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
            asteriks,
            rank,
            profiles.get(i).returnUserName(),
            profiles.get(i).returnAge(),
            profiles.get(i).returnPoliciesString(),
            pluralPolicies,
            Integer.toString(totalPremium),
            " %s%s: %s, %s, %s polic%s for a total of $%s");

        // the details of the policys the profile has are printed out
        for (int k = 1; k < profiles.get(i).returnPolicies() + 1; k++) {

          for (int l = 0; l < carPolicysPositions.size(); l++) {

            /*  goes through the carPolicysPositions homePolicyPositions and lifePolicyPositions
            arrays to make sure to print out the policys in the order
            they were added to the profile */

            if (carPolicies.get(carPolicysPositions.get(l)).returnOrder() == k) {

              MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                  carPolicies.get(carPolicysPositions.get(l)).returnMakeModel(),
                  carPolicies.get(carPolicysPositions.get(l)).returnSumInsured(),
                  carPolicies.get(carPolicysPositions.get(l)).returnPremium(),
                  carPolicies.get(carPolicysPositions.get(l)).returnDiscountedPremium(),
                  "\tCar Policy (%s, Sum Insured: $%s, Premium: $%s -> $%s)");

            } else {
            }
          }
          for (int l = 0; l < lifePolicysPositions.size(); l++) {
            if (lifePolicies.get(lifePolicysPositions.get(l)).returnOrder() == k) {
              MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                  lifePolicies.get(lifePolicysPositions.get(l)).returnSumInsured(),
                  lifePolicies.get(lifePolicysPositions.get(l)).returnPremium(),
                  lifePolicies.get(lifePolicysPositions.get(l)).returnDiscountedPremium(),
                  "\tLife Policy (Sum Insured: $%s, Premium: $%s -> $%s)");
            }
          }

          for (int l = 0; l < homePolicysPositions.size(); l++) {
            if (homePolicies.get(homePolicysPositions.get(l)).returnOrder() == k) {
              MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                  homePolicies.get(homePolicysPositions.get(l)).returnAdress(),
                  homePolicies.get(homePolicysPositions.get(l)).returnSumInsured(),
                  homePolicies.get(homePolicysPositions.get(l)).returnPremium(),
                  homePolicies.get(homePolicysPositions.get(l)).returnDiscountedPremium(),
                  "\tHome Policy (%s, Sum Insured: $%s, Premium: $%s -> $%s)");
            }
          }
        }
      }
    }
  }

  private boolean checkIfNameContained(InsurancePolicies typePolicy, Integer i) {

    // returns boolean true if the instance of a policy has the same stored name as the current
    // profile

    return typePolicy.returnName().equals(profiles.get(i).returnUserName());
  }

  private void updateAmountPolicies(InsurancePolicies typePolicy, Integer i) {

    // updates the amount of policies field in a policy class

    typePolicy.amountPolicies(profiles.get(i).returnPolicies());
  }

  public void createNewProfile(String userName, String age) {

    // formats the inputted userName into titlecase where the first letter is capitalised only

    userName = formatUserName(userName);
    // creates new profile named newProfile with username and age inputted
    Profile newProfile = new Profile(userName, age, 0, 0);

    // sets contains variable to 0
    int contains = 0;
    int loaded = 0;
    int profileLocation = 0;
    /*checks if the username has ever been inputted into the database previously and if
    a profile is loaded currently*/
    for (int i = 0; i < profiles.size(); i++) {
      if (profiles.get(i).returnUserName().contains(newProfile.returnUserName())) {
        contains = 1;
      }
      if (profiles.get(i).returnProfileLoaded() == 1) {

        loaded = 1;
        profileLocation = i;
      }
    }

    /* checks if the age of the profile is greater than or equal to 0
    if the name is already contained in the database, if a profile is already loaded
    and if the username length is greater than or equal to 3 and if so adds the profile to the
    database*/
    if (newProfile.returnIntAge() >= 0
        && contains == 0
        && loaded == 0
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

    }
    // if a profile is already loaded an error message is printed
    else if (loaded == 1) {

      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(
          profiles.get(profileLocation).returnUserName(),
          "Cannot create a new profile. First unload the profile for %s.");
      return;
    }
  }

  public void loadProfile(String userName) {
    // format username inputted by user to title case
    userName = formatUserName(userName);

    int loaded = 0;
    // iterate through array list of profiles to find the correct profile to load
    for (int i = 0; i < profiles.size(); i++) {
      if (userName.equals(profiles.get(i).returnUserName())) {
        loaded = 1;

        // unloads all previously loaded profiles
        for (int j = 0; j < profiles.size(); j++) {
          profiles.get(j).profileUnloaded();
        }
        // loads profile with the inputted username
        profiles.get(i).profileLoaded();
        MessageCli.PROFILE_LOADED.printMessage(userName, "Profile loaded for %s.");
      }
    }
    // outputs message if not profile is found to load
    if (loaded == 0) {
      MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(
          userName, "No profile found for %s. Profile not loaded.");
    }
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

    // format username inputted into titlecase
    userName = formatUserName(userName);

    int deleted = 0;
    // iterates through profiles arraylist to find the profile to delete
    for (int i = 0; i < profiles.size(); i++) {
      if (profiles.get(i).returnUserName().equals(userName)
          && profiles.get(i).returnProfileLoaded() == 0) {
        deleted = 1;
        MessageCli.PROFILE_DELETED.printMessage(userName, "Profile deleted for %s.");
        profiles.remove(i);
      }
      // if the profile is found but is loaded it isnt deleted and a message is output
      else if (profiles.get(i).returnUserName().equals(userName)
          && profiles.get(i).returnProfileLoaded() == 1) {
        MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(
            userName, "Cannot delete profile for %s while loaded. No profile was deleted.");
        return;
      }
    }
    // if the profile was not found a message is output to user saying it wasnt found
    if (deleted == 0) {
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(
          userName, "No profile found for %s. No profile was deleted.");
    }
  }

  private String formatUserName(String userName) {

    // formats the username into title case and returns it

    userName =
        (userName.substring(0, 1).toUpperCase()
            + userName.substring(1, userName.length()).toLowerCase());

    return userName;
  }

  public void createPolicy(PolicyType type, String[] options) {

    int profilesLoaded = 0;
    String userName = " ";

    // converts inputted policy type to lowercase
    String typeString = type.toString().toLowerCase();

    // finds the loaded profile and records its position
    int profileNumber = 0;
    for (int j = 0; j < profiles.size(); j++) {
      if (profiles.get(j).returnProfileLoaded() == 1) {
        profilesLoaded = 1;
        userName = profiles.get(j).returnUserName();
        profileNumber = j;
      }
    }

    // if no profile is loaded an error message is outputted
    if (profilesLoaded == 0) {
      MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage(
          "Need to load a profile in order to create a policy.");
      /** */

      // if the policy type is a life policy and the user is above 100 a error message is output
    } else if (profiles.get(profileNumber).returnIntAge() > 100 && typeString.equals("life")) {
      MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(
          userName, "%s is over the age limit. No policy was created.");
      return;

    }
    // else a new policy is created
    else {

      MessageCli.NEW_POLICY_CREATED.printMessage(
          typeString, userName, "New %s policy created for %s.");

      // a new instance of a class is created for each policy

      /*  the order field is filled by getting the amount of previous policies the profile
      already has so the policy has the attribute of which place it was created for the profile*/
      if (typeString.equals("home")) {
        profiles.get(profileNumber).addedPolicy();
        HomeInsurance policy =
            new HomeInsurance(
                userName,
                options[0],
                options[1],
                options[2],
                0,
                profiles.get(profileNumber).returnPolicies());

        homePolicies.add(policy);
      }
      if (typeString.equals("car")) {
        profiles.get(profileNumber).addedPolicy();
        CarInsurance policy =
            new CarInsurance(
                userName,
                options[0],
                options[1],
                options[2],
                options[3],
                0,
                profiles.get(profileNumber).returnIntAge(),
                profiles.get(profileNumber).returnPolicies());

        carPolicies.add(policy);
      }

      // checks if the user already has a life policy
      int contains = 0;
      for (int i = 0; i < lifePolicies.size(); i++) {
        if (lifePolicies
            .get(i)
            .returnName()
            .contains(profiles.get(profileNumber).returnUserName())) {
          contains = 1;
        }
      }
      // a new life policy is created only if a previous one doesnt exist
      if (typeString.equals("life") && contains == 0) {
        profiles.get(profileNumber).addedPolicy();
        LifeInsurance policy =
            new LifeInsurance(
                profiles.get(profileNumber).returnAge(),
                userName,
                options[0],
                0,
                profiles.get(profileNumber).returnPolicies());

        lifePolicies.add(policy);

      }
      // if a life policy already exists a error message is output
      else if (typeString.equals("life") && contains == 1) {
        MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(
            profiles.get(profileNumber).returnUserName(),
            "%s already has a life policy. No new policy was created.");
      }
    }
  }
}
