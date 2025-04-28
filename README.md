## Lottery Ticket Machine Simulation

### 1. Design Lottery Ticket Machine with the following features

- Users can enter the purchase money and program will generate many tickets as the budget allows
- Users then enters the winning numbers and bonus number
- The program will compare the user's tickets to the winning numbers and print the result, including winnings and return rate

#### The prize
- There are five prize ranks. The criteria and prize amounts are as follows:
    - 1st Prize: Match 6 numbers / 2,000,000,000 KRW
    - 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW 
    - 3rd Prize: Match 5 numbers / 1,500,000 KRW
    - 4th Prize: Match 4 numbers / 50,000 KRW
    - 5th Prize: Match 3 numbers / 5,000 KRW

### 2. Input and output requirements
#### Input
- The purchase amount must be divisible by 1.000 because each ticket costs 1,000 KRW
- Each lottery ticket consists of 6 different random numbers in the range from 1 to 45
- The winning numbers also consists of 6 different numbers drawn in the range from 1 to 45
- The bonus number is different from winning numbers and drawn in the range from 1 to 45
#### Output
- Generated tickets need not be unique. They can be the same
- Show result statistics and the profit rate
- Profit rate should be rounded to the nearest tenth (e.g. 100.5%)

#### Sample input and output
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
### 3. Other requirements
- The program must be executable with Kotlin 1.9.24.
- Avoid using `else`
- Separate business logic and UI logic
- Implement unit tests for all logic