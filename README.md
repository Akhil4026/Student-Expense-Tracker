# Student Expense Tracker

## Overview
Student Expense Tracker is a Java console application designed
to help students manage and monitor their daily expenses.

## Features
- Add expense
- View all expenses
- Search expenses by category
- Delete expense
- Calculate total spending
- Save and load expenses using CSV file handling

## Technologies Used
- Java
- OOP
- ArrayList
- File Handling
- Git and GitHub

## Project Structure
src/
├── Main.java
├── model/
├── service/
├── util/
└── ui/

## How to Run

Compile:
javac -d out src/Main.java src/model/Expense.java src/service/ExpenseManager.java src/util/FileHandler.java src/ui/ExpenseMenu.java

Run:
java -cp out Main

## Future Enhancements
- Monthly budget tracking
- Graphical user interface
- Database integration
- Login system
- Monthly expense reports
