import java.util.Arrays;
import java.text.DecimalFormat;
/** CardHolder class.
  *
  * @author Megan Barone- COMP 1210-011
  * @version November 7, 2018
  */
public abstract class Cardholder implements Comparable<Cardholder> {
   
   protected String category, acctNumber, name;
   protected double prevBalance, payment;
   protected double[] purchases;
   /**
     */
   public static final double INTEREST_RATE = 0.01;
   
   /** Class constructor.
     * @param acctNumberIn Command line arguments- not used.
     * @param nameIn Command line arguments- not used.
     */
   public Cardholder(String acctNumberIn, String nameIn) {
      acctNumber = acctNumberIn;
      name = nameIn;
      purchases = new double[0];
   }
   /** Setter for acctNumber.
     * @param acctNumberIn Command line arguments- not used.
     */
   public void setAcctNumber(String acctNumberIn) {
      acctNumber = acctNumberIn;
   }
   /** Getter for acctNumber.
     * @return acctNumber.
     */
   public String getAcctNumber() {
      return acctNumber;
   }
   /** Setter for name.
     * @param nameIn Command line arguments- not used.
     */
   public void setName(String nameIn) {
      name = nameIn;
   }
   /** Getter for name.
     * @return name.
     */
   public String getName() {
      return name;
   }
   /** Setter for prevBalance.
     * @param prevBalanceIn Command line arguments- not used.
     */
   public void setPrevBalance(double prevBalanceIn) {
      prevBalance = prevBalanceIn;
   }
   /** Getter for prevBalance.
     * @return prevBalance.
     */
   public double getPrevBalance() {
      return prevBalance;
   } 
   /** Setter for payment.
     * @param paymentIn Command line arguments- not used.
     */
   public void setPayment(double paymentIn) {
      payment = paymentIn;
   } 
   /** Getter for payment.
     * @return payment.
     */
   public double getPayment() {
      return payment;
   }
   /** Setter for purchases.
     * @param purchasesIn Command line arguments- not used.
     */
   public void setPurchases(double[] purchasesIn) {
      purchases = purchasesIn;
   }
   /** Getter for purchases.
     * @return purchases.
     */
   public double[] getPurchases() {
      return purchases;
   }
   /** Method for adding purchases to array.
     * @param purchasesToAdd Command line arguments- not used.
     */
   public void addPurchases(double... purchasesToAdd) {
   
      for (int i = 0; i < purchasesToAdd.length; i++) {
         purchases = Arrays.copyOf(purchases, purchases.length + 1);
         purchases[purchases.length - 1] = purchasesToAdd[i];
      }
   }
   /** Method for delete single purchase.
     * @param purchaseToDelete Command line arguments- not used. 
     */
   private void deleteSinglePurchase(double purchaseToDelete) {
      for (int i = 0; i < purchases.length; i++) {
         if (purchases[i] == (purchaseToDelete)) {
            for (int j = i; j < purchases.length - 1; j++) {
               purchases[j] = purchases[j + 1];
            }
            purchases = Arrays.copyOf(purchases, purchases.length - 1);
         
         }
      }
   }
   /** Method for deleting purchases to array.
     * @param purchasesToDelete Command line arguments- not used.
     */
   public void deletePurchases(double... purchasesToDelete) {
      for (int i = 0; i < purchasesToDelete.length; i++) {
         deleteSinglePurchase(purchasesToDelete[i]);
      } 
      
   }
   /** Method calculates interest.
     * @return interest amount.
     */
   public double interest() {
      return (prevBalance - payment) * INTEREST_RATE;
   }
   /** Method adds up purchases.
     * @return totalPurchases.
     */
   public double totalPurchases() {
      double totalPurchases = 0;
      for (int i = 0; i < purchases.length; i++) {
         totalPurchases += purchases[i];
      }
      return totalPurchases;
   }
   /** Method calculates balance.
     * @return balance.
     */
   public double balance() {
      return prevBalance + interest() + totalPurchases();
   }
   /** Method calculates current balance.
     * @return current balance.
     */
   public double currentBalance() {
      return prevBalance - payment + interest() + totalPurchases();
   }
   /** Method calculates minimum payment.
     * @return minPayment.
     */
   public double minPayment() {
      return currentBalance() * 0.03;
   }
   /** toString method.
     * @return result.
     */
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.00");
      DecimalFormat df2 = new DecimalFormat("#,##0");
      String result = category + "\nAcctNo/Name: " + getAcctNumber() 
                      + " " + getName()
                      + "\nPrevious Balance: $" + df.format(getPrevBalance()) 
                      + "\nPayment: ($" + df.format(getPayment()) + ")" 
                      + "\nInterest: $" + df.format(interest())
                      + "\nNew Purchases: $" + df.format(totalPurchases())
                      + "\nCurrent Balance: $" + df.format(currentBalance())
                      + "\nMinimum Payment: $" + df.format(minPayment())
                      + "\nPurchase Points: " + df2.format(purchasePoints());
      return result;
   }
   /** Abstract method.
     * @return purchasePoints as an int.
     */
   public abstract int purchasePoints();
   /** compareTo method compares two strings (name).
     * @param ch Command line arguments- not used,
     * @return result
     */
   public int compareTo(Cardholder ch) {
      return this.getName().compareToIgnoreCase(ch.getName());
        
   }















}