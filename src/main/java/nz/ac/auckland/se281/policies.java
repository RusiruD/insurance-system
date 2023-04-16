package nz.ac.auckland.se281;

public abstract class policies extends Object {
  private String sumInsured;

  public policies(String sumInsured) {
    this.sumInsured = sumInsured;
  }

  public String returnSumInsured() {
    return sumInsured;
  }
}
