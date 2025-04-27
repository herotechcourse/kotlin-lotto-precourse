# kotlin-lotto-precourse

# Lotto Game

## Project Introduction

This project is the Pre-course Week 2 assignment to implement a Lotto game based on specified requirements. It is a console application where users purchase lotto tickets by entering an amount, the application issues the tickets, the user inputs the winning numbers, and the bonus number, and finally, the application displays the winning statistics and the overall profit rate.

## Key Features

* **Purchase Lotto Tickets:** Allows the user to input the amount for purchasing lotto tickets.
* **Issue Lotto Tickets:** Automatically issues lotto tickets based on the purchased amount. Each ticket consists of 6 unique numbers between 1 and 45.
* **Input Winning Numbers:** Allows the user to input the 6 winning numbers from the previous draw and 1 bonus number.
* **Check Winnings:** Compares the issued lotto tickets against the winning and bonus numbers to determine the winning rank.
* **Output Results:** Displays the winning statistics (count per rank) and calculates/displays the total profit rate based on the purchase amount.
* **Exception Handling:** Handles invalid user input by throwing an `IllegalArgumentException` and re-prompting for input from that specific step.

## Functional Requirements Checklist

### Lotto Purchase

* [x] Allow the user to input the purchase amount in units of 1,000 KRW (e.g., `3000`, `10000`).
* [x] Determine the number of tickets to issue based on the amount (e.g., 3 tickets for 3,000 KRW).

### Lotto Ticket Issuance

* [x] Automatically issue the determined number of lotto tickets.
* [x] Ensure each lotto ticket contains 6 unique numbers between 1 and 45 (no duplicates within a ticket).
* [x] Print all the issued lotto numbers (e.g., `[8, 21, 23, 41, 42, 43]`, `[3, 5, 11, 16, 32, 38]`, ...).

### Winning Numbers Input

* [x] Allow the user to input 6 winning numbers, separated by commas (,), with each number between 1 and 45 (e.g., `1,2,3,4,5,6`).

### Bonus Number Input

* [x] Allow the user to input 1 bonus number between 1 and 45.

### Result Announcement

* [x] Compare each purchased lotto ticket with the winning numbers and the bonus number to determine the results.
* [x] Calculate the count for each winning rank based on the following criteria:
    * 3 matches (5,000 KRW)
    * 4 matches (50,000 KRW)
    * 5 matches (1,500,000 KRW)
    * 5 matches + Bonus number match (30,000,000 KRW)
    * 6 matches (2,000,000,000 KRW)
* [x] Print the winning statistics in the specified format:
    ```
    Winning Statistics
    ---
    3 matches (5,000 KRW) - n tickets
    4 matches (50,000 KRW) - n tickets
    5 matches (1,500,000 KRW) - n tickets
    5 matches, Bonus ball match (30,000,000 KRW) - n tickets
    6 matches (2,000,000,000 KRW) - n tickets
    ```
* [x] Calculate the total profit rate (Total Winnings / Purchase Amount * 100).
* [x] Print the total profit rate, rounded to one decimal place (e.g., `Total profit rate is 62.5%`).

### Exception Handling

For the following cases, throw an `IllegalArgumentException`, and re-prompt the user for input from the current step:

* **During Purchase Amount Input:**
    * [x] If the input is not a valid number.
    * [x] If the input amount is not divisible by 1,000.
* **During Winning Numbers Input:**
    * [x] If the input is not separated by commas or contains non-numeric characters (excluding commas).
    * [x] If the count of numbers is not exactly 6.
    * [x] If any number is outside the range of 1 to 45.
    * [x] If there are duplicate numbers among the 6 winning numbers.
* **During Bonus Number Input:**
    * [x] If the number is outside the range of 1 to 45.
    * [x] If the bonus number is already present in the 6 winning numbers entered previously.

---
## Class Diagram
### 1. `main` Class Diagram
![image](https://github.com/user-attachments/assets/8d6e0d1a-d525-4768-a0ce-59a98d1f27de)
### 2. `test` Class Diagram
![image](https://github.com/user-attachments/assets/1ef44cb6-5c9b-44bc-a853-fc4d7a61aad1)

