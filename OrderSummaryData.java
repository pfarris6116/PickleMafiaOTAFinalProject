/*******************************************************************************

OrderSummaryData is a Java class that acts as the database for storing information while the application is in use.

*///////////////////////////////////////////////////////////////////////////////

package ThePickleApp;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.*;



public class OrderSummaryData {
    
    private String clientName;
    private int orderNum;
    
    private String summary;
    private String totals;
    private String combo;
    
    private int step;
    
    private String item;
    private int Qty;
    private double price;
    private int catNum;
    

    public OrderSummaryData (){
        
        this.clientName = "";
        this.orderNum = 000;
        this.summary = "";
        this.totals = "";
        this.combo = "";
        this.step = -1;
        this.item = "";
        this.Qty = 0;
        this.price = 0.00;
        this.catNum = 0;
        
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    // Setters
    public void setName (String clientName){
        this.clientName = clientName;
    }
    
    public void setOrderNum (){
        Random rand = new Random();
        this.orderNum = rand.nextInt(999);
    }
    
    public void setItem (String item){
        this.item = item;
    }
    
    public void setQty (int Qty){
        this.Qty = Qty;
    }
    
    public void setPrice (int price){
        this.price = price;
    }
    
    public void setCatNum (int catNum){
        this.catNum = catNum;
    }
    
//////////////////////////////////////////////////////////////////////////////// 
    
    // Getters
    public String getName (){
        return clientName;
    }
    
    public int getOrderNum (){
        return orderNum;
    }
    
    public String getItem (){
        return item;
    }
    
    public int getQty (){
        return Qty;
    }
    
    public double getPrice (){
        return price;
    }
    
    public int getCatNum (){
        return catNum;
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    // methods for Step integer
    public void setStep (int step){
        this.step = step;
    }
    
    public void incrementStep (int step){
        this.step += step;
    }
    
    public int getStep (){
        return step;
    }
    
////////////////////////////////////////////////////////////////////////////////   
    
    // methods for Summary
    public String getSummaryHeader () {
        return String.format("\n%56s%5s\n\n %90s %5s \n %100s \n", "", "-----------------------------------------------------------------", "Order", orderNum, clientName);
    }
    
    public String getSummaryItem() {
        return String.format("\n%58s%-10s %-35s %-10s $%.2f", Qty, "x", item, "", (price * Qty));
    }
    
    public void setSummary(){
        this.summary = getSummaryHeader();
    }
    
    public void addItemToSummary(){
        this.summary += getSummaryItem();
    }
    
    public void addComboToSummary(){
        this.summary += getCombo();
    }
    
    public void addTotalsToSummary(){
        this.summary += getTotals();
    }
    
    public String getSummary(){
        return summary;
    }
    
//////////////////////////////////////////////////////////////////////////////// 
    
    // methods for Combo
    public void resetCombo(){
        this.combo = "";
    }
    
    public void setCombo(){
        this.combo = String.format("\n\n%61s\n", "Combo");   // add prices
    }
    
    public void addToCombo(){
        this.combo += String.format("%58s%-10s %-35s %-10s $%.2f\n", "1", "x", item, "", price);
    }
    
    public String getCombo(){
        return combo;
    }
    
////////////////////////////////////////////////////////////////////////////////    
    
    // methods for Totals
    public void setTotals(){
        // filter out current summary, splice out the prices
        String sum = getSummary();
        String regex = "\\$\\d+";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sum);

        // List to store the prices
        ArrayList<String> matchedPrices = new ArrayList<>();

        // Find all prices in the string
        while (matcher.find()) {
            // Add the matched price to the list
            matchedPrices.add(matcher.group());
        }

        double SubTotal = 0.0;
        
        // Output the extracted prices
        System.out.println("Matched Prices:");
        for (String priced : matchedPrices) {
            String priceWithoutDollar = priced.substring(1); // Removes the '$' character
            double cost = Double.parseDouble(priceWithoutDollar); // Convert to double
            SubTotal += cost; // Add to SubTotal
        }
        
        double Tax = 0.07 * SubTotal;
        double Total = SubTotal + Tax;
        this.totals = String.format("\n\n%65s%5s\n%65s%60s$%.2f\n%60s%69s$%.2f\n%62s%66s$%.2f", "", "---------------------------------------------------", "Subtotal:", "", SubTotal, "Tax:", "", Tax, "Total:", "", Total);
    }
    
    public String getTotals(){
        return totals;
    }
    
}

