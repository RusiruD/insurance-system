package nz.ac.auckland.se281;

public class Profile {

  private String userName;
  private String age;
  private int loaded;

  public Profile(String userName, String age, int loaded) {

    this.loaded = loaded;
    this.userName = userName;
    this.age = age;
  }

  public void printDetails() {

    System.out.println(this.userName + "dsas" + this.age);
  }

  public String returnAge() {
    return age;
  }

  public String returnUserName() {
    return userName;
  }

  public int returnIntAge() {
    int ageInteger = Integer.parseInt(age);
    return ageInteger;
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
}
