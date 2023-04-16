package nz.ac.auckland.se281;

public abstract class InsurancePolicies extends Object {
  protected String sumInsured;
  protected String name;
  protected int order;
  protected int amountPolicies;

  public InsurancePolicies(String sumInsured, String name, int order, int amountPolicies) {
    this.amountPolicies = amountPolicies;
    this.sumInsured = sumInsured;
    this.name = name;
    this.order = order;
  }

  public String returnSumInsured() {
    return sumInsured;
  }

  public void amountPolicies(int n) {
    amountPolicies = n;
  }

  public String returnName() {
    return name;
  }

  public int returnOrder() {
    return order;
  }

  public abstract String returnPremium();

  public abstract String returnDiscountedPremium();

  public abstract int returnDiscountedPremiumInt();
}
