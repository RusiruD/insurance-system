package nz.ac.auckland.se281;

public class CarPolicy extends Policies {
  private String name;
  private String sumInsured;
  private String makeModel;
  private String licencePlate;
  private String breakdown;
  private int amountPolicies;
  private int age;
  private int order;

  public CarPolicy(
      String name,
      String sumInsured,
      String makeModel,
      String licencePlate,
      String breakdown,
      int amountPolicies,
      int age,
      int order) {
    super(sumInsured);
    this.name = name;
    this.sumInsured = sumInsured;
    this.makeModel = makeModel;
    this.licencePlate = licencePlate;
    this.breakdown = breakdown;
    this.amountPolicies = amountPolicies;
    this.age = age;
    this.order = order;
  }

  public String returnName() {
    return name;
  }

  public int returnorder() {
    return order;
  }

  public void amountPolicies(int n) {
    amountPolicies = n;
  }

  public String returnPremium() {
    double premium = -1;
    int breakdownCover = 0;
    double baseRate = 0.15;
    // if the user wants breakdown cover an additional fee is added
    if (breakdown.contains("y")) {
      breakdownCover = 80;
    }
    // depending on the age of the user the base insurance rate is calculated diffrently
    if (age >= 25) {
      baseRate = 0.1;
    }
    // the premium is calculated
    premium = (breakdownCover + (baseRate * Double.parseDouble(sumInsured)));
    return Integer.toString((int) premium);
  }

  public String returnDiscountedPremium() {
    double premium = -1;
    int breakdownCover = 0;
    double discount = 0;
    double baseRate = 0.15;
    // if the user wants breakdown cover an additional fee is added
    if (breakdown.contains("y")) {
      breakdownCover = 80;
    }

    // depending on the age of the user the base insurance rate is calculated diffrently

    if (age >= 25) {
      baseRate = 0.1;
    }
    // depending on the amount of policies the user has a varying discount is placed on their
    // insurance premium
    if (amountPolicies == 2) {
      discount = 0.9;
    } else if (amountPolicies == 3) {
      discount = 0.8;
    } else {
      discount = 1;
    }
    // the discount is applied to the premium and the breakdown cover fee
    premium = (discount * (breakdownCover + (baseRate * Double.parseDouble(sumInsured))));

    return Integer.toString((int) premium);
  }

  public int returnDiscountedPremiumInt() {
    double premium = -1;
    int breakdownCover = 0;
    double discount = 0;
    double baseRate = 0.15;

    // if the user wants breakdown cover an additional fee is added
    if (breakdown.contains("y")) {
      breakdownCover = 80;
    }
    // depending on the age of the user the base insurance rate is calculated diffrently
    if (age >= 25) {
      baseRate = 0.1;
    }
    // depending on the amount of policies the user has a varying discount is placed on their
    // insurance premium
    if (amountPolicies == 2) {
      discount = 0.9;
    } else if (amountPolicies == 3) {
      discount = 0.8;
    } else {
      discount = 1;
    }
    // the discount is applied to the premium and the breakdown cover fee
    premium = (discount * (breakdownCover + (baseRate * Double.parseDouble(sumInsured))));

    return (int) premium;
  }

  public String returnmakeModel() {
    return makeModel;
  }
}
