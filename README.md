# kotlin-lotto-precourse

## Project Overview
A simple lottery ticket machine implemented in Kotlin 1.9.24.  
The program allows users to purchase lottery tickets, input winning numbers, and calculate their winnings and return rate.

This project follows the Pre-course Guidelines and Programming Requirements, including proper separation of concerns, error handling, and unit testing.

---

## Features

### 1. Purchase Tickets
- User inputs the purchase amount.
- The amount must be divisible by 1,000 KRW.
- The program generates the correct number of lottery tickets (one ticket per 1,000 KRW).

### 2. Generate Lottery Tickets
- Each ticket consists of 6 unique random numbers.
- Numbers are between 1 and 45 inclusive.

### 3. Input Winning Numbers
- User inputs last week's winning numbers.
- 6 unique numbers required, within 1 to 45 range.
- Validation ensures correct input.

### 4. Input Bonus Number
- User inputs a single bonus number.
- Bonus number must also be between 1 and 45.

### 5. Calculate Results
- Matches are checked between purchased tickets and winning numbers.
- Bonus number is considered for 2nd prize.
- Classifies tickets into the appropriate prize ranks.

### 6. Display Winning Statistics
- Displays the number of tickets for each rank.
- Calculates total prize winnings.
- Calculates and displays total return rate rounded to one decimal place.

### 7. Unit Tests
- Unit tests for core logic.
- Tests cover normal cases and error scenarios.
- UI (input/output) is not directly tested.

---

## Technologies Used
- Kotlin 1.9.24
- JUnit 5
- AssertJ
- Camp.nextstep.edu.missionutils (Randoms, Console)

---

## How to Run

```bash
./gradlew clean test

