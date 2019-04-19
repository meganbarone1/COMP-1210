import java.text.DecimalFormat;
/** This class represents a Diamond Cardholder. Inherits from CardHolder class.
  * 
  * @author Megan Barone- COMP 1210-011
  * @version November 7, 2018
  */
public class DiamondCardholder extends Cardholder {
   
   protected double discountRate = 0.05;
   
   /** Constructor for this class.
     * @param acctNumberIn Command line arguments- not used.
     * @param nameIn Command line arguments- not used.
     */
   public DiamondCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Diamond Cardholder";
   }
   /** Getter for discount rate.
     * @return discountRate.
     */
   public double getDiscountRate() {
      return discountRate;
   }
   /** Setter for discount rate.
     * @param discountRateIn Command line arguments- not used.
     */
   public void setDiscountRate(double discountRateIn) {
      discountRate = discountRateIn;
   }
   /** Calculates purchase points.
     * @return purchasePoints.
     */
   public int purchasePoints() {
      return (int) (totalPurchases() / 1) * 3;
      
   }
   /** Overrided totalPurchases() method.
     * @return totalPurchases with discount applied.
     */
   public double totalPurchases() {
      return super.totalPurchases() * (1 - discountRate);
   }
   /** Overrided toString() method.
     * @return String with card information.
     */
   public String toString() {
      DecimalFormat df = new DecimalFormat("0.0%");
      return super.toString() + "\n(includes " + df.format(getDiscountRate())
                              + " discount rate applied to New Purchases)";
   }

   
   















}