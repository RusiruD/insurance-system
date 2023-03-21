package nz.ac.auckland.se281;

public class Profile {

  private String userName;
  private String age;
  // private ArrayList<String> names= new ArrayList<String>();
  public Profile(String userName, String age) {
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
}
