package nz.ac.auckland.se281;

public class Profile {

  private String userName;
  private String age;
  private int loaded;
  private int policies;

  public Profile(String userName, String age, int loaded, int policies) {

    this.loaded = loaded;
    this.userName = userName;
    this.age = age;
    this.policies = policies;
  }

  public void printDetails() {

    System.out.println(this.userName + "dsas" + this.age);
  }

  public String returnAge() {
    return age;
  }
  // returns the age converted to an integer
  public int returnIntAge() {

    int ageInteger = Integer.parseInt(age);

    return ageInteger;
  }

  public String returnUserName() {
    return userName;
  }

  // loads the profile when called
  public void profileLoaded() {

    this.loaded = 1;
  }
  // unloads the profile when called

  public void profileUnloaded() {

    this.loaded = 0;
  }
  // returns the loaded state of the profile

  public int returnProfileLoaded() {

    return this.loaded;
  }

  public void addedPolicy() {

    this.policies = this.policies + 1;
  }

  public int returnpolicies() {

    return this.policies;
  }

  public String returnPoliciesString() {

    String x = String.valueOf(policies);
    return x;
  }
}
