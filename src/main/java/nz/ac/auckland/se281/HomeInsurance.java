package nz.ac.auckland.se281;

public class HomeInsurance extends InsurancePolicies {
  private String adress;
  private String rental;

  public HomeInsurance(
      String name, String sumInsured, String adress, String rental, int amountPolicies, int order) {
    super(sumInsured, name, order, amountPolicies);

    this.adress = adress;
    this.rental = rental;
  }

  public String returnAdress() {
    return adress;
  }

  @Override
  public String returnPremium() {

    int baseRate = 0;
    // checks if the home policy is for a rental
    if (rental.contains("y") || rental.contains("Y") ) {
      baseRate = 50;

    } else {
      baseRate = 100;
    }
    // calculates the premium the user has to pay
    int premium = (Integer.parseInt(sumInsured) / baseRate);
    return Integer.toString(premium);
  }

  @Override
  public String returnDiscountedPremium() {

    // sets variables to default values

    double discount = 1;
    int premium = 0;

    // calls return premium function to get premium
    premium = (Integer.parseInt(this.returnPremium()));

    /*  checks how many policies the profile has and sets the
    appropriate discount to the premium they pay */
    if (amountPolicies == 2) {
      discount = 0.9;

    } else if (amountPolicies >= 3) {
      discount = 0.8;
    } else {
      discount = 1;
      ;
    }

    // returns premium with discount applied to it as a String
    return Integer.toString((int) (premium * discount));
  }

  @Override
  public int returnDiscountedPremiumInt() {

    //calls returnDiscountedPremium method to return same value but as an Integer
    return Integer.parseInt(this.returnDiscountedPremium());
  }
}
