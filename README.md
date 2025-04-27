# kotlin-lotto-precourse

## Overview
This is a simple Lotto program.
Users can purchase lottery tickets, input winning numbers, and check their winnings and profit rate.

## Features
### Input
- [ ] Enter purchase amount (must be divisible by 1,000 KRW)
- [ ] Enter winning numbers (6 unique numbers, comma-separated)
- [ ] Enter bonus number (single number)

### Game logic
- [ ] Each ticket consists of 6 unique random numbers between 1 and 45.
- [ ] Compare each ticket's numbers with the winning numbers and bonus number.
  - [ ] Prize ranks
    - [ ] 6 matches → 1st Prize (2,000,000,000 KRW)
    - [ ] 5 matches + bonus → 2nd Prize (30,000,000 KRW)
    - [ ] 5 matches → 3rd Prize (1,500,000 KRW)
    - [ ] 4 matches → 4th Prize (50,000 KRW)
    - [ ] 3 matches → 5th Prize (5,000 KRW)
- [ ] Calculate total winnings and profit rate.

### Output
- [ ] Display all purchased tickets (sorted numbers).
- [ ] Display the number of winning tickets for each prize rank.
- [ ] Display total profit rate

### Error Handling
- [ ] Throw `IllegalArgumentException` for invalid inputs
  - [ ] Non-divisible purchase amount
  - [ ] Invalid number ranges (must be 1–45)
  - [ ] Duplicate numbers not allowed for winning numbers



