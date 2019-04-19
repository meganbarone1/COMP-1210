import java.text.DecimalFormat;
/** Represents a Blue Diamond Cardholder. Inherits from DiamondCardHolder class.
  * 
  * @author Megan Barone- COMP 1210-011
  * @version November 7, 2018
  */
public class BlueDiamondCardholder extends DiamondCardholder {
   
   protected int bonusPurchasePoints = 2500;
   
   /** Constructor for this class.
     * @param acctNumberIn Command line arguments- not used.
     * @param nameIn Command line arguments- not used.
     */
   public BlueDiamondCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Blue Diamond Cardholder";
      discountRate = 0.10;  
   }
   /** Getter for bonus purchase points.
     * @return bonusPurchasePoints.
     */
   public int getBonusPurchasePoints() {
      return bonusPurchasePoints;
   }
   /** Setter for bonus purchase points.
     * @param bonusPurchasePointsIn Command line arguments- not used.
     */
   public void setBonusPurchasePoints(int bonusPurchasePointsIn) {
      bonusPurchasePoints = bonusPurchasePointsIn;
   }
   /** Overrided purchasePoints() method.
     * @return purchasePoints.
     */
   public int purchasePoints() {
      int purchasePoints = (int) (super.totalPurchases() / 1) * 5;
      if (super.totalPurchases() > 2500) {
         purchasePoints += bonusPurchasePoints;
      }
      return purchasePoints;
   
   }
   /** Overrided toString() method.
     * @return card information.
     */
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0");
      if (super.totalPurchases() > 2500) {
         return super.toString() + "\n(includes " 
                                 + df.format(getBonusPurchasePoints())
                                 + " bonus points added to Purchase Points)";
      }
      else {
         return super.toString();
      }  
   }



















}