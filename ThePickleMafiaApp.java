/*******************************************************************************

Parker Farris
Programming 2 Semester Project
December 5, 2024
Final Semester Project

This is my semester project for Programming 2 at Volunteer State Community College during the Fall 2024 term.
This program is a Restaurant Order Taking Application that will take input from an order taker, process that input, and display a summary of what the customer ordered. 

////////////////////////////////////////////////////////////////////////////////

REQUIREMENTS

1.	Create an application that will take a customer’s order input and print a summary for the order taker.
2.	All menus will take the form of a Graphics User Interface (GUI). This will require an object-oriented JFrame approach.
3.	The application will allow the user to input data.
4.	The application will display a summary and total based on the input data.
5.	The application will validate the data and provide appropriate error messages.
6.	The application will retrieve and store data to and from external sources.
7.	The application will allow the user to take another order without having to restart the program, or allow the user to end the program.

////////////////////////////////////////////////////////////////////////////////

INPUTS

1.	SplashScreen - Customer's Name, Continue/Exit Button
2.	MenuSelection - Menu Radio Button Choice, Continue/Exit Button
3.	ItemSelection - Item Radio Button Choice, Quantity Combo Box, Continue/Exit Button
4.	OrderSummary - Add Item/All Orders/New Order/Exit Buttons

////////////////////////////////////////////////////////////////////////////////

OUTPUTS

1.	ItemSelection - Item Radio Buttons Text, Quantity Combo Box Values(Visible or Hidden)
2.	OrderSummary - Order Number and Customer Name, Items, Quantity Ordered, and Price of the Items, Tax, Subtotal, and Total

*///////////////////////////////////////////////////////////////////////////////

package ThePickleApp;

import java.util.ArrayList;
import javax.swing.JFrame;
import java.io.*;



public class ThePickleMafiaApp {

    static JFrame ss, ms, is, os;   // splash screen, menu selection, item selection, order summary
    static OrderSummaryData oData = new OrderSummaryData();
    private static final String SYSTEMFILENAME = "system.txt";       // file name to get items and prices from
    private static final String SUMMARYFILENAME = "summary.txt";     // file name to write the order summary to
    public static ArrayList<String> items = new ArrayList<String>(); // arraylist to store item and price info
    
    
    // Main method shows a new SplashScreen
    public static void main(String[] args) {
        
        //Create the first screen of the application
       ss = new SplashScreen();
       ss.setVisible(true);
    }
    
    // createOrder method starts a new order by calling the fillInArray method and adding a summary header to the summary string
    public static void createOrder(String headerDetails) {
        
        // called by Splash Screen, set name and random orderNum
        fillInArray();
        oData.setSummary();
    }
    
    // fillInArray method reads the system file and adds the item/price data to the items arraylist
    public static void fillInArray() {
        
        // read system file, create array by separating item and price
        try (BufferedReader reader = new BufferedReader(new FileReader(SYSTEMFILENAME))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");  // Separate item and price by comma
            if (parts.length == 2) {
                String itemName = parts[0].trim();
                String itemPrice = parts[1].trim();
                items.add(itemName + " - " + itemPrice);  // Add formatted item
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // saveOrder method gets and writes the summary string to the summary file
    public static void saveOrder() {
        String summary = oData.getSummary();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SUMMARYFILENAME, true))) {
        writer.write("\n\n" + summary);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    // readSummaries method reads the summary file and returns all stored summaries as a string
    public static String readSummaries() {
        StringBuilder orderContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(SUMMARYFILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                orderContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return(orderContent.toString());

    }
    
}
