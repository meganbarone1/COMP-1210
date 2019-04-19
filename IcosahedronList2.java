import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;
/** 
  * Represents an array of icosahedrons.
  *
  * @author Megan Barone- COMP 1210-011
  * @version October 3, 2018
  */
public class IcosahedronList2 {
// Instance variables for name of list and array of icosahedrons
   private String listName;
   private Icosahedron[] icosahedrons;
   private int numOfIcos;

/** Constructor.
  * @param listNameIn is list name.
  * @param icosahedronsIn is array.
  * @param numOfIcosIn is length of array.
  */
   public IcosahedronList2(String listNameIn, 
      Icosahedron[] icosahedronsIn, int numOfIcosIn)
   {
      listName = listNameIn;
      icosahedrons = icosahedronsIn;
      numOfIcos = numOfIcosIn;
   }
// Methods 
   /** Gets name of icosahedron list.
     * @return listName represents this.
     */
   public String getName() {
      return listName;
   }   
   /** Returns number of icosahedrons in list.
     * @return icosahedron.size() represents this.
     */   
   public int numberOfIcosahedrons() {       
      return numOfIcos;
   }

   /** Returns total surface area for all icosahedrons in list.
     * @return totalSA represents this.
     */
   public double totalSurfaceArea() {
      double totalSA = 0.0;
      int index = 0;
      while (index < numOfIcos) {
         totalSA += icosahedrons[index].surfaceArea();
         index++;
      }  
      return totalSA;       
   }
   /** Returns total volume for all icosahedrons in list.
     * @return totalV represents this.
     */
   public double totalVolume() {
      double totalV = 0.0;
      int index = 0;
      while (index < numOfIcos) {
         totalV += icosahedrons[index].volume();
         index++;
      }
      return totalV;
   }
   /** Returns average surface area of all icsoahedrons.
     * @return total represents this.
     */
   public double averageSurfaceArea() {
      double total = 0.0;
      int index = 0;
      while (index < numOfIcos) {
         total += icosahedrons[index].surfaceArea();
         index++;
      }
      if (total == 0) {
         return 0;
      }
      return total / numOfIcos;
   }
   /** Returns average volume of all icosahedrons.
     * @return total represents this.
     */
   public double averageVolume() {
      double total = 0.0;
      for (int index = 0; index < numOfIcos; index++) {
         total += icosahedrons[index].volume();
      }
      if (total == 0) {
         return 0.0;
      }
      return total / numOfIcos;
   }
   /** Returns average surface area to volume ratio for all icosahedrons.
     * @return total represents this.
     */
   public double averageSurfaceToVolumeRatio() {
      double total = 0.0;
      int index = 0;
      while (index < numOfIcos) {
         total += icosahedrons[index].surfaceToVolumeRatio();
         index++;
      }
      if (total == 0) {
         return 0;
      }
      return total / numOfIcos;
   }

   
   /** @return String for icosahedron list.
     */
   public String toString() {
      String result = listName + "\n";
      int index = 0;
      while (index < numOfIcos) {
         result += "\n" + icosahedrons[index] + "\n"; 
         index++;  
      }   
      return result;
   }
   /** @return summary information for icosahedron list.
     */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String result = "";
      result += "----- Summary for " + getName() + " -----"; 
      result += "\nNumber of Icosahedrons: " + numberOfIcosahedrons();
      result += "\nTotal Surface Area: " + df.format(totalSurfaceArea());
      result += "\nTotal Volume: " + df.format(totalVolume());
      result += "\nAverage Surface Area: " + df.format(averageSurfaceArea());
      result += "\nAverage Volume: " + df.format(averageVolume());
      result += "\nAverage Surface/Volume Ratio: "  
         + df.format(averageSurfaceToVolumeRatio());
      
      return result;
   }
   /** Gets list.
     * @return icosahedrons list
     */
   public Icosahedron[] getList() {
      return icosahedrons;     
   }
   /** Reads file from user input.
     * @param fileNameIn is file to be read
     * @return iL is icoahedron object
     * @throws FileNotFoundException if file cannot be opened
     */
   public IcosahedronList2 readFile(String fileNameIn) 
                                 throws FileNotFoundException {
            
      Scanner scanFile = new Scanner(new File(fileNameIn));
      Icosahedron[] myList = new Icosahedron[100];
      String iListName = "";
      int numIcos = 0;
      String label = "", color = "";
      double edge = 0;
      
      listName = scanFile.nextLine(); 
           
      while (scanFile.hasNext()) {
         label = scanFile.next();
         color = scanFile.next();
         edge = Double.parseDouble(scanFile.next());
         
         Icosahedron icos = new Icosahedron(label, color, edge);
         myList[numIcos] = icos;
         numIcos++;           
      }
      IcosahedronList2 iL = new IcosahedronList2(listName, myList, numIcos);
      return iL;
   }  
   /** Adds icosahedron to the list.
     * @param labelIn icosahedron label
     * @param colorIn icosahedron color
     * @param edgeIn icosahedron edge length
     */
   public void addIcosahedron(String labelIn, String colorIn, double edgeIn) {
      Icosahedron icos = new Icosahedron(labelIn, colorIn, edgeIn);
      icosahedrons[numOfIcos] = icos;
      numOfIcos++;              
   }
   /** Finds icosahedron in list.
     * @param labelIn icosahedron label
     * @return icos if one is found
     */
   public Icosahedron findIcosahedron(String labelIn) {
      for (int i = 0; i < numOfIcos; i++) {
         
         if (labelIn.equalsIgnoreCase(icosahedrons[i].getLabel())) {
            return icosahedrons[i];  
         }
                 
      }
      return null;
   } 
   /** Deletes icosahedron from the list.
     * @param labelIn icosahedron label
     * @return icos if one is found and deleted
     */
   public Icosahedron deleteIcosahedron(String labelIn) {
      Icosahedron result = null;
         
      for (int i = 0; i < numOfIcos; i++) {
         if (icosahedrons[i].getLabel().equalsIgnoreCase(labelIn)) { 
            
            result = icosahedrons[i];
            for (int j = i; j < numOfIcos - 1; j++) {
               
               icosahedrons[j] = icosahedrons[j + 1];
            }
            icosahedrons[numOfIcos - 1] = null; 
            numOfIcos--;
            
            break;
         }
      }
      return result;
            
   }
   /** Returns true or false if icosahedron is found and edited.
     * @param label icosahedron label
     * @param color icosahedron color
     * @param edge icosahedron edge length
     * @return true if icosahedron is edited
     */
   public boolean editIcosahedron(String label, String color, double edge) {
      Icosahedron icos = findIcosahedron(label);
      if (icos != null) {
         icos.setColor(color);
         icos.setEdge(edge);
         return true;
      }
      else {
         return false;
      }
   }
   /** Returns icosahedron from list with shortest edge.
     * @return icosShortestEdge is that.
     */
   public Icosahedron findIcosahedronWithShortestEdge() {
      double shortest = 0;
      Icosahedron icosShortestEdge = null;
      
      if (numOfIcos > 0) {
         shortest = icosahedrons[0].getEdge();
         icosShortestEdge = icosahedrons[0];
      }
      for (int index = 0; index < numOfIcos; index++) {
         if (shortest > icosahedrons[index].getEdge()) {
            shortest = icosahedrons[index].getEdge();
            icosShortestEdge = icosahedrons[index];
         }
      }
      return icosShortestEdge;
   }
   /** Returns icosahedron from list with longest edge.
     * @return icosLongestEdge is that.
     */
   public Icosahedron findIcosahedronWithLongestEdge() {
      double longest = 0;
      Icosahedron icosLongestEdge = null;
      
      if (numOfIcos > 0) {
         longest = icosahedrons[0].getEdge();
         icosLongestEdge = icosahedrons[0];
      }
      for (int index = 1; index < numOfIcos; index++) {
         if (longest < icosahedrons[index].getEdge()) {
            longest = icosahedrons[index].getEdge();
            icosLongestEdge = icosahedrons[index];
         }
      }
      return icosLongestEdge;
   }
  /** Returns icosahedron from list with smallest volume.
    * @return icosSmallestVolume is that.
    */
   public Icosahedron findIcosahedronWithSmallestVolume() {
      double smallest = 0;
      Icosahedron icosSmallestVolume = null;
      
      if (numOfIcos > 0) {
         smallest = icosahedrons[0].volume();
         icosSmallestVolume = icosahedrons[0];
      }
      for (int index = 1; index < numOfIcos; index++) {
         if (smallest > icosahedrons[index].volume()) {
            smallest = icosahedrons[index].volume();
            icosSmallestVolume = icosahedrons[index];
         }
      }
      return icosSmallestVolume;
   }
  /** Returns icosahedron from list with largest volume.
    * @return icosLargestVolume is that.
    */
   public Icosahedron findIcosahedronWithLargestVolume() {
      double largest = 0;
      Icosahedron icosLargestVolume = null;
      
      if (numOfIcos > 0) {
         largest = icosahedrons[0].volume();
         icosLargestVolume = icosahedrons[0];
      }
      for (int index = 0; index < numOfIcos; index++) {
         if (largest < icosahedrons[index].volume()) {
            largest = icosahedrons[index].volume();
            icosLargestVolume = icosahedrons[index];
         }
      }
      return icosLargestVolume;
   }
}







