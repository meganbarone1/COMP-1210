/** This class represents a Sapphire Cardholder. Inherits from CardHolder class.
  * 
  * @author Megan Barone- COMP 1210-011
  * @version November 7, 2018
  */
public class SapphireCardholder extends Cardholder {
   
   /** Constructor for this class.
     * @param acctNumberIn Command line arguments- not used.
     * @param nameIn Command line arguments- not used.
     */
   public SapphireCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Sapphire Cardholder";
   }
   /** Calculates purchase points for cardholder.
     * @return purchasePoints.
     */
   public int purchasePoints() {
      int purchasePoints = (int) super.totalPurchases() / 1;
      return purchasePoints;
   }











}