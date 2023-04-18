package nz.ac.auckland.se281;

public class LifeInsurance extends InsurancePolicies {
  private String age;

  public LifeInsurance(String age, String name, String sumInsured, int amountPolicies, int order) {
    super(sumInsured, name, order, amountPolicies);
    this.age = age;
  }

  @Override
  public String returnPremium() {

    // calculates the premium for a user using the formula and the users age
    int ageInt = Integer.parseInt(age);
    double premium = (0.01 * ((0.01 * ageInt) + 1) * Double.parseDouble(sumInsured));
    return Integer.toString((int) premium);
  }

  @Override
  public String returnDiscountedPremium() {

    double discount = 1;
   
    /* checks the amount of policies the profile has and
     calculates the discount applied to the premium based on this*/
    if (amountPolicies == 2) {
      discount = 0.9;
    } else if (amountPolicies >= 3) {
      discount = 0.8;
    } else {
      discount = 1;
    }

    //by calling the returnPremium method the discountedPremium can be easily returned
    double discountedPremium = (discount * (Integer.parseInt(this.returnPremium())));
    return Integer.toString((int) discountedPremium);
  }

  @Override
  public int returnDiscountedPremiumInt() {

    //the output of the returnDiscountedPremium is converted to an integer and returned
    return Integer.parseInt(this.returnDiscountedPremium());
  }
}
