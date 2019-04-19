import java.util.Scanner;
import java.io.FileNotFoundException;
/** This class is used alongside Icosahedron and IcosahedronList.
  * Makes a menu for user to choose from options read file, add, delete, 
  * find, edit, print, or quit.
  * 
  * @author Megan Barone- COMP 1210-011   
  * @version October 9, 2018
  */
public class IcosahedronList2MenuApp {
   /** Main method that sets up menu and creates a scanner.
     *
     * @param args is not used.
     * @throws FileNotFoundException if file is not found.
     */
   public static void main(String[] args) throws FileNotFoundException
   {
      String iListName = "*** no list name assigned ***";
      Icosahedron[] myList = new Icosahedron[100];
      IcosahedronList2 myIList = new IcosahedronList2(iListName, myList, 0);
      String fileName = "no file name";
     
      String label, color;
      double edge;
     
      String code = "";
     
      Scanner scan = new Scanner(System.in);
     
      System.out.println("Icosahedron List System Menu\n"
                     + "R - Read File and Create Icosahedron List\n"
                     + "P - Print Icosahedron List\n"
                     + "S - Print Summary\n"
                     + "A - Add Icosahedron\n"
                     + "D - Delete Icosahedron\n"
                     + "F - Find Icosahedron\n"
                     + "E - Edit Icosahedron\n"
                     + "Q - Quit");
                     
                     
                     
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = scan.nextLine();
         if (code.length() == 0) {
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch(codeChar) {
            case 'R': // Read in File and Create IcosahedronList
               System.out.print("\tFile name: ");
               fileName = scan.nextLine();
            
               myIList = myIList.readFile(fileName);
            
               System.out.println("\tFile read in and "
                              + "Icosahedron List created\n");
               break; 
               
            case 'P':
               System.out.println(myIList);
               break;
               
            case 'S':
               System.out.println("\n" + myIList.summaryInfo() + "\n");
               break;
               
            case 'A':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tColor: ");
               color = scan.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(scan.nextLine());
               myIList.addIcosahedron(label, color, edge);
               System.out.println("\t*** Icosahedron added ***\n");
               break;
            case 'D':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               Icosahedron icosDelete = myIList.deleteIcosahedron(label);
               if (icosDelete != null) {
                  System.out.println("\t\"" + icosDelete.getLabel() 
                     + "\" deleted\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
            case 'F': 
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               Icosahedron icosFind; 
               
               if (myIList.findIcosahedron(label) != null) {
                  icosFind = myIList.findIcosahedron(label); 
                  System.out.println(icosFind + "\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               
               break;
                  
            case 'E': 
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tColor: ");
               color = scan.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(scan.nextLine());
               
               
               if (myIList.editIcosahedron(label, color, edge)) {
                  System.out.println("\t\"" + label + "\""  
                     + " successfully edited\n");
               }
               else {
                  System.out.println("\t\"" + label + "\"" + " not found\n");
               }
            
               break;
            
            case 'Q':
               break;
               
            default:
               System.out.println("\t*** invalid code ***\n");
               break;
         }         
      }  while (!code.equalsIgnoreCase("Q"));          
          
   
   
   
   
   
   
   
   
   
   
   }
}