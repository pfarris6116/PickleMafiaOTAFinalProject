# Restaurant Order Taking Application (The Pickle Mafia)

A desktop GUI application built in Java that simulates a restaurant order-taking system. Order takers can input customer details, select menu items (including combo meals), validate inputs, calculate totals with tax, and generate printable order summaries. Orders are saved to an external file for persistence.

**Semester Project** – Programming 2, Volunteer State Community College (Fall 2024)

<img width="655" height="378" alt="Splash" src="https://github.com/user-attachments/assets/4a19e695-2428-477c-a342-4e96d8700ea0" />

## Features
- **Multi-screen GUI** using Java Swing (JFrame, JRadioButton, JComboBox, JTextArea, etc.)
- Customer name input with validation
- Menu selection: Combo Meal, Burgers, Sides, or Drinks
- Combo meal support with step-by-step category navigation (Burger → Sides → Drinks)
- Item selection with quantity (1–5) and dynamic radio button population from file
- Real-time order summary with calculated subtotal, 7% tax, and grand total
- View all previous orders stored in `summary.txt`
- Option to add more items, start a new order, or exit
- Data persistence using external text files (`system.txt` for menu items, `summary.txt` for orders)
- Input validation and user-friendly error messages

## Technologies & Skills Demonstrated
- **Java** (core language, OOP principles)
- **Java Swing** – Event-driven GUI with multiple interconnected JFrames
- **File I/O** – Reading from `system.txt` and appending to `summary.txt` using BufferedReader/BufferedWriter
- **Data Structures** – ArrayList for menu items, custom data model class
- **Object-Oriented Design** – Multiple classes with clear separation of concerns (UI vs. data logic)
- Regular Expressions for parsing prices in totals calculation
- Random order number generation
- Event handling for buttons and user interactions

## Project Structure
- **ThePickleMafiaApp.java** – Main entry point, file handling, and shared logic
- **OrderSummaryData.java** – Central data model (stores name, order number, items, combo logic, totals)
- **SplashScreen.java** – Welcome screen + customer name input
- **MenuSelection.java** – Category selection (including combo meal flow)
- **ItemSelection.java** – Dynamic item selection with radio buttons and quantity
- **OrderSummary.java** – Displays current order + totals, view all orders, and navigation options

## How to Run
1. Ensure **Java JDK 8 or higher** is installed.
2. Place the following files in the project root:
   - `system.txt` (menu items and prices, comma-separated)
   - `summary.txt` (will be created/updated automatically)
3. Compile all Java files:
   ```bash
   javac ThePickleApp/*.java

<img width="621" height="388" alt="Menu Selection" src="https://github.com/user-attachments/assets/5fd2e1ba-e91b-4a4a-a1d6-fcdfca2a52ab" />
<img width="618" height="393" alt="Item Selection" src="https://github.com/user-attachments/assets/0c1efc0c-546a-492b-affb-2c9b1dc3cb7c" />
<img width="675" height="384" alt="Order Summary" src="https://github.com/user-attachments/assets/fa07aa8f-ed27-45ac-a563-3803fb985053" />

# What I Learned

Designing and connecting multiple GUI windows in an event-driven application
Managing application state across screens using a shared data object
Reading/writing external files for data persistence
Implementing complex flow logic (combo meals with steps)
Input validation and clean error handling for better user experience

This project strengthened my object-oriented programming, GUI development, and file-handling skills.

Developer: Parker L. Farris
Course: Programming 2 – Volunteer State Community College
Date: Fall 2024
GitHub: https://github.com/pfarris6116/PickleMafiaOTAFinalProject
