# kotlin-lotto-precourse

## Overview
This is a simple Lotto program.
Users can purchase lottery tickets, input winning numbers, and check their winnings and profit rate.

## Features
### Input
- [x] Enter purchase amount (must be divisible by 1,000 KRW)
- [x] Enter winning numbers (6 unique numbers, comma-separated)
- [x] Enter bonus number (single number)

### Game logic
- [x] Each ticket consists of 6 unique random numbers between 1 and 45.
- [x] Compare each ticket's numbers with the winning numbers and bonus number.
  - [x] Prize ranks
    - [x] 6 matches → 1st Prize (2,000,000,000 KRW)
    - [x] 5 matches + bonus → 2nd Prize (30,000,000 KRW)
    - [x] 5 matches → 3rd Prize (1,500,000 KRW)
    - [x] 4 matches → 4th Prize (50,000 KRW)
    - [x] 3 matches → 5th Prize (5,000 KRW)
- [x] Calculate total winnings and profit rate.

### Output
- [x] Display all purchased tickets (sorted numbers).
- [x] Display the number of winning tickets for each prize rank.
- [x] Display total profit rate

### Error Handling
- [x] Throw `IllegalArgumentException` for invalid inputs
  - [x] Non-divisible purchase amount
  - [x] Invalid number ranges (must be 1–45)
  - [x] Duplicate numbers not allowed for winning numbers



