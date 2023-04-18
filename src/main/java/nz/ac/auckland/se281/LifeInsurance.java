package nz.ac.auckland.se281;

public class LifeInsurance extends InsurancePolicies {
  private String age;

  public LifeInsurance(String age, String name, String sumInsured, int amountPolicies, int order) {
    super(sumInsured, name, order, amountPolicies);
    this.age = age;
  }

  @Override
  public String returnPremium() {
    int ageInt = Integer.parseInt(age);
    double premium = (0.01 * ((0.01 * ageInt) + 1) * Double.parseDouble(sumInsured));
    return Integer.toString((int) premium);
  }

  @Override
  public String returnDiscountedPremium() {

    double discount = 1;
    // calculates the premium using the age of the user and the sum of insurance
    // double premium = (0.01 * ((0.01 * ageInt) + 1) * Double.parseDouble(sumInsured));
    // double discountedPremium = premium;

    // checks the amount of policies the profile has and
    // calculates the discount applied to the premium based on this
    if (amountPolicies == 2) {
      discount = 0.9;
    } else if (amountPolicies >= 3) {
      discount = 0.8;
    } else {
      discount = 1;
    }

    double discountedPremium = (discount * (Integer.parseInt(this.returnPremium())));
    return Integer.toString((int) discountedPremium);
  }

  @Override
  public int returnDiscountedPremiumInt() {

   
    return Integer.parseInt(this.returnDiscountedPremium());
  }
}
