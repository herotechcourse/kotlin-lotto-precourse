# kotlin-lotto-precourse

A Simple Lottery Ticket Application built with Kotlin

---

## 🔧 Features

- ⭐ User input for purchase amount
- ⭐ Validation for purchase amount (must be divisible by 1,000)
- 🔹 Display purchase amount to the user
- ⭐ Automatic issuance of lottery tickets based on purchase amount
- ⭐ Each ticket contains 6 unique random numbers within range 1–45
- ⭐ Sort numbers within each ticket for display
- ⭐ Display issued lottery tickets to the user
- ⭐ User input for winning numbers and bonus number
- ⭐ Validation of winning numbers (6 unique numbers) and bonus number inputs (1 number)
- ⭐ Display last week winning numbers and bonus number to the user
- ⭐ Prize ranking system based on number matches and bonus number
- ⭐ Calculation of total winnings based on ticket results
- ⭐ Display how many tickets matched each prize rank (Winning Statistics)
- ⭐ Calculation of profit rate
- ⭐ Display profit rate
- ⭐ Error handling with IllegalArgumentException or IllegalStateException for invalid inputs
- ⭐ Re-prompting user on invalid input (instead of terminating the program)
- ⭐ Unit tests using JUnit 5 + AssertJ

---

## 🔄 Progress Log

| Feature                                                                                      | Status      | Branch                            |
|----------------------------------------------------------------------------------------------|-------------|-----------------------------------|
| User input for purchase amount                                                               | ✅ Done      | `feature/purchase-amount-input`   |
| Validation for purchase amount (must be divisible by 1,000)                                  | ✅ Done      | `feature/amount-validation`       |
| [Optional] Display purchase amount to the user                                               | ✅ Done      | `feature/display-amount`          |
| Automatic issuance of lottery tickets based on purchase amount                               | ✅ Done      | `feature/ticket-issuance`         |
| Each ticket contains 6 unique random numbers within range 1–45                               | ✅ Done      | `feature/ticket-numbers`          |
| Sort numbers within each ticket for display                                                  | ✅ Done      | `feature/ticket-sort`             |
| Display issued lottery tickets to the user                                                   | ✅ Done      | `feature/display-tickets`         |
| User input for winning numbers and bonus number                                              | ✅ Done      | `feature/winning-numbers-input`   |
| Validation of winning numbers (6 unique numbers) and bonus number inputs (1 number)          | ✅ Done      | `feature/winning-validation`      |
| Display last week winning numbers and bonus number to the user                               | 📅 Planned  | `feature/display-last-week-winners` |
| Prize ranking system based on number matches and bonus number                                | 📅 Planned  | `feature/prize-ranking`           |
| Calculation of total winnings based on ticket results                                        | 📅 Planned  | `feature/calculate-winnings`      |
| Display how many tickets matched each prize rank (Winning Statistics)                        | 📅 Planned  | `feature/prize-statistics`        |
| Calculation of profit rate                                                                   | 📅 Planned  | `feature/profit-rate`             |
| Display profit rate                                                                          | 📅 Planned  | `feature/display-profit-rate`     |
| Error handling with `IllegalArgumentException` or `IllegalStateException` for invalid inputs | 🚧 WIP      | `Integrated with each feature`    |
| Re-prompting user on invalid input (instead of terminating the program)                      | 🚧 WIP      | `Integrated with each feature`    |
| Unit tests using **JUnit 5** + **AssertJ**                                                   | 🚧 WIP      | `Integrated with each feature`    |

---

## 🚀 Getting Started

### Prerequisites

- Kotlin 1.9.24
- Gradle
- JUnit 5
- AssertJ

---

### Running the Application

To run the application, use the following commands:

- For macOS/Linux: `./gradlew clean run`
- For Windows: `gradlew.bat clean run` or `.\gradlew.bat clean run`

---

### Running Tests

To execute unit tests, run the following command:

- For macOS/Linux: `./gradlew clean test`
- For Windows: `gradlew.bat clean test` or `.\gradlew.bat clean test`

---

## 🧩 Example Usage

When you run the program, you will be prompted to enter the following inputs:

1. **Please enter the purchase amount.**
   <br><br>
   Example input:

   ```text
   8000
   ```
<br>

2. **Please enter last week's winning numbers.**
   <br><br>
   Example input:

   ```text
   5
   ```
<br>

3. **Please enter the bonus number.**
   <br><br>
   Example input:

   ```text
   7
   ```
<br>

After the inputs are provided, the program simulates the lottery ticket. Below is the expected execution:

```text
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
3 Matches (5,000 KRW) - 1 ticket
4 Matches (50,000 KRW) - 0 tickets
5 Matches (1,500,000 KRW) - 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) - 0 tickets
6 Matches (2,000,000,000 KRW) - 0 tickets
Total return rate is 62.5%.
```