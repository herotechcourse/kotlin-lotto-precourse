# kotlin-lotto-precourse

## 👀 Overview
The Lotto Ticket Machine allows users to purchase lottery tickets, compare them with winning numbers, and determine the corresponding prizes and profit rate.

## 🛠️feature

### 🍀 1. Purchase amount for lottery tickets
- Print "Please enter the purchase amount."
- Receive the purchase amount from the user
    - [x] throws an exception when input string is not a valid integer
    - [x] throws an exception when purchase amount is not positive or not a multiple of 1000
    - If the user inputs invalid data, the program must throw an IllegalArgumentException and re-prompt input from that step.

### 🍀 2. Generate lottery tickets
- Print number of tickets issued and their numbers (sorted in ascending order)
    - [x] throws an exception when lotto numbers exceed six
    - [x] throws an exception when lotto numbers contain duplicates
    - [x] throws an exception when lotto less than 1 or more than 45


### 🍀 3. Input Winning numbers
- Print "Please enter last week's winning numbers."
- Receive the winning numbers from the user
    - [x] throws an exception when input string contains non-integer value
    - [x] throws an exception when winning numbers exceed six
    - [x] throws an exception when winning numbers contain duplicates
    - [x] throws an exception when winning number is out of valid range
    - If the user inputs invalid data, the program must throw an IllegalArgumentException and re-prompt input from that step.

### 🍀 5. Input Bonus number
- Print "Please enter the bonus number."
- Receive the bonus number from the user
    - [x] throws an exception when bonus number is not an integer
    - [x] throws an exception when bonus number is included in winning numbers
    - [x] throws an exception when bonus number is out of valid range
    - If the user inputs invalid data, the program must throw an IllegalArgumentException and re-prompt input from that step.

### 🍀 6. Generate Winning Statistics
- Print "Winning Statistics\n---"
- Print Lotto result statistics and profit rate

### Example Execution
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