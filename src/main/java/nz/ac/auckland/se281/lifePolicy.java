package nz.ac.auckland.se281;

public class lifePolicy extends policies {
  private String name;
  private String sumInsured;
  private String age;
  private int amountPolicies;
  private int order;

  public lifePolicy(String age, String name, String sumInsured, int amountPolicies, int order) {
    super(sumInsured);
    this.name = name;
    this.sumInsured = sumInsured;
    this.age = age;
    this.amountPolicies = amountPolicies;
    this.order = order;
  }

  public String returnName() {
    return name;
  }

  public int returnorder() {
    return order;
  }

  public String returnSumInsured() {
    return sumInsured;
  }

  public void amountPolicies(int n) {
    amountPolicies = n;
  }

  public String returnPremium() {
    int ageInt = Integer.parseInt(age);
    double premium = (0.01 * ((0.01 * ageInt) + 1) * Double.parseDouble(sumInsured));
    return Integer.toString((int) premium);
  }

  public String returnDiscountedPremium() {
    int ageInt = Integer.parseInt(age);
    double discount = 1;
    double premium = (0.01 * ((0.01 * ageInt) + 1) * Double.parseDouble(sumInsured));
    double discountedPremium = premium;
    if (amountPolicies == 2) {
      discount = 0.9;
    } else if (amountPolicies == 3) {
      discount = 0.8;
    } else {
      discountedPremium = 1;
    }

    discountedPremium = (discount * premium);
    return Integer.toString((int) discountedPremium);
  }

  public int returnDiscountedPremiumInt() {
    int ageInt = Integer.parseInt(age);
    double discount = 1;
    double premium = (0.01 * ((0.01 * ageInt) + 1) * Double.parseDouble(sumInsured));
    double discountedPremium = premium;
    if (amountPolicies == 2) {
      discount = 0.9;
    } else if (amountPolicies == 3) {
      discount = 0.8;
    } else {
      discountedPremium = 1;
    }

    discountedPremium = (discount * premium);

    return (int) discountedPremium;
  }
}