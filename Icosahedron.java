import java.text.DecimalFormat;
/** This class defines an icosahedron
  * (including label, color, and edge) and
  * contains methods to find surface area, volume,
  * and surface to volume ratio of an icosahedron.
  * 
  * @author Megan Barone- COMP 1210
  * @version September 18, 2018 
  */
public class Icosahedron {
// instance variables
   private String label = "";
   private String color = "";
   private double edge = 0;
   private static int count = 0;
   
// constructor
   /** Sets up constructor.
     * @param label1 Command line arguments- not used.
     * @param color1 Command line arguments- not used.
     * @param edge1 Command line arguments- not used.
     */
   public Icosahedron(String label1, String color1, double edge1) {
      boolean didSetLabel = setLabel(label1);
      boolean didSetColor = setColor(color1);
      boolean didSetEdge = setEdge(edge1);
      count++;
   }
// methods
   /** Setter for label.
     * @param labelIn Command line arguments- not used.
     * @return true or false if label is set.
     */
   public boolean setLabel(String labelIn) {
      if (labelIn != null) {
         label = labelIn.trim();
         return true;
      }
      return false;
   }
   /** Setter for color.
     * @param colorIn Command line arguments- not used.
     * @return true or false if color is set.
     */
   public boolean setColor(String colorIn) {
      if (colorIn != null) {
         color = colorIn.trim();
         return true;
      }
      return false;  
   }
   /** Setter for edge.
     * @param edgeIn Command line arguments- not used.
     * @return true or false if edge is set.
     */
   public boolean setEdge(double edgeIn) {
      if (edgeIn > 0) {
         edge = edgeIn;
         return true;
      }
      return false;
   }
   /** Getter for label.
     * @return label based on user input.
     */
   public String getLabel() {
      return label;
   }
   /** Getter for color.
     * @return color based on user input.
     */
   public String getColor() {
      return color;
   }
   /** Getter for edge.
     * @return edge based on user input.
     */
   public double getEdge() {
      return edge;
   }
   /** Sets up surface area formula.
     * @return surfaceArea after user input is processed with formula.
     */ 
   public double surfaceArea() {
      double surfaceArea = 5 * Math.sqrt(3) * Math.pow(edge, 2);
      return surfaceArea;
   }   
   /** Sets up volume formula.
     * @return volume after user input is processed with formula.
     */
   public double volume() {
      double volume = ((5 * (3 + Math.sqrt(5)) * Math.pow(edge, 3) / 12));   
      return volume; 
   }
   /** Sets up surface to volume ratio formula.
     * @return surfaceToVolumeRatio based on user input into this formula.
     */
   public double surfaceToVolumeRatio() {
      double surfaceToVolumeRatio = surfaceArea() / volume();
      return surfaceToVolumeRatio;
   }
   /** String toString method
     * Sets up output needed.
     * @return output final for object icosahedron.
     */
   public String toString() {
      DecimalFormat formattedSurfaceArea = new DecimalFormat("#,##0.0#####");
      DecimalFormat formattedVolume = new DecimalFormat("#,##0.0#####");
      DecimalFormat formattedRatio = new DecimalFormat("#,##0.0#####");
      String output = "Icosahedron \"" + label + "\" is \"" + color
         + "\" with 30 edges of length " + edge + " units." + "\n" + "\t";
      output += "surface area = " + formattedSurfaceArea.format(surfaceArea())
         + " square units " + "\n" + "\t";
      output += "volume = " + formattedVolume.format(volume()) + " cubic units "
         + "\n" + "\t";
      output += "surface/volume ratio = " 
         + formattedRatio.format(surfaceToVolumeRatio()); 
      return output;
   }
   /** Gets count.
     * @return count is an int.
     */
   public static int getCount() {
      return count;
   }
   /** Resets count to 0.
     */
   public static void resetCount() {
      count = 0;
   }
   /** Checks if a certain Object is same as Icosahedron object.
     * @param obj is a particular Object.
     * @return true if so and false if not
     *
     */
   public boolean equals(Object obj) {
      if (!(obj instanceof Icosahedron)) {
         return false;
      }
      else {
         Icosahedron d = (Icosahedron) obj;
         return (label.equalsIgnoreCase(d.getLabel()) 
              && color.equalsIgnoreCase(d.getColor())
              && Math.abs(edge - d.getEdge()) < 0.000001);
      }
   }
  /** Returns 0.
    * @return 0.
    */
   public int hashCode() {
      return 0;
   }

}