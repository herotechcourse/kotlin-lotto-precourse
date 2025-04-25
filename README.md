# kotlin-lotto-precourse

### Table of Contents

- [🚀 About This Program](#-about-this-program---lotto)
- [☑️ Feature List](#-feature-list)
- [✖️ Exception Cases](#-exception-cases)

## 🚀 About This Program - Lotto

---

This is a simple lottery program that simulates purchasing and evaluating lottery tickets.

- The price of one lottery ticket is **1,000 KRW**.
- When the user enters a purchase amount, the program issues as many tickets as the budget allows.

  *(The maximum allowed amount is 100,000 KRW.)*

- The user is then prompted to enter **6 winning numbers** and **1 bonus number**.
- The program compares all purchased tickets with the winning numbers and prints:
    - the number of winning tickets by prize tier
    - the total winnings
    - and the profit rate.

If the user enters an invalid value, the program:

- shows an error message starting with `[ERROR]`,
- throws an exception,
- and re-prompts the input starting from the step where the error occurred.

There are five prize tiers from 1st to 5th place. The match conditions and prize amounts are described below.

| Rank | Match Condition                   | Prize Amount (KRW) |
|------|-----------------------------------|--------------------|
| 1st  | 6 matching numbers                | 2,000,000,000 KRW  |
| 2nd  | 5 matching numbers + bonus number | 30,000,000 KRW     |
| 3rd  | 5 matching numbers                | 1,500,000 KRW      |
| 4th  | 4 matching numbers                | 50,000 KRW         |
| 5th  | 3 matching numbers                | 5,000 KRW          |

<br/>

## ☑️ Feature List

---

### Lottery Purchase Amount Input

- [x]  Prompt the user to enter the lottery purchase amount.

### Lottery Issuance

- [x]  Calculate the number of tickets based on the purchase amount (1 ticket per 1000 KRW).
- [x]  Each ticket consists of 6 unique numbers ranging from 1 to 45.
- [x]  The generated numbers for each ticket must be sorted in ascending order.

### Winning Numbers Input

- [x]  Prompt the user to enter 6 winning numbers in a comma-separated format.
- [x]  Validate that the entered numbers are 6 unique values within the range of 1 to 45.

### Bonus Number Input

- [x]  Prompt the user to enter 1 bonus number.
- [x]  The bonus number must not duplicate any of the winning numbers.

### Lottery Result Evaluation

- [x]  Compare each purchased ticket against the winning numbers to count matching numbers.
- [x]  Classify each ticket into 1st to 5th prize tiers based on the number of matches and the bonus number.

### Winning Statistics Output

- [x]  Display the number of tickets in each prize tier.

### Profit Rate Calculation and Output

- [x]  Calculate the total winning amount.
- [x]  Calculate the profit rate based on the total purchase amount.
- [x]  Round the profit rate to one decimal place and display it as a percentage.

<br/>

## ✖️ Exception Cases

---

### Validation for Lottery Purchase Amount

- [x]  Throw an error if the input is empty.
- [x]  Throw an error if the input contains non-numeric characters.
- [x]  Throw an error if the amount is not between 1000 and 100000 KRW.
- [x]  Throw an error if the amount is not a multiple of 1000.

### Validation for Winning Numbers

- [x]  Throw an error if the input is empty.
- [x]  Throw an error if all input values are not valid numbers.
- [x]  Throw an error if the number of values is not exactly 6.
- [x]  Throw an error if any number is outside the range of 1 to 45.
- [x]  Throw an error if there are duplicate numbers.

### Validation for Bonus Number

- [x]  Throw an error if the input is empty.
- [x]  Throw an error if the input is not a number.
- [x]  Throw an error if the number is outside the range of 1 to 45.
- [x]  Throw an error if the number duplicates any of the winning numbers.