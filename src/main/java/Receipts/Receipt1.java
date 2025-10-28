package Receipts;

/***  DIRECTIONS for Receipt2.java 
The receipt that was generated in Activity 1 prints literal values for each of the items, 
but that is not always the best practice. In this activity you will modify the code from Activity 1 
to include variables that will store your high school’s name and the prices of the items available at the snack bar. 

In your IDE, create a new file called Receipt2.java. 
Open the code from Activity 1, Receipt1.java (or use the code provided below) 
and copy and paste it into your new file. 
Be sure to rename the class Receipt2 so it matches the file name.  

Modify the code to include a variable for the high school’s name and variables for the 
prices of each item that is available on the snack bar menu. 
Be sure to use the most appropriate data types to store the values. 
Once the variables are declared and given initial values, 
use string concatenation to replace the statements that print the literal values that were given in Receipt1.java 
with the variables declared in this part. You will need to change the parameter in System.out.println. 

For example, instead of printing “Drink ...... $1.50”, 
you should print “Drink ......” followed by the value of the variable that stores the price of the drink. 
You might need to abbreviate the name of your high school so it fits on one line, 
or use a second line to accommodate the longer high school name. 
Run (and debug if needed) the program to be sure it prints the information in the correct format.
***/

/**
 * Receipt1.java  
 *
 * @author – Your name
 * @author – Class period
 */ 
public class Receipt1
{
   public static void main(String [] args)
   {
      System.out.println("**************************************");
      System.out.println("*                                    *");
      System.out.println("*     Trevor Packer HS Snack Bar     *");
      System.out.println("*                                    *");
      System.out.println("*     Drink ..........$1.50          *");                      
      System.out.println("*     Candy ..........$1.25          *");     
      System.out.println("*     Hot Dog ........$2.75          *");     
      System.out.println("*     Hamburger ......$3.50          *");     
      System.out.println("*                                    *");    
      System.out.println("**************************************");
   }
}