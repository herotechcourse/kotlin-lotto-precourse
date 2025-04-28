# kotlin-lotto-precourse

## Table of Contents

- [Built With](#built-with)  
- [Conventions](#conventions)  
- [Features](#features)  


## Built With

- Kotlin 1.9.24  
- JUnit 5  
- AssertJ  
- camp.nextstep.edu.missionutils

## Conventions
- [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)

- [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

## Features
### User Input
- [ ] The user can enter the purchase amount.  
  - [ ] If the input is not a single number, throw `IllegalArgumentException`  
    - “[ERROR] Purchase amount is not a single number.”  
  - [ ] If the amount is not divisible by 1,000 KRW, throw `IllegalArgumentException`  
    - “[ERROR] Purchase amount must be in multiples of 1,000 KRW.”

- [ ] The user can enter the winning numbers.  
  - [ ] If there are not exactly 6 comma-separated tokens, throw `IllegalArgumentException`  
    - “[ERROR] Winning numbers must contain 6 numbers.”  
  - [ ] If any token is not numeric or is outside the 1–45 range, throw `IllegalArgumentException`  
    - “[ERROR] Input is not a number.”  
    - “[ERROR] Lotto numbers must be between 1 and 45.”  
  - [ ] If there are duplicate numbers, throw `IllegalArgumentException`  
    - “[ERROR] Winning numbers contain duplicates.”  
  - [ ] Allow leading/trailing whitespace and trim spaces around each number.

- [ ] The user can enter the bonus number.  
  - [ ] If the input is not a single number, throw `IllegalArgumentException`  
    - “[ERROR] Bonus number is not a single number.”  
  - [ ] If the input is not numeric or is outside the 1–45 range, throw `IllegalArgumentException`  
    - “[ERROR] Input is not a number.”  
    - “[ERROR] Lotto numbers must be between 1 and 45.”  
  - [ ] If the bonus number is one of the winning numbers, throw `IllegalArgumentException`  
    - “[ERROR] Bonus number duplicates a winning number.”

- [ ] When the user enters invalid data, throw `IllegalArgumentException` and re-prompt at the **same** step.

---

### Ticket Issuance
- [ ] Issue as many tickets as the purchase amount allows (1 ticket = 1,000 KRW).  
- [ ] Each ticket consists of 6 unique random numbers between 1 and 45.  
- [ ] Sort each ticket’s numbers in ascending order before printing.

---

### Winning Logic
- [ ] Compare all issued tickets against the winning numbers and bonus number.  
- [ ] Determine each ticket’s rank (1st–5th) based on the count of matches and bonus match.  
    ```
    1st Prize: Match 6 numbers / 2,000,000,000 KRW
    2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
    3rd Prize: Match 5 numbers / 1,500,000 KRW
    4th Prize: Match 4 numbers / 50,000 KRW
    5th Prize: Match 3 numbers / 5,000 KRW
    ```

- [ ] Tally the number of winning tickets per rank.  
- [ ] Calculate the total return rate = (total winnings ÷ investment) and round to one decimal place.

---

### Console Output
- [ ] **Input Prompts**  
  - `Purchase amount for lottery tickets:`  
  - `Winning numbers (comma-separated):`  
  - `Bonus number:`

- [ ] **Ticket Issuance Result**  
    ```
    You have purchased X tickets.
    [n1, n2, n3, n4, n5, n6]
    … (X lines)
    ```

- [ ] **Winning Statistics** 
    ```
    3 Matches (5,000 KRW) – A tickets
    4 Matches (50,000 KRW) – B tickets
    5 Matches (1,500,000 KRW) – C tickets
    5 Matches + Bonus Ball (30,000,000 KRW) – D tickets
    6 Matches (2,000,000,000 KRW) – E tickets
    Total return rate is XX.X%.
    ```

---

### Testing and Structure
- [ ] Write unit tests for core business logic (ticket generation, rank determination, return-rate calculation).  
- [ ] Separate UI input/output into `InputView` and `OutputView` classes.  
- [ ] Implement retry logic at the Application level to catch exceptions and re-prompt input.  

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
