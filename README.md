# Pickle Mafia Order Taking Application

A Java Swing GUI application that allows an order taker to input customer orders, validate data, calculate totals, and generate printable summaries. Built as a semester project for Programming 2 at Volunteer State Community College.

<img width="655" height="378" alt="Splash" src="https://github.com/user-attachments/assets/4a19e695-2428-477c-a342-4e96d8700ea0" />

## Features
- **Graphical User Interface** built with multiple JFrame windows (Splash Screen, Menu Selection, Item Selection, Order Summary)
- Supports different menu types with radio buttons and combo boxes for item and quantity selection
- Real-time order summary generation with calculated totals
- Data validation with appropriate error messages
- Persistent storage using external text files (`system.txt` for menu items and `summary.txt` for orders)
- Option to start a new order without restarting the program or exit cleanly
- Displays all previous orders from the summary file

## Technologies Used
- **Java** (core language)
- **Java Swing** (for all GUI components: JFrame, JButton, JLabel, JTextField, JRadioButton, JComboBox, JTextArea, etc.)
- File I/O with text files (reading/writing orders and menu data)
- Object-oriented design with multiple classes and static methods/variables
- Event-driven programming for button actions

## Project Structure
The application consists of the following main classes:

- **PickleApp2** — Main class handling program flow, file I/O, and order creation
- **SplashScreen** — Initial screen to capture customer name
- **MenuSelection** — Allows selection of menu type
- **ItemSelection** — Handles item and quantity input with validation
- **OrderSummary** — Displays the final order summary, total, and options to add more items, view all orders, or exit
- **OrderSummaryData** — Data model class for storing order details

Data is stored temporarily in arrays/ArrayList during runtime and persisted to `summary.txt`.

## How to Run the Application
1. Ensure you have **Java JDK** installed (compatible with Java 8+).
2. Clone or download the repository.
3. Place the required data files (`system.txt` and `summary.txt`) in the project root (or update file paths in code if needed).
4. Compile all `.java` files:
5. Run the main class:

The program will launch the Splash Screen. Follow the on-screen menus to take orders.

## Screenshots
<img width="621" height="388" alt="Menu Selection" src="https://github.com/user-attachments/assets/5fd2e1ba-e91b-4a4a-a1d6-fcdfca2a52ab" />
<img width="618" height="393" alt="Item Selection" src="https://github.com/user-attachments/assets/0c1efc0c-546a-492b-affb-2c9b1dc3cb7c" />
<img width="675" height="384" alt="Order Summary" src="https://github.com/user-attachments/assets/fa07aa8f-ed27-45ac-a563-3803fb985053" />

- Opening / Splash Screen
- Menu Selection
- Item Selection
- Order Summary

## What I Learned
- Building event-driven GUI applications with Java Swing
- Managing multiple windows and data flow between screens
- Reading from and writing to external files for persistence
- Input validation and error handling in a user-friendly interface
- Structuring a larger OOP project with separate classes for UI and data

This project demonstrates my ability to create functional desktop applications with clean user interfaces and proper data handling.

## Repository
**GitHub**: [https://github.com/pfarris6116/PickleMafiaOTAFinalProject]

---

**Created by**: Parker Farris  
**Course**: Programming 2, Volunteer State Community College  
**Semester**: Fall 2024
