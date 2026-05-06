# Restaurant Table Reservation System

A comprehensive group project for Data Structures and Algorithms implementing a restaurant table reservation management system with advanced features.

## 📋 Project Overview

This is a Java-based command-line application that manages restaurant table reservations using various data structures:

- **Stack** - For available tables management
- **LinkedList** - For active reservations
- **Queue** - For waiting list management
- **Recursive functions** - For searching and displaying reservations

### Features

✅ Add new reservations  
✅ Cancel existing reservations  
✅ View all current reservations  
✅ View waiting list  
✅ Show available tables  
✅ Automatic promotion from waiting list when tables become available  
✅ Input validation with custom exceptions  
✅ Colored console interface  
✅ Developer options for system monitoring

---

## 👥 Team Members

**Group Name:** Anubis

**Institution:** Mae Fah Luang University  
**School:** Applied Digital Technology  
**Major:** Software Engineering  
**Project Type:** First Year Java DSA Group Project

**Members:**

- 6831503002 - Mr. Aung Kyaw Min Htet
- 6831503011 - Mr. Kyaw Zin Htike
- 6831503022 - Mr. Kaung Sett Paing
- 6831503119 - Mr. Bhone Pyae Ko

**Created Date:** May 6, 2026  
**Version:** 1.0.0.0

---

## 🏗️ Project Structure

```
restaurant_table_reservation/
├── README.md
├── .git/
└── main/
    ├── Main.java                 (Entry point)
    ├── core/
    │   ├── ReservationSystem.java (Business logic)
    │   └── Reservation.java       (Data model)
    ├── util/
    │   ├── ConsoleHelper.java     (UI formatting)
    │   ├── Color.java             (ANSI color codes)
    │   ├── Validation.java        (Input validation)
    │   └── DeveloperOptions.java  (Debug features)
    └── exception/
        ├── InvalidNameException.java
        ├── InvalidPeopleException.java
        ├── InvalidReservationException.java
        ├── NoTablesAvailableException.java
        └── ReservationNotFoundException.java
```

---

## 📦 Prerequisites

Before running this project, ensure you have:

- **Java 21+** installed ([Download](https://www.oracle.com/java/technologies/downloads/))
- **Git** for version control (optional)
- A terminal/command prompt

### Verify Java Installation

```bash
java -version
```

Expected output:

```
java version "21.0.5"
```

---

## 🚀 Setup Instructions

### Step 1: Clone or Download the Project

**Using Git:**

```bash
git clone <repository-url>
cd restaurant_table_reservation
```

**Or download and extract the ZIP file**

### Step 2: Navigate to Project Directory

```bash
cd /Users/akmh/Desktop/restaurant_table_reservation
```

### Step 3: Create Build Directory

```bash
mkdir -p bin
```

---

## ▶️ How to Run

### Quick Start (One Command)

```bash
mkdir -p bin && javac -d bin main/**/*.java && java -cp bin main.Main
```

### Step-by-Step Execution

**Step 1: Compile all Java files**

```bash
javac -d bin main/**/*.java
```

**Step 2: Run the application**

```bash
java -cp bin main.Main
```

### Expected Output

```
╔══════════════════════════════════════╗
║   RESTAURANT RESERVATION SYSTEM      ║
╠══════════════════════════════════════╣
║  1. Add Reservation                  ║
║  2. Cancel Reservation               ║
║  3. View Reservations                ║
║  4. View Waiting List                ║
║  5. Show Available Tables            ║
║  6. Developer Info                   ║
║  7. Exit                             ║
╚══════════════════════════════════════╝

Enter your choice: _
```

---

## 📖 Usage Guide

### 1. Add Reservation

- **Select:** Option 1
- **Enter:** Customer name (letters and spaces only)
- **Enter:** Number of people (positive integer)
- **Result:** Reservation confirmed or added to waiting list

### 2. Cancel Reservation

- **Select:** Option 2
- **Enter:** Customer name to cancel
- **Result:** Reservation cancelled, table freed, waiting customer promoted if applicable

### 3. View Reservations

- **Select:** Option 3
- **Shows:** All current confirmed reservations with details

### 4. View Waiting List

- **Select:** Option 4
- **Shows:** Customers waiting for available tables

### 5. Show Available Tables

- **Select:** Option 5
- **Shows:** List of currently available tables

### 6. Developer Info

- **Select:** Option 6
- **Shows:** Project information and team details

### 7. Exit

- **Select:** Option 7
- **Action:** Safely exits the application

---

## 🔧 Technical Details

### Data Structures Used

| Data Structure | Purpose             | Usage                                               |
| -------------- | ------------------- | --------------------------------------------------- |
| **Stack**      | Available Tables    | LIFO - Last table assigned is first to be reused    |
| **LinkedList** | Active Reservations | Easy insertion and deletion of reservations         |
| **Queue**      | Waiting List        | FIFO - First customer to wait is first to get table |

### Algorithms Implemented

- **Recursive Search** - Find reservations by customer name
- **Recursive Display** - Show all reservations recursively
- **Validation Loops** - Input validation until valid data

### Exception Handling

Custom exceptions ensure robust error handling:

- `InvalidNameException` - Invalid customer name
- `InvalidPeopleException` - Invalid party size
- `ReservationNotFoundException` - Reservation not found
- `NoTablesAvailableException` - No tables available
- `InvalidReservationException` - General reservation errors

---

## 🎨 Features Explained

### Input Validation

- All user inputs are validated in `Validation.java`
- Name must contain only letters and spaces
- Party size must be positive integer
- Menu choices must be 1-7
- Invalid inputs loop until valid

### Exception Handling

- Try-catch blocks in `Main.java` handle all exceptions
- User-friendly error messages displayed
- Program continues running after errors

### Automatic Promotion

When a reservation is cancelled:

1. Table is returned to available tables
2. First customer from waiting list is automatically promoted
3. New reservation created with assigned table
4. Confirmation message displayed

### Developer Options

Access developer features for testing and monitoring (Option 6):

- View system information
- Check system stats
- View team information

---

## 🐛 Troubleshooting

### Error: "javac: command not found"

**Solution:** Java compiler is not in PATH. Install Java or add to PATH.

### Error: "Cannot find symbol"

**Solution:** Make sure all files are in correct directories. Run:

```bash
javac -d bin main/**/*.java
```

### Error: "main.Main not found"

**Solution:** Ensure you're in the correct directory and used `-d bin` flag.

### Program exits unexpectedly

**Solution:** Check error messages. Invalid input might cause exception. Use try-catch blocks.

---

## 📝 Example Session

```
Enter your choice: 1
════════════════════════════════════════
                Add Reservation
════════════════════════════════════════
Enter name: John Smith
Number of people: 4
✓ Reservation for John Smith confirmed! Table 3 assigned.

Enter your choice: 2
════════════════════════════════════════
              Cancel Reservation
════════════════════════════════════════
Enter name: John Smith
✓ Reservation for John Smith cancelled. Table 3 is now free.

Enter your choice: 3
════════════════════════════════════════
             CURRENT RESERVATIONS
════════════════════════════════════════
ℹ No reservations at the moment.

Enter your choice: 7
ℹ Thank you for using Restaurant Reservation System!
Exiting...
```

---

## 📚 Learning Outcomes

This project demonstrates understanding of:

- ✅ Data structures (Stack, Queue, LinkedList)
- ✅ Exception handling (Custom exceptions)
- ✅ Recursion (Search and display functions)
- ✅ Object-oriented programming (Classes, encapsulation)
- ✅ Input validation and error handling
- ✅ User interface design
- ✅ Code organization and structure

---

## 🔗 Getting Help

If you encounter issues:

1. **Check the troubleshooting section above**
2. **Verify Java version:** `java -version`
3. **Check file structure** matches the project layout
4. **Look at error messages** for specific clues

---

## 📄 License

This project is created for educational purposes as part of Mae Fah Luang University's Software Engineering program.

---

## 🎉 Conclusion

Thank you for using the Restaurant Table Reservation System! This project showcases practical application of data structures and algorithms in a real-world scenario.

**Enjoy managing your restaurant reservations!** 🍽️
