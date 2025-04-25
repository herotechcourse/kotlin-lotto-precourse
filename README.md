# implement feature List

Implement a simple lottery ticket machine with the following rules:

- [x] The user enters the purchase amount
  - [x] Each ticket costs 1,000 KRW
  - [x] so the amount must be divisible by 1,000.
- [x] the program issues as many lottery tickets as the budget allows.
- [x] generate lottos
  - [x] Each lottery ticket consists of 6 unique random numbers.
  - [x] Numbers must be in the range from 1 to 45.
  
The user then enters the winning numbers and a bonus number.
The winning numbers consist of 6 unique numbers.
The bonus number is a single, separate number.
There are five prize ranks. The criteria and prize amounts are as follows:
1st Prize: Match 6 numbers / 2,000,000,000 KRW
2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
3rd Prize: Match 5 numbers / 1,500,000 KRW
4th Prize: Match 4 numbers / 50,000 KRW
5th Prize: Match 3 numbers / 5,000 KRW
The program compares the user's tickets to the winning numbers and prints the result, including winnings and profit rate.
If the user inputs invalid data, the program must throw an IllegalArgumentException and re-prompt input from that step.
Handle only specific exception types such as IllegalArgumentException or IllegalStateException, not generic Exception.


# Input/Output Requirements

## Input

- [x] Purchase amount for lottery tickets: 
  - ex 14000
- [ ] Winning numbers (comma-separated): 
  - ex 1,2,3,4,5,6
- [ ] Bonus number: 
  - ex 7

## Output
- [x] print purchase prompt 
  - ex Please enter the purchase amount.
- [x] Number of tickets issued and their numbers (sorted in ascending order):
  - [x] print issued ticket intro message with ammount
    - You have purchased 8 tickets.
  - [x] print issued number of tickets
    - [x] sorted in ascending order
- [ ] print lotto numbers input prompt 
  - ex Please enter last week's winning numbers.
- [ ] print bonus number input prompt
  - ex Please enter the bonus number.
- [ ] print winning numbers status intro message
  - ex Winning Statistics /n ---
- [ ] print Lotto result statistics:
- [ ] Profit rate rounded to the nearest tenth (e.g., 100.0%, 51.5%, 1,000,000.0%):
  - ex Total return rate is 62.5%.
- [ ] Error messages must start with [ERROR]:
  - ex [ERROR] Lotto numbers must be between 1 and 45.

## Example Execution
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
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
Total return rate is 62.5%.
```