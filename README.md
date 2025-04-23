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

* [ ] Allow the user to input the purchase amount in units of 1,000 KRW (e.g., `3000`, `10000`).
* [ ] Determine the number of tickets to issue based on the amount (e.g., 3 tickets for 3,000 KRW).

### Lotto Ticket Issuance

* [ ] Automatically issue the determined number of lotto tickets.
* [ ] Ensure each lotto ticket contains 6 unique numbers between 1 and 45 (no duplicates within a ticket).
* [ ] Print all the issued lotto numbers (e.g., `[8, 21, 23, 41, 42, 43]`, `[3, 5, 11, 16, 32, 38]`, ...).

### Winning Numbers Input

* [ ] Allow the user to input 6 winning numbers, separated by commas (,), with each number between 1 and 45 (e.g., `1,2,3,4,5,6`).

### Bonus Number Input

* [ ] Allow the user to input 1 bonus number between 1 and 45.

### Result Announcement

* [ ] Compare each purchased lotto ticket with the winning numbers and the bonus number to determine the results.
* [ ] Calculate the count for each winning rank based on the following criteria:
    * 3 matches (5,000 KRW)
    * 4 matches (50,000 KRW)
    * 5 matches (1,500,000 KRW)
    * 5 matches + Bonus number match (30,000,000 KRW)
    * 6 matches (2,000,000,000 KRW)
* [ ] Print the winning statistics in the specified format:
    ```
    Winning Statistics
    ---
    3 matches (5,000 KRW) - n tickets
    4 matches (50,000 KRW) - n tickets
    5 matches (1,500,000 KRW) - n tickets
    5 matches, Bonus ball match (30,000,000 KRW) - n tickets
    6 matches (2,000,000,000 KRW) - n tickets
    ```
* [ ] Calculate the total profit rate (Total Winnings / Purchase Amount * 100).
* [ ] Print the total profit rate, rounded to one decimal place (e.g., `Total profit rate is 62.5%`).

### Exception Handling

For the following cases, throw an `IllegalArgumentException`, and re-prompt the user for input from the current step:

* **During Purchase Amount Input:**
    * [ ] If the input is not a valid number.
    * [ ] If the input amount is not divisible by 1,000.
* **During Winning Numbers Input:**
    * [ ] If the input is not separated by commas or contains non-numeric characters (excluding commas).
    * [x] If the count of numbers is not exactly 6.
    * [ ] If any number is outside the range of 1 to 45.
    * [ ] If there are duplicate numbers among the 6 winning numbers.
* **During Bonus Number Input:**
    * [ ] If the number is outside the range of 1 to 45.
    * [ ] If the bonus number is already present in the 6 winning numbers entered previously.