package nz.ac.auckland.se281;

public class homePolicy extends policies {
  private String name;
  private String sumInsured;
  private String adress;
  private String rental;
  private int amountPolicies;
  private int order;

  public homePolicy(
      String name, String sumInsured, String adress, String rental, int amountPolicies, int order) {
    super(sumInsured);
    this.name = name;
    this.sumInsured = sumInsured;
    this.adress = adress;
    this.rental = rental;
    this.amountPolicies = amountPolicies;
    this.order = order;
  }

  public int returnorder() {
    return order;
  }

  public String returnName() {
    return name;
  }

  public String returnAdress() {
    return adress;
  }

  public void amountPolicies(int n) {
    amountPolicies = n;
  }

  public String returnPremium() {
    int baseRate = 0;
    if (rental.contains("y")) {
      baseRate = 50;

    } else {
      baseRate = 100;
    }
    int premium = (Integer.parseInt(sumInsured) / baseRate);
    return Integer.toString(premium);
  }

  public String returnDiscountedPremium() {
    double discountedPremium = 0;
    double discount = 1;
    int premium = 0;
    int baseRate = 0;
    if (rental.contains("y")) {
      baseRate = 50;

    } else {
      baseRate = 100;
    }
    premium = (Integer.parseInt(sumInsured) / baseRate);

    if (amountPolicies == 2) {
      discount = 0.9;

    } else if (amountPolicies == 3) {
      discount = 0.8;
    } else {
      discount = 1;
      ;
    }
    discountedPremium = (premium * discount);
    return Integer.toString((int) discountedPremium);
  }

  public int returnDiscountedPremiumInt() {

    double discountedPremium = 0;
    double discount = 1;
    int premium = 0;
    int baseRate = 0;
    if (rental.contains("y")) {
      baseRate = 50;

    } else {
      baseRate = 100;
    }
    premium = (Integer.parseInt(sumInsured) / baseRate);

    if (amountPolicies == 2) {
      discount = 0.9;

    } else if (amountPolicies == 3) {
      discount = 0.8;
    } else {
      discount = 1;
      ;
    }
    discountedPremium = (premium * discount);

    return (int) discountedPremium;
  }
}
