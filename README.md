# kotlin-lotto-precourse

## Overview
A simple lotto ticket machine implemented in Kotlin 1.9.24 for the pre-course mission of the Tech Course.  
The application allows users to buy lotto tickets, input winning numbers, and calculate winning results and profit rate.

---

## Feature Checklist

### Input Handling
- [x] Prompt user for purchase amount.
- [x] Validate that the purchase amount is a positive integer divisible by 1,000.
- [x] Throw IllegalArgumentException and terminate if the purchase amount is invalid.
- [x] Prompt user for last week's winning numbers (comma-separated).
- [x] Validate that winning numbers:
    - [x] Are exactly 6 numbers.
    - [x] Are within 1-45 and non-duplicated.
- [x] Prompt user for bonus number.
- [x] Validate that the bonus number:
    - [x] Is within 1-45.
    - [x] Does not duplicate the winning numbers.
- [x] Throw IllegalArgumentException and terminate if input is invalid.

---

### Core Game Logic
- [x] Issue one lotto ticket per 1,000 KRW.
- [x] Each ticket must have:
    - [x] 6 unique random numbers between 1 and 45.
    - [x] Numbers sorted in ascending order.
- [x] Compare each purchased ticket against winning numbers.
- [x] Determine matches:
    - [x] Match 6 numbers → 1st prize.
    - [x] Match 5 numbers + bonus → 2nd prize.
    - [x] Match 5 numbers → 3rd prize.
    - [x] Match 4 numbers → 4th prize.
    - [x] Match 3 numbers → 5th prize.
- [x] Calculate the total number of winners per rank.
- [x] Calculate total prize money and profit rate.

---

### Output Handling
- [x] Print the number of tickets purchased and the numbers of each ticket (sorted).
- [x] Display the winning statistics:
    - [x] Show the count of tickets for each winning rank.
    - [x] Show the total profit rate rounded to one decimal place.
- [x] Ensure error messages start with [ERROR].

---

### Testing
- [x] Write unit tests using **JUnit 5** and **AssertJ**.
- [x] Test the following cases:
    - [x] Valid input handling.
    - [x] Invalid input (throws exceptions).
    - [x] Ticket generation logic.
    - [x] Matching logic.
    - [x] Prize calculation and profit rate.
---

## Notes
- This README will be updated as features are implemented.
- All Git commits will follow the [AngularJS Commit Message Guidelines](https://github.com/angular/angular/blob/main/CONTRIBUTING.md#commit).
