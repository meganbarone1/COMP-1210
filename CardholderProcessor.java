import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
 /** This class creates a processor for cardholders,
  * including one cardholder array and one String array 
  * of invalid records.
  *
  * @author Megan Barone- COMP 1210-011
  * @version November 12, 2018
  */
public class CardholderProcessor {
   
   private Cardholder[] cardholders;
   private String[] invalidRecords;
   
   /** Constructor for class.
     */
   public CardholderProcessor() {
      cardholders = new Cardholder[0];
      invalidRecords = new String[0];
   }
   
   /** Getter for cardholders.
     * @return cardholders is an array.
     */
   public Cardholder[] getCardholdersArray() {
      return cardholders;
   }
   /** Getter for invalid records.
     * @return invalidRecords is an array.
     */
   public String[] getInvalidRecordsArray() {
      return invalidRecords;
   }
   /** This method adds cardholders to the array.
     * @param cardholderIn Command line arguments- not used.
     */
   public void addCardholder(Cardholder cardholderIn) {   
      cardholders = Arrays.copyOf(cardholders, cardholders.length + 1);
      cardholders[cardholders.length - 1] = cardholderIn;     
   }
   /** This method adds invalid records to the array.
     * @param recordIn Command line arguments- not used.
     */
   public void addInvalidRecord(String recordIn) {
      invalidRecords = Arrays.copyOf(invalidRecords, invalidRecords.length + 1);
      invalidRecords[invalidRecords.length - 1] = recordIn;
   }
   /** This method uses a scanner to add cardholders from a file.  
     * @throws FileNotFoundException if file is not found.
     * @param fileNameIn Command line arguments- not used.
     */
   public void readCardholderFile(String fileNameIn)
                                     throws FileNotFoundException {
                                     
      Scanner sc = new Scanner(new File(fileNameIn));
      Cardholder ch = null;
      
      
      while (sc.hasNext()) {
         String record = sc.nextLine();
         Scanner scanLine = new Scanner(record).useDelimiter(";");
         int category = Integer.parseInt(scanLine.next());
         String acctNumber = scanLine.next();
         String name = scanLine.next();
         
         
         
         try {
            
            
            
            double prevBalance, payment;
            
            
         
         
         
         
            if (category == 1) {
               
               
               ch = new SapphireCardholder(acctNumber, name);
                
               prevBalance = Double.parseDouble(scanLine.next());
               payment = Double.parseDouble(scanLine.next());
               
               ch.setPrevBalance(prevBalance);
               ch.setPayment(payment);
               while (scanLine.hasNext()) {
                  String newPurchases = scanLine.next();
                  double newPurchasesD = Double.parseDouble(newPurchases);
                  ch.addPurchases(newPurchasesD);
               }
               this.addCardholder(ch);      
              
            }     
            
            else if (category == 2) {
               
               
               ch = new DiamondCardholder(acctNumber, name);
               
               prevBalance = Double.parseDouble(scanLine.next());
               payment = Double.parseDouble(scanLine.next());
               
               ch.setPrevBalance(prevBalance);
               ch.setPayment(payment);
               while (scanLine.hasNext()) {
                  String newPurchases = scanLine.next();
                  double newPurchasesD = Double.parseDouble(newPurchases);
                  ch.addPurchases(newPurchasesD);
               }     
               this.addCardholder(ch);
            
            }
            else if (category == 3) {
               
               
               ch = new BlueDiamondCardholder(acctNumber, name);
               
               prevBalance = Double.parseDouble(scanLine.next());
               payment = Double.parseDouble(scanLine.next());
               
               ch.setPrevBalance(prevBalance);
               ch.setPayment(payment);
               while (scanLine.hasNext()) {
                  String newPurchases = scanLine.next();
                  double newPurchasesD = Double.parseDouble(newPurchases);
                  ch.addPurchases(newPurchasesD);
               }
               this.addCardholder(ch);     
               
            }
            else  {
               throw new InvalidCategoryException();
                                 
            }
         
         
         
            
         
         }
         catch (InvalidCategoryException e) {
            record += " *** invalid category ***";
            addInvalidRecord(record);
            continue;
         }
         
         catch (NumberFormatException e) {
            record += " *** invalid numeric value ***";
            addInvalidRecord(record);
            continue;
         }
         
      }
         
   }
   /** This method generates a monthly report.
     * @return result.
     */
   public String generateReport() {
     
      String result = "----------------------------\n"
                                 + "Monthly Cardholder Report\n"
                                 + "----------------------------\n";
      
      for (Cardholder ch : cardholders) {
         result += ch;
         result += "\n\n";
         
      }
      return result;
      
      
   }
   /** This method sorts monthly report by name.
     * @return result.
     */
   public String generateReportByName() {
      
      
      String result = "--------------------------------------\n"
                                 + "Monthly Cardholder Report (by Name)\n"
                                 + "--------------------------------------\n";
      
      Arrays.sort(cardholders);
            
      for (Cardholder ch : cardholders) {
         result += ch;
         result += "\n\n";
         
      }
      return result;
     
   }
   /** This method sorts monthly report by current balance.
     * @return result.
     */
   public String generateReportByCurrentBalance() {
   
   
      String result = "---------------------------------------\n"
                                 + "Monthly Cardholder Report "
                                 +  "(by Current Balance)\n"
                                 + "---------------------------------------\n";
      Arrays.sort(cardholders, new CurrentBalanceComparator());
     
      for (Cardholder ch : cardholders) {
         result += ch;
         result += "\n\n";
         
      }
      return result;
   }
   /** Creates a report for invalid records.
     * @return result is that report.
     */
   public String generateInvalidRecordsReport() {
      String result = "-----------------------\n"
                        + "Invalid Records Report\n"
                        + "-----------------------\n";
     
      for (String st : invalidRecords) {
         result += st;
         result += "\n\n";
      }
      return result;
                        
   }














}