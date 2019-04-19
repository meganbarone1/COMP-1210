import java.util.Comparator;
/** Comparator class used to sort Cardholder[] by currentBalance.
  *
  * @author Megan Barone- COMP 1210-011
  * @version November 14, 2018
  */
public class CurrentBalanceComparator implements Comparator<Cardholder> {
   
   /** Compare method.
     * @param ch Command line arguments- not used.
     * @param ch2 Command line arguments- not used.
     * @return an int.
     */
   public int compare(Cardholder ch, Cardholder ch2) {
     	
      
      if (ch.currentBalance() > ch2.currentBalance()) {
         
         return -1;
      }
      else if (ch.currentBalance() < ch2.currentBalance())  {
         
         return 1;
      }
      else {
         
         return 0;
      }
      
     	
   }















}