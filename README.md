# kotlin-lotto-precourse
# 🎲 Lotto Game Simulator (Kotlin)

A fully testable, modular, and cleanly-structured command-line Lotto simulator written in Kotlin. This project emphasizes separation of concerns, input validation, domain-driven design, and unit test coverage of all business logic.

---

## 📚 Overview

Users can purchase multiple lotto tickets, input winning numbers and a bonus number, and the system will evaluate the tickets, determine the prize ranks, and calculate the total profit rate.

Built with **readability**, **testability**, and **clean architecture** in mind.

---

## ✅ Features

- Purchase lotto tickets based on input amount (1,000 KRW per ticket)
- Enter winning numbers and bonus number with **strict validation**
  - Each lottery ticket consists of 6 unique random numbers.
  - Numbers must be in the range from 1 to 45. 
  - The user then enters the winning numbers and a bonus number. 
  - The winning numbers consist of 6 unique numbers. 
  - The bonus number is a single, separate number.
- 🏆 Automatically determine rank of each ticket:
    - 1st: 6 numbers match
    - 2nd: 5 numbers + bonus match
    - 3rd: 5 numbers match
    - 4th: 4 numbers match
    - 5th: 3 numbers match
- Calculate and display total profit rate
- Fully tested domain and service logic

---
## 🏗️ Project Structure
```
📦 lotto/
├── Application.kt               // Entry point of the application
│── Lotto.kt                     // Manages lotto numbers
├── domain/                      // Classes related to domain objects
│   ├── LottoTicket.kt           // Represents a single lotto ticket
│   └── Rank.kt                  // Enum representing lotto ranks
├── service/                     // Service layer: business logic processing
│   └── LottoService.kt          // Service that handles lotto-related logic
├── view/                        // Handles user input and output
│   ├── InputView.kt             // Responsible for handling input
│   └── OutputView.kt            // Responsible for displaying output
├── util/                        // Utility classes
│   ├── RandomUtil.kt            // Generates random lotto numbers
│   └── InputValidator.kt        // Validates user input
├── test/                        // Test code
│   ├── domain/                  // Tests for the domain package
│   ├── service/                 // Tests for the service package
│   └── util/                    // Tests for the util package
└── README.md                    // List of features and implementation notes

```

## 💻 Example
```text
Example Execution
Please enter the purchase amount.
8000

You have purchased 8 tickets.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

Please enter last week's winning numbers.
1,2,3,4,5,6

Please enter the bonus number.
7

Winning Statistics
---
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
Total return rate is 62.5%.
```