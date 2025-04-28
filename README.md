# Lotto


#### Table of Contents
- [Project Introduction](#project-introduction)
- [Key Learning Goals](#key-learning-goals)
- [Package Structure](#package-structure)
- [Feature Specification](#feature-specification)

---

## Project Introduction
This project is a simple **lottery ticket machine** developed during the **HeroTechCourse Pre-course Week 2**.  
It simulates purchasing lottery tickets, inputting the winning numbers, and calculating the results and total return rate.

The application is built with **Kotlin 1.9.24** and designed to run on the **CLI (Command Line Interface)**.  
It follows the guidelines provided by the course, including strict validation rules, clean code practices, and structured testing.



### Key learning goals
1. Grouping related functions into classes for better object collaboration.
2. Writing unit tests to verify the correctness of each function and class.
3. Improving code quality by applying feedback from Pre-course Week 1.

---

## Package Structure
```

├── Application.kt
├── Lotto.kt
├── controller
│   ├── BonusNumberHandler.kt
│   ├── LottoProgramStart.kt
│   ├── PurchaseAmountHandler.kt
│   └── WinningNumbersHandler.kt
├── model
│   ├── LottoConstant.kt
│   ├── LottoNumberMaker.kt
│   ├── MatchCalculator.kt
│   ├── PurchaseAmountParser.kt
│   ├── ReturnRateCalculator.kt
│   └── WinningNumbersParser.kt
├── validation
│   ├── BonusNumberValidator.kt
│   ├── PurchaseAmountValidator.kt
│   ├── WinningNumbersValidator.kt
│   └── errorConstant.kt
└── view
    ├── InputView.kt
    └── OutputView.kt
```

---

## Feature Specification

### Receive the purchase amount for the lotto.
- [X] Print a prompt message to enter the purchase amount.
- [X] Parse the entered amount and calculate the number of purchasable tickets by dividing it by 1,000.
- [X] If the input is invalid, throw an 'IllegalArgumentException' and prompt the user again.
  - [X] If the input is empty.
  - [X] If the amount is less than 1,000.
  - [X] If the amount is not divisible by 1,000.
  - [X] If the input is not a valid number.

### Print the purchased lotto tickets.
- [X] Print a message to show the number of purchased tickets. "You have purchased $8 tickets."
- [X] Sort the numbers in each lotto ticket in ascending order. 
- [X] Print each lotto ticket's numbers, one per line.

### Manage lotto tickets as Objects.
- [X] Create a `Lotto` object for each purchased ticket.
- [X] Validate that each `Lotto` object contains exactly six numbers.
- [X] Validate that all numbers are between 1 and 45.
- [X] Validate that all numbers are unique.
- [X] Validate that the numbers in each ticket in ascending order.

### Receive the winning numbers for the lotto.
- [X] Print a prompt message to enter the winning numbers. "Please enter last week's winning numbers."
- [X] If the input is invalid, throw an 'IllegalArgumentException' and prompt the user again.
  - [X] If the input is empty.
  - [X] If the number of values is not 6.
  - [X] If any value is not a number.

### Receive the bonus number for the lotto.
- [X] Print a prompt message to enter the bonus number.
- [X] If the input is invalid, throw an 'IllegalArgumentException' and prompt the user again.
    - [X] If the input is empty.
    - [X] If the input is not a number.
    - [X] If the number is not in range 1 to 45.
    - [X] If the number must not consist of winning numbers.

### Print the winning statistics by match count.
- [X] Print a message for the winning statistics. "Winning Statistics"
- [X] Print a separator line.
- [X] Print the number of winning tickets for 3, 4, 5, 5+bonus number, and 6 matched numbers.

### Print the total return rate.
- [X] Calculate the total return rate.
- [X] Print the return rate message. "Total return rate is $62.5 %."
