package nz.ac.auckland.se281;

public abstract class InsurancePolicies extends Object {
    protected String sumInsured;
    protected String name;
    protected int order;

    public InsurancePolicies(String sumInsured, String name, int order) {
      this.sumInsured = sumInsured;
      this.name=name;
      this.order=order;
    }
  
    public String returnSumInsured() {
      return sumInsured;
    }
    public String returnName() {
        return name;
      }
      public int returnorder() {
        return order;
      }
    
    
    
}
