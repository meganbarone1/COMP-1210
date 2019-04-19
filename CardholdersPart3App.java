import java.io.FileNotFoundException;
/** Driver class for cardholders.
  * 
  * @author Megan Barone- COMP 1210-011
  * @version November 28, 2018
  */
public class CardholdersPart3App {
    /** Main method.
      * @param args Command line arguments- used for file name.
      * @throws FileNotFoundException if file is not found.
      */
   public static void main(String[] args) throws FileNotFoundException {
      if (args.length == 0) {
         System.out.print("File name expected as command line argument."
                           + "\nProgram ending.\n");
         return;
      }
      
      String filepath = args[0];
      try {
         CardholderProcessor processor = new CardholderProcessor();
      
         processor.readCardholderFile(filepath);
         System.out.print(processor.generateReport());
         System.out.print(processor.generateReportByName());
         System.out.print(processor.generateReportByCurrentBalance());
         System.out.print(processor.generateInvalidRecordsReport());
      }
      catch (FileNotFoundException e) {
         System.out.println(" *** Attempted to read file: " + filepath 
                        + " (No such file or directory)");
      }
   } 









}



















