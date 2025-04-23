# kotlin-lotto-precourse

This project is part of the **Hero Tech Pre-course**. This repo was created with the purpose of solving Task 2, which is to implement a **Lotto game**. 
The application simulates a lottery ticket machine where users can input a purchase amount, receive randomly generated lottery tickets, input winning numbers, 
and receive statistics about their winnings and profit rate.

The application is written in **Kotlin** following feedback, guidelines, structure and requirements provided by `Hero Tech Team`. 
___
## Table of Contents

1. [Task Description](#task-description)
2. [Feature List](#feature-list)

## Task Description 

The task consists of creating a Lotto ticket system that meets the following criteria:

- Each ticket contains 6 unique random numbers (1–45).
- Each ticket costs 1,000 KRW.
- User enters a purchase amount, and receives the corresponding number of tickets.
- User enters winning numbers and a bonus number.
- The system evaluates the results and calculates the total profit rate.
- Follows Kotlin coding conventions, uses provided `Randoms` and `Console` APIs, and includes unit testing with JUnit 5 and AsserJ. 

## Feature List 

### Input Handling and Validation
- Prompt the user to input the purchase amount.
- Validate the amount is a positive integer divisible by 1,000.
  - If it is not divisible by 1,000, reject, throw error and prompt again. 
- Prompt the user to input 6 comma-separated winning numbers.
- Prompt the user to input a single bonus number.
- Validate that all numbers are:
    - Between 1 and 45 (inclusive),
    - Unique within their respective sets (winning numbers and bonus),
    - Properly formatted as integers (e.g. `2` and not `2.0`)
- Raise `IllegalArgumentException` for any invalid input.
- Re-prompt the user from the same step after an invalid input.
- All error messages are prefixed with `[ERROR]`.

### Game Logic
- Calculate how many tickets to generate based on the input amount.
- Generate tickets with 6 **unique random numbers** in the 1–45 range using `Randoms.pickUniqueNumbersInRange`.
- Compare each ticket against the winning numbers and bonus number.
- Determine match count and assign the correct prize tier:
    - 6 matches = 1st Prize
    - 5 matches + bonus 0 2nd Prize
    - 5 matches = 3rd Prize
    - 4 matches = 4th Prize
    - 3 matches = 5th Prize
- Calculate the total prize money earned and compute the **return rate**.

### Output and Results
- Print how many tickets were purchased and show each ticket’s numbers, sorted in ascending order.
- Print the Winning Statistics per prize category.
- Display the total return rate, rounded to the nearest tenth (e.g. 75.5%).
- Ensure output format matches the exact structure given in the guidelines by `Hero and Woowa Tech`. 

### Testing
- Implement unit tests using **JUnit 5** and **AssertJ**.
  - Unit tests for:
    - Input validation.
    - Game logic and scenarios.
    - Ticket generation.
    - Results calculation.
- Use the provided `LottoTest` class as a reference for best practices.