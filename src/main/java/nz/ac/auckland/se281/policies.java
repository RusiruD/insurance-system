package nz.ac.auckland.se281;

public abstract class Policies extends Object {
  private String sumInsured;

  public Policies(String sumInsured) {
    this.sumInsured = sumInsured;
  }

  public String returnSumInsured() {
    return sumInsured;
  }
}
