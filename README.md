# 🎯 Lotto Program

This project implements a lottery ticket simulator where users can purchase tickets, input winning numbers, and check their results.

## 🧩 Feature List

1. Lotto Purchase
    - Accept purchase amount input from the user
    - Validate amount is divisible by 1,000 KRW (ticket price)
    - Generate lottery tickets with random numbers

2. Lotto Number Generation
    - Each ticket contains 6 unique random numbers
    - Numbers are in the range from 1 to 45
    - Display numbers in ascending order

3. Winning Number Input
    - Accept 6 winning numbers from the user (comma-separated)
    - Validate numbers are unique and within the valid range
    - Accept a bonus number that is not among the winning numbers

4. Result Calculation
    - Compare user tickets with winning numbers
    - Determine prize ranks based on matching numbers
    - Calculate total prize money and profit rate

5. Result Output
    - Display purchased tickets with sorted numbers
    - Show winning statistics with match counts and prizes
    - Present profit rate rounded to the nearest tenth

## 🏆 Prize Ranks

- 1st Prize: Match 6 numbers (2,000,000,000 KRW)
- 2nd Prize: Match 5 numbers + bonus number (30,000,000 KRW)
- 3rd Prize: Match 5 numbers (1,500,000 KRW)
- 4th Prize: Match 4 numbers (50,000 KRW)
- 5th Prize: Match 3 numbers (5,000 KRW)

## 📋 Example

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