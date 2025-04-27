# 🎟 kotlin-lotto-precourse
Building a simple lottery ticket machine.

- [Features](#features)
- [Example Execution](#example-execution)
- [Functional Requirements](#functional-requirements)

## Features
### Receiving the Lottery Purchase Amount
- Display purchase amount input guide
- Receive purchase amount input
### Validating the Purchase Amount
- Validate positive integer >= 1,000
- Validate non-empty input
- Validate divisibility by 1,000
- Allow commas in input
### Generating Lottery Tickets
- Generate (purchase amount / 1,000) tickets 
- Generate 6 unique numbers between 1 and 45 per ticket
### Displaying Issued Lottery Tickets
- Display number of issued tickets
- Display ticket numbers in ascending order
### Receiving the Winning Numbers
- Display winning numbers input guide
- Receive 6 unique winning numbers separated by commas
### Validating the Winning Numbers
- Validate exactly 6 winning numbers
- Validate numbers between 1 and 45
- Validate no duplicate numbers
### Receiving the Bonus Number
- Display bonus number input guide
- Receive one bonus number between 1 and 45
### Validating the Bonus Number
- Validate bonus number between 1 and 45
- Validate no overlap with winning numbers
### Calculating Winning Results
- Calculate winning ranks
### Calculating the Profit Rate
- Calculate profit rate
### Displaying the Results
- Display winning results
- Display profit rate

## Example Execution
```
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

## Functional Requirements
Implement a simple lottery ticket machine with the following rules:
- The user enters the purchase amount, and the program issues as many lottery tickets as the budget allows.
    - Each ticket costs 1,000 KRW, so the amount must be divisible by 1,000.
- Each lottery ticket consists of 6 unique random numbers.
    - Numbers must be in the range from 1 to 45.
- The user then enters the winning numbers and a bonus number.
    - The winning numbers consist of 6 unique numbers.
    - The bonus number is a single, separate number.
- There are five prize ranks. The criteria and prize amounts are as follows:
    - 1st Prize: Match 6 numbers / 2,000,000,000 KRW
    - 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
    - 3rd Prize: Match 5 numbers / 1,500,000 KRW
    - 4th Prize: Match 4 numbers / 50,000 KRW
    - 5th Prize: Match 3 numbers / 5,000 KRW
- The program compares the user's tickets to the winning numbers and prints the result, including winnings and profit rate.
- If the user inputs invalid data, the program must throw an `IllegalArgumentException` and re-prompt input from that step.
    - Handle only specific exception types such as `IllegalArgumentException` or `IllegalStateException`, not generic Exception.