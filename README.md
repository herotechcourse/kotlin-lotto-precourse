# 🎯 kotlin-lotto-precourse

## 🎲 Lotto Game

---

## 📚 Project Overview

This project is part of the Pre-course Week 2 assignment, aimed at building a console-based Lotto game according to given specifications.  
Users can purchase lotto tickets by entering an amount, input the winning numbers and bonus number, and view the final results, including winning statistics and the overall profit rate.

---

## ✨ Features

### 🎟️ Ticket Purchase

- Users enter an amount to buy lotto tickets.

### 🧾 Ticket Issuance

- Tickets are automatically generated based on the entered amount.
- Each ticket contains 6 unique numbers between 1 and 45.

### 🏆 Winning Numbers Input

- Users provide 6 winning numbers and a bonus number.

### 🧮 Result Calculation

- The system compares the purchased tickets with the winning numbers and bonus number to determine the winning ranks.

### 📈 Results Output

- Displays the count of tickets per winning category.
- Calculates the total profit rate.

### 🚨 Robust Error Handling

- Detects invalid input and prompts the user to re-enter correct data.

---

## 📋 Requirements

### 🎟️ Ticket Purchase

- Accept purchase amounts in multiples of 1,000 KRW (e.g., 3000, 10000).
- Determine the number of tickets issued based on the input amount.

### 🧾 Ticket Issuance

- Generate the corresponding number of tickets automatically.
- Ensure each ticket contains 6 unique numbers between 1 and 45.
- Print all generated ticket numbers (e.g., `[8, 21, 23, 41, 42, 43]`).

### 🏆 Winning and Bonus Numbers Input

- Allow users to input 6 winning numbers separated by commas.
- Allow input of 1 bonus number.

### 🧮 Result Evaluation

- Compare each ticket against the winning numbers and bonus number.
- Categorize results based on:

| 🎯 Matches             | 🏆 Prize          |
| ---------------------- | ----------------- |
| 3 matches              | 5,000 KRW         |
| 4 matches              | 50,000 KRW        |
| 5 matches              | 1,500,000 KRW     |
| 5 matches + bonus ball | 30,000,000 KRW    |
| 6 matches              | 2,000,000,000 KRW |

- Display winning statistics:

🏆 Winning Statistics

Matches Prize
3 matches 5,000 KRW
4 matches 50,000 KRW
5 matches 1,500,000 KRW
5 matches + Bonus ball match 30,000,000 KRW
6 matches 2,000,000,000 KRW
The program calculates and displays the profit rate, rounded to one decimal place.

🚨 Exception Handling
If invalid inputs are detected, an IllegalArgumentException is thrown, and the user must re-enter the correct input.

During Purchase Amount Input:
Non-numeric input.

Amount not divisible by 1,000.

During Winning Numbers Input:
Incorrect format (e.g., not comma-separated or contains invalid characters).

Number of entries not exactly six.

Numbers out of the valid range (1 to 45).

Duplicate numbers.

During Bonus Number Input:
Number out of the valid range (1 to 45).

Bonus number already included among the winning numbers.
